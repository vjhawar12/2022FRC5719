package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.ControlMode; 
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;


public class Robot extends TimedRobot implements Constants {
  protected Timer timer; 

  protected double rightTorque, leftTorque; 

  protected final VictorSPX leftFront  = new VictorSPX(LEFT_FRONT); 
  protected final VictorSPX rightFront = new VictorSPX(RIGHT_FRONT); 
  protected final VictorSPX rightFollower = new VictorSPX(RIGHT_FOLLOWER); 
  protected final VictorSPX leftFollower = new VictorSPX(LEFT_FOLLOWER); 

  public Joystick joystick = new Joystick(0);  

  private void driveAuto(double vel) {
    rightFront.set(ControlMode.PercentOutput, vel);
    leftFront.set(ControlMode.PercentOutput, vel); 
    rightFollower.set(ControlMode.Follower, RIGHT_FRONT); 
    leftFollower.set(ControlMode.Follower, LEFT_FRONT); 
}

  private void driveTeleop(double xVel, double yVel) {
    rightFront.set(ControlMode.PercentOutput, xVel);
    leftFront.set(ControlMode.PercentOutput, yVel); 
    rightFollower.set(ControlMode.Follower, RIGHT_FRONT); 
    leftFollower.set(ControlMode.Follower, LEFT_FRONT); 
  }

  @Override
  public void autonomousInit() {
    timer = new Timer(); 
    timer.reset(); 
    timer.start(); 
  }

  @Override
  public void autonomousPeriodic() {
    if (timer.get() < 2.0) {
      driveAuto(100); 
    }
  }

  @Override
  public void teleopInit() {
    rightTorque = 0; 
    leftTorque = 0; 
  }

  @Override
  public void teleopPeriodic() {
    rightTorque = joystick.getRawAxis(JOYSTICK_RIGHT); 
    leftTorque = -1 * joystick.getRawAxis(JOYSTICK_LEFT); 
    driveTeleop(rightTorque, leftTorque); 
  }
}

