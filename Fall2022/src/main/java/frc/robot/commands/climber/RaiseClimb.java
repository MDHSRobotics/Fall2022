
package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.XboxPositionAccessible;
import frc.robot.oi.positions.ThumbstickPosition;
import frc.robot.subsystems.Climber;

public class RaiseClimb extends CommandBase {

    private Climber m_Climber;
    private final XboxPositionAccessible m_Controller;
    private ThumbstickPosition m_Thumbstickpos;

    public RaiseClimb(Climber climber, XboxPositionAccessible controller) {
        Logger.setup("Constructing Command: RaiseArms...");

        // Add given subsystem requirements
        m_Climber = climber;
        m_Controller = controller;
        addRequirements(m_Climber);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RaiseArms...");
    }

    @Override
    public void execute() {
        
        m_Climber.raiseClimb(m_Thumbstickpos.getPositions(m_Controller, false).rightForwardBackPosition);
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: RaiseClimb...");
        } else {
            Logger.ending("Ending Command: RaiseClimb...");
        }
     
    }

}
