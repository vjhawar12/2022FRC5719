package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.ControlMode; 
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;


public class Robot extends TimedRobot implements Constants {
  protected Timer timer; 

  protected double rightTorque, leftTorque; 

  protected final VictorSPX leftFront  = new VictorSPX(2); 
  protected final VictorSPX rightFront = new VictorSPX(3); 
  protected final VictorSPX rightFollower = new VictorSPX(1); 
  protected final VictorSPX leftFollower = new VictorSPX(0); 

  public Joystick joystick = new Joystick(0);  

  private void driveStraight(double vel) {
    rightFront.set(ControlMode.PercentOutput, vel);
    leftFront.set(ControlMode.PercentOutput, vel); 
    rightFollower.set(ControlMode.Follower, 3); 
    leftFollower.set(ControlMode.Follower, 2); 
}

  private void driveStraight(double xVel, double yVel) {
    rightFront.set(ControlMode.PercentOutput, xVel);
    leftFront.set(ControlMode.PercentOutput, yVel); 
    rightFollower.set(ControlMode.Follower, 3); 
    leftFollower.set(ControlMode.Follower, 2); 
  }

  @Override
  public void autonomousInit() {
    timer = new Timer(); 
    timer.reset(); 
    timer.start(); 
  }

  @Override
  public void autonomousPeriodic() {
    if (timer.get() < 5.0) {
      driveStraight(100); 
    }
  }

  @Override
  public void teleopInit() {
    rightTorque = 0; 
    leftTorque = 0; 
  }

  @Override
  public void teleopPeriodic() {
    rightTorque = joystick.getRawAxis(1); 
    leftTorque = -1 * joystick.getRawAxis(5); 
    driveStraight(rightTorque, leftTorque); 
  }
}
