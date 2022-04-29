package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer; 
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends TimedRobot implements Constants {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String autoSelected;
  private final SendableChooser<String> sendableChooser = new SendableChooser<>();

  private final Timer timer = new Timer(); 

  private PWMTalonSRX frontTalonLeft = new PWMTalonSRX(frontLeftMotorPort); 
  private PWMTalonSRX frontTalonRight = new PWMTalonSRX(frontRightMotorPort); 
  private PWMTalonSRX backTalonRight = new PWMTalonSRX(backRightMotorPort); 
  private PWMTalonSRX backTalonLeft = new PWMTalonSRX(backLeftMotorPort); 

  private MotorControllerGroup leftMotor = new MotorControllerGroup(frontTalonLeft, backTalonLeft); 
  private MotorControllerGroup rightMotor = new MotorControllerGroup(frontTalonRight, backTalonRight); 

  public DifferentialDrive differentialDrive; 
  public Joystick rightJoystick; 
  public Joystick leftJoystick; 

  @Override
  public void robotInit() {
    sendableChooser.setDefaultOption("Default Auto", kDefaultAuto);
    sendableChooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", sendableChooser);
    leftMotor.setInverted(true); 
    differentialDrive = new DifferentialDrive(leftMotor, rightMotor); 
    rightJoystick = new Joystick(rightJoystickPort); 
    leftJoystick = new Joystick(leftJoystickPort); 
  }

  @Override
  public void robotPeriodic() {}


  @Override
  public void autonomousInit() {
    autoSelected = sendableChooser.getSelected();
    System.out.println("Auto selected: " + autoSelected);
    timer.reset(); 
    timer.start(); 
  }

  @Override
  public void autonomousPeriodic() {
    if (timer.get() < 5) {
      differentialDrive.arcadeDrive(0.5, 0.0);
    } else {
      differentialDrive.stopMotor();
    }
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    differentialDrive.tankDrive(leftJoystick.getY(), rightJoystick.getY());
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
