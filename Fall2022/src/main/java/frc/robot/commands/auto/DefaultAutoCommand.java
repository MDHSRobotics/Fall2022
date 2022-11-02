package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.constants.AutoConstants;

public class DefaultAutoCommand extends SequentialCommandGroup {

    public DefaultAutoCommand() {
    
        addCommands(

            // Roll conveyor to shoot pre-loaded ball into high port 
            new ShootSequence(AutoConstants.kInitialTopShooterWheelPower, AutoConstants.kInitialBottomShooterWheelPower),

            // Back up to give space for robot to turn towards second ball
            new MoveBackward(AutoConstants.kMoveBackwardTimeSeconds)

        );

    }

}