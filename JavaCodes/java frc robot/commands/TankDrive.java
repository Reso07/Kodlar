/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class TankDrive extends Command {
  /**
   * Creates a new TankDrive.
   */
  public TankDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    requires(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double stick1 = Robot.m_oi.GetDriverRaxAxis(RobotMap.STICK_Y),
    stick2 = Robot.m_oi.GetDriverRaxAxis(RobotMap.STICK_X);

    Robot.driveTrain.setLeftMotors(stick1*stick1); Robot.driveTrain.setRightMotors(stick2*stick2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.driveTrain.setLeftMotors(0); Robot.driveTrain.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  protected void interrupted() {
    this.end(true);
  }
}