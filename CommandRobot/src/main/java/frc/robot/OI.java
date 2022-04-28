package frc.robot;

import edu.wpi.first.wpilibj.Joystick; 

public class OI {

    Joystick driver = new Joystick(Constants.joystickDriver); 
    Joystick operator = new Joystick(Constants.joystickOperator); 

    public Joystick getDriver() {
        return driver; 
    }

    public Joystick getOperator() {
        return operator; 
    }
}
