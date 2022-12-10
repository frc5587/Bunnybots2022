// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.frc5587.lib.control.*;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

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
  private final DeadbandJoystick joystick = new DeadbandJoystick(0);
  private final DeadbandXboxController xboxController = new DeadbandXboxController(1);

  /* Subsystems */
  private final Arm arm = new Arm();
  private final IntakePistons intakePistons = new IntakePistons();
  private final Intake intake = new Intake();
  private final Drivetrain drivetrain = new Drivetrain();
  
  /* Commands */
  private final FlipArm flipArm = new FlipArm(arm);
  private final ArmFront armFront = new ArmFront(arm);
  private final ArmRear armRear = new ArmRear(arm);
  private final IntakeCrate intakeCrate = new IntakeCrate(intake, intakePistons);
  private final EjectCrate ejectCrate = new EjectCrate(intake, intakePistons);
  private final ArcadeDrive arcadeDrive = new ArcadeDrive(drivetrain, () -> -joystick.getY(), joystick::getX);

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
    // xboxController.dPadUp.whileActiveOnce(flipArm);
    xboxController.dPadUp.whileActiveOnce(armRear);
    xboxController.dPadDown.whileActiveOnce(armFront);
    
    xboxController.yButton.and(xboxController.leftTrigger.negate()).whileActiveOnce(intakeCrate);

    /**
    * when y button & left trigger are active, move intake outwards.
    * when the y button & left trigger are inactive, stop.
    */
    xboxController.yButton.and(xboxController.leftTrigger).whileActiveOnce(ejectCrate);
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
