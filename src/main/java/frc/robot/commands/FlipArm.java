package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class FlipArm extends CommandBase {
    private Arm arm;
    
    public FlipArm(Arm arm) {
        this.arm = arm;

        addRequirements(arm);
    }

    @Override
    public void initialize() {
        arm.toggleArm();
    }

    @Override
    public void end(boolean interrupted) {
        arm.stop();
    }
}
