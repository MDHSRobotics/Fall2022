package frc.robot.commands.test;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.SparkMaxTester;

public class StopTestMotor extends CommandBase {
    
    private SparkMaxTester m_sparkMaxTester;

    public StopTestMotor(SparkMaxTester sparkMaxTester) {
        Logger.setup("Constructing Command: StopTestMotor...");

        // Add given subsystem requirements
        m_sparkMaxTester = sparkMaxTester;
        addRequirements(m_sparkMaxTester);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopTestMotor...");
    }

    @Override
    public void execute() {
        m_sparkMaxTester.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
        
    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: StopTestMotor...");
        } else {
            Logger.ending("Ending Command: StopTestMotor...");
        }
    }

}
