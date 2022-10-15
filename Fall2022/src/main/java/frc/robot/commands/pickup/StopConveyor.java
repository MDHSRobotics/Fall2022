package frc.robot.commands.pickup;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;

public class StopConveyor extends CommandBase {

    private Conveyor m_conveyor;

    public StopConveyor(Conveyor conveyor) {
        Logger.setup("Constructing Command: StopConveyor...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopConveyor...");
    }

    @Override
    public void execute() {
        m_conveyor.stopConveyor();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: StopConveyor...");
        } else {
            Logger.ending("Ending Command: StopConveyor...");
        }
    }

}

