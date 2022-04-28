package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeJoystickCommand extends Command {
    IntakeJoystickCommand() {

    }

    @Override
    protected void initialize() {
        RobotContainer.intakeSubsystem.stop(); 
    }

    @Override 
    public boolean isFinished() {
        // 
        return false;  
    }
}
