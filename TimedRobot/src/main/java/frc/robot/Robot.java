package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.ControlMode; 
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


public class Robot extends TimedRobot implements Constants {
  protected Timer timer; 

  protected double rightTorque, leftTorque; 

  protected final VictorSPX leftFront  = new VictorSPX(LEFT_FRONT); 
  protected final VictorSPX rightFront = new VictorSPX(RIGHT_FRONT); 
  protected final VictorSPX rightFollower = new VictorSPX(RIGHT_FOLLOWER); 
  protected final VictorSPX leftFollower = new VictorSPX(LEFT_FOLLOWER); 

  // MotorControllerGroup right = new MotorControllerGroup(rightFront, rightFollower); 
  // MotorControllerGroup left = new MotorControllerGroup(leftFront, leftFollower); 
  // DifferentialDrive drive = new DifferentialDrive(right, left); 

  public PS4Controller controller = new PS4Controller(0);  

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

  private void driveArcade(double vel, double rotation) {
    // drive.arcadeDrive(vel, rotation); 
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
    rightTorque = controller.getRawAxis(JOYSTICK_RIGHT); 
    leftTorque = -1 * controller.getRawAxis(JOYSTICK_LEFT); 
    driveTeleop(rightTorque, leftTorque); 
  }
} 

