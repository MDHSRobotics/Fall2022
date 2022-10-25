package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.swervedrive.TimedSwerve; 
import frc.robot.subsystems.constants.AutoConstants;

public class MoveForward extends SequentialCommandGroup {

    public MoveForward () {
        double driveSpeedMPS = 0.3; 

        addCommands(
                new TimedSwerve(BotSubsystems.swerveDriver, driveSpeedMPS, 0.0, 0.0, AutoConstants.timePerCommand)
        );
    }

}