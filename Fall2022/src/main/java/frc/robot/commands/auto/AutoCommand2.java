package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.BotSubsystems;
import frc.robot.commands.pickup.TogglePickup;
import frc.robot.subsystems.constants.AutoConstants;

// Autonomous pathing for ball on the center
public class AutoCommand2 extends SequentialCommandGroup {

    public AutoCommand2() {
    
        addCommands(

            // Roll conveyor to shoot pre-loaded ball into high port 
            new ShootSequence(AutoConstants.kInitialTopShooterWheelPower, AutoConstants.kInitialBottomShooterWheelPower),

            // Back up to give space for robot to turn towards second ball
            new MoveBackward(AutoConstants.kMoveBackwardTimeSeconds),

            // Lower pickup to get ready for picking up second ball
            new TogglePickup(BotSubsystems.pickup),
            
            // Turn towards second ball
            new TurnAngle(AutoConstants.kAngleToBallRadiansPathTwo),

            // Move towards and pick up second ball
            new MoveForward(AutoConstants.kMoveToBallTimeSecondsPathTwo),

            // Turn towards goal
            new TurnAngle(AutoConstants.kAngleToPortRadiansPathTwo),

            // Shoot second ball into high port
            new ShootSequence(AutoConstants.kSecondBallTopShooterWheelPowerPathTwo, AutoConstants.kSecondBallBottomShooterWheelPowerPathTwo)
            
        );

    }

}