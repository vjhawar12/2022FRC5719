package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;

public class AutoDrive extends Robot {
    public AutoDrive() {
        timer = new Timer(); 
        timer.start();
    }

    private void driveStraight(double velocity) {
        
    }

    private void driveStraight(int percentage) {
        frontMotorRight.set(ControlMode.PercentOutput, percentage);
        frontMotorLeft.set(ControlMode.PercentOutput, percentage); 
        backMotorRight.set(ControlMode.Follower, 0); 
        backMotorLeft.set(ControlMode.Follower, 1); 
    }

    public void periodic() {
        if (timer.get() < 3.0) {
           driveStraight(30);
        }
    }
}
