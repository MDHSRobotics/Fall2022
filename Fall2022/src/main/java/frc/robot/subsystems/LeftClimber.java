package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.BotControllers;
import static frc.robot.subsystems.Devices.sparkMaxLeftClimber;

import frc.robot.consoles.Logger;

public class LeftClimber extends SubsystemBase {

    private double m_leftThumbstickPosition;

    public LeftClimber() {
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