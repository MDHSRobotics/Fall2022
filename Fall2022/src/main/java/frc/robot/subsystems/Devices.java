package frc.robot.subsystems; 
 
import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.subsystems.constants.MotorIDConstants;
 
public class Devices { 
    public static CANSparkMax sparkMaxShooterTopWheel = new CANSparkMax(MotorIDConstants.motorIdTopShooter, MotorType.kBrushless);
    public static CANSparkMax sparkMaxShooterBottomWheel = new CANSparkMax(MotorIDConstants.motorIdBottomShooter, MotorType.kBrushless);
} 
