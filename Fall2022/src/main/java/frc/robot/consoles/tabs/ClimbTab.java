
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.BotCommands;
import frc.robot.brains.*;
import frc.robot.consoles.ShuffleLogger;

import java.util.Map;

// The Shuffleboard Climb tab.
public class ClimbTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;
    private ShuffleboardLayout m_commandLayout;
    private ShuffleboardLayout m_climbConstantsLayout;
    private SimpleWidget m_climbPower;
    private ComplexWidget m_commandWidget1, m_commandWidget2;

    // Constructor
    public ClimbTab() {
        ShuffleLogger.logTrivial("Constructing ClimbTab...");

        m_tab = Shuffleboard.getTab("Climb");

        m_climbConstantsLayout = m_tab.getLayout("Climbing Constants", BuiltInLayouts.kList);
        m_commandLayout = m_tab.getLayout("Commands", BuiltInLayouts.kList);
    }

    // Create Brain Widgets
    public void preInitialize() {
        // Shoot Power
        m_climbPower = m_climbConstantsLayout.add("Climbing Power", ClimbBrain.climbPowerDefault);
        ClimbBrain.climbPowerEntry = m_climbPower.getEntry();
        m_climbPower.withWidget(BuiltInWidgets.kNumberSlider);
        m_climbPower.withProperties(Map.of("min", 0, "max", 1.0));
    }

    // Create all other Widgets
    public void initialize() {
        m_commandWidget1 = m_commandLayout.add("Move Left Climb", BotCommands.moveLeftClimb);
        m_commandWidget2 = m_commandLayout.add("Move Right Climb", BotCommands.moveRightClimb);
    }

    // Configure all Widgets
    public void configure() {
        m_climbConstantsLayout.withPosition(2, 0);
        m_climbConstantsLayout.withSize(6, 2);
        m_climbConstantsLayout.withProperties(Map.of("Number of columns", 2));
        m_climbConstantsLayout.withProperties(Map.of("Number of rows", 3));
        m_climbConstantsLayout.withProperties(Map.of("Label position", "LEFT"));

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
