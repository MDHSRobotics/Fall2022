package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.swervedrive.TimedSwerve;
import frc.robot.subsystems.constants.AutoConstants;
import frc.robot.subsystems.constants.SwerveConstants;

public class TurnAround extends SequentialCommandGroup {

    public TurnAround() {

        addCommands(
                new TimedSwerve(BotSubsystems.swerveDriver, 0.0, 0.0, (Math.PI) / (AutoConstants.timePerCommand - SwerveConstants.kDriveRampTime), AutoConstants.timePerCommand)
        );
    }

}