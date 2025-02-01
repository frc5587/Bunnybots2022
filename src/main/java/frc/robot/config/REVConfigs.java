package frc.robot.config;

import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import frc.robot.Constants.DrivetrainConstants;

public class REVConfigs {
    public SparkBaseConfig leftConfig;
    public SparkBaseConfig rightConfig;
    
    public REVConfigs() {
        leftConfig.smartCurrentLimit(DrivetrainConstants.STALL_CURRENT_LIMIT, DrivetrainConstants.FREE_CURRENT_LIMIT);
        leftConfig.idleMode(IdleMode.kBrake);
        leftConfig.inverted(DrivetrainConstants.LEFT_MOTORS_INVERTED);

        rightConfig.apply(leftConfig);
        rightConfig.inverted(DrivetrainConstants.RIGHT_MOTORS_INVERTED);

    }
}
