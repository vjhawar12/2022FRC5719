package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class IntakeJoystickCommand extends SequentialCommandGroup {
    IntakeJoystickCommand() {

    }

    @Override
    protected void initialize() {
        RobotContainer.intakeSubsystem.stop(); 
    }
}
