package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase; 
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX; 
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder; 

public class DriveSubsystem extends SubsystemBase {

    PWM motor = new PWM(Constants.pwm); 

    PWMMotorController frontLeft = new PWMTalonSRX(Constants.talonFrontLeft);
    PWMMotorController rearLeft = new PWMTalonSRX(Constants.talonBackLeft);
    MotorControllerGroup left = new MotorControllerGroup(frontLeft, rearLeft);
 
    PWMMotorController frontRight = new PWMTalonSRX(Constants.talonFrontRight);
    PWMMotorController rearRight = new PWMTalonSRX(Constants.talonBackRight);
    MotorControllerGroup right = new MotorControllerGroup(frontRight, frontLeft);
 
    DifferentialDrive m_drive; 

    Encoder leftEncoder = new Encoder(
        Constants.leftEncoder1, 
        Constants.leftEncoder2, 
        false, 
        Encoder.EncodingType.k4X
    ); 

    Encoder rightEncoder = new Encoder(
        Constants.rightEncoder1, 
        Constants.rightEncoder2, 
        false, 
        Encoder.EncodingType.k4X
    );

    public DriveSubsystem() {
        frontLeft.setInverted(false); 
        frontRight.setInverted(false); 
        rearRight.setInverted(false); 
        rearLeft.setInverted(false); 
        m_drive = new DifferentialDrive(left, right);
    }
    
    public void driveJoytick(Joystick joystick, double speed) {
        m_drive.arcadeDrive(speed * joystick.getY(), speed * joystick.getX());
    } 

    public void drive(double speed, double rotation) {
        m_drive.arcadeDrive(speed, rotation);
    }

    public void stop() {
        m_drive.stopMotor(); 
    }

    public int getLeftRaw() {
        return leftEncoder.getRaw(); 
    }

    public int getRightRaw() {
        return rightEncoder.getRaw(); 
    }

    public double getRawAvg() {
        return 0.5 * (leftEncoder.getRaw() + rightEncoder.getRaw()); 
    }

    public double getAvgDistance() {
        return getRawAvg() * Constants.encoderValue; 
    }

    public void resetEncoders(boolean right, boolean left) {
        if (right) {
            rightEncoder.reset(); 
        }
        if (left) {
            leftEncoder.reset(); 
        }
    }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    }

}
