package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer; 
import frc.robot.Robot; 

public class DriveCommand extends CommandBase {
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField", "unused"})

  private final DriveSubsystem driveSubsystem;

  public DriveCommand() {
    driveSubsystem = null;
  }

  public DriveCommand(DriveSubsystem subsystem) {
    driveSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.driveSubsystem.stop(); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.driveSubsystem.driveJoytick(Robot.oi.getDriver(), 1); 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      RobotContainer.driveSubsystem.stop(); 
  }

  public void interrupted() {
    end(true); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
