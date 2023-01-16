// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;
import org.frc5587.lib.auto.ConstrainedTrajectory.TrajectoryConstraints;
import org.frc5587.lib.auto.RamseteCommandWrapper.RamseteConstants;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

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
        public static final double WHEEL_DIAMETER = .505 / Math.PI;
        public static final int ENCODER_CPR = 42;
        public static final double GEARING = (54. / 20.) * (50. / 12.);
        public static final boolean INVERT_GYRO = false;
        public static final double TRACK_WIDTH = 25.496;

        public static final int STALL_CURRENT_LIMIT = 40;
        public static final int FREE_CURRENT_LIMIT = 35;
        public static final int HISTORY_LIMIT = 32;

        public static final boolean LEFT_MOTORS_INVERTED = false;
        public static final boolean RIGHT_MOTORS_INVERTED = true;

        public static final int LEFT_LEADER = 10;
        public static final int LEFT_FOLLOWER = 11;
        public static final int RIGHT_LEADER = 15;
        public static final int RIGHT_FOLLOWER = 16;
    }

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

    public static final class IntakeConstants {
        // motor ports
        public static final int LEFT_MOTOR = 25;
        public static final int RIGHT_MOTOR = 26;
        
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

    public static final class AutoConstants {
        public static final double KS = 0.12199;
        public static final double KV = 0.86458;
        public static final double KA = 0.11829;
        public static final double KP = 1.1124;
            /* pid/ff values */
            public static final SimpleMotorFeedforward DRIVETRAIN_FF = new SimpleMotorFeedforward(KS, KV, KA);
            public static final PIDController PID_CONTROLLER = new PIDController(KP, 0, 0);
    
            /* kinematics */
            public static final double TRACK_WIDTH = 0.7;
    
            public static final DifferentialDriveKinematics DRIVETRAIN_KINEMATICS = new DifferentialDriveKinematics(
                TRACK_WIDTH);
    
            /* Ramsete values */
            public static final double MAXIMUM_VELOCITY = 2; // m/s
            public static final double MAXIMUM_ACCELERATION = 1; // m/s^2
            public static final double CENTRIPETAL_ACCELERATION = 1; // m/s^2
    
            /* Ramsete */
            public static final RamseteConstants RAMSETE_CONSTANTS = new RamseteConstants(
                DRIVETRAIN_FF, PID_CONTROLLER, MAXIMUM_VELOCITY, MAXIMUM_ACCELERATION, 
                    CENTRIPETAL_ACCELERATION, DRIVETRAIN_KINEMATICS);
            
            /* trajectory */
            public static final TrajectoryConstraints TRAJECTORY_CONSTRAINTS = new TrajectoryConstraints(
                DRIVETRAIN_FF, MAXIMUM_VELOCITY, MAXIMUM_ACCELERATION, 
                    CENTRIPETAL_ACCELERATION, DRIVETRAIN_KINEMATICS);
    }
}
