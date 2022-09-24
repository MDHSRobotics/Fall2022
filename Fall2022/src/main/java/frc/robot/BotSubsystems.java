package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static SparkMaxTester sparkMaxTester;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        sparkMaxTester = new SparkMaxTester();
    
    }

    // Set all the subsystem "teleop" default commands
    public static void setTeleopDefaultCommands() {

        // SwerveDriver
        Logger.setup("SparkMaxTester Teleop Default Command -> Stop...");
        sparkMaxTester.setDefaultCommand(BotCommands.stop);

    }

}
