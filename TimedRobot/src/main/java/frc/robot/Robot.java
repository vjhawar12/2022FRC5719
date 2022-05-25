package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Robot extends TimedRobot implements Constants {
  protected Timer timer; 

  protected double rightTorque, leftTorque; 

  protected final VictorSPX leftFront  = new VictorSPX(2); 
  protected final VictorSPX rightFront = new VictorSPX(3); 
  protected final VictorSPX rightFollower = new VictorSPX(1); 
  protected final VictorSPX leftFollower = new VictorSPX(0); 

  public Joystick joystick = new Joystick(0); 

  private void driveStraight(double vel) {
    rightFront.set(VictorSPXControlMode.PercentOutput, vel);
    leftFront.set(VictorSPXControlMode.PercentOutput, vel); 
    rightFollower.set(VictorSPXControlMode.Follower, 1); 
    leftFollower.set(VictorSPXControlMode.Follower, 0); 
}

  private void driveStraight(double xVel, double yVel) {
    rightFront.set(VictorSPXControlMode.PercentOutput, xVel);
    leftFront.set(VictorSPXControlMode.PercentOutput, yVel); 
    rightFollower.set(VictorSPXControlMode.Follower, 1); 
    leftFollower.set(VictorSPXControlMode.Follower, 0); 
  }

  @Override
  public void autonomousInit() {
    timer.reset(); 
    timer.start(); 
  }

  @Override
  public void autonomousPeriodic() {
    if (timer.get() < 3.0) {
      driveStraight(30); 
    }
  }

  @Override
  public void teleopInit() {
    rightTorque = 0; 
    leftTorque = 0; 
  }

  @Override
  public void teleopPeriodic() {
    rightTorque = joystick.getRawAxis(Constants.rightJoystickPort); 
    leftTorque = joystick.getRawAxis(Constants.leftJoystickPort); 
    driveStraight(rightTorque, leftTorque); 
  }
}
