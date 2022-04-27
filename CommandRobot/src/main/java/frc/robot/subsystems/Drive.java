package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase; 
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup; 
import com.ctre.phoenix.motorcontrol.can.TalonSRX; 
import frc.robot.Constants;

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
}
