package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.BotSubsystems;
import frc.robot.commands.pickup.SpinConveyor;
import frc.robot.commands.pickup.TogglePickup;
import frc.robot.commands.shoot.ShootMax;

public class AutoCommand3 extends SequentialCommandGroup {

    public AutoCommand3() {
    
        addCommands(
            
            // lower the pickup and spin the roller
            new TogglePickup(BotSubsystems.pickup),

            // move forward until ball is collected
            new MoveForward(0.3),

            // turn around 180 degrees
            new TurnAngle(Math.PI),

            // start ramping up shooter
            new ShootMax(BotSubsystems.shooter),

            // give time for shooter to ramp up
            new Wait(0.5),

            // spin conveyor to deliver ball to shooter
            new SpinConveyor(BotSubsystems.conveyor)
            
        );

    }

}