// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class ArmConstants {
        /* CAN IDs */
        public static final int MOTOR_ID = 20;

        /* motor configurations */
        public static final boolean MOTOR_INVERTED = false;
        public static final int STALL_CURRENT_LIMIT = 35;
        public static final int FREE_CURRENT_LIMIT = 40;

        /* setpoints */
        public static final double FRONT_SETPOINT = Math.toRadians(0);
        public static final double REAR_SETPOINT = Math.toRadians(160);

        public static final double REAR_THRESHOLD = Math.toRadians(140);
        public static final double FRONT_THRESHOLD = Math.toRadians(10);

        /* PivotingArmConstants */
        public static final double GEARING = 64;
        public static final double[] SOFT_LIMITS = {Math.toRadians(0), Math.toRadians(180)};
        public static final int ZERO_OFFSET = 0;
        public static final int ENCODER_CPR = 42;
        public static final int[] SWITCH_PORTS = {0, 1};
        public static final boolean[] SWITCH_INVERTIONS = {false, false};
        public static final ProfiledPIDController PID = new ProfiledPIDController(6.9012, 0, 1.5006, new Constraints(5, 50));
        public static final ArmFeedforward FF = new ArmFeedforward(0.34905, -0.032397, 1.23, 0.083365);
    }
}
