package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;
import java.util.Map;

import frc.robot.consoles.ShuffleLogger;
import frc.robot.BotCommands.*;
import frc.robot.brains.*;

// The Shuffleboard Aim tab.
public class ShootTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;
    private ShuffleboardLayout m_shootLayout;

    private SimpleWidget m_shootPower;
    private SimpleWidget m_shootScaleFactor;

    //private ComplexWidget ;

    // Constructor
    public ShootTab() {
        ShuffleLogger.logTrivial("Constructing ShootTab...");

        m_tab = Shuffleboard.getTab("Shoot");

        m_shootLayout = m_tab.getLayout("Commands", BuiltInLayouts.kList);
    }

    // Create Brain Widgets
    public void preInitialize() {
            // Shoot Power
            m_shootPower = m_shootLayout.add("Shooting Power", ShooterBrain.shootPowerDefault);
            ShooterBrain.shootPowerEntry = m_shootPower.getEntry();
            m_shootPower.withWidget(BuiltInWidgets.kTextView);

            // Scale Factor
            m_shootScaleFactor = m_shootLayout.add("Scale Factor", ShooterBrain.shootScaleFactorDefault);
            ShooterBrain.shootScaleFactorEntry = m_shootScaleFactor.getEntry();
            m_shootScaleFactor.withWidget(BuiltInWidgets.kTextView);
    }

    // Create all other Widgets
    public void initialize() {

    }

    // Configure all Widgets
    public void configure() {
        m_shootLayout.withPosition(0, 0);
        m_shootLayout.withSize(2, 2);
        m_shootLayout.withProperties(Map.of("Number of columns", 2));
        m_shootLayout.withProperties(Map.of("Number of rows", 3));
        m_shootLayout.withProperties(Map.of("Label position", "LEFT"));
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}
