package frc.robot.subsystems.constants;

import edu.wpi.first.math.trajectory.TrapezoidProfile;

public final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 0.5;
    public static final double kMaxAccelerationMetersPerSecondSquared = 0.5;

    //Pid constants for trajectory following
    //TODO validate the pid constants
    public static final double kPXController = 1.5;
    public static final double kPYController = 1.5;
    public static final double kPThetaController = 0;

    //Profile for trajectory following
    public static final double kMaxAngularSpeedRadiansPerSecond = 0.25;
                    //SwerveConstants.kPhysicalMaxAngularSpeedRadiansPerSecond / 10;
    public static final double kMaxAngularAccelerationRadiansPerSecondSquared = Math.PI / 4;

    public static final TrapezoidProfile.Constraints kThetaControllerConstraints = 
                new TrapezoidProfile.Constraints(
                        kMaxAngularSpeedRadiansPerSecond,
                        kMaxAngularAccelerationRadiansPerSecondSquared);

}
