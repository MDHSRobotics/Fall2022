package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.BotControllers;
import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.sparkMaxLeftClimber;

public class LeftClimber extends SubsystemBase {

    private double m_leftThumbstickPosition;

    public LeftClimber() {
        Logger.setup("Constructing Subsystem: LeftClimber...");

        sparkMaxLeftClimber.restoreFactoryDefaults();
    } 

    // Stop the climber
    public void stopLeftClimb() {
        sparkMaxLeftClimber.stopMotor();
    }
    
    // Move left climb based on thumbstick position
    public void moveLeftClimb() {
        sparkMaxLeftClimber.set(m_leftThumbstickPosition);
        Logger.info("Left Thumstick Position: " + m_leftThumbstickPosition);
    }

    public void setLeftThumbstickPosition() {
        m_leftThumbstickPosition = BotControllers.xbox.xbox.getLeftY();
    }
    
}