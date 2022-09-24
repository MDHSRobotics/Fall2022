// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.subsystems.Devices.sparkMaxTestMotor;

public class SparkMaxTester extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public SparkMaxTester() {
    sparkMaxTestMotor.restoreFactoryDefaults();
  }

  public void spin(){
    sparkMaxTestMotor.set(0.5);
  }

  public void stop(){
    sparkMaxTestMotor.stopMotor();
  }
}
