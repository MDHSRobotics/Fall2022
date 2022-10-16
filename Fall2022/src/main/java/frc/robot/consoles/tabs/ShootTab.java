package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.BotCommands;
import frc.robot.brains.*;
import frc.robot.consoles.ShuffleLogger;

import java.util.Map;

// The Shuffleboard Aim tab.
public class ShootTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;
    private ShuffleboardLayout m_shootLayout;
    private ShuffleboardLayout m_commandLayout;

    private SimpleWidget m_shootPower;
    private SimpleWidget m_shootScaleFactor;

    private ComplexWidget m_shoot, m_stopShoot;

    // Constructor
    public ShootTab() {
        ShuffleLogger.logTrivial("Constructing ShootTab...");

        m_tab = Shuffleboard.getTab("Shoot");

        m_shootLayout = m_tab.getLayout("Shooting Constants", BuiltInLayouts.kList);
        m_commandLayout = m_tab.getLayout("Commands", BuiltInLayouts.kList);

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
    }

    // Create all other Widgets
    public void initialize() {
        // Shoot Command
        m_shoot = m_commandLayout.add("Shoot", BotCommands.shoot);

        // Stop Shooter Command
        m_stopShoot = m_commandLayout.add("Stop Shooter", BotCommands.stopShooter);
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
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}
