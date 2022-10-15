
package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RightClimber;

public class MoveRightClimb extends CommandBase {

    private RightClimber m_climber; 

    public MoveRightClimb(RightClimber climber) {
        Logger.setup("Constructing Command: Move Right Climb...");

        // Add given subsystem requirements
        m_climber = climber;
        addRequirements(m_climber);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: Move Right Climb...");
    }

    @Override
    public void execute() {
        m_climber.setRightThumbstickPosition();
        m_climber.moveRightClimb();
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: Move Right Climb...");
        } else {
            Logger.ending("Ending Command: Move Right Climb...");
        }
        m_climber.stopRightClimb();
    }

}
