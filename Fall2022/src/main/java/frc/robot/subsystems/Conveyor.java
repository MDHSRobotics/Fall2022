package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.sparkMaxConveyor;

public class Conveyor extends SubsystemBase{

    private static boolean m_isConveyorToggled = false;

    public Conveyor() {
        Logger.setup("Constructing Subsystem: Delivery...");
    }

    public void stopConveyor() {
        sparkMaxConveyor.stopMotor();
    }

    public void spinConveyor(double power) {
        sparkMaxConveyor.set(power);
    }

    public boolean getConveyorToggleState() {
        return m_isConveyorToggled;
    }

    public void invertConveyorToggleState() {
        m_isConveyorToggled = !m_isConveyorToggled;
    }

}
