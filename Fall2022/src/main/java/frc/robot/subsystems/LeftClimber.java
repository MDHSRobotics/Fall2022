package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.sparkMaxLeftClimber;

public class LeftClimber extends SubsystemBase {

    public LeftClimber() {
        Logger.setup("Constructing Subsystem: LeftClimber...");

        sparkMaxLeftClimber.restoreFactoryDefaults();
    } 

    // Stop the climber
    public void stopLeftClimb() {
        sparkMaxLeftClimber.stopMotor();
    }
    
    // Move left climb based on thumbstick position
    public void moveLeftClimb(double power) {
        sparkMaxLeftClimber.set(power);
        Logger.info("Left Climb Motor Power: " + power);
    }
}