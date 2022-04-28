package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase; 
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup; 
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX; 
import edu.wpi.first.wpilibj.Encoder; 

public class DriveSubsystem extends SubsystemBase {

    PWM motor = new PWM(Constants.pwm); 

    MotorController m_frontLeft = new PWMVictorSPX(1);
    MotorController m_rearLeft = new PWMVictorSPX(2);
    MotorControllerGroup m_left = new MotorControllerGroup(m_frontLeft, m_rearLeft);
 
    MotorController m_frontRight = new PWMVictorSPX(3);
    MotorController m_rearRight = new PWMVictorSPX(4);
    MotorControllerGroup m_right = new MotorControllerGroup(m_frontRight, m_rearRight);
 
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
        m_frontLeft.setInverted(false); 
        m_frontRight.setInverted(false); 
        m_rearRight.setInverted(false); 
        m_rearLeft.setInverted(false); 
        m_drive = new DifferentialDrive(m_left, m_right);
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
