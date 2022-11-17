package frc.robot.subsystems;

import org.frc5587.lib.subsystems.DrivetrainBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends DrivetrainBase {
    private static CANSparkMax leftLeader = new CANSparkMax(DrivetrainConstants.LEFT_LEADER, MotorType.kBrushless);
    private static CANSparkMax leftFollower = new CANSparkMax(DrivetrainConstants.LEFT_FOLLOWER, MotorType.kBrushless);
    private static CANSparkMax rightLeader = new CANSparkMax(DrivetrainConstants.RIGHT_LEADER, MotorType.kBrushless);
    private static CANSparkMax rightFollower = new CANSparkMax(DrivetrainConstants.RIGHT_FOLLOWER, MotorType.kBrushless);

    public static MotorControllerGroup leftGroup = new MotorControllerGroup(leftLeader, leftFollower);
    public static MotorControllerGroup rightGroup = new MotorControllerGroup(rightLeader, rightFollower);

    public static DriveConstants constants = new DriveConstants(DrivetrainConstants.WHEEL_DIAMETER, DrivetrainConstants.HISTORY_LIMIT, DrivetrainConstants.INVERT_GYRO, DrivetrainConstants.ENCODER_CPR, DrivetrainConstants.GEARING, DrivetrainConstants.TRACK_WIDTH);

    public Drivetrain() {
        super(leftGroup, rightGroup, constants);
    }

    @Override
    public void configureMotors() {
        leftLeader.restoreFactoryDefaults();
        leftFollower.restoreFactoryDefaults();
        rightLeader.restoreFactoryDefaults();
        rightFollower.restoreFactoryDefaults();

        leftLeader.setIdleMode(IdleMode.kBrake);        
        leftFollower.setIdleMode(IdleMode.kBrake);        
        rightLeader.setIdleMode(IdleMode.kBrake);
        rightFollower.setIdleMode(IdleMode.kBrake);

        leftLeader.setSmartCurrentLimit(DrivetrainConstants.STALL_CURRENT_LIMIT, DrivetrainConstants.FREE_CURRENT_LIMIT);
        leftFollower.setSmartCurrentLimit(DrivetrainConstants.STALL_CURRENT_LIMIT, DrivetrainConstants.FREE_CURRENT_LIMIT);
        rightLeader.setSmartCurrentLimit(DrivetrainConstants.STALL_CURRENT_LIMIT, DrivetrainConstants.FREE_CURRENT_LIMIT);
        rightFollower.setSmartCurrentLimit(DrivetrainConstants.STALL_CURRENT_LIMIT, DrivetrainConstants.FREE_CURRENT_LIMIT);
    }

    @Override
    protected double getRightPositionTicks() {
        return rightLeader.getEncoder().getPosition();
    }

    @Override
    protected double getLeftPositionTicks() {
        return leftLeader.getEncoder().getPosition();
    }

    @Override
    protected double getRightVelocityTicksPerSecond() {
        return rightLeader.getEncoder().getVelocity();
    }

    @Override
    protected double getLeftVelocityTicksPerSecond() {
        return leftLeader.getEncoder().getVelocity();
    }

    @Override
    protected void resetEncoders() {
        leftLeader.getEncoder().setPosition(0);
        rightLeader.getEncoder().setPosition(0);
    }   
}
