package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakePistons;

public class EjectCrate extends CommandBase {
    private final Intake intake;
    private final IntakePistons intakePistons;
    /**
     * @param intake intake subsystem
     */
    public EjectCrate(Intake intake, IntakePistons intakePistons) {
        this.intake = intake;
        this.intakePistons = intakePistons;

        addRequirements(intake, intakePistons);
    }

    @Override
    public void initialize() {
        intake.backward();
    }

    @Override
    public void end(boolean interrupted) {
        intakePistons.retract();
        intake.stop();
    }
}