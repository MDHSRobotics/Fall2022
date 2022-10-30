package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Shooter Subsystem,
// their default values, and methods for retrieving their current values.
public class ClimbBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double climbPowerDefault = 1;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry climbPowerEntry;

    //---------//
    // Setters //
    //---------//

    public static void setClimbPower(double value) {
        climbPowerEntry.setDouble(value);
    }

    //---------//
    // Getters //
    //---------//

    public static double getClimbPower() {
        return climbPowerEntry.getDouble(climbPowerDefault);
    }

}