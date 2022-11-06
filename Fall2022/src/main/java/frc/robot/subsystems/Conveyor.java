package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.sparkMaxConveyor;
import static frc.robot.subsystems.Devices.sparkMaxCownveyorLimitSwitch;;

public class Conveyor extends SubsystemBase{

    public Conveyor() {
        Logger.setup("Constructing Subsystem: Conveyor...");

        sparkMaxConveyor.setSmartCurrentLimit(15);   
    }

    public void stopConveyor() {
        sparkMaxConveyor.stopMotor();
    }

    public void spinConveyor(double power) {
        sparkMaxConveyor.set(power);
    }

    public boolean getLimitSwitchEnableState() { 
        return sparkMaxCownveyorLimitSwitch.isPressed();
    }

}
