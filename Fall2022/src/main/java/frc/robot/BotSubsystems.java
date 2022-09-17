package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

public class BotSubsystems {

    public static ExampleSubsystem exampleSubsystem;
    //public static SwerveDriver swerveDriver;
    public static Pickup pickup;

    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        exampleSubsystem = new ExampleSubsystem();
        //swerveDriver = new SwerveDriver();
        pickup = new Pickup();
    
    }

    public static void setTeleopDefaultCommands() {

        // Pickup
        Logger.setup("Pickup Teleop Default Command -> FeedPickup...");
        pickup.setDefaultCommand(BotCommands.feedPickup); 
    }

}
