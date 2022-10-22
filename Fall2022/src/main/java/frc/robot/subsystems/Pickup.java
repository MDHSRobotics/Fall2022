package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.*;

public class Pickup extends SubsystemBase{

    private static boolean m_isRollerToggled = false;

    public Pickup() {
        Logger.setup("Constructing Subsystem: Pickup...");

        pcmCompressor.enableDigital();
        pickupSolenoidOne.set(false);
        pickupSolenoidTwo.set(false);
    }

    public void lowerPickup() {
        pickupSolenoidOne.set(true);
        pickupSolenoidTwo.set(true);
    }

    public void raisePickup() {
        pickupSolenoidOne.set(false);
        pickupSolenoidTwo.set(false);
    }

    public void spinRoller(double power) {
        sparkMaxPickup.set(power);

    }

    public void stopRoller() {
        sparkMaxPickup.stopMotor();
      
    }

    public boolean getRollerToggleState() {
        return m_isRollerToggled;
    }

    public void invertRollerToggleState() {
        m_isRollerToggled = !m_isRollerToggled;
    }
    
}

