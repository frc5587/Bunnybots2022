// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
    public static final class AutoConstants {
            /* pid/ff values */
            public static final SimpleMotorFeedforward DRIVETRAIN_FF = new SimpleMotorFeedforward(
                    0.66725, 2.3304, 0.3317);
            public static final PIDController PID_CONTROLLER = new PIDController(3.2003, 0, 0);
    
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
