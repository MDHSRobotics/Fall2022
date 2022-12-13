package frc.robot.commands.test;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.SparkMaxTester;

public class SpinTestMotor extends CommandBase {
    
    private SparkMaxTester m_sparkMaxTester;

    public SpinTestMotor(SparkMaxTester sparkMaxTester) {
        Logger.setup("Constructing Command: SpinTestMotor...");

        // Add given subsystem requirements
        m_sparkMaxTester = sparkMaxTester;
        addRequirements(m_sparkMaxTester);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: SpinTestMotor...");
    }

    @Override
    public void execute() {
        m_sparkMaxTester.spin();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
        
    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            Logger.ending("Interrupting Command: SpinTestMotor...");
        } else {
            Logger.ending("Ending Command: SpinTestMotor...");
        }
    }

}
