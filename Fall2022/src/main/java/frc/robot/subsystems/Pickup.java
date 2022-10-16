package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.subsystems.Devices.*;

public class Pickup extends SubsystemBase{

    public Pickup() {
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

    public void startRoller(double power) {
        sparkMaxPickup.set(power);

    }

    public void stopRoller() {
        sparkMaxPickup.stopMotor();
      
    }
    
}

