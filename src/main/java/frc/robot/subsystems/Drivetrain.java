package frc.robot.subsystems;

import org.frc5587.lib.subsystems.SwerveDrivetrainBase;
import org.frc5587.lib.subsystems.SwerveModuleBase.SwerveModuleConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SwerveDrivetrainBase {
    private static SwerveModuleConstants module1Constants = new SwerveModuleConstants(DrivetrainConstants.TURN_MOTOR_GEARING, DrivetrainConstants.ENCODER_CPR, DrivetrainConstants.MODULE1_ROTATION_PID);
    private static SwerveModuleConstants module2Constants = new SwerveModuleConstants(DrivetrainConstants.TURN_MOTOR_GEARING, DrivetrainConstants.ENCODER_CPR, DrivetrainConstants.MODULE2_ROTATION_PID);
    private static SwerveModuleConstants module3Constants = new SwerveModuleConstants(DrivetrainConstants.TURN_MOTOR_GEARING, DrivetrainConstants.ENCODER_CPR, DrivetrainConstants.MODULE3_ROTATION_PID);
    private static SwerveModuleConstants module4Constants = new SwerveModuleConstants(DrivetrainConstants.TURN_MOTOR_GEARING, DrivetrainConstants.ENCODER_CPR, DrivetrainConstants.MODULE4_ROTATION_PID);


    private static SwerveModule module1 = new SwerveModule(new WPI_TalonFX(10), new WPI_TalonFX(15), module1Constants);
    private static SwerveModule module2 = new SwerveModule(new WPI_TalonFX(11), new WPI_TalonFX(16), module2Constants);
    private static SwerveModule module3 = new SwerveModule(new WPI_TalonFX(12), new WPI_TalonFX(17), module3Constants);
    private static SwerveModule module4 = new SwerveModule(new WPI_TalonFX(13), new WPI_TalonFX(18), module4Constants);


    public Drivetrain(DriveConstants constants) {
        super(module1, module2, module3, module4, constants);
    }
    
}
