package frc.robot.commands.shoot;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;
import frc.robot.sensors.Limelight;

public class ShootLimelight extends CommandBase {

    private final Shooter m_shooter; 

    public ShootLimelight(Shooter shooter) {
        Logger.setup("Constructing Command: ShootMax...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ShootMax...");
        m_shooter.setShooterEnableState(true);
    }

    @Override
    public void execute() {
        double power = Limelight.calculateDistanceToTarget();
        m_shooter.shootLimelight(power);;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: ShootMax...");
        } else {
            Logger.ending("Ending Command: ShootMax...");
        }
        m_shooter.setShooterEnableState(false);
    }

}
