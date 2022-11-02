package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotSubsystems;
import frc.robot.commands.pickup.TogglePickup;
import frc.robot.subsystems.constants.AutoConstants;

// Autonomous pathing for ball on the left
public class AutoCommand1 extends SequentialCommandGroup {

    public AutoCommand1() {
    
        addCommands(

            // Roll conveyor to shoot pre-loaded ball into high port 
            new ShootSequence(AutoConstants.kInitialTopShooterWheelPower, AutoConstants.kInitialBottomShooterWheelPower),

            // Back up to give space for robot to turn towards second ball
            new MoveBackward(AutoConstants.kMoveBackwardTimeSeconds),

            // Lower pickup to get ready for picking up second ball
            new TogglePickup(BotSubsystems.pickup),
            
            // Turn towards second ball
            new TurnAngle(AutoConstants.kAngleToBallRadiansPathOne),

            // Move towards and pick up second ball
            new MoveForward(AutoConstants.kMoveToBallTimeSecondsPathOne),

            // Turn towards goal
            new TurnAngle(AutoConstants.kAngleToPortRadiansPathOne),

            // Shoot second ball into high port
            new ShootSequence(AutoConstants.kSecondBallTopShooterWheelPowerPathOne, AutoConstants.kSecondBallBottomShooterWheelPowerPathOne)
        );

    }

}