package frc.robot.commands;

import java.util.function.DoubleSupplier;
import org.frc5587.lib.commands.ArcadeDriveBase;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends ArcadeDriveBase {
    public ArcadeDrive(Drivetrain drivetrain, DoubleSupplier throttleSupplier, DoubleSupplier curveSupplier) {
        super(drivetrain, throttleSupplier, curveSupplier);
    }
    
}