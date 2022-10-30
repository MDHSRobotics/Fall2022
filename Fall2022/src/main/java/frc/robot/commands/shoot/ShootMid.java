package frc.robot.commands.shoot;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;

public class ShootMid extends CommandBase {

    private final Shooter m_shooter; 

    public ShootMid(Shooter shooter) {
        Logger.setup("Constructing Command: ShootMid...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ShootMid...");
        m_shooter.setShooterEnableState(true);
    }

    @Override
    public void execute() {
        m_shooter.shootMid();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: ShootMid...");
        } else {
            Logger.ending("Ending Command: ShootMid...");
        }
        m_shooter.setShooterEnableState(false);
    }

}
