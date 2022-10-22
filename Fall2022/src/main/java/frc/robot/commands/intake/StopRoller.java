package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Pickup;

public class StopRoller extends CommandBase {

    private Pickup m_pickup;

    public StopRoller(Pickup pickup) {
        Logger.setup("Constructing Command: StopRoller...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopRoller...");
    }

    @Override
    public void execute() {
        m_pickup.stopRoller();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: StopRoller...");
        } else {
            Logger.ending("Ending Command: StopRoller...");
        }
    }

}
