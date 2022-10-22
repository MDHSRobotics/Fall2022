package frc.robot.commands.test;

import frc.robot.subsystems.SparkMaxTester;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class StopTestMotor extends CommandBase {
  
  private final SparkMaxTester m_sparkMaxTester;

  public StopTestMotor(SparkMaxTester sparkMaxTester) {
    m_sparkMaxTester = sparkMaxTester;
    
    addRequirements(m_sparkMaxTester);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_sparkMaxTester.stop();
  }
    
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
}
