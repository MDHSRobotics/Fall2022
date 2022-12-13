package frc.robot.commands.shoot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.BotControllers;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;

public class ShootSlider extends CommandBase {
    
    private Shooter m_shooter;

    public ShootSlider(Shooter shooter) {
        Logger.setup("Constructing Command: ShootSlider...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ShootSlider...");
        m_shooter.setShooterEnableState(true);
    }

    @Override
    public void execute() {
        double sliderValue = BotControllers.jstick.jstick.getRawAxis(3);

        if (sliderValue > 0.9) {
            m_shooter.shootMin();
        } else if (sliderValue < -0.9) {
            m_shooter.shootMax();
        } else {
            m_shooter.shootMid();
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: ShootSlider...");
        } else {
            Logger.ending("Ending Command: ShootSlider...");
        }
        m_shooter.setShooterEnableState(false);
    }

}
