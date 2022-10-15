package frc.robot.subsystems;

import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkMaxLowLevel.MotorType; 

import frc.robot.subsystems.constants.MotorIDConstants;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    //Climb
    public static CANSparkMax sparkMaxLeftClimber = new CANSparkMax(MotorIDConstants.motorIdLeftClimb, MotorType.kBrushless); 
    public static CANSparkMax sparkMaxRightClimber = new CANSparkMax(MotorIDConstants.motorIdRightClimb, MotorType.kBrushless); 
}
