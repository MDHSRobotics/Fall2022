package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Devices {
    public static CANSparkMax sparkMaxTestMotor = new CANSparkMax(55, MotorType.kBrushless);
}
