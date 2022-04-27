package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase; 
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup; 
import com.ctre.phoenix.motorcontrol.can.TalonSRX; 
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX; 

public class Drive extends SubsystemBase {

    PWM motor = new PWM(Constants.pwm); 

    MotorController m_frontLeft = new PWMVictorSPX(1);
    MotorController m_rearLeft = new PWMVictorSPX(2);
    MotorControllerGroup m_left = new MotorControllerGroup(m_frontLeft, m_rearLeft);
 
    MotorController m_frontRight = new PWMVictorSPX(3);
    MotorController m_rearRight = new PWMVictorSPX(4);
    MotorControllerGroup m_right = new MotorControllerGroup(m_frontRight, m_rearRight);
 
    DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
    
    public void driveSystem() {
        
    } 

    public void useJoystick(Joystick joystick) {
        
    }
}
