
package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.consoles.Shuffler;

import frc.robot.consoles.Logger;
import frc.robot.consoles.Shuffler;

// This is where the robot state is initialized and persisted.
public class RobotManager {

    //--------------//
    // Robot States //
    //--------------//

    public enum Variant {
        TEST_BOARD, TEST_DRIVE, BUILD_HOME, BUILD_AWAY
    }

    // Variant is used to configure different device mappings for different "robots"
    // TODO: This needs to be added to the Brain and Shuffleboard, so that it is settable on the fly
    public static Variant botVariant = Variant.TEST_BOARD;

    // If the robot is running in the real world or in simulation
    public static final boolean isReal = RobotBase.isReal();
    public static final boolean isSim = !isReal;

    //-------------------------------//
    // Shuffleboard & SmartDashboard //
    //-------------------------------//

    // The robot Shuffler instance
    public static Shuffler botShuffler;


    //----------------//
    // Initialization //
    //----------------//

    // It is important that the robot be initialized in exactly this order.
    public static void initialize() {
        Logger.setup("Initializing RobotManager...");

        // Pre-intialize the Shuffler
        botShuffler = new Shuffler();
        botShuffler.preInitialize();

        // Initialize BotSensors, BotSubsystems, BotCommands, and TestCommands
        BotSensors.initializeSensors();
        BotSubsystems.initializeSubsystems();
        BotCommands.initializeCommands();

        // Intialize and configure the Shuffler
        botShuffler.initialize();
        botShuffler.configure();    

    }

}
