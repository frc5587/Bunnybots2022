package frc.robot.subsystems;

import org.frc5587.lib.subsystems.SwerveModuleBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants.DrivetrainConstants;

public class SwerveModule extends SwerveModuleBase {
    protected WPI_TalonFX driveMotor;
    protected WPI_TalonFX turnMotor;

    public SwerveModule(WPI_TalonFX driveMotor, WPI_TalonFX turnMotor, SwerveModuleConstants constants) {
        super(driveMotor, turnMotor, constants);

        this.driveMotor = turnMotor;
        this.turnMotor = turnMotor;
    }

    @Override
    public double getRotationPositionTicks() {
        return turnMotor.getSelectedSensorPosition();
    }

    @Override
    public double getDrivePositionTicks() {
        return driveMotor.getSelectedSensorPosition();
    }

    @Override
    public double getRotationVelocityTicksPerSecond() {
        return turnMotor.getSelectedSensorVelocity();
    }

    @Override
    public double getDriveVelocityTicksPerSecond() {
        return driveMotor.getSelectedSensorVelocity();
    }

    @Override
    public void setRotationEncoderPosition(double position) {
        turnMotor.setSelectedSensorPosition(position);
    }

    @Override
    public void setDriveEncoderPosition(double position) {
        driveMotor.setSelectedSensorPosition(position);
    }

    @Override
    protected void configureMotors() {
        turnMotor.configFactoryDefault();
        driveMotor.configFactoryDefault();

        turnMotor.setNeutralMode(NeutralMode.Brake);
        driveMotor.setNeutralMode(NeutralMode.Brake);

        turnMotor.setInverted(DrivetrainConstants.TURN_MOTORS_INVERTED);
        driveMotor.setInverted(DrivetrainConstants.DRIVE_MOTORS_INVERTED);

        turnMotor.configSupplyCurrentLimit(DrivetrainConstants.SUPPLY_CURRENT_LIMIT_CONFIGURATION);
        driveMotor.configSupplyCurrentLimit(DrivetrainConstants.SUPPLY_CURRENT_LIMIT_CONFIGURATION);
                
    }
}
