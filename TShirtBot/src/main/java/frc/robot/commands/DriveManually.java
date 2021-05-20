// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

public class DriveManually extends CommandBase {
  private final Drivetrain m_drivetrain;
  private final DoubleSupplier m_leftSpeed;
  private final DoubleSupplier m_rightSpeed;
  private final DoubleSupplier m_forwardSpeed;
  private final DoubleSupplier m_reverseSpeed;
  private double m_currentSpeed = 0;

  /** Creates a new DriveManually. */
  public DriveManually(DoubleSupplier forwardSpeed, DoubleSupplier reverseSpeed, DoubleSupplier leftSpeed,
  DoubleSupplier rightSpeed, Drivetrain subsystem) {
    m_drivetrain = subsystem;
    m_leftSpeed = leftSpeed;
    m_rightSpeed = rightSpeed;
    m_forwardSpeed = forwardSpeed;
    m_reverseSpeed = reverseSpeed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.stopDrive();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Math.abs(m_forwardSpeed.getAsDouble() - m_reverseSpeed.getAsDouble()) > 0.03) {
      m_drivetrain.triggerDrive(m_forwardSpeed.getAsDouble(), m_reverseSpeed.getAsDouble(), 0, true);
    } else {
      m_drivetrain.tankDrive(m_leftSpeed.getAsDouble(), m_rightSpeed.getAsDouble(), true);
    }
    //getAverageSpeed() hasn't yet been added to the Drivetrain subsystem.
    //m_currentSpeed = m_drivetrain.getAverageSpeed();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_currentSpeed = 0;
    m_drivetrain.stopDrive();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
