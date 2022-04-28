package frc.robot.commands; 

import edu.wpi.first.wpilibj.command.Command; 
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
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
