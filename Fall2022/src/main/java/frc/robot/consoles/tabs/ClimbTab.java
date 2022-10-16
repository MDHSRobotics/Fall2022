
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.BotCommands;
import frc.robot.consoles.ShuffleLogger;

import java.util.Map;

// The Shuffleboard Aim tab.
public class ClimbTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;
    private ShuffleboardLayout m_commandLayout;
    private ComplexWidget m_commandWidget1, m_commandWidget2;

    // Constructor
    public ClimbTab() {
        ShuffleLogger.logTrivial("Constructing ClimbTab...");

        m_tab = Shuffleboard.getTab("Climb");

        m_commandLayout = m_tab.getLayout("Commands", BuiltInLayouts.kList);
        m_commandLayout.withPosition(0, 0);
        m_commandLayout.withSize(2, 2);
        m_commandLayout.withProperties(Map.of("Number of columns", 2));
        m_commandLayout.withProperties(Map.of("Number of rows", 3));
        m_commandLayout.withProperties(Map.of("Label position", "LEFT"));
    }

    // Create Brain Widgets
    public void preInitialize() {
    }

    // Create all other Widgets
    public void initialize() {
        m_commandWidget1 = m_commandLayout.add("Move Left Climb", BotCommands.moveLeftClimb);
        m_commandWidget2 = m_commandLayout.add("Move Right Climb", BotCommands.moveRightClimb);
    }

    // Configure all Widgets
    public void configure() {
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}
