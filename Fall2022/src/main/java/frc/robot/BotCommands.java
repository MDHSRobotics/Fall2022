package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.ExampleCommand;
import frc.robot.commands.auto.*;
import frc.robot.commands.climber.*;
import frc.robot.commands.pickup.*;
import frc.robot.commands.shoot.*;
import frc.robot.commands.swervedrive.*;
import frc.robot.commands.test.*;
import frc.robot.consoles.Logger;

public class BotCommands {

    // Example Command to be used as a placeholder until real commands implemented
    public static ExampleCommand exampleCommand;

    // Auto Command options
    public static AutoCommand1 autoCommand1;
    public static AutoCommand2 autoCommand2;
    public static SendableChooser<Command> autoCommandChooser;

    // Climber
    public static MoveLeftClimb moveLeftClimb;
    public static MoveRightClimb moveRightClimb;

    // Conveyor
    public static SpinConveyor spinConveyor;
    public static StopConveyor stopConveyor;

    // Pickup
    public static RaisePickup raisePickup;
    public static LowerPickup lowerPickup;
    public static TogglePickup togglePickup;

    // Shooter
    public static Shoot shoot;
    public static StopShoot stopShoot;

    // SwerveDriver
    public static SwerveDrive swerveDrive;
    public static ToggleDriverOrientation toggleDriverOrientation;
    public static DriveBox driveBox;

    // SparkMax Test
    public static SpinTestMotor spinTestMotor;
    public static StopTestMotor stopTestMotor;

    // Initialize all robot commands
    public static void initializeCommands() {

        Logger.setup("Initializing BotCommands...");

        // Re-usable Example Command
        exampleCommand = new ExampleCommand(BotSubsystems.exampleSubsystem, "Default", 10);

        // Auto Commands
        autoCommand1 = new AutoCommand1();
        autoCommand2 = new AutoCommand2();

        // Add commands to the autonomous command chooser
        autoCommandChooser = new SendableChooser<>();
        autoCommandChooser.setDefaultOption("Auto Command One", BotCommands.autoCommand1);
        autoCommandChooser.addOption("Auto Command Two", BotCommands.autoCommand2);

        // Climber
        moveLeftClimb = new MoveLeftClimb(BotSubsystems.leftClimber);
        moveRightClimb = new MoveRightClimb(BotSubsystems.rightClimber);

        // Conveyor
        spinConveyor = new SpinConveyor(BotSubsystems.conveyor);
        stopConveyor = new StopConveyor(BotSubsystems.conveyor);

        // Pickup
        raisePickup = new RaisePickup(BotSubsystems.pickup);
        lowerPickup = new LowerPickup(BotSubsystems.pickup);
        togglePickup = new TogglePickup(BotSubsystems.pickup);

        // Shooter
        shoot = new Shoot(BotSubsystems.shooter);
        stopShoot = new StopShoot(BotSubsystems.shooter);

        // SwerveDriver
        swerveDrive = new SwerveDrive(BotSubsystems.swerveDriver, BotControllers.jstick); 
        toggleDriverOrientation = new ToggleDriverOrientation(BotSubsystems.swerveDriver);
        driveBox = new DriveBox();

        // SparkMax Test
        spinTestMotor = new SpinTestMotor(BotSubsystems.sparkMaxTester);
        stopTestMotor = new StopTestMotor(BotSubsystems.sparkMaxTester);

    }
}
