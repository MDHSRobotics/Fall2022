package frc.robot.subsystems; 
 
import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
 
public class Devices { 
    public static CANSparkMax sparkMaxShooterTopWheel = new CANSparkMax(0 ,MotorType.kBrushless);
    public static CANSparkMax sparkMaxShooterBottomWheel = new CANSparkMax(1 ,MotorType.kBrushless);
} 
