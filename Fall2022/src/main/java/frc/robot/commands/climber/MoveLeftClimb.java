
package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.BotControllers;
import frc.robot.brains.*;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.LeftClimber;

public class MoveLeftClimb extends CommandBase {

    private LeftClimber m_climber;


    public MoveLeftClimb(LeftClimber climber) {
        Logger.setup("Constructing Command: MoveLeftClimb...");

        // Add given subsystem requirements
        m_climber = climber;
        addRequirements(m_climber);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: MoveLeftClimb...");
    }

    @Override
    public void execute() {
        double leftThumbstickPositionY = BotControllers.xbox.xbox.getLeftY();
        double power = leftThumbstickPositionY * ClimbBrain.getClimbPower();
        m_climber.moveLeftClimb(power);
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: MoveLeftClimb...");
        } else {
            Logger.ending("Ending Command: MoveLeftClimb...");
        }
        m_climber.stopLeftClimb();
    }

}
