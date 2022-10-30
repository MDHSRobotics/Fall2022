package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.brains.IntakeBrain;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;

public class SpinConveyor extends CommandBase {

    private Conveyor m_conveyor;

    public SpinConveyor(Conveyor conveyor) {
        Logger.setup("Constructing Command: SpinConveyor...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: SpinConveyor...");
    }

    @Override
    public void execute() {
        m_conveyor.spinConveyor(IntakeBrain.getConveyorPower());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: SpinConveyor...");
        } else {
            Logger.ending("Ending Command: SpinConveyor...");
        }
    }

}
