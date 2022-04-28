package frc.robot.commands; 

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.subsystems.DriveSubsystem;

public class AutoCommand extends SequentialCommandGroup {
    DriveSubsystem driveSubsystem = new DriveSubsystem(); 
    DriveCommand driveCommand = new DriveCommand(driveSubsystem); 


    public AutoCommand() {
        addCommands(driveCommand); 
    }
}
