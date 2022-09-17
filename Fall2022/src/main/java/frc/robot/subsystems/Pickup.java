package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.subsystems.Devices.*;

public class Pickup extends SubsystemBase{

    public Pickup() {
        pcmCompressor.enableDigital();
        pickupSolenoidOne.set(false);
        pickupSolenoidTwo.set(false);
    }

    public void extendPickup() {
        pickupSolenoidOne.set(true);
        pickupSolenoidTwo.set(true);
    }

    public void retractPickup() {
        pickupSolenoidOne.set(false);
        pickupSolenoidTwo.set(false);
    }

    public void toggleRoller() {
        talonSrxPickupLeft.set(0.5);
        talonSrxPickupRight.set(-0.5);
    }

    public void stopRoller() {
        talonSrxPickupLeft.stopMotor();
        talonSrxPickupRight.stopMotor();
    }
}

