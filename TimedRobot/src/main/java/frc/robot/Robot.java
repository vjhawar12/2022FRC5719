package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.ControlMode; 
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot implements Constants {
  protected Timer timer; 
  protected double forwardTorque, lateralTorque; 

  protected final WPI_VictorSPX leftFront  = new WPI_VictorSPX(LEFT_FRONT); 
  protected final WPI_VictorSPX rightFront = new WPI_VictorSPX(RIGHT_FRONT);   
  protected final WPI_VictorSPX rightFollower = new WPI_VictorSPX(RIGHT_FOLLOWER); 
  protected final WPI_VictorSPX leftFollower = new WPI_VictorSPX(LEFT_FOLLOWER); 

  DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront); 

  public PS4Controller controller = new PS4Controller(JOYSTICK_PORT);  

  @Override
  public void autonomousInit() {
    timer = new Timer(); 
    timer.reset(); 
    timer.start();
  }

  @Override
  public void autonomousPeriodic() {
    if (timer.get() < 2.0) {
      drive.arcadeDrive(100, 30);
    }
  }

  @Override
  public void teleopInit() {
    forwardTorque = 0; 
    lateralTorque = 0; 
  }

  @Override
  public void teleopPeriodic() {
    forwardTorque = controller.getRawAxis(JOYSTICK_LEFT); 
    lateralTorque = controller.getRawAxis(JOYSTICK_RIGHT); 
    leftFollower.follow(leftFront); 
    rightFollower.follow(rightFront); 
    drive.arcadeDrive(lateralTorque, forwardTorque);
  }
} 

