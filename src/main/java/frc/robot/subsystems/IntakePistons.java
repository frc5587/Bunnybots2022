package frc.robot.subsystems;

import org.frc5587.lib.subsystems.PistonControl;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants.IntakeConstants;

public class IntakePistons extends PistonControl {
    public static DoubleSolenoid piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, IntakeConstants.SOLENOID_ID, IntakeConstants.SOLENOID_ID2);

    public IntakePistons() {
        super(piston);
    }
}
