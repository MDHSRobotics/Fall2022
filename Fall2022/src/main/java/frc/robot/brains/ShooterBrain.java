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

    public static double shootBottomWheelMaxVelocityDefault = 0.;
    public static double shootBottomWheelMinVelocityDefault = 1000000.;
    public static double shootTopWheelMaxVelocityDefault = 0.;
    public static double shootTopWheelMinVelocityDefault = 1000000.;

    // The ideal shooting distance is 11.38' which is where the apex is at the target center
    public static double shootDistanceDefault = 11.38;
    public static double shootTargetFPSDefault = 0.;
    public static double shootTargetTPHMSDefault = 0.;

    // shooting w/ power
    public static double shootPowerDefault = 0.1;
    public static double shootScaleFactorDefault = 2;


    // pid stuff
    public static double kPDefault = 6e-5; 
    public static double kIDefault = 0;
    public static double kDDefault = 0; 
    public static double kIzDefault = 0; 
    public static double kFFDefault = 0.000015; 
    
    // idk what to do w/ these
    public static double kMaxOutputDefault = 5676; 
    public static double kMinOutputDefault = 0;
    public static final double maxRPM = 5676;

    // shoot velocity
    public static double shootVelDefault = 100;
    public static double shootVelSFDefault = 2;

    // encoder velocity
    public static double bottomEncoderVelocityDefault = 0;
    public static double topEncoderVelocityDefault = 0;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry shootVelEntry;
    public static NetworkTableEntry shootVelSFEntry;

    public static NetworkTableEntry topEncoderVelocityEntry;
    public static NetworkTableEntry bottomEncoderVelocityEntry;

    public static NetworkTableEntry shootPowerEntry;
    public static NetworkTableEntry shootScaleFactorEntry;

    public static NetworkTableEntry kPEntry;
    public static NetworkTableEntry kIEntry;
    public static NetworkTableEntry kDEntry;
    public static NetworkTableEntry kIzEntry;
    public static NetworkTableEntry kFFEntry;
    public static NetworkTableEntry kMaxOutputEntry;
    public static NetworkTableEntry kMinOutputEntry;

    /*
    public static NetworkTableEntry shootBottomWheelCurrentVelocityEntry;
    public static NetworkTableEntry shootTopWheelCurrentVelocityEntry;
    
    public static NetworkTableEntry shootBottomWheelMaxVelocityEntry;
    public static NetworkTableEntry shootBottomWheelMinVelocityEntry;
    public static NetworkTableEntry shootTopWheelMaxVelocityEntry;
    public static NetworkTableEntry shootTopWheelMinVelocityEntry;

    public static NetworkTableEntry shootDistanceEntry;
    public static NetworkTableEntry shootTargetFPSEntry;
    public static NetworkTableEntry shootTargetTPHMSEntry;
    */

    //---------//
    // Setters //
    //---------//

    public static void setShootVel (double value){
        shootVelEntry.setDouble(value);
    }
    public static void setShootVelSF (double value){
        shootVelSFEntry.setDouble(value);
    }


    public static void setTopEncoderVelocity (double value){
        topEncoderVelocityEntry.setDouble(value);
    }

    public static void setBottomEncoderVelocity (double value){
        bottomEncoderVelocityEntry.setDouble(value);
    }


    public static void setkP (double value){
        kPEntry.setDouble(value);
    }

    public static void setkI (double value){
        kIEntry.setDouble(value);
    }

    public static void setkD (double value){
        kDEntry.setDouble(value);
    }

    public static void setkIz (double value){
        kIzEntry.setDouble(value);
    }

    public static void setkFF (double value){
        kFFEntry.setDouble(value);
    }

    public static void setkMaxOutput (double value){
        kMaxOutputEntry.setDouble(value);
    }

    public static void setkMinOutput (double value){
        kMinOutputEntry.setDouble(value);
    }



    public static void setShooterPower(double value){
        shootPowerEntry.setDouble(value);
    }

    public static void setScaleFactor(double value){
        shootScaleFactorEntry.setDouble(value);
    }

    /*
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
    */

    //---------//
    // Getters //
    //---------//

    public static double getShootVel (){
        return shootVelEntry.getDouble(shootVelDefault);
    }

    public static double getShootVelSF (){
        return shootVelSFEntry.getDouble(shootVelSFDefault);
    }


    public static double getBottomEncoderVelocity(){
        return bottomEncoderVelocityEntry.getDouble(bottomEncoderVelocityDefault);
    }
    public static double getTopEncoderVelocity(){
        return topEncoderVelocityEntry.getDouble(topEncoderVelocityDefault);
    }


    public static double getkP (){
        return kPEntry.getDouble(kPDefault);
    }

    public static double getkI (){
        return kIEntry.getDouble(kIDefault);
    }

    public static double getkD (){
        return kDEntry.getDouble(kDDefault);
    }

    public static double getkIz (){
        return kIzEntry.getDouble(kIzDefault);
    }

    public static double getkFF (){
        return kFFEntry.getDouble(kFFDefault);
    }

    public static double getkMaxOutput (){
        return kFFEntry.getDouble(kMaxOutputDefault);
    }

    public static double getkMinOutput (){
        return kFFEntry.getDouble(kMinOutputDefault);
    }


    public static double getShooterPower(){
        return shootPowerEntry.getDouble(shootPowerDefault);
    }

    public static double getScaleFactor(){
        return shootScaleFactorEntry.getDouble(shootScaleFactorDefault);
    }

    /*
    public static double getBottomWheelVelocity() {
        return shootBottomWheelCurrentVelocityEntry.getDouble(shootBottomWheelCurrentVelocityDefault);
    }

    public static double getTopWheelVelocity() {
        return shootTopWheelCurrentVelocityEntry.getDouble(shootTopWheelCurrentVelocityDefault);
    }

    public static double getShootDistance() {
        return shootDistanceEntry.getDouble(shootDistanceDefault);
    }
    */

}