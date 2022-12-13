package frc.robot.commands.pickup;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Pickup;

public class LowerPickup extends CommandBase {

    private Pickup m_pickup;

    public LowerPickup(Pickup pickup) {
        Logger.setup("Constructing Command: LowerPickup...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LowerPickup...");
        m_pickup.lowerPickup();
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: LowerPickup...");
        } else {
            Logger.ending("Ending Command: LowerPickup...");
        }
    }

}
