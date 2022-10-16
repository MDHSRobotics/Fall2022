
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;
import pabeles.concurrency.ConcurrencyOps.NewInstance;

// This class contains all the shared NetworkTableEntries for the Shuffler,
// their default values, and methods for retrieving their current values.
public class DeliveryBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double spinPowerDefault = 0.1;
    public static double conveyorPowerDefault = 0.1;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry spinPowerEntry;
    public static NetworkTableEntry conveyorPowerEntry;

    //---------//
    // Setters //
    //---------//

    public static void setSpinPower(double value){
        spinPowerEntry.setDouble(value);
    }

    public static void setConveyorPower(double value){
        conveyorPowerEntry.setDouble(value);
    }

    //---------//
    // Getters //
    //---------//

    public static double getSpinPower(){
        return spinPowerEntry.getDouble(spinPowerDefault);
    }

    public static double getConveyorPower(){
        return conveyorPowerEntry.getDouble(conveyorPowerDefault);
    }

}
