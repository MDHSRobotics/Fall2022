
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.BotCommands;
import frc.robot.brains.IntakeBrain;
import frc.robot.consoles.ShuffleLogger;

import java.util.Map;

// The Shuffleboard Intake tab.
public class IntakeTab {

    // Tab & Layouts
    private SimpleWidget m_spinPower, m_conveyorPower;

    private ShuffleboardTab m_tab;

    private ShuffleboardLayout m_commandLayout, m_intakeLayout;

    private ComplexWidget m_commandWidget1, m_commandWidget2, m_commandWidget3, m_commandWidget4, m_commandWidget5, m_commandWidget6, m_commandWidget7, m_commandWidget8, m_commandWidget9;

    // Constructor
    public IntakeTab() {
        ShuffleLogger.logTrivial("Constructing IntakeTab...");
        

        m_tab = Shuffleboard.getTab("Intake");

        m_commandLayout = m_tab.getLayout("Commands", BuiltInLayouts.kList);
        m_commandLayout.withPosition(0, 0);
        m_commandLayout.withSize(2, 2);
        m_commandLayout.withProperties(Map.of("Number of columns", 2));
        m_commandLayout.withProperties(Map.of("Number of rows", 10));
        m_commandLayout.withProperties(Map.of("Label position", "LEFT"));

        m_intakeLayout = m_tab.getLayout("Intake Constants", BuiltInLayouts.kList);
        m_intakeLayout.withPosition(2, 0);
        m_intakeLayout.withSize(2, 2);
        m_intakeLayout.withProperties(Map.of("Number of columns", 2));
        m_intakeLayout.withProperties(Map.of("Number of rows", 3));
        m_intakeLayout.withProperties(Map.of("Label position", "LEFT"));
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_spinPower = m_intakeLayout.add("Spin Power", IntakeBrain.spinPowerDefault);
        IntakeBrain.spinPowerEntry = m_spinPower.getEntry();
        m_spinPower.withWidget(BuiltInWidgets.kTextView);

        m_conveyorPower = m_intakeLayout.add("Conveyor Power", IntakeBrain.conveyorPowerDefault);
        IntakeBrain.conveyorPowerEntry = m_conveyorPower.getEntry();
        m_conveyorPower.withWidget(BuiltInWidgets.kTextView);
    }

    // Create all other Widgets
    public void initialize() {
        m_commandWidget1 = m_commandLayout.add("Lower Pickup", BotCommands.lowerPickup);
        m_commandWidget2 = m_commandLayout.add("Raise Pickup", BotCommands.raisePickup);
        m_commandWidget3 = m_commandLayout.add("Spin Roller", BotCommands.spinRoller);
        m_commandWidget4 = m_commandLayout.add("Stop Roller", BotCommands.stopRoller);
        m_commandWidget5 = m_commandLayout.add("Spin Conveyor", BotCommands.spinConveyor);
        m_commandWidget6 = m_commandLayout.add("Stop Conveyor", BotCommands.stopConveyor);
        m_commandWidget7 = m_commandLayout.add("Toggle Pickup", BotCommands.togglePickup);
        m_commandWidget8 = m_commandLayout.add("Toggle Roller", BotCommands.defaultConveyor);
        m_commandWidget9 = m_commandLayout.add("Toggle Conveyor", BotCommands.defaultPickup);
    }

    // Configure all Widgets
    public void configure() {
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}
