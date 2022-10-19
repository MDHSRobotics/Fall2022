// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shoot;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;

/** An example command that uses an example subsystem. */
public class ShootMid extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Shooter m_shooter;

  /**
   * Creates a new Shoot.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShootMid(Shooter subsystem) {

    m_shooter = subsystem;

    Logger.setup("Constructing Command: Shoot Mid...");

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooter);
  }

  @Override
  public void initialize() {
    Logger.action("Initializing Command: Shoot Mid...");
  }

  @Override
  public void execute() {
    m_shooter.shootMid();
  }

  // This command continues until interrupted
  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    if (interrupted) {
        Logger.ending("Interrupting Command: Shoot Mid...");
    } else {
        Logger.ending("Ending Command: Shoot Mid...");
    }
  }

}
