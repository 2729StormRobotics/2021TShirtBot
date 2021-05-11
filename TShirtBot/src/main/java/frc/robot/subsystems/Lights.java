// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lights extends SubsystemBase {

  private final Spark m_ledDriver;

  /** Creates a new Lights. */
  public Lights() {

    // Instantiate led driver and assign to its port
    m_ledDriver = new Spark(/* TODO: kLedBlinkinDriverPort */);

  }

  /**
   * Updates the lights to indicate the number of shirts that are available to
   * shoot in the current firing mode, given a number of shirts from 0 to 4.
   * 
   * @param numShirts Number of shirts in the barrels, must be between 0 and 4.
   */
  public void updateShirtCounter(int numShirts) {
    switch (numShirts) {
      case 4:
        m_ledDriver.set(/* TODO: kFourShirts */);
        break;
      case 3:
        m_ledDriver.set(/* TODO: kThreeShirts */);
        break;
      case 2:
        m_ledDriver.set(/* TODO: kTwoShirts */);
        break;
      case 1:
        m_ledDriver.set(/* TODO: kOneShirt */);
        break;
      default:
        m_ledDriver.set(/* TODO: kEmpty */);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
