package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.sparkMaxRightClimber;

public class RightClimber extends SubsystemBase {

    public RightClimber() {
        Logger.setup("Constructing Subsystem: RightClimber...");

        sparkMaxRightClimber.restoreFactoryDefaults();
    } 

    // Stop the climber
    public void stopRightClimb() {
        sparkMaxRightClimber.stopMotor();
    }

    // Move right climb based on thumbstick position
    public void moveRightClimb(double power) {
        sparkMaxRightClimber.set(power);
        Logger.info("Right Climb Motor Power: " + power);
    }
}