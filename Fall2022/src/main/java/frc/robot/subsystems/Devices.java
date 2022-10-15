package frc.robot.subsystems;

import frc.robot.devices.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

import frc.robot.subsystems.constants.MotorIDConstants;
// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    // Pickup
    public static CANSparkMax sparkMaxPickup = new CANSparkMax(MotorIDConstants.motorIdPickup, MotorType.kBrushless);

    // Pneumatics
    public static Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    public static Solenoid pickupSolenoidOne = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    public static Solenoid pickupSolenoidTwo = new Solenoid(PneumaticsModuleType.CTREPCM, 1);

    // Conveyor
    public static CANSparkMax sparkMaxConveyor = new CANSparkMax(MotorIDConstants.motorIdConveyor, MotorType.kBrushless);

    public static CANSparkMax sparkMaxShooterTopWheel = new CANSparkMax(MotorIDConstants.motorIdTopShooter, MotorType.kBrushless);
    public static CANSparkMax sparkMaxShooterBottomWheel = new CANSparkMax(MotorIDConstants.motorIdBottomShooter, MotorType.kBrushless);
} 