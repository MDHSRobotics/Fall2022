package frc.robot.subsystems;

import frc.robot.BotSubsystems;
import frc.robot.subsystems.constants.*;

import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;  
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.math.trajectory.Trajectory;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

import java.io.IOException; 
import java.nio.file.Path;
import java.util.ArrayList;

import edu.wpi.first.wpilibj.DriverStation;

public class Pathweaver {
    
    private static PIDController xController = new PIDController(AutoConstants.kPXController, 0, 0);
    private static PIDController yController = new PIDController(AutoConstants.kPYController, 0, 0);
    private static PIDController thetaController = new PIDController(AutoConstants.kPThetaController, 0, 0);

    private static String m_trajectoryJson1 = "/home/lvuser/deploy/paths/trajectory1.wpilib.json";
    private static String m_trajectoryJson2 = "/home/lvuser/deploy/paths/trajectory2.wpilib.json";
    private static String m_trajectoryJson3 = "/home/lvuser/deploy/paths/trajectory3.wpilib.json";

    private static Trajectory m_trajectory1 = new Trajectory();
    private static Trajectory m_trajectory2 = new Trajectory();
    private static Trajectory m_trajectory3 = new Trajectory();

    private static String[] m_trajectoryJsonArray = {m_trajectoryJson1, m_trajectoryJson2, m_trajectoryJson3};
    private static ArrayList<Trajectory> m_trajectoryArray = new ArrayList<Trajectory>() {
        {
            add(m_trajectory1);
            add(m_trajectory2);
            add(m_trajectory3);
        }
    };

    public static void intializeTrajectory(){
        for (int i = 0; i < 3; i++) {
            try {
            
                Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(m_trajectoryJsonArray[i]);
                Trajectory trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
                m_trajectoryArray.set(i, trajectory);
            
            } catch (IOException ex) {
                DriverStation.reportError("Unable to open trajectory: " + m_trajectoryJsonArray[i], ex.getStackTrace());
            }
        }
    }

    public static Command getPathweaverCommand(Trajectory pathweaverTrajectory) {

        RamseteCommand ramseteCommand =
        new RamseteCommand(
            pathweaverTrajectory,
            BotSubsystems.swerveDriver::getPose,
            new RamseteController(AutoConstants.kRamseteB, AutoConstants.kRamseteZeta),
            new SimpleMotorFeedforward(
                PathConstants.ksVolts,
                PathConstants.kvVoltSecondsPerMeter,
                PathConstants.kaVoltSecondsSquaredPerMeter),
            PathConstants.kDriveKinematics,
            BotSubsystems.swerveDriver::getWheelSpeeds,
            new PIDController(PathConstants.kPDriveVel, 0, 0),
            new PIDController(PathConstants.kPDriveVel, 0, 0),
            // RamseteCommand passes volts to the callback
            BotSubsystems.swerveDriver::tankDriveVolts,
            m_robotDrive);

    // Reset odometry to the starting pose of the trajectory.
    BotSubsystems.swerveDriver.resetOdometry(pathweaverTrajectory.getInitialPose());

    // Run path following command, then stop at the end.
    return ramseteCommand.andThen(() -> m_robotDrive.tankDriveVolts(0, 0));
    }

    // Return the command to run in autonomous mode (AutoNav)
    public static Command getChosenTrajectory(int chosenPath) {
        Trajectory chosenTrajectory = m_trajectoryArray.get(chosenPath-1);
        return getPathweaverCommand(chosenTrajectory);
    }
    
}
