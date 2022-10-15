package frc.robot.subsystems; 
 
import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
 
public class Devices { 
    public static CANSparkMax sparkMaxShooterTopWheel = new CANSparkMax(58 ,MotorType.kBrushless);
    public static CANSparkMax sparkMaxShooterBottomWheel = new CANSparkMax(60 ,MotorType.kBrushless);
} 
