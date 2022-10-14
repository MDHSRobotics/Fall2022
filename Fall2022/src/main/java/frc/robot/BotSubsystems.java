package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static ExampleSubsystem exampleSubsystem;
    public static Climber Climber;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        exampleSubsystem = new ExampleSubsystem();
        Climber = new Climber();
    }

    // Set all the subsystem "teleop" default commands
    public static void setTeleopDefaultCommands() {

        // Climber
        Logger.setup("PickerUpper Teleop Default Command -> Climber...");
        Climber.setDefaultCommand(BotCommands.raiseClimb);


    }

}
