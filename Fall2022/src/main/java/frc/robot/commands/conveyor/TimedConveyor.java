package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.brains.IntakeBrain;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;

public class TimedConveyor extends CommandBase {

    private Conveyor m_conveyor;
    private double m_targetTime;
    private double m_delayTime;
    private Timer m_timer;

    public TimedConveyor(Conveyor conveyor, double timeInSeconds, double delayInSecods) {
        Logger.setup("Constructing Command: TimedShoot...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        m_targetTime = timeInSeconds;
        m_delayTime = delayInSecods;
        m_timer = new Timer();
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: TimedShoot...");
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        double currentTime = m_timer.get();
         
        if (currentTime > m_delayTime) {
            m_conveyor.spinConveyor(IntakeBrain.getConveyorPower());
        }
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
        m_conveyor.stopConveyor();
    }
}
