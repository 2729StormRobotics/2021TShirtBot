// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * This version of Lights is designed to control a WS2812 LED strip directly, WITHOUT the Blinkin LED Driver that was used in 2019. 
 * This requires more complex controls work but allows more low-level software control. 
 */
public class Lights extends SubsystemBase {

  private AddressableLED m_led;
  private AddressableLEDBuffer m_ledBuffer;

  /** Creates a new Lights. */
  public Lights() {

    m_led = new AddressableLED(/* TODO: kLedPort (must be PWM port of Rio) */);

    // This is an expensive operation and must NOT be done periodically. 
    m_ledBuffer = new AddressableLEDBuffer(/* TODO: kLedLength */);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
