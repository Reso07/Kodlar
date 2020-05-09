package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

public class DriveTrain extends Subsystem {
  private TalonSRX motorLeft1 = new TalonSRX(RobotMap.MOTOR_LEFT_1_ID);
  private TalonSRX motorLeft2 = new TalonSRX(RobotMap.MOTOR_LEFT_2_ID);
  private TalonSRX motorRight1 = new TalonSRX(RobotMap.MOTOR_RIGHT_1_ID);
  private TalonSRX motorRight2 = new TalonSRX(RobotMap.MOTOR_RIGHT_2_ID);

   @Override
   public void initDefaultCommand() {
     setDefaultCommand(new TankDrive())
   }

   public void setLeftMotors(double speed) {
     motorLeft1.set(ControlMode.PercentOutput, -speed);
     motorLeft2.set(ControlMode.PercentOutput, -speed);
   }

   public void setRightMotors(double speed) {
    motorRight1.set(ControlMode.PercentOutput, speed);
    motorRight2.set(ControlMode.PercentOutput, speed);
  }
}