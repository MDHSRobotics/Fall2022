package frc.robot.sensors; 
 
import edu.wpi.first.networktables.NetworkTable; 
import edu.wpi.first.networktables.NetworkTableEntry; 
import edu.wpi.first.networktables.NetworkTableInstance; 
 
public class Limelight { 
    private static double averageDistance; 
    private static int sampleSize = 20; 
    private static double[] averageDistanceSamples = new double[sampleSize]; 
 
    private static final double CAMERA_HEIGHT = 12.0; // height of lens (in) h1
    private static final double TARGET_HEIGHT = 24.0; //height to the center of target(in) h2
    private static final double CAMERA_ANGLE = 35.0;// angle of the camera(deg) a1 

    private static NetworkTable m_limelightNetworkTable = NetworkTableInstance.getDefault().getTable("limelight"); 
    
    private static NetworkTableEntry m_horizontalOffset = m_limelightNetworkTable.getEntry("tx"); // Checks horizontal offset from crosshair to target
    private static NetworkTableEntry m_verticalOffset = m_limelightNetworkTable.getEntry("ty"); // Checks vertical offset from crosshair to target
    private static NetworkTableEntry m_targetDetected = m_limelightNetworkTable.getEntry("tv"); // Checks whether limelight has valid targets
    private static NetworkTableEntry m_targetVisionCoverage = m_limelightNetworkTable.getEntry("ta"); // How many pixels of screen is target (target area)
    private static NetworkTableEntry m_ledMode = m_limelightNetworkTable.getEntry("ledMode"); // Set led state

    public static double getXOffset() { 
        return m_horizontalOffset.getDouble(0.0); 
    } 
    
    public static double getYOffset() { 
        return m_verticalOffset.getDouble(0.0); 
    }
    public static void setLedMode(int mode) { 
        m_ledMode.setNumber(mode); 
    } 
 
    // Uses the limelight to find the distance in feet 
    public static double calculateDistanceToTarget() { 
        double yOffset = getYOffset(); 
        double angleInRadians = ((yOffset + CAMERA_ANGLE) / 180) * Math.PI; 
 
        double distance = (TARGET_HEIGHT - CAMERA_HEIGHT) / Math.tan(angleInRadians); 
        distance /= 12.0; // converts inches to feet 
 
        // Calculate average velocities 
        for (int i = sampleSize - 2; i > 0; i--) { 
            averageDistanceSamples[i] = averageDistanceSamples[i - 1]; 
        } 
 
        averageDistanceSamples[0] = distance; 
 
        for (double sample : averageDistanceSamples) { 
            averageDistance += sample; 
        } 
 
        averageDistance /= sampleSize; 
 
        return averageDistance; 


    } 
}
