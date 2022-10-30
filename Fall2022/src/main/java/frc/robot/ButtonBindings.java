package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure jstick buttons
    public static void configureJoystick() {
        Logger.setup("Configure Buttons -> Jstick Controller...");
        
        // SwerveDrive
        BotControllers.jstick.jstickBtn7.whenPressed(BotCommands.toggleDriverOrientation);

    }

    // Configure xbox buttons
    public static void configureXbox() {
        Logger.setup("Configure Buttons -> Xbox Controller...");

        // Conveyor
        BotControllers.xbox.btnDpadUp.whileHeld(BotCommands.spinConveyor);
        BotControllers.xbox.btnDpadDown.whileHeld(BotCommands.reverseConveyor);

        // Pickup
        BotControllers.xbox.btnA.whenPressed(BotCommands.togglePickup);
        
        // Shooter
        BotControllers.xbox.btnBumperLeft.whenHeld(BotCommands.shootMin);
        BotControllers.xbox.btnBumperRight.whenHeld(BotCommands.shootMid);
        BotControllers.xbox.btnBumperBoth.whileActiveOnce(BotCommands.shootMax, true);

        // SwerveDrive
        BotControllers.xbox.btnStart.whenPressed(BotCommands.toggleDriverOrientation);

        // SparkMax Test
        BotControllers.xbox.btnB.whileHeld(BotCommands.spinTestMotor);

    }

}
