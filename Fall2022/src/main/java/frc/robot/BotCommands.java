package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

//import frc.robot.commands.swervedriver.*;
import frc.robot.commands.auto.*;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.pickup.*;

import frc.robot.consoles.Logger;

public class BotCommands {

	// Pickup
    public static TogglePickup togglePickup;
    // Example Command to be used as a placeholder until real commands implemented
    public static ExampleCommand exampleCommand;
    public static SpinConveyor spinConveyor;
    public static StopConveyor stopConveyor;
    public static RaisePickup raisePickup;
    public static LowerPickup lowerPickup;

    // Auto Command options
    public static AutoCommand1 autoCommand1;
    public static AutoCommand2 autoCommand2;
    public static SendableChooser<Command> autoCommandChooser;


	// SwerveDriver
    // public static SwerveDrive swerveDrive;
    // public static ToggleDriverOrientation toggleDriverOrientation;
    // public static DriveBox driveBox;

    public static void initializeCommands() {
        
        Logger.setup("Initializing BotCommands...");

        // Pickup
        togglePickup = new TogglePickup(BotSubsystems.pickup);
        spinConveyor = new SpinConveyor(BotSubsystems.conveyor);
        stopConveyor = new StopConveyor(BotSubsystems.conveyor);
        raisePickup = new RaisePickup(BotSubsystems.pickup);
        lowerPickup =  new LowerPickup(BotSubsystems.pickup);

        // Re-usable Example Command
        exampleCommand = new ExampleCommand(BotSubsystems.exampleSubsystem, "Default", 10);

        // Auto Commands
        autoCommand1 = new AutoCommand1();
        autoCommand2 = new AutoCommand2();

        // Add commands to the autonomous command chooser
        autoCommandChooser = new SendableChooser<>();
        autoCommandChooser.setDefaultOption("Auto Command One", BotCommands.autoCommand1);
        autoCommandChooser.addOption("Auto Command Two", BotCommands.autoCommand2);

    }
}
