package frc.robot.subsystems;

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

    // Pneumatics
    public static Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    public static Solenoid solenoidOne = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    public static Solenoid solenoidTwo = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
    public static Solenoid solenoidThree = new Solenoid(PneumaticsModuleType.CTREPCM, 4);

}
