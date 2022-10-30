package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.sparkMaxConveyor;
import static frc.robot.subsystems.Devices.conveyorLimitSwitch;

public class Conveyor extends SubsystemBase{

    public Conveyor() {
        Logger.setup("Constructing Subsystem: Delivery...");
    }

    public void stopConveyor() {
        sparkMaxConveyor.stopMotor();
    }

    public void spinConveyor(double power) {
        sparkMaxConveyor.set(power);
    }

    public boolean getLimitSwitchEnableState() {
        return conveyorLimitSwitch.get(); 
    }

}
