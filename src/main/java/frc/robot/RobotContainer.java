// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.frc5587.lib.control.DeadbandJoystick;
import org.frc5587.lib.control.DeadbandXboxController;

import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  /* Controllers */
  private final DeadbandJoystick joystick = new DeadbandJoystick(0);
  private final DeadbandXboxController xboxController = new DeadbandXboxController(1);

  /* Subsystems */
  private final Drivetrain drivetrain = new Drivetrain();
  
  /* Commands */
  private final ArcadeDrive arcadeDrive = new ArcadeDrive(drivetrain, joystick::getY, () -> -joystick.getX());

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    /* Configure the button bindings */
    configureButtonBindings();
    drivetrain.setDefaultCommand(arcadeDrive);
  }

    /**
     * Use this method to define your button->command mappings. Buttons are created
     * within {@link DeadbandXboxController}.
     */
  private void configureButtonBindings() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
