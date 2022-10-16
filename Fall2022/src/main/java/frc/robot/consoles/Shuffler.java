package frc.robot.consoles;

import frc.robot.consoles.tabs.*;

// Class that wraps all of the interaction with the Shuffleboard

// All decisions about content and layout of the Shuffleboard are consolidated in this file
// to make it easier to change things rather than having to look throughout all of the
// classes for subsystems, commands, etc.

// The Shuffler class knows about the subsystems, commands, etc. but generally not vice versa.
public class Shuffler {
    // Tabs
    private MainTab m_mainTab;
    private InputsTab m_inputsTab;
    private JoystickTab m_jstickTab;
    private ClimbTab m_climbTab;
    private DeliveryTab m_deliveryTab;
    private ShootTab m_shootTab;
    private DriveTab m_driveTab;

    public Shuffler() {
        ShuffleLogger.logTrivial("Constructing Shuffler...");
        m_mainTab = new MainTab();
        m_inputsTab = new InputsTab();
        m_jstickTab = new JoystickTab();
        m_climbTab = new ClimbTab();
        m_deliveryTab = new DeliveryTab();
        m_shootTab = new ShootTab();
        m_driveTab = new DriveTab();
    }

    public void preInitialize() {
        ShuffleLogger.logTrivial("Pre-Initializing Shuffler...");
        m_mainTab.preInitialize();
        m_inputsTab.preInitialize();
        m_jstickTab.preInitialize();
        m_climbTab.preInitialize();
        m_deliveryTab.preInitialize();
        m_shootTab.preInitialize();
        m_driveTab.preInitialize();
    }

    public void initialize() {
        ShuffleLogger.logTrivial("Initializing Shuffler...");
        m_mainTab.initialize();
        m_inputsTab.initialize();
        m_jstickTab.initialize();
        m_climbTab.initialize();
        m_deliveryTab.initialize();
        m_shootTab.initialize();
        m_driveTab.initialize();
    }

    public void configure() {
        ShuffleLogger.logTrivial("Configuring Shuffler...");
        m_mainTab.configure();
        m_inputsTab.configure();
        m_jstickTab.configure();
        m_climbTab.configure();
        m_deliveryTab.configure();
        m_shootTab.configure();
        m_driveTab.configure();

        setupSmartdashboard();
    }

    public void update() {
        m_mainTab.update();
        m_inputsTab.update();
        m_inputsTab.update();
        m_climbTab.update();
        m_deliveryTab.update();
        m_shootTab.update();
        m_driveTab.update();
    }

    // This is for stuff that can't be displayed easily in custom Shuffleboard tabs.
    // It will end up on the SmartDashboard tab.
    private void setupSmartdashboard() {
    }

}

