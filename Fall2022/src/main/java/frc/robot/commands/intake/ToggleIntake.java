package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Pickup;

public class ToggleIntake extends CommandBase {

    private Conveyor m_conveyor;
    private Pickup m_pickup; 

    public ToggleIntake(Conveyor conveyor, Pickup pickup) {
        Logger.setup("Constructing Command: ToggleIntake...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ToggleIntake...");
        
        m_conveyor.invertConveyorToggleState();
        m_pickup.invertRollerToggleState();
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
            Logger.ending("Interrupting Command: ToggleIntake...");
        } else {
            Logger.ending("Ending Command: ToggleIntake...");
        }
    }
    
}
