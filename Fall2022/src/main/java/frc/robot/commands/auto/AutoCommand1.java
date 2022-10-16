package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.PrintCommand;

import frc.robot.BotSubsystems;
import frc.robot.commands.ExampleCommand;

public class AutoCommand1 extends SequentialCommandGroup {

    public AutoCommand1() {
    
        addCommands(

            new PrintCommand("Starting Command Group for AutoCommand1 ..."),

            // First sub-command
            new ExampleCommand(BotSubsystems.exampleSubsystem, "Auto-1a", 10),

            // Second sub-command
            new ExampleCommand(BotSubsystems.exampleSubsystem, "Auto-1b", 10),

            new PrintCommand("Ending Command Group for AutoCommand1 ...")
        );

    }

}