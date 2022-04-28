package frc.robot.commands; 

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class AutoCommand extends Command {
    DriveSubsystem driveSubsystem = new DriveSubsystem(); 
    DriveCommand driveCommand = new DriveCommand(driveSubsystem); 


    public AutoCommand() {
        addCommands(driveCommand); 
    }

    @Override
    public boolean isFinished() {
        //
        return false; 
    }
}
