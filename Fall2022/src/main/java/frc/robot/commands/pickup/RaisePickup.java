package frc.robot.commands.pickup;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Pickup;

import java.util.Timer;

public class RaisePickup extends CommandBase {

    private Pickup m_pickup;

    public RaisePickup(Pickup pickup) {
        Logger.setup("Constructing Command: RaisePickup...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RaisePickup...");
            m_pickup.raisePickup();
            m_pickup.stopRoller();
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        //need something to stop
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: RaisePickup...");
        } else {
            Logger.ending("Ending Command: RaisePickup...");
        }
    }
    
}
