package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class JoystickDrive extends Robot {
    JoystickDrive() {
        
    }

    public void periodic() {
        double rightTorque = joystick.getRawAxis(1); 
        double leftTorque = -1 * joystick.getRawAxis(2); 
    
        frontMotorLeft.set(ControlMode.PercentOutput, leftTorque); 
        frontMotorRight.set(ControlMode.PercentOutput, rightTorque);
        backMotorLeft.set(ControlMode.Follower, 0); 
        backMotorRight.set(ControlMode.Follower, 1); 
    }
}
