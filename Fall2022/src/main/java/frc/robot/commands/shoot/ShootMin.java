package frc.robot.commands.shoot;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;

public class ShootMin extends CommandBase {

    private final Shooter m_shooter; 

    public ShootMin(Shooter shooter) {
        Logger.setup("Constructing Command: ShootMin...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ShootMin...");
        m_shooter.setShooterEnableState(true);
    }

    @Override
    public void execute() {
        m_shooter.shootMin();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: ShootMin...");
        } else {
            Logger.ending("Ending Command: ShootMin...");
        }
        m_shooter.setShooterEnableState(false);
    }

}
