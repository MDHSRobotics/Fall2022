package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static ExampleSubsystem exampleSubsystem;
    public static LeftClimber leftClimber;
    public static RightClimber rightClimber;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        exampleSubsystem = new ExampleSubsystem();
        leftClimber = new LeftClimber();
        rightClimber = new RightClimber();
    }

    // Set all the subsystem "teleop" default commands
    public static void setTeleopDefaultCommands() {

        // Climber
        Logger.setup("Left Climber Teleop Default Command -> Move Left Climb...");
        leftClimber.setDefaultCommand(BotCommands.moveLeftClimb);

        Logger.setup("Right Climber Teleop Default Command -> Move Right Climb...");
        rightClimber.setDefaultCommand(BotCommands.moveRightClimb);
    }
}
 