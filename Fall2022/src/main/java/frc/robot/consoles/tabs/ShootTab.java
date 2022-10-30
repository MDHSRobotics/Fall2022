package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.BotCommands;
import frc.robot.brains.*;
import frc.robot.consoles.ShuffleLogger;

import java.util.Map;

// The Shuffleboard Shoot tab.
public class ShootTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;
    private ShuffleboardLayout m_shootLayout;
    private ShuffleboardLayout m_commandLayout;
    private ShuffleboardLayout m_pidLayout;
    private ShuffleboardLayout m_shootVelLayout;
    private ShuffleboardLayout m_shootVelEncoderLayout;

    private SimpleWidget m_shootPower, m_shootScaleFactor, m_pidValues, m_shootVelRPM, m_shootVelSF, m_shootBottomRPM, m_shootTopRPM;

    private ComplexWidget m_shoot, m_stopShoot, m_shootVel;

    public ShootTab() {
        ShuffleLogger.logTrivial("Constructing ShootTab...");

        m_tab = Shuffleboard.getTab("Shoot");

        m_shootLayout = m_tab.getLayout("Shooting Constants", BuiltInLayouts.kList);
        m_commandLayout = m_tab.getLayout("Commands", BuiltInLayouts.kList);
        m_pidLayout = m_tab.getLayout("PID Constants", BuiltInLayouts.kList);
        m_shootVelLayout = m_tab.getLayout("Velocity Shooting",BuiltInLayouts.kList);
        m_shootVelEncoderLayout = m_tab.getLayout("Encoder Velocity Values",BuiltInLayouts.kList);
    }

    // Create Brain Widgets
    public void preInitialize() {
        // Shoot Power
        m_shootPower = m_shootLayout.add("Shooting Power", ShooterBrain.shootPowerDefault);
        ShooterBrain.shootPowerEntry = m_shootPower.getEntry();
        m_shootPower.withWidget(BuiltInWidgets.kNumberSlider);
        m_shootPower.withProperties(Map.of("min", 0, "max", 1.0));

        // Scale Factor
        m_shootScaleFactor = m_shootLayout.add("Scale Factor (divides the shoot power)", ShooterBrain.shootScaleFactorDefault);
        ShooterBrain.shootScaleFactorEntry = m_shootScaleFactor.getEntry();
        m_shootScaleFactor.withWidget(BuiltInWidgets.kNumberSlider);
        m_shootScaleFactor.withProperties(Map.of("min",0,"max",10.0));

        // Shoot with rpm
        m_shootVelSF = m_shootVelLayout.add("Scale Factor (divides the shoot rpm)", ShooterBrain.shootVelocityScaleFactorDefault);
        ShooterBrain.shootVelocityScaleFactorEntry = m_shootVelSF.getEntry();
        m_shootVelSF.withWidget(BuiltInWidgets.kNumberSlider);
        m_shootVelSF.withProperties(Map.of("min",0,"max",10.0));

        m_shootVelRPM = m_shootVelLayout.add("Shoot Rpm", ShooterBrain.shootVelocityDefault);
        ShooterBrain.shootVelocityEntry = m_shootVelRPM.getEntry();
        m_shootVelRPM.withWidget(BuiltInWidgets.kNumberSlider);
        m_shootVelRPM.withProperties(Map.of("min",0,"max",5676));

        m_shootBottomRPM = m_shootVelEncoderLayout.add("Bottom Wheel RPM", ShooterBrain.bottomEncoderVelocityDefault);
        ShooterBrain.bottomEncoderVelocityEntry = m_shootBottomRPM.getEntry();
        m_shootBottomRPM.withWidget(BuiltInWidgets.kTextView);

        m_shootTopRPM = m_shootVelEncoderLayout.add("Top Wheel RPM", ShooterBrain.topEncoderVelocityDefault);
        ShooterBrain.topEncoderVelocityEntry = m_shootTopRPM.getEntry();
        m_shootTopRPM.withWidget(BuiltInWidgets.kTextView);
    }

    // Create all other Widgets
    public void initialize() {
        // Shoot Command
        m_shoot = m_commandLayout.add("Shoot", BotCommands.shoot);

        // Stop Shooter Command
        m_stopShoot = m_commandLayout.add("Stop Shooter", BotCommands.stopShoot);

        // Shoot Velocity Command
        m_shootVel = m_commandLayout.add("Shoot Velocity", BotCommands.shootVel);
    }

    // Configure all Widgets
    public void configure() {
        m_shootLayout.withPosition(2, 0);
        m_shootLayout.withSize(6, 2);
        m_shootLayout.withProperties(Map.of("Number of columns", 2));
        m_shootLayout.withProperties(Map.of("Number of rows", 3));
        m_shootLayout.withProperties(Map.of("Label position", "LEFT"));

        m_commandLayout.withPosition(0, 0);
        m_commandLayout.withSize(2, 2);
        m_commandLayout.withProperties(Map.of("Number of columns", 2));
        m_commandLayout.withProperties(Map.of("Number of rows", 3));
        m_commandLayout.withProperties(Map.of("Label position", "LEFT"));

        m_pidLayout.withPosition(0, 2);
        m_pidLayout.withSize(2, 2 );
        m_pidLayout.withProperties(Map.of("Number of columns", 2));
        m_pidLayout.withProperties(Map.of("Number of rows", 3));
        m_pidLayout.withProperties(Map.of("Label position", "LEFT"));

        m_shootVelLayout.withPosition(2, 2);
        m_shootVelLayout.withSize(6, 2);
        m_shootVelLayout.withProperties(Map.of("Number of columns", 2));
        m_shootVelLayout.withProperties(Map.of("Number of rows", 3));
        m_shootVelLayout.withProperties(Map.of("Label position", "LEFT"));

        m_shootVelEncoderLayout.withPosition(8, 2);
        m_shootVelEncoderLayout.withSize(2, 2);
        m_shootVelEncoderLayout.withProperties(Map.of("Number of columns", 2));
        m_shootVelEncoderLayout.withProperties(Map.of("Number of rows", 3));
        m_shootVelEncoderLayout.withProperties(Map.of("Label position", "LEFT"));
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}
