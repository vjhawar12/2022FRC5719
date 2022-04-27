package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase; 
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup; 
import com.ctre.phoenix.motorcontrol.can.TalonSRX; 
import frc.robot.Constants;
<<<<<<< HEAD
<<<<<<< HEAD
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX; 

public class Drive extends SubsystemBase {
=======
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX; 

public class DriveSubsystem extends SubsystemBase {
>>>>>>> 45798a64f8a06e8daa4ee93ff5f5ad5715333633

    PWM motor = new PWM(Constants.pwm); 

    MotorController m_frontLeft = new PWMVictorSPX(1);
    MotorController m_rearLeft = new PWMVictorSPX(2);
    MotorControllerGroup m_left = new MotorControllerGroup(m_frontLeft, m_rearLeft);
 
    MotorController m_frontRight = new PWMVictorSPX(3);
    MotorController m_rearRight = new PWMVictorSPX(4);
    MotorControllerGroup m_right = new MotorControllerGroup(m_frontRight, m_rearRight);
 
<<<<<<< HEAD
    DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
    
    public void driveSystem() {
        
    } 

    public void useJoystick(Joystick joystick) {
        
    }
=======

public class Drive extends SubsystemBase {
    protected TalonSRX motorFrontLeft = new TalonSRX(Constants.talonFrontLeft); 
    protected TalonSRX motorFrontRight = new TalonSRX(Constants.talonFrontRight); 
    protected TalonSRX motorBackLeft = new TalonSRX(Constants.talonBackLeft); 
    protected TalonSRX motorBackRight = new TalonSRX(Constants.talonBackRight); 

    protected PWM motor = new PWM(Constants.pwm); 

    MotorController leftMotorController; 
    MotorController rightMotorController; 

    MotorControllerGroup left = new MotorControllerGroup(leftMotorController); 
    MotorControllerGroup right = new MotorControllerGroup(rightMotorController); 
 
    DifferentialDrive m_drive = new DifferentialDrive(left, right);
    
    public void driveSystem() {

    } 
>>>>>>> 3d33c6485e555eeca98d2b8235b362ca2fa94afb
=======
    DifferentialDrive m_drive; 

    DriveSubsystem() {
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

>>>>>>> 45798a64f8a06e8daa4ee93ff5f5ad5715333633
}
