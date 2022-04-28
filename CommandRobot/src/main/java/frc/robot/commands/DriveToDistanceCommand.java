package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer; 

public class DriveToDistanceCommand extends SequentialCommandGroup {
    DriveCommand driveCommand = new DriveCommand(); 
    double distance = 0.0; 
    double speed = 0.0; 

    public DriveToDistanceCommand(double _distance, double _speed) {
        distance = _distance;
        speed = _speed; 
    }

    @Override
    public void initialize() {
        RobotContainer.driveSubsystem.stop(); 
        RobotContainer.driveSubsystem.resetEncoders(true, true); 
        driveCommand.cancel(); 
    }

    @Override
    public void execute() {
        RobotContainer.driveSubsystem.drive(speed, 0); 
    }

    @Override
    public boolean isFinished() {
        return Math.abs(RobotContainer.driveSubsystem.getAvgDistance() - distance) <= 0.1; 
    }

    public void end() {
        RobotContainer.driveSubsystem.stop(); 
        driveCommand.execute(); 
    }

    public void interrupted() {
        end(); 
    }
}
