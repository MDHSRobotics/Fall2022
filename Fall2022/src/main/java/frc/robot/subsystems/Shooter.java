package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;

import frc.robot.brains.ShooterBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.sparkMaxShooterBottomWheel;
import static frc.robot.subsystems.Devices.sparkMaxShooterTopWheel;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Shooter extends SubsystemBase {

    private SparkMaxPIDController m_topPidController, m_bottomPidController;
    private RelativeEncoder m_topEncoder, m_bottomEncoder;

    // Encoder constants
    private static final boolean MOTOR_INVERT_TOP = false;
    private static final boolean MOTOR_INVERT_BOTTOM = false;

    public Shooter() {
        Logger.setup("Constructing Subsystem: Shooter...");

        sparkMaxShooterTopWheel.restoreFactoryDefaults();
        sparkMaxShooterBottomWheel.restoreFactoryDefaults();
        
        m_topPidController = sparkMaxShooterTopWheel.getPIDController();
        sparkMaxShooterTopWheel.setInverted(MOTOR_INVERT_TOP);
        m_topPidController.setP(0.0002);
        
        m_bottomPidController = sparkMaxShooterBottomWheel.getPIDController();
        sparkMaxShooterBottomWheel.setInverted(MOTOR_INVERT_BOTTOM);
        m_bottomPidController.setP(0.0002);  
        
        m_topEncoder = sparkMaxShooterTopWheel.getEncoder();
        m_bottomEncoder = sparkMaxShooterBottomWheel.getEncoder();
    }

    public void shoot(){
        double shootPower = ShooterBrain.getShooterPower();
        double scaleFactor = ShooterBrain.getScaleFactor();

        sparkMaxShooterTopWheel.set(shootPower / scaleFactor);
        sparkMaxShooterBottomWheel.set(-shootPower);
    }

    public void shootMin() {
        sparkMaxShooterTopWheel.set(0.1);
        sparkMaxShooterBottomWheel.set(-0.3);
    }

    // 5ft away
    public void shootMid() {
        sparkMaxShooterTopWheel.set(0.475);
        sparkMaxShooterBottomWheel.set(-0.575);
    }

    // 12ft away (safezone)
    public void shootMax() {
        sparkMaxShooterTopWheel.set(0.5);
        sparkMaxShooterBottomWheel.set(-0.7);
    }

    public void shootVelocity() {
        double shootVelocity = ShooterBrain.getShootVelocity();
        double shootVelocityScaleFactor = ShooterBrain.getShootVelocityScaleFactor();

        m_topPidController.setReference((shootVelocity / shootVelocityScaleFactor), CANSparkMax.ControlType.kVelocity);
        m_bottomPidController.setReference(shootVelocity, CANSparkMax.ControlType.kVelocity);
    }

    public void stop() {
        sparkMaxShooterTopWheel.stopMotor();
        sparkMaxShooterBottomWheel.stopMotor();
    }

    @Override
    public void periodic() {
        double topEncoderVelocity = m_topEncoder.getVelocity();
        double bottomEncoderVelocity = m_bottomEncoder.getVelocity();
        
        ShooterBrain.setTopEncoderVelocity(topEncoderVelocity);
        ShooterBrain.setBottomEncoderVelocity(bottomEncoderVelocity);
    }

    // Translate a desired target velocity in feet per second to a motor speed in Ticks per 100 ms.
    // The translation is done via a lookup table with values based on shooting experiments.
    // Each entry in the table is the result of testing a particular motor speed (Ticks per 100ms) and
    // then measuring the range that the ball is shot. From the range we can calculate the effective
    // velocity of the ball (ft/sec). The lookup table correlates the ball velocity and motor speed
    // for each test.  We can deduce the motor speed for other ball velocities by interpolating
    // (or extrapolating) using the values in the lookup table.

    public static double translateFPSToTicksViaTable(double targetFPS) {

        // Initialize the lookup table; Key=Velocity in FPS; Value=Motor speed in Ticks/100ms
        SortedMap<Double, Double> luTable = new TreeMap<Double, Double>();

        // The data below is based on shooting experiments conducted on March 5, 2020:
        // (Feet per second, Ticks per 100ms)
        // TODO Update the values in the table below based on latest experiment
        luTable.put(20., 200.);
        luTable.put(30., 300.);
        luTable.put(50., 500.);
        luTable.put(90., 1700.);

        boolean firstPass = true;
        double f1 = -99.;
        double t1 = -99.;
        double targetTPHMS = -99.;

        // Iterate over the lookup table, which is sorted based on the key (fps)
        for (Map.Entry<Double, Double> entry : luTable.entrySet()) {
            double f2 = entry.getKey();
            double t2 = entry.getValue();
            Logger.debug(f2 + " (ft/sec) => " + t2 + " (Ticks/100ms");

            // Skip over the first value because we can't compute a slope until we have read at least 2 values
            if (firstPass) {
                firstPass = false;
            }
            else {
                double slope = (t2-t1) / (f2-f1);
                targetTPHMS = t1 + (targetFPS-f1) * slope;

                if (targetFPS <= f2)
                    break;
            }

            f1 = f2;
            t1 = t2;
        }

        return targetTPHMS;
    }

}