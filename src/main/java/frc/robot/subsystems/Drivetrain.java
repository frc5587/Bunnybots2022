package frc.robot.subsystems;

import org.frc5587.lib.subsystems.DifferentialDriveBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends DifferentialDriveBase {
    private static CANSparkMax leftLeader = new CANSparkMax(DrivetrainConstants.LEFT_LEADER, MotorType.kBrushless);
    private static CANSparkMax rightFollower = new CANSparkMax(DrivetrainConstants.RIGHT_FOLLOWER, MotorType.kBrushless);

    public static MotorControllerGroup leftGroup = new MotorControllerGroup(leftLeader);
    public static MotorControllerGroup rightGroup = new MotorControllerGroup(rightFollower);

    public static DriveConstants constants = new DriveConstants(DrivetrainConstants.WHEEL_DIAMETER, DrivetrainConstants.HISTORY_LIMIT, DrivetrainConstants.INVERT_GYRO, DrivetrainConstants.ENCODER_CPR, DrivetrainConstants.GEARING, DrivetrainConstants.TRACK_WIDTH);

    public Drivetrain() {
        super(leftGroup, rightGroup, constants);
    }

    @Override
    public void configureMotors() {
        leftLeader.restoreFactoryDefaults();
        rightFollower.restoreFactoryDefaults();

        leftLeader.setIdleMode(IdleMode.kBrake); 
        rightFollower.setIdleMode(IdleMode.kBrake);

        leftLeader.setSmartCurrentLimit(DrivetrainConstants.STALL_CURRENT_LIMIT, DrivetrainConstants.FREE_CURRENT_LIMIT);
        rightFollower.setSmartCurrentLimit(DrivetrainConstants.STALL_CURRENT_LIMIT, DrivetrainConstants.FREE_CURRENT_LIMIT);

        leftLeader.setInverted(true);
        rightFollower.setInverted(DrivetrainConstants.RIGHT_MOTORS_INVERTED);
    }

    @Override
    protected double getRightPositionTicks() {
        return rightFollower.getEncoder().getPosition();
    }

    @Override
    protected double getLeftPositionTicks() {
        return leftLeader.getEncoder().getPosition();
    }

    @Override
    protected double getRightVelocityTicksPerSecond() {
        return rightFollower.getEncoder().getVelocity();
    }

    @Override
    protected double getLeftVelocityTicksPerSecond() {
        return leftLeader.getEncoder().getVelocity();
    }

    @Override
    public Rotation2d getRotation2d() {
        return new Rotation2d();
    }

    @Override
    protected void resetEncoders() {
        leftLeader.getEncoder().setPosition(0);
        rightFollower.getEncoder().setPosition(0);
    }   
}