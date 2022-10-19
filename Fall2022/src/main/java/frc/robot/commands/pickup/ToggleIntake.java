package frc.robot.commands.pickup;

import frc.robot.BotSubsystems;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Pickup;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ToggleIntake extends SequentialCommandGroup {

    private static boolean m_isIntakeToggled;

    public ToggleIntake(Conveyor conveyor, Pickup pickup) {
        if (!m_isIntakeToggled) {
            addCommands(
                new SpinConveyor(BotSubsystems.conveyor), 
                new SpinRoller(BotSubsystems.pickup)
            );
            m_isIntakeToggled = !m_isIntakeToggled;
        } else {
            addCommands(
                new StopConveyor(BotSubsystems.conveyor), 
                new StopRoller(BotSubsystems.pickup)
            );
            m_isIntakeToggled = !m_isIntakeToggled;
        }
    }

}
