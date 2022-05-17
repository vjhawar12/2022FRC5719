package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot implements Constants {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String autoSelected;
  private final SendableChooser<String> sendableChooser = new SendableChooser<>();
  private Timer timer; 

  private final VictorSPX frontMotorLeft = new VictorSPX(frontLeftMotorPort); 
  private final VictorSPX frontMotorRight = new VictorSPX(frontRightMotorPort); 
  private final VictorSPX backMotorRight = new VictorSPX(backRightMotorPort); 
  private final VictorSPX backMotorLeft = new VictorSPX(backLeftMotorPort); 

  public Joystick rightJoystick; 
  public Joystick leftJoystick; 

  @Override
  public void robotInit() {
    sendableChooser.setDefaultOption("Default Auto", kDefaultAuto);
    sendableChooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", sendableChooser); 
    rightJoystick = new Joystick(rightJoystickPort); 
    leftJoystick = new Joystick(leftJoystickPort); 
  }

  @Override
  public void robotPeriodic() {
    
  }


  @Override
  public void autonomousInit() {
    autoSelected = sendableChooser.getSelected();
    System.out.println("Auto selected: " + autoSelected);
    timer = new Timer(); 
    timer.start();
  }

  @Override
  public void autonomousPeriodic() {
   // if (timer.get() < 5.0) {
    frontMotorRight.set(ControlMode.Velocity, 10);
    frontMotorLeft.set(ControlMode.Velocity, 10); 
    backMotorRight.set(ControlMode.Follower, 0); 
    backMotorLeft.set(ControlMode.Follower, 1); 
   // }
  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    // control with joystick 
    double rightTorque = rightJoystick.getRawAxis(1); 
    double leftTorque = leftJoystick.getRawAxis(5); 

    frontMotorLeft.set(ControlMode.PercentOutput, leftTorque); 
    frontMotorRight.set(ControlMode.PercentOutput, rightTorque);
    backMotorLeft.set(ControlMode.Follower, 0); 
    backMotorRight.set(ControlMode.Follower, 1); 
  }
  
}
