package frc.robot.commands; 

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.DriveSubsystem;

public class AutoCommand extends CommandGroup {
    DriveSubsystem driveSubsystem = new DriveSubsystem(); 
    DriveCommand driveCommand = new DriveCommand(driveSubsystem); 

    public AutoCommand() {
        addSequential(new DriveToDistanceCommand(20, 0.8)); 
        addSequential(new DriveForewardTimeoutCommand());
    }
}
