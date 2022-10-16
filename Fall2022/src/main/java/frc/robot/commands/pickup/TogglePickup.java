package frc.robot.commands.pickup;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.brains.DeliveryBrain;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Pickup;

import java.util.Timer;

public class TogglePickup extends CommandBase {

    private Pickup m_pickup;
    private static boolean m_isPickupLowered = false;

    public TogglePickup(Pickup pickup) {
        Logger.setup("Constructing Command: TogglePickup...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: TogglePistons...");
        
        if (!m_isPickupLowered) {
            m_pickup.lowerPickup();
            m_pickup.startRoller(DeliveryBrain.getSpinPower());
        } else {
            m_pickup.raisePickup();
            m_pickup.stopRoller();
        }

        m_isPickupLowered = !m_isPickupLowered;
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
            Logger.ending("Interrupting Command: TogglePickup...");
        } else {
            Logger.ending("Ending Command: TogglePickup...");
        }
    }
    
}
