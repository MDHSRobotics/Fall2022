package frc.robot;

import frc.robot.subsystems.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static ExampleSubsystem exampleSubsystem;
    //public static SwerveDriver swerveDriver;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        exampleSubsystem = new ExampleSubsystem();
        //swerveDriver = new SwerveDriver();
    }

    // Set all the subsystem "teleop" default commands
    public static void setTeleopDefaultCommands() {

        // SwerveDriver
        //Logger.setup("SwerveDriver Teleop Default Command -> SwerveDrive...");
        //swerveDriver.setDefaultCommand(BotCommands.swerveDrive);

    }

}
