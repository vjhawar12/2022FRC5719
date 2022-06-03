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
  protected double forwardTorque, lateralTorque; 

  protected final VictorSPX leftFront  = new VictorSPX(LEFT_FRONT); 
  protected final VictorSPX rightFront = new VictorSPX(RIGHT_FRONT); 
  protected final VictorSPX rightFollower = new VictorSPX(RIGHT_FOLLOWER); 
  protected final VictorSPX leftFollower = new VictorSPX(LEFT_FOLLOWER); 

  public PS4Controller controller = new PS4Controller(0);  

  private void driveAuto(double vel) {  
    rightFront.set(ControlMode.PercentOutput, vel);
    leftFront.set(ControlMode.PercentOutput, vel); 
    rightFollower.set(ControlMode.Follower, RIGHT_FRONT); 
    leftFollower.set(ControlMode.Follower, LEFT_FRONT); 
}

  private void driveTeleop(double forward, double lateral) {
    rightFront.set(ControlMode.PercentOutput, forward);
    leftFront.set(ControlMode.PercentOutput, lateral); 
    rightFollower.set(ControlMode.Follower, RIGHT_FRONT); 
    leftFollower.set(ControlMode.Follower, LEFT_FRONT);
  }

  @Override
  public void autonomousInit() {
    timer = new Timer(); 
    timer.reset(); 
    timer.start();
    timer.stop();
  
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
    forwardTorque = controller.getRawAxis(JOYSTICK_LEFT); 
    lateralTorque = -1 * controller.getRawAxis(JOYSICK_RIGHT); 
    driveTeleop(forwardTorque, lateralTorque); 
  }
} 

