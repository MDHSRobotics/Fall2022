package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.brains.IntakeBrain;
import frc.robot.consoles.Logger;

import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Pickup;
import frc.robot.subsystems.Shooter;

public class DefaultConveyor extends CommandBase {

    private Conveyor m_conveyor;

    private boolean m_shooterEnableState;
    private boolean m_conveyorLimitSwitchEnableState;
    private boolean m_pickupToggleState;

    public DefaultConveyor(Conveyor conveyor) {
        Logger.setup("Constructing Command: DefaultConveyor...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: DefaultConveyor...");
    }

    @Override
    public void execute() {
        m_shooterEnableState = Shooter.getShooterEnableState();
        m_conveyorLimitSwitchEnableState = m_conveyor.getLimitSwitchEnableState();
        m_pickupToggleState = Pickup.getPickupToggleState();

        if ((m_shooterEnableState) || ((!m_conveyorLimitSwitchEnableState) && (m_pickupToggleState))) {
            m_conveyor.spinConveyor(IntakeBrain.getConveyorPower());
        } else {
            m_conveyor.stopConveyor();
        } 
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: DefaultConveyor...");
        } else {
            Logger.ending("Ending Command: DefaultConveyor...");
        }
    }
    
}
