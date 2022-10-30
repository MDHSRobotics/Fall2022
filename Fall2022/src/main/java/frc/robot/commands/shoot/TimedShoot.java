package frc.robot.commands.shoot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;

public class TimedShoot extends CommandBase {

    private Shooter m_shooter;
    private double m_topWheelPower;
    private double m_bottomWheelPower;
    private double m_targetTime;
    private Timer m_timer;

    public TimedShoot(Shooter shooter, double topWheelPower, double bottomWheelPower, double timeInSeconds) {
        Logger.setup("Constructing Command: TimedShoot...");

        // Add given subsystem requirements
        m_shooter = shooter;
        m_topWheelPower = topWheelPower;
        m_bottomWheelPower = bottomWheelPower;
        m_targetTime = timeInSeconds;
        m_timer = new Timer();
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: TimedShoot...");
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        m_shooter.shootInput(m_topWheelPower, m_bottomWheelPower);
    }

    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();
        Logger.info(String.format("Current Time: %.2f, Target Time: %.2f",  currentTime, m_targetTime));

        if (currentTime > m_targetTime) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void end(boolean interrupted) {
        double currentTime = m_timer.get();
        if (interrupted) {
            Logger.ending(String.format("Interrupting Command: TimedShoot... Current Time: %.2f", currentTime));
        } else {
            Logger.ending(String.format("Ending Command: TimedShoot... Current Time: %.2f", currentTime));
        }
        m_shooter.stopShooter();
    }
}
