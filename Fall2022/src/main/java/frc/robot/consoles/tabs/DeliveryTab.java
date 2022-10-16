
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.BotCommands;
import frc.robot.brains.DeliveryBrain;
import frc.robot.consoles.ShuffleLogger;

import java.util.Map;

// The Shuffleboard Aim tab.
public class DeliveryTab {

    // Tab & Layouts
    private SimpleWidget m_spinPower, m_conveyorPower;

    private ShuffleboardTab m_tab;

    private ShuffleboardLayout m_commandLayout, m_deliveryLayout;

    private ComplexWidget m_commandWidget1, m_commandWidget2, m_commandWidget3, m_commandWidget4, m_commandWidget5;

    // Constructor
    public DeliveryTab() {
        ShuffleLogger.logTrivial("Constructing DeliveryTab...");

        m_tab = Shuffleboard.getTab("Delivery");

        m_commandLayout = m_tab.getLayout("Commands", BuiltInLayouts.kList);
        m_commandLayout.withPosition(0, 0);
        m_commandLayout.withSize(2, 2);
        m_commandLayout.withProperties(Map.of("Number of columns", 2));
        m_commandLayout.withProperties(Map.of("Number of rows", 3));
        m_commandLayout.withProperties(Map.of("Label position", "LEFT"));

        m_deliveryLayout = m_tab.getLayout("Delivery Constants", BuiltInLayouts.kList);
        m_deliveryLayout.withPosition(2, 0);
        m_deliveryLayout.withSize(2, 2);
        m_deliveryLayout.withProperties(Map.of("Number of columns", 2));
        m_deliveryLayout.withProperties(Map.of("Number of rows", 3));
        m_deliveryLayout.withProperties(Map.of("Label position", "LEFT"));
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_spinPower = m_deliveryLayout.add("Spin Power", DeliveryBrain.spinPowerDefault);
        DeliveryBrain.spinPowerEntry = m_spinPower.getEntry();
        m_spinPower.withWidget(BuiltInWidgets.kTextView);

        m_conveyorPower = m_deliveryLayout.add("Conveyor Power", DeliveryBrain.conveyorPowerDefault);
        DeliveryBrain.conveyorPowerEntry = m_conveyorPower.getEntry();
        m_conveyorPower.withWidget(BuiltInWidgets.kTextView);
    }

    // Create all other Widgets
    public void initialize() {
        m_commandWidget1 = m_commandLayout.add("Lower Pickup", BotCommands.lowerPickup);
        m_commandWidget2 = m_commandLayout.add("Raise Pickup", BotCommands.raisePickup);
        m_commandWidget3 = m_commandLayout.add("Spin Conveyor", BotCommands.spinConveyor);
        m_commandWidget4 = m_commandLayout.add("Stop Conveyor", BotCommands.stopConveyor);
        m_commandWidget5 = m_commandLayout.add("Toggle Pickup", BotCommands.togglePickup);

    }

    // Configure all Widgets
    public void configure() {
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}
