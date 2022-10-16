package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.BotControllers;
import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.sparkMaxRightClimber;

public class RightClimber extends SubsystemBase {

    private double m_rightThumbstickPosition;

    public RightClimber() {
        Logger.setup("Constructing Subsystem: RightClimber...");

        sparkMaxRightClimber.restoreFactoryDefaults();
    } 

    // Stop the climber
    public void stopRightClimb() {
        sparkMaxRightClimber.stopMotor();
    }

    // Move right climb based on thumbstick position
    public void moveRightClimb() {
        sparkMaxRightClimber.set(m_rightThumbstickPosition);
        Logger.info("Right Thumstick Position: " + m_rightThumbstickPosition);
    }

    public void setRightThumbstickPosition() {
        m_rightThumbstickPosition = BotControllers.xbox.xbox.getRightY();
    }
    
}