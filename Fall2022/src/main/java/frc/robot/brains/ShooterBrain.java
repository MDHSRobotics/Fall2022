package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Shooter Subsystem,
// their default values, and methods for retrieving their current values.
public class ShooterBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double shootTopWheelCurrentVelocityDefault = 0.;
    public static double shootBottomWheelCurrentVelocityDefault = 0.;

    public static double shootTopWheelMinVelocityDefault = 0.;
    public static double shootTopWheelMaxVelocityDefault = 0.;
    public static double shootBottomWheelMinVelocityDefault = 0.;
    public static double shootBottomWheelMaxVelocityDefault = 0.;

    // The ideal shooting distance is 11.38' which is where the apex is at the target center
    public static double shootDistanceDefault = 11.38;
    public static double shootTargetFPSDefault = 0.;
    public static double shootTargetTPHMSDefault = 0.;

    // shooting w/ power
    public static double shootPowerDefault = 0.5;
    public static double shootScaleFactorDefault = 5;
    
    // idk what to do w/ these
    public static double kMinOutputDefault = 0;
    public static double kMaxOutputDefault = 5676; 
    public static final double maxRPM = 5676;

    // shoot velocity
    public static double shootVelocityDefault = 100;
    public static double shootVelocityScaleFactorDefault = 2;

    // encoder velocity
    public static double bottomEncoderVelocityDefault = 0.315;
    public static double topEncoderVelocityDefault = 0.315;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry shootVelocityEntry;
    public static NetworkTableEntry shootVelocityScaleFactorEntry;

    public static NetworkTableEntry topEncoderVelocityEntry;
    public static NetworkTableEntry bottomEncoderVelocityEntry;

    public static NetworkTableEntry shootPowerEntry;
    public static NetworkTableEntry shootScaleFactorEntry;

    public static NetworkTableEntry kPEntry;
    public static NetworkTableEntry kIEntry;
    public static NetworkTableEntry kDEntry;
    public static NetworkTableEntry kIzEntry;
    public static NetworkTableEntry kFEntry;
    public static NetworkTableEntry kMaxOutputEntry;
    public static NetworkTableEntry kMinOutputEntry;

    public static NetworkTableEntry shootBottomWheelCurrentVelocityEntry;
    public static NetworkTableEntry shootTopWheelCurrentVelocityEntry;
    
    public static NetworkTableEntry shootBottomWheelMaxVelocityEntry;
    public static NetworkTableEntry shootBottomWheelMinVelocityEntry;
    public static NetworkTableEntry shootTopWheelMaxVelocityEntry;
    public static NetworkTableEntry shootTopWheelMinVelocityEntry;

    public static NetworkTableEntry shootDistanceEntry;
    public static NetworkTableEntry shootTargetFPSEntry;
    public static NetworkTableEntry shootTargetTPHMSEntry;

    //---------//
    // Setters //
    //---------//

    public static void setShootVelocity (double value) {
        shootVelocityEntry.setDouble(value);
    }

    public static void setShootVelocityScaleFactor (double value) {
        shootVelocityScaleFactorEntry.setDouble(value);
    }


    public static void setTopEncoderVelocity (double value) {
        topEncoderVelocityEntry.setDouble(value);
    }

    public static void setBottomEncoderVelocity (double value) {
        bottomEncoderVelocityEntry.setDouble(value);
    }

    public static void setShooterPower(double value) {
        shootPowerEntry.setDouble(value);
    }

    public static void setScaleFactor(double value) {
        shootScaleFactorEntry.setDouble(value);
    }

    public static void setTopWheelCurrentVelocity(double value) {
        shootTopWheelCurrentVelocityEntry.setDouble(value);
    }

    public static void setBottomWheelCurrentVelocity(double value) {
        shootBottomWheelCurrentVelocityEntry.setDouble(value);
    }

    public static void setBottomWheelMaxVelocity(double value) {
        shootBottomWheelMaxVelocityEntry.setDouble(value);
    }

    public static void setBottomWheelMinVelocity(double value) {
        shootBottomWheelMinVelocityEntry.setDouble(value);
    }

    public static void setTopWheelMaxVelocity(double value) {
        shootTopWheelMaxVelocityEntry.setDouble(value);
    }

    public static void setTopWheelMinVelocity(double value) {
        shootTopWheelMinVelocityEntry.setDouble(value);
    }

    public static void setTargetFPS(double value) {
        shootTargetFPSEntry.setDouble(value);
    }

    public static void setTargetTPHMS(double value) {
        shootTargetTPHMSEntry.setDouble(value);
    }

    //---------//
    // Getters //
    //---------//

    public static double getShootVelocity() {
        return shootVelocityEntry.getDouble(shootVelocityDefault);
    }

    public static double getShootVelocityScaleFactor() {
        return shootVelocityScaleFactorEntry.getDouble(shootVelocityScaleFactorDefault);
    }

    public static double getBottomEncoderVelocity() {
        return bottomEncoderVelocityEntry.getDouble(bottomEncoderVelocityDefault);
    }
    
    public static double getTopEncoderVelocity() {
        return topEncoderVelocityEntry.getDouble(topEncoderVelocityDefault);
    }

    public static double getShooterPower() {
        return shootPowerEntry.getDouble(shootPowerDefault);
    }

    public static double getScaleFactor() {
        return shootScaleFactorEntry.getDouble(shootScaleFactorDefault);
    }

    public static double getBottomWheelVelocity() {
        return shootBottomWheelCurrentVelocityEntry.getDouble(shootBottomWheelCurrentVelocityDefault);
    }

    public static double getTopWheelVelocity() {
        return shootTopWheelCurrentVelocityEntry.getDouble(shootTopWheelCurrentVelocityDefault);
    }

    public static double getShootDistance() {
        return shootDistanceEntry.getDouble(shootDistanceDefault);
    }

}