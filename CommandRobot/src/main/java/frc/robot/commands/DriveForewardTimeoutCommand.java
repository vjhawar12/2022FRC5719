package frc.robot.commands; 

import edu.wpi.first.wpilibj.command.Command; 
import frc.robot.RobotContainer;

public class DriveForewardTimeoutCommand extends Command {

    public DriveForewardTimeoutCommand() {

    }

    @Override
    public void initialize() {
        RobotContainer.driveSubsystem.stop(); 
    }

    @Override
    public void execute() {
        RobotContainer.driveSubsystem.drive(1, 0);
    }

    @Override
    public boolean isFinished() {
       return isTimedOut(); 
    }
}
