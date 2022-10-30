package frc.robot.commands.shoot;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
    
    private Shooter m_shooter;

    public Shoot(Shooter shooter) {
        Logger.setup("Constructing Command: Shoot...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: Shoot...");
        m_shooter.setShooterEnableState(true);
    }

    @Override
    public void execute() {
        m_shooter.shootInput();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: Shoot...");
        } else {
            Logger.ending("Ending Command: Shoot...");
        }
        m_shooter.setShooterEnableState(false);
    }

}
