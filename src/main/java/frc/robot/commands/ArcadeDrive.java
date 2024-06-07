package frc.robot.commands;

import java.util.function.DoubleSupplier;
import org.frc5587.lib.commands.ArcadeDriveBase;

import edu.wpi.first.math.MathUtil;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends ArcadeDriveBase {
    public ArcadeDrive(Drivetrain drivetrain, DoubleSupplier throttleSupplier, DoubleSupplier curveSupplier) {
        //super(drivetrain, () -> MathUtil.clamp(throttleSupplier.getAsDouble(), -0.4, 0.4), () -> MathUtil.clamp(curveSupplier.getAsDouble(), -0.4, 0.4));
        super(drivetrain, throttleSupplier, curveSupplier);
    }
    
}