package frc.robot.commands.pickup;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Pickup;
import java.util.Timer;

public class TogglePickup extends CommandBase {

    private Pickup m_pickup;
    private double m_msPassed;
    private static boolean m_isPickupToggled;

    public TogglePickup(Pickup pickup) {
        Logger.setup("Constructing Command: TogglePickup...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: TogglePistons...");

        m_msPassed = 0;

        m_isPickupToggled = !m_isPickupToggled;
        if (m_isPickupToggled) {
            m_pickup.extendPickup();
        } else {
            m_pickup.retractPickup();
            m_pickup.stopRoller();
        }

    }

    @Override
    public void execute() {
        m_msPassed += 200;
    }

    @Override
    public boolean isFinished() {
        if (!m_isPickupToggled) {
            return true;
        } else if (m_isPickupToggled) {
            if (m_msPassed >= 1200) {
                m_pickup.toggleRoller();
                return true;
            }
        }
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
