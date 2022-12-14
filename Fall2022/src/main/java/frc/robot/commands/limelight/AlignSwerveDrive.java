package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Limelight;

public class AlignSwerveDrive extends CommandBase {

    private Limelight m_limelight;

    public AlignSwerveDrive(Limelight limelight) {
        Logger.setup("Constructing Command: AlignSwerveDrive...");

        // Add given subsystem requirements
        m_limelight = limelight;
        addRequirements(m_limelight);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AlignSwerveDrive...");

        m_limelight.toggleAlignmentState();
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: AlignSwerveDrive...");
        } else {
            Logger.ending("Ending Command: AlignSwerveDrive...");
        }
        m_limelight.toggleAlignmentState();
    }

}
