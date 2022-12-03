// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class IntakeConstants {
        // motor ports
        public static final int RIGHT_MOTOR = 25;
        public static final int LEFT_MOTOR = 26;
        
        public static final boolean RIGHT_MOTOR_INVERTED = false;
        public static final boolean LEFT_MOTOR_INVERTED = true;
        // motor limits
        public static final int STALL_LIMIT = 20;
        public static final int FREE_LIMIT = 25;
        // motor speeds
        public static final double THROTTLE_FORWARD = 0.75;
        public static final double THROTTLE_REVERSE = 0.25;

        public static final double LEFT_VELOCITY_THRESHOLD = 10;  // rps
        public static final double RIGHT_VELOCITY_THRESHOLD = 500;  // rps
        public static final double EJECT_CRATE_RUNTIME = 0.5; // seconds

        public static final double HOLD = 0.05;

        public static final int SOLENOID_ID = 0;
        public static final int SOLENOID_ID2 = 1;

    }
}
