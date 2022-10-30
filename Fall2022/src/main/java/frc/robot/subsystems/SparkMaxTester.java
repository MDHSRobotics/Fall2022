package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.sparkMaxTestMotor;

public class SparkMaxTester extends SubsystemBase {
    
    public SparkMaxTester() {
        Logger.setup("Constructing Subsystem: SparkMaxTester...");
        sparkMaxTestMotor.restoreFactoryDefaults();
    }

    public void spin() {
        sparkMaxTestMotor.set(0.5);
    }

    public void stop() {
        sparkMaxTestMotor.stopMotor();
    }

}
