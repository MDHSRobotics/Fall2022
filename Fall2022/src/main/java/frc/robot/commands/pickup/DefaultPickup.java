package frc.robot.commands.pickup;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.brains.IntakeBrain;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Pickup;

public class DefaultPickup extends CommandBase {

    private Pickup m_pickup;

    public DefaultPickup(Pickup pickup) {
        Logger.setup("Constructing Command: DefaultPickup...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: DefaultPickup...");
    }

    @Override
    public void execute() {
        if (Pickup.getPickupToggleState()) {
            m_pickup.lowerPickup();
            m_pickup.spinRoller(IntakeBrain.getSpinPower());
        } else {
            m_pickup.raisePickup();
            m_pickup.stopRoller();
        }
    }

    @Override
    public boolean isFinished() {
        return false;

    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: DefaultPickup...");
        } else {
            Logger.ending("Ending Command: DefaultPickup...");
        }
    }
    
}
