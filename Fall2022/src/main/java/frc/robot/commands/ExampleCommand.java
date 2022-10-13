// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.consoles.Logger;

/** An example command that uses an example subsystem. */
public class ExampleCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ExampleSubsystem m_subsystem;
  private final String m_commandName;
  private int m_tries;
  private final int m_maxTries;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(ExampleSubsystem subsystem, String commandName, int maxTries) {

    m_subsystem = subsystem;
    m_commandName = commandName;
    m_maxTries = maxTries;
    m_tries = 0;

    Logger.setup("Constructing Command: Example (" + m_commandName + ") ...");

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {
    Logger.action("Initializing Command: Example (" + m_commandName + ") ...");
    m_tries = 0;
  }

  @Override
  public void execute() {
    m_subsystem.doSomething();
    m_tries += 1;
  }

  // This command continues until interrupted
  @Override
  public boolean isFinished() {
    boolean allDone = m_tries >= m_maxTries;
    return allDone;
  }

  @Override
  public void end(boolean interrupted) {
    if (interrupted) {
        System.out.println("--");
        Logger.ending("Interrupting Command: Example (" + m_commandName + ") ...");
    } else {
        Logger.ending("Ending Command: Example (" + m_commandName + ") ...");
    }
  }

}
