// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

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

  public Drivetrain() {

    // Initialize motor objects
    m_leftMotor1 = new WPI_TalonSRX(kLeftMotorPort1);
    m_leftMotor2 = new WPI_TalonSRX(kLeftMotorPort2);
    m_rightMotor1 = new WPI_TalonSRX(kRightMotorPort1);
    m_rightMotor2 = new WPI_TalonSRX(kRightMotorPort2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
