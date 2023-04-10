// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import org.frc5587.lib.control.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  /* Controllers */
  private final DeadbandCommandJoystick joystick = new DeadbandCommandJoystick(0);
  private final DeadbandCommandXboxController xboxController = new DeadbandCommandXboxController(1);

  /* Subsystems */
  private final Drivetrain drivetrain = new Drivetrain();
  
  /* Commands */
  private final ArcadeDrive arcadeDrive = new ArcadeDrive(drivetrain, () -> -joystick.getY(), joystick::getX);
  private final ArcadeDrive ddrDrive = new ArcadeDrive(drivetrain, buttonToValue(xboxController.x(), xboxController.b(), Constants.DrivetrainConstants.DDR_FWD), buttonToValue(xboxController.y(), xboxController.a(), Constants.DrivetrainConstants.DDR_TURN));

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    /* Configure the button bindings */
    configureButtonBindings();
    // drivetrain.setDefaultCommand(arcadeDrive); // Uncomment this line, and comment out below to use joysticks
    drivetrain.setDefaultCommand(ddrDrive); // Uncomment this line, and comment out above to use DDR Pad
  }

    /**
     * Use this method to define your button->command mappings. Buttons are created
     * within {@link DeadbandXboxController}.
     */
  private void configureButtonBindings() {
  }

  private static DoubleSupplier buttonToValue(Trigger pos, Trigger neg, double power) {
    return () -> {
        if(pos.getAsBoolean() == neg.getAsBoolean()) return 0;
        else if(pos.getAsBoolean()) return power;
        else return -power;
    };
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
