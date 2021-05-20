// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.Constants.DrivetrainConstants.*;


public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  // Declare motor objects
  private final WPI_TalonSRX m_leftMotor1;
  private final WPI_TalonSRX m_leftMotor2;
  private final WPI_TalonSRX m_rightMotor1;
  private final WPI_TalonSRX m_rightMotor2;

  private final DifferentialDrive m_drive;

  private boolean m_reverseDrive = false;


  public Drivetrain() {

    // Initialize motor objects
    m_leftMotor1 = new WPI_TalonSRX(kLeftMotorPort1);
    m_leftMotor2 = new WPI_TalonSRX(kLeftMotorPort2);
    m_rightMotor1 = new WPI_TalonSRX(kRightMotorPort1);
    m_rightMotor2 = new WPI_TalonSRX(kRightMotorPort2);

    //I'm not sure which motor should follow which; it could be the other way.
    m_leftMotor2.follow(m_leftMotor1);
    m_rightMotor2.follow(m_rightMotor1);

    m_drive = new DifferentialDrive(m_leftMotor1, m_rightMotor1);
    m_drive.setRightSideInverted(false);

  }

  // Drives the motor using tank drive
  // Change the squareInputs if needed
  public void tankDrive(double leftPower, double rightPower, boolean squareInputs) {
    if (m_reverseDrive) {
      m_drive.tankDrive(rightPower, leftPower, squareInputs);
    }
    else {
      m_drive.tankDrive(leftPower, rightPower, squareInputs);
    }
  }

  // Drives the motors using arcade drive
  public void arcadeDrive(double speed, double turn, boolean squareInputs) {
    m_drive.arcadeDrive(speed, turn, squareInputs);
  }


// Drives the motor using trigger drive
public void triggerDrive(double forward, double reverse, double turn, boolean squareInputs) {
  m_drive.arcadeDrive(forward - reverse, turn, squareInputs);
}

// sets motor values to zero to stop
public void stopDrive() {
  m_drive.tankDrive(0, 0);
}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
