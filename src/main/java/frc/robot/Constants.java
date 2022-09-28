package frc.robot;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DrivetrainConstants {
        public static final double TURN_MOTOR_GEARING = 8.14;
        public static final int ENCODER_CPR = 2048;

        public static final int SMART_CURRENT_LIMIT = 35;
        public static final int HARD_CURRENT_LIMIT = 40;
        public static final double SMART_CURRENT_LIMIT_DELAY = 0.2; // in seconds
        public static final SupplyCurrentLimitConfiguration SUPPLY_CURRENT_LIMIT_CONFIGURATION = new SupplyCurrentLimitConfiguration(
                true,
                DrivetrainConstants.SMART_CURRENT_LIMIT,
                DrivetrainConstants.HARD_CURRENT_LIMIT,
                DrivetrainConstants.SMART_CURRENT_LIMIT_DELAY);

        public static final boolean TURN_MOTORS_INVERTED = true;
        public static final boolean DRIVE_MOTORS_INVERTED = false;
        
        public static final ProfiledPIDController MODULE1_ROTATION_PID = new ProfiledPIDController(
                1, 0, 0, new TrapezoidProfile.Constraints(0.3, 0.1));
        public static final ProfiledPIDController MODULE2_ROTATION_PID = new ProfiledPIDController(
                1, 0, 0, new TrapezoidProfile.Constraints(0.3, 0.1));
        public static final ProfiledPIDController MODULE3_ROTATION_PID = new ProfiledPIDController(
                1, 0, 0, new TrapezoidProfile.Constraints(0.3, 0.1));
        public static final ProfiledPIDController MODULE4_ROTATION_PID = new ProfiledPIDController(
                1, 0, 0, new TrapezoidProfile.Constraints(0.3, 0.1));
    }
}
