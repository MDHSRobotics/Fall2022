
package frc.robot.consoles;

import frc.robot.consoles.tabs.*;

// Class that wraps all of the interaction with the Shuffleboard

// All decisions about content and layout of the Shuffleboard are consolidated in this file
// to make it easier to change things rather than having to look throughout all of the
// classes for subsystems, commands, etc.

// The Shuffler class knows about the subsystems, commands, etc. but generally not vice versa.
public class Shuffler {
    // Tabs
    private DriveTab m_driveTab;
    private InputsTab m_inputsTab;

    public Shuffler() {
        m_driveTab = new DriveTab();
        m_inputsTab = new InputsTab();

    }

    public void preInitialize() {
        m_driveTab.preInitialize();
        m_inputsTab.preInitialize();
    }

    public void initialize() {
        m_driveTab.initialize();
        m_inputsTab.initialize();
    }

    public void configure() {
        m_driveTab.configure();
        m_inputsTab.configure();
        setupSmartdashboard();
    }

    public void update() {
        m_driveTab.update();
        m_inputsTab.update();
    }

    // This is for stuff that can't be displayed easily in custom Shuffleboard tabs.
    // It will end up on the SmartDashboard tab.
    private void setupSmartdashboard() {
        // SmartDashboard.putData("Command Scheduler", Scheduler.getInstance());
    }

}