package frc.robot.subsystems;

import org.frc5587.lib.subsystems.DifferentialDriveBase;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.config.REVConfigs;

public class Drivetrain extends DifferentialDriveBase {
    private static SparkMax leftLeader = new SparkMax(DrivetrainConstants.LEFT_LEADER, MotorType.kBrushless);
    private static SparkMax rightFollower = new SparkMax(DrivetrainConstants.RIGHT_FOLLOWER, MotorType.kBrushless);

    public static DriveConstants constants = new DriveConstants(DrivetrainConstants.WHEEL_DIAMETER, DrivetrainConstants.HISTORY_LIMIT, DrivetrainConstants.INVERT_GYRO, DrivetrainConstants.ENCODER_CPR, DrivetrainConstants.GEARING, DrivetrainConstants.TRACK_WIDTH);

    private REVConfigs motorConfigs = new REVConfigs();

    public Drivetrain() {
        super(leftLeader, rightFollower, constants);
    }

    @Override
    public void configureMotors() {
        leftLeader.configure(motorConfigs.leftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFollower.configure(motorConfigs.rightConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

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