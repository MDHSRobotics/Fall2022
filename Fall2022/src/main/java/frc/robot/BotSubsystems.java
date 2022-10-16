package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

public class BotSubsystems {

    public static ExampleSubsystem exampleSubsystem;
    public static LeftClimber leftClimber;
    public static RightClimber rightClimber; 
    public static Conveyor conveyor;
    public static Pickup pickup;
    public static Shooter shooter; 

    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        exampleSubsystem = new ExampleSubsystem();
        leftClimber = new LeftClimber();
        rightClimber = new RightClimber();
        conveyor = new Conveyor();
        pickup = new Pickup();
        shooter = new Shooter();
    }

    public static void setTeleopDefaultCommands() {

        // Climber
        Logger.setup("Left Climber Teleop Default Command -> MoveLeftClimb...");
        leftClimber.setDefaultCommand(BotCommands.moveLeftClimb);
        Logger.setup("Right Climber Teleop Default Command -> MoveRightClimb...");
        rightClimber.setDefaultCommand(BotCommands.moveRightClimb);

        // Conveyor
        Logger.setup("Pickup Teleop Default Command -> StopConveyor...");
        conveyor.setDefaultCommand(BotCommands.stopConveyor);

        // Pickup
        Logger.setup("Pickup Teleop Default Command -> FeedPickup...");
        pickup.setDefaultCommand(BotCommands.raisePickup);

        // Shooter
        Logger.setup("Shooter Teleop Default Command -> StopShoot...");
        shooter.setDefaultCommand(BotCommands.stopShooter);

    }
}
 