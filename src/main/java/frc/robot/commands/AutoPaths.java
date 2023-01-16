package frc.robot.commands;

import org.frc5587.lib.auto.RamseteCommandWrapper;
import org.frc5587.lib.auto.AutoPath;
import org.frc5587.lib.auto.ConstrainedTrajectory;

import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

// TODO
public class AutoPaths {
    // subsystems
    private final Drivetrain drivetrain;

    // Auto Paths
    private RamseteCommandWrapper crossLine;

    private RamseteCommandWrapper approachRight;

    private RamseteCommandWrapper ramLeft;

    private RamseteCommandWrapper ramRight;

    private NetworkTableEntry chooseAutoPath = SmartDashboard.getEntry("Choose Auto Path");
    private Notifier chooseAutoNotifier = new Notifier(this::blinkIfNoPath);

    public final boolean usingPathPlannerPaths;
    SendableChooser<Command> autoChooser = new SendableChooser<Command>();

    /**
     * Creates autonomous paths for 4 field positions using
     * {@link RamseteCommandWrapper}
     * and {@link AutoPath}, then links them to a {@link SendableChooser}.
     * 
     * Positions can be seen here:
     * <img src="./doc-files/autoposdiagram_small.png" width=100% />
     */
    public AutoPaths(Drivetrain drivetrain, boolean pathPlannerPaths) {
        this.drivetrain = drivetrain;
        this.usingPathPlannerPaths = pathPlannerPaths;


        // Auto Paths
        if (pathPlannerPaths) {
            crossLine = new RamseteCommandWrapper(drivetrain,
                    new AutoPath("CrossLine", true), AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            approachRight = new RamseteCommandWrapper(drivetrain,
                    new AutoPath("ApproachRight", true), AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            ramLeft = new RamseteCommandWrapper(drivetrain,
                    new AutoPath("RamLeft", true), AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            ramRight = new RamseteCommandWrapper(drivetrain,
                    new AutoPath("RamRight", true), AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
        } else {
            crossLine = new RamseteCommandWrapper(drivetrain,
                    new AutoPath("CrossLine"), AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            approachRight = new RamseteCommandWrapper(drivetrain,
                    new AutoPath("ApproachRight"), AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            ramLeft = new RamseteCommandWrapper(drivetrain,
                    new AutoPath("RamLeft"), AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            ramRight = new RamseteCommandWrapper(drivetrain,
                    new AutoPath("RamRight"), AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
        }
        
        autoChooser.addOption("Cross Line", crossLine);
        autoChooser.addOption("Ram Left", ramLeft);
        autoChooser.addOption("Ram Right", ramRight);
        autoChooser.addOption("Approach Right", approachRight);
        autoChooser.setDefaultOption("NO COMMAND", null);
        SmartDashboard.putData(autoChooser);

        chooseAutoNotifier.startPeriodic(0.1);
    }

    public SendableChooser<Command> getChooser() {
        return this.autoChooser;
    }

    public Command getSelectedCommand() {
        return autoChooser.getSelected();
    }

    /**
     * Creates new RamseteCommandWrappers for all paths using a
     * {@link ConstrainedTrajectory}
     */
    public void useConstrainedTrajectories() {
        if (usingPathPlannerPaths) {
            crossLine = new RamseteCommandWrapper(drivetrain, ConstrainedTrajectory.constrain(
                    new AutoPath("CrossLine", true).trajectory, AutoConstants.TRAJECTORY_CONSTRAINTS),
                    AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            approachRight = new RamseteCommandWrapper(drivetrain, ConstrainedTrajectory.constrain(
                    new AutoPath("ApproachRight", true).trajectory, AutoConstants.TRAJECTORY_CONSTRAINTS),
                    AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            ramLeft = new RamseteCommandWrapper(drivetrain, ConstrainedTrajectory.constrain(
                    new AutoPath("RamLeft", true).trajectory, AutoConstants.TRAJECTORY_CONSTRAINTS),
                    AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            ramRight = new RamseteCommandWrapper(drivetrain, ConstrainedTrajectory.constrain(
                    new AutoPath("RamRight", true).trajectory, AutoConstants.TRAJECTORY_CONSTRAINTS),
                    AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
        } else {
            crossLine = new RamseteCommandWrapper(drivetrain, ConstrainedTrajectory.constrain(
                    new AutoPath("CrossLine").trajectory, AutoConstants.TRAJECTORY_CONSTRAINTS),
                    AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            approachRight = new RamseteCommandWrapper(drivetrain, ConstrainedTrajectory.constrain(
                    new AutoPath("ApproachRight").trajectory, AutoConstants.TRAJECTORY_CONSTRAINTS),
                    AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            ramLeft = new RamseteCommandWrapper(drivetrain, ConstrainedTrajectory.constrain(
                    new AutoPath("RamLeft").trajectory, AutoConstants.TRAJECTORY_CONSTRAINTS),
                    AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
            ramRight = new RamseteCommandWrapper(drivetrain, ConstrainedTrajectory.constrain(
                    new AutoPath("RamRight").trajectory, AutoConstants.TRAJECTORY_CONSTRAINTS),
                    AutoConstants.RAMSETE_CONSTANTS).setOdometryToFirstPoseOnStart();
        }
    }

    private void blinkIfNoPath() {
        if (getSelectedCommand() == null) {
            chooseAutoPath.setBoolean(!chooseAutoPath.getBoolean(false));
        } else {
            chooseAutoPath.setBoolean(true);
        }

    }
}