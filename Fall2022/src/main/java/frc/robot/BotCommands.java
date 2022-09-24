package frc.robot;

//import frc.robot.commands.swervedriver.*;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.SparkMaxTester;
import frc.robot.commands.*;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

	// SwerveDriver
    public static Spin spin;
    public static Stop stop;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // SwerveDriver
        spin = new Spin(BotSubsystems.sparkMaxTester, BotControllers.xbox);
        stop = new Stop(BotSubsystems.sparkMaxTester, BotControllers.xbox);
    }
}
