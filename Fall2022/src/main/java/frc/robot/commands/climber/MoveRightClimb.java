
package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.BotControllers;
import frc.robot.brains.*;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.RightClimber;

public class MoveRightClimb extends CommandBase {

    private RightClimber m_climber; 

    public MoveRightClimb(RightClimber climber) {
        Logger.setup("Constructing Command: MoveRightClimb...");

        // Add given subsystem requirements
        m_climber = climber;
        addRequirements(m_climber);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: MoveRightClimb...");
    }

    @Override
    public void execute() {
        double rightThumbstickPositionY = BotControllers.xbox.xbox.getRightY();
        double power = rightThumbstickPositionY * ClimbBrain.getClimbPower();
        m_climber.moveRightClimb(power);
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: MoveRightClimb...");
        } else {
            Logger.ending("Ending Command: MoveRightClimb...");
        }
        m_climber.stopRightClimb();
    }

}
