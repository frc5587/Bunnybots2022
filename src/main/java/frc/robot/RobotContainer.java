// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.frc5587.lib.control.DeadbandJoystick;
import org.frc5587.lib.control.DeadbandXboxController;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakePistons;

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
  private final IntakePistons intakePistons = new IntakePistons();
  private final Intake intake = new Intake();
  
  /* Commands */


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    /* Configure the button bindings */
    configureButtonBindings();
  }

    /**
     * Use this method to define your button->command mappings. Buttons are created
     * within {@link DeadbandXboxController}.
     */
  private void configureButtonBindings() {
    xboxController.xButton.whenPressed(intakePistons::extend);
    xboxController.yButton.whenPressed(intakePistons::retract);
    xboxController.leftBumper.whileActiveContinuous(intake::forward);
    xboxController.rightBumper.whileActiveContinuous(intake::backward);
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
