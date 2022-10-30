package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import frc.robot.BotSubsystems;
import frc.robot.commands.conveyor.TimedConveyor;
import frc.robot.commands.shoot.TimedShoot;
import frc.robot.subsystems.constants.AutoConstants;

public class ShootSequence extends ParallelCommandGroup {

    public ShootSequence(double topPower, double bottomPower) {

        addCommands(
            new TimedShoot(BotSubsystems.shooter, topPower, bottomPower, AutoConstants.kShootTimeSeconds),
            new TimedConveyor(BotSubsystems.conveyor, AutoConstants.kShootTimeSeconds)
        );
        
    }

}