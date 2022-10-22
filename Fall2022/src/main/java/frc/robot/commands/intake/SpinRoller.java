package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.brains.DeliveryBrain;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Pickup;

public class SpinRoller extends CommandBase {

    private Pickup m_pickup;

    public SpinRoller(Pickup pickup) {
        Logger.setup("Constructing Command: SpinRoller...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: SpinRoller...");
    }

    @Override
    public void execute() {
        m_pickup.spinRoller(DeliveryBrain.getSpinPower());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: SpinRoller...");
        } else {
            Logger.ending("Ending Command: SpinRoller...");
        }
    }

}
