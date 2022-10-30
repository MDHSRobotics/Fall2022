package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.BotSubsystems;
import frc.robot.commands.swervedrive.TimedSwerve;

public class Wait extends SequentialCommandGroup {

    public Wait(double seconds) {

        addCommands(
            new TimedSwerve(BotSubsystems.swerveDriver, 0.0, 0.0, 0.0, seconds)
        );
    }

}