package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.brains.DeliveryBrain;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;

public class ReverseConveyor extends CommandBase {

    private Conveyor m_conveyor;

    public ReverseConveyor(Conveyor conveyor) {
        Logger.setup("Constructing Command: ReverseConveyor...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ReverseConveyor...");
    }

    @Override
    public void execute() {
        m_conveyor.spinConveyor(-DeliveryBrain.getConveyorPower());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: ReverseConveyor...");
        } else {
            Logger.ending("Ending Command: ReverseConveyor...");
        }
    }

}
