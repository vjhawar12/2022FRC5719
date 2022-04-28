package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeJoystickCommand extends Command {
    boolean direction = false; 
    double speed = 0.0; 

    IntakeJoystickCommand(boolean dir, double _speed) {
        direction = dir; 
        speed = _speed; 
    }

    @Override
    protected void initialize() {
       
    }

    // Intakes or outtakes in the direction and speed given
    @Override
    protected void execute() {
       
    }

    // Will only return true when  the command is cancelled
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    // Stops the motors before exiting the program
    @Override
    protected void end() {
        
    }

    // Only called when the command is interrupted
    @Override
    protected void interrupted() {
        end();
    }
}
