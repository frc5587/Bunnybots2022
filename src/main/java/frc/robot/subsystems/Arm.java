package frc.robot.subsystems;

import frc.robot.Constants.ArmConstants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.frc5587.lib.subsystems.PivotingArmBase;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends PivotingArmBase {
    public static CANSparkMax motor = new CANSparkMax(ArmConstants.MOTOR_ID, MotorType.kBrushless); 
    private final RelativeEncoder encoder = motor.getEncoder();

    private final DigitalInput frontLimitSwitch = new DigitalInput(ArmConstants.SWITCH_PORTS[0]);
    private final DigitalInput rearLimitSwitch = new DigitalInput(ArmConstants.SWITCH_PORTS[1]);

    public static PivotingArmConstants constants = new PivotingArmConstants(
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
    }
    
    public Arm(CANSparkMax motor) {
        super(constants, motor);
    }

    public DigitalInput getFrontLimitSwitch() {
        return frontLimitSwitch;
    }

    public DigitalInput getRearLimitSwitch() {
        return rearLimitSwitch;
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
    
    @Override
    public void configureMotors() {
        motor.restoreFactoryDefaults();
        motor.setIdleMode(IdleMode.kBrake);
        motor.setInverted(ArmConstants.MOTOR_INVERTED);
        resetEncoders();
    }

    public void forward() {
        motor.set(0.3);
    }

    public void back() {
        motor.set(-0.3);
    }
    
    public void moveRear() {
        getController().setGoal(ArmConstants.REAR_SETPOINT);
    }
    
    public void moveFront() {
        getController().setGoal(ArmConstants.FRONT_SETPOINT);
    }

    public void toggleArm() {
        if(getFrontLimitSwitch().get()) {
            moveRear();
        } else if (getFrontLimitSwitch().get()) {
            moveFront();
        }
    }

    @Override
    public void periodic() {
        // TODO Auto-generated method stub
        super.periodic();
        SmartDashboard.putBoolean("Front Limit Switch", getFrontLimitSwitch().get());
        SmartDashboard.putBoolean("Rear Limit Switch", getRearLimitSwitch().get());
    }
}