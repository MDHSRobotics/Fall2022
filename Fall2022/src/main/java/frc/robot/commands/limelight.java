package frc.robot.commands; 
 
import edu.wpi.first.networktables.NetworkTable; 
import edu.wpi.first.networktables.NetworkTableEntry; 
import edu.wpi.first.networktables.NetworkTableInstance; 
 
public class limelight { 
    private static double avgDistance; 
    private static int sampleSize = 20; 
    private static double[] avgDistanceSamples = new double[sampleSize]; 
 
    private static final double CAMERA_HEIGHT = 12.0; // height of lens (in) 
    private static final double TARGET_HEIGHT = 24.0; //height to the center of target(in) 
    private static final double CAMERA_ANGLE = 0.0;// angle of the camera(deg) 
 
    private static NetworkTable m_limelight = NetworkTableInstance.getDefault().getTable("limelight"); 
    private static NetworkTableEntry m_tx = m_limelight.getEntry("tx"); // Checks horizontal offset from crosshair to target
    private static NetworkTableEntry m_ty = m_limelight.getEntry("ty"); // Checks vertical offset from crosshair to target
    private static NetworkTableEntry m_tv = m_limelight.getEntry("tv"); // Checks whether limelight has valid targets
    // private static NetworkTableEntry m_ta = m_limelight.getEntry("ta"); // How many pixels of screen is target (target area)
    private static NetworkTableEntry m_ledMode = m_limelight.getEntry("ledMode"); // Set led state
 
    public static double getXOffset() { 
        return m_tx.getDouble(0.0); 
    } 
 
    public static double getYOffset() { 
        return m_ty.getDouble(0.0); 
    } 

    public static void setLedMode(int mode) { 
        m_ledMode.setNumber(mode); 
    } 
 
    // Uses the limelight to find the distance in feet 
    public static double calculateDistanceToTarget() { 
        double yOffset = getYOffset(); 
        double angleInRadians = ((yOffset + CAMERA_ANGLE) / 180.) * Math.PI; 
 
        double distance = (TARGET_HEIGHT - CAMERA_HEIGHT) / Math.tan(angleInRadians); 
        distance /= 12.0; // converts inches to feet 
 
        // Calculate average velocities 
        for (int i = sampleSize - 2; i > 0; i--) { 
            avgDistanceSamples[i] = avgDistanceSamples[i - 1]; 
        } 
 
        avgDistanceSamples[0] = distance; 
 
        for (double sample : avgDistanceSamples) { 
            avgDistance += sample; 
        } 
 
        avgDistance /= sampleSize; 
 
        return avgDistance; 

    
    } 
}
