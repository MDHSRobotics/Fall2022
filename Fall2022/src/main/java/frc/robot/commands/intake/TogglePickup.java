package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Pickup;

public class TogglePickup extends CommandBase {

    private Pickup m_pickup;

    public TogglePickup(Pickup pickup) {
        Logger.setup("Constructing Command: TogglePickup...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: TogglePickups...");

        m_pickup.invertPickiupToggleState();
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return true;

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