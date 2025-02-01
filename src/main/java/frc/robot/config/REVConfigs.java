package frc.robot.config;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants.DrivetrainConstants;

public class REVConfigs {
    public SparkMaxConfig leftConfig = new SparkMaxConfig();
    public SparkMaxConfig rightConfig = new SparkMaxConfig();

    public REVConfigs() {
        leftConfig.smartCurrentLimit(DrivetrainConstants.STALL_CURRENT_LIMIT, DrivetrainConstants.FREE_CURRENT_LIMIT)
            .idleMode(IdleMode.kBrake)
            .inverted(DrivetrainConstants.LEFT_MOTOR_INVERTED);

        rightConfig.apply(leftConfig)
            .inverted(DrivetrainConstants.RIGHT_MOTOR_INVERTED);

    }
}
