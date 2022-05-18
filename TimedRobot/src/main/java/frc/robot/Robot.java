package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot implements Constants {
  protected Timer timer; 

  protected final VictorSPX frontMotorLeft = new VictorSPX(frontLeftMotorPort); 
  protected final VictorSPX frontMotorRight = new VictorSPX(frontRightMotorPort); 
  protected final VictorSPX backMotorRight = new VictorSPX(backRightMotorPort); 
  protected final VictorSPX backMotorLeft = new VictorSPX(backLeftMotorPort); 

  public Joystick joystick = new Joystick(0); 

  private AutoDrive autoDrive; 
  private JoystickDrive joystickDrive; 

  @Override
  public void autonomousInit() {
    autoDrive = new AutoDrive(); 
  }

  @Override
  public void autonomousPeriodic() {
    autoDrive.periodic(); 
  }

  @Override
  public void teleopInit() {
    joystickDrive = new JoystickDrive(); 
  }

  @Override
  public void teleopPeriodic() {
    joystickDrive.periodic(); 
  }
  
}
