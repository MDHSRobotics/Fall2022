package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.BotSubsystems;
import frc.robot.commands.swervedrive.TimedSwerve;
import frc.robot.subsystems.constants.AutoConstants;
import frc.robot.subsystems.constants.SwerveConstants;

public class TurnAngle extends SequentialCommandGroup {

    public TurnAngle(double angle) {

        addCommands(
                new TimedSwerve(BotSubsystems.swerveDriver, 0.0, 0.0, (angle) / (AutoConstants.timePerCommand - SwerveConstants.kDriveRampTime), AutoConstants.timePerCommand)
        );
    }

}