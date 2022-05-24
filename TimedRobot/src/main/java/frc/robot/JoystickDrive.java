package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class JoystickDrive extends Robot {
    double rightTorque; 
    double leftTorque; 

    JoystickDrive() {
        rightTorque = 0; 
        leftTorque = 0; 
    }

    public void periodic() {
        rightTorque = joystick.getRawAxis(Constants.rightJoystickPort); 
        leftTorque = joystick.getRawAxis(Constants.leftJoystickPort); 
    
        frontMotorLeft.set(ControlMode.PercentOutput, leftTorque); 
        frontMotorRight.set(ControlMode.PercentOutput, rightTorque);
        backMotorLeft.set(ControlMode.Follower, 0); 
        backMotorRight.set(ControlMode.Follower, 1); 
    }
}
