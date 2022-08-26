package frc.robot;

//import frc.robot.commands.swervedriver.*;

import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

	// SwerveDriver
    // public static SwerveDrive swerveDrive;
    // public static ToggleDriverOrientation toggleDriverOrientation;
    // public static DriveBox driveBox;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // SwerveDriver
        // swerveDrive = new SwerveDrive(BotSubsystems.swerveDriver, BotControllers.xbox);
        // toggleDriverOrientation = new ToggleDriverOrientation(BotSubsystems.swerveDriver);
        // driveBox = new DriveBox();
    }
}
