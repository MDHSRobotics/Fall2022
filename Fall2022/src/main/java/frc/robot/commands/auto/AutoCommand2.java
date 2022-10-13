package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.robot.BotSubsystems;
import frc.robot.commands.ExampleCommand;

public class AutoCommand2 extends SequentialCommandGroup {

    public AutoCommand2() {

        addCommands(
            
            new PrintCommand("Starting Command Group for AutoCommand2 ..."),

            // First sub-command
            new ExampleCommand(BotSubsystems.exampleSubsystem, "Auto-2a", 5),

            // Second sub-command
            new ExampleCommand(BotSubsystems.exampleSubsystem, "Auto-2b", 5),

            // Third sub-command
            new ExampleCommand(BotSubsystems.exampleSubsystem, "Auto-2c", 5),

            new PrintCommand("Ending Command Group for AutoCommand2 ...")
        );
    }

}
