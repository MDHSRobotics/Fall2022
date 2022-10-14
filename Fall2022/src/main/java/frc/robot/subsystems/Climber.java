package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.subsystems.Devices.ClimberLeft;
import static frc.robot.subsystems.Devices.ClimberRight;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.constants.ClimberConstants;

public class Climber extends SubsystemBase {

    public Climber() {
        Logger.setup("Constructing Subsystem: Climb...");
        ClimberLeft.restoreFactoryDefaults();
        ClimberRight.restoreFactoryDefaults();
   }

   @Override
   public void periodic() {
       // This method will be called once per scheduler run
   }

   // Stop the Climber
   public void stop() {
        ClimberLeft.stopMotor();
        ClimberRight.stopMotor();
   }
   // Raise the Claws
   public void raiseClimb(double value) {
        ClimberLeft.set(-ClimberConstants.kClimbSpeed * value);
        ClimberRight.set(-ClimberConstants.kClimbSpeed * value);
    }
    //Lower the Claws
   public void lowerClimb() {
        ClimberLeft.set(ClimberConstants.kClimbSpeed);
        ClimberRight.set(ClimberConstants.kClimbSpeed);
    }
}
