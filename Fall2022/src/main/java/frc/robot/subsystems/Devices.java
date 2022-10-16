package frc.robot.subsystems;

import frc.robot.devices.*;
import frc.robot.subsystems.constants.MotorIDConstants;

import com.ctre.phoenix.sensors.CANCoder;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    // Climb
    public static CANSparkMax sparkMaxLeftClimber = new CANSparkMax(MotorIDConstants.motorIdLeftClimb, MotorType.kBrushless);  
    public static CANSparkMax sparkMaxRightClimber = new CANSparkMax(MotorIDConstants.motorIdRightClimb, MotorType.kBrushless);

    // Pickup
    public static CANSparkMax sparkMaxPickup = new CANSparkMax(MotorIDConstants.motorIdPickup, MotorType.kBrushless);

    // Pneumatics
    public static Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    public static Solenoid pickupSolenoidOne = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    public static Solenoid pickupSolenoidTwo = new Solenoid(PneumaticsModuleType.CTREPCM, 1);

    // Conveyor
    public static CANSparkMax sparkMaxConveyor = new CANSparkMax(MotorIDConstants.motorIdConveyor, MotorType.kBrushless);

    // Shoot
    public static CANSparkMax sparkMaxShooterTopWheel = new CANSparkMax(MotorIDConstants.motorIdTopShooter, MotorType.kBrushless);
    public static CANSparkMax sparkMaxShooterBottomWheel = new CANSparkMax(MotorIDConstants.motorIdBottomShooter, MotorType.kBrushless);  

    // SwerveDrive
    public static DevTalonFX talonFxSwerveDriveFL = new DevTalonFX("talonFxSwerveDriveWheelFrontLeft", MotorIDConstants.motorIdDriveFL);
    public static DevTalonFX talonFxSwerveDriveFR = new DevTalonFX("talonFxSwerveDriveWheelFrontRight", MotorIDConstants.motorIdDriveFR);
    public static DevTalonFX talonFxSwerveDriveRL = new DevTalonFX("talonFxSwerveDriveWheelRearLeft", MotorIDConstants.motorIdDriveRL);
    public static DevTalonFX talonFxSwerveDriveRR = new DevTalonFX("talonFxSwerveDriveWheelRearRight", MotorIDConstants.motorIdDriveRR);
    public static DevTalonFX talonFxSwerveTurnFL = new DevTalonFX("talonFxSwerveTurnWheelFrontLeft", MotorIDConstants.motorIdTurnFL);
    public static DevTalonFX talonFxSwerveTurnFR = new DevTalonFX("talonFxSwerveTurnWheelFrontRight", MotorIDConstants.motorIdTurnFR);
    public static DevTalonFX talonFxSwerveTurnRL = new DevTalonFX("talonFxSwerveTurnWheelRearLeft", MotorIDConstants.motorIdTurnRL);
    public static DevTalonFX talonFxSwerveTurnRR = new DevTalonFX("talonFxSwerveTurnWheelRearRight", MotorIDConstants.motorIdTurnRR);

    public static CANCoder canCoderFR = new CANCoder(4);
    public static CANCoder canCoderRR = new CANCoder(3);
    public static CANCoder canCoderFL = new CANCoder(2);
    public static CANCoder canCoderRL = new CANCoder(1);

    // SparkMax Test
    public static CANSparkMax sparkMaxTestMotor = new CANSparkMax(1, MotorType.kBrushless);

} 