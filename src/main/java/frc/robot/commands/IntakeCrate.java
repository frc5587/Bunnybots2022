package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakePistons;

public class IntakeCrate extends CommandBase {
    private final Intake intake;
    private final IntakePistons intakePistons;

    /**
     * Keeps running the intake inwards until it detects that it has a crate. This
     * is done by the right wheel being stalled and the left wheel spinning somewhat
     * free. This happens because of how the eleatic band pushed on the left side of
     * the crate.
     * 
     * @param intake intake subsystem
     */
    public IntakeCrate(Intake intake, IntakePistons intakePistons) {
        this.intake = intake;
        this.intakePistons = intakePistons;

        addRequirements(intake, intakePistons);
    }

    @Override
    public void initialize() {
        intake.forward();
    }

    @Override
    public void end(boolean interrupted) {
        intakePistons.extend();
        intake.stop();

    }
}