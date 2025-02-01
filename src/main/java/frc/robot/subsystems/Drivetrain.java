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
    private static SparkMax leftMotor = new SparkMax(DrivetrainConstants.LEFT_MOTOR, MotorType.kBrushless);
    private static SparkMax rightMotor = new SparkMax(DrivetrainConstants.RIGHT_MOTOR, MotorType.kBrushless);

    public static DriveConstants constants = new DriveConstants(DrivetrainConstants.WHEEL_DIAMETER,
            DrivetrainConstants.HISTORY_LIMIT, DrivetrainConstants.INVERT_GYRO, DrivetrainConstants.ENCODER_CPR,
            DrivetrainConstants.GEARING, DrivetrainConstants.TRACK_WIDTH);

    private REVConfigs motorConfigs = new REVConfigs();

    public Drivetrain() {
        super(leftMotor, rightMotor, constants);
    }

    @Override
    public void configureMotors() {
        leftMotor.configure(motorConfigs.leftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightMotor.configure(motorConfigs.rightConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    }

    @Override
    protected double getRightPositionTicks() {
        return rightMotor.getEncoder().getPosition();
    }

    @Override
    protected double getLeftPositionTicks() {
        return leftMotor.getEncoder().getPosition();
    }

    @Override
    protected double getRightVelocityTicksPerSecond() {
        return rightMotor.getEncoder().getVelocity();
    }

    @Override
    protected double getLeftVelocityTicksPerSecond() {
        return leftMotor.getEncoder().getVelocity();
    }

    @Override
    public Rotation2d getRotation2d() {
        return new Rotation2d();
    }

    @Override
    protected void resetEncoders() {
        leftMotor.getEncoder().setPosition(0);
        rightMotor.getEncoder().setPosition(0);
    }
}