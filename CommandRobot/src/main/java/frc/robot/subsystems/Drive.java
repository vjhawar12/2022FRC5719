package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase; 
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.PWM; 
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup; 


public class Drive extends SubsystemBase {
    TalonSRX frontRight = new Talon(RobotMap.frontRight); 
}
