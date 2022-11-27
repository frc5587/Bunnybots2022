package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.frc5587.lib.subsystems.PivotingArmBase;

import frc.robot.Constants.ArmConstants;

public class Arm extends PivotingArmBase {
    private static CANSparkMax motor = new CANSparkMax(ArmConstants.MOTOR_ID, MotorType.kBrushless);
    private RelativeEncoder encoder = motor.getEncoder();

    private static PivotingArmConstants armConstants = new PivotingArmConstants(
        ArmConstants.GEARING,
        ArmConstants.SOFT_LIMITS, 
        ArmConstants.ZERO_OFFSET, 
        ArmConstants.ENCODER_CPR, 
        ArmConstants.SWITCH_PORTS,
        ArmConstants.SWITCH_INVERTIONS, 
        ArmConstants.PID, 
        ArmConstants.FF
    );

    public Arm() {
        this(motor);

        configureMotors();
    }

    public Arm(CANSparkMax motor) {
        super(armConstants, motor);
    }

    @Override
    public double getEncoderPosition() {
        return encoder.getPosition();
    }

    @Override
    public double getEncoderVelocity() {
        return encoder.getVelocity();
    }

    @Override
    public void setEncoderPosition(double position) {
        encoder.setPosition(position);
    }

    // TODO
    public double getAngle() {
        return getEncoderPosition() * ArmConstants.GEARING;
    }

    // TODO
    /**
     * Tells if the arm is in the front position.
     * @return a truthy value if the arm is in the front
     */
    public boolean inFrontPosition() {
        return false; 
    }

    /**
     * Return what position the arm is in.
     * @return an {@link ArmPosition} of either FRONT or REAR
     */
    public ArmPosition getPosition() {
        if(inFrontPosition() == true) {
            return ArmPosition.FRONT;
        } else if (inFrontPosition() == false) {
            return ArmPosition.REAR;
        } else {
            return null;
        }
    }

    /**
     * Flips arm to opposite side.
     */
    public void toggleArm() {
        if(getPosition() == ArmPosition.FRONT) {
            getController().setGoal(ArmConstants.REAR_SETPOINT);
        } else if (getPosition() == ArmPosition.REAR) {
            getController().setGoal(ArmConstants.FRONT_SETPOINT);
        }
    }

    @Override
    public void configureMotors() {
        motor.restoreFactoryDefaults();
        motor.setIdleMode(IdleMode.kBrake);
        motor.setInverted(ArmConstants.MOTOR_INVERTED);
        motor.setSmartCurrentLimit(ArmConstants.STALL_CURRENT_LIMIT, ArmConstants.FREE_CURRENT_LIMIT);

        resetEncoders();
    }

    public enum ArmPosition {
        FRONT,
        REAR
    }
}
