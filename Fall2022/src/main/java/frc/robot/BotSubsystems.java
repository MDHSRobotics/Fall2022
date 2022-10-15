package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

public class BotSubsystems {

    public static ExampleSubsystem exampleSubsystem;
    public static Shooter shooter;
    //public static SwerveDriver swerveDriver;
    public static Pickup pickup;
    public static Conveyor conveyor;

    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        exampleSubsystem = new ExampleSubsystem();
        shooter = new Shooter();
        //swerveDriver = new SwerveDriver();
        pickup = new Pickup();
        conveyor = new Conveyor();
    }

    public static void setTeleopDefaultCommands() {

        // Shooter
        Logger.setup("Shooter Teleop Default Command -> Stop Shooter...");
        shooter.setDefaultCommand(BotCommands.stopShooter);

        // Pickup
        Logger.setup("Pickup Teleop Default Command -> FeedPickup...");
        conveyor.setDefaultCommand(BotCommands.stopConveyor); 
        pickup.setDefaultCommand(BotCommands.raisePickup);
    }

}
