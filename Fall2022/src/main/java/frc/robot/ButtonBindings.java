package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    public static void configureJoystick() {
        
        // SwerveDrive
        BotControllers.jstick.jstickBtn7.whenPressed(BotCommands.toggleDriverOrientation);

    }

    // Configure xbox buttons
    public static void configureXbox() {
        Logger.setup("Configure Buttons -> Xbox Controller...");

        // Pickup
        BotControllers.xbox.btnB.whenPressed(BotCommands.spinConveyor);

        // Shooter
        BotControllers.xbox.btnBumperLeft.whenHeld(BotCommands.shoot);

        // SwerveDrive
        BotControllers.xbox.btnStart.whenPressed(BotCommands.toggleDriverOrientation);

        //SparkMax Test
        BotControllers.xbox.btnStart.whileHeld(BotCommands.spinTestMotor);

    }

}
