package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.VictorSPX; 
import com.ctre.phoenix.motorcontrol.ControlMode; 
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot implements Constants {
  protected Timer timer; 

  protected double rightTorque, leftTorque; 

  protected final VictorSPX leftFront  = new VictorSPX(0); 
  protected final VictorSPX rightFront = new VictorSPX(1); 
  protected final VictorSPX rightFollower = new VictorSPX(2); 
  protected final VictorSPX leftFollower = new VictorSPX(3); 

  public Joystick joystick = new Joystick(0); 

  private void driveStraight(double vel) {
    rightFront.set(ControlMode.PercentOutput, vel);
    leftFront.set(ControlMode.PercentOutput, vel); 
    rightFollower.set(ControlMode.Follower, 0); 
    leftFollower.set(ControlMode.Follower, 1); 
}

  private void driveStraight(double xVel, double yVel) {
    rightFront.set(ControlMode.PercentOutput, xVel);
    leftFront.set(ControlMode.PercentOutput, yVel); 
    rightFollower.set(ControlMode.Follower, 0); 
    leftFollower.set(ControlMode.Follower, 1); 
  }

  @Override
  public void autonomousInit() {
    timer.reset(); 
    timer.start();
    timer.stop();
  
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
