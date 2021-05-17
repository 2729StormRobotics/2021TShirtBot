// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;


/**
 * This version of Lights is designed to control a WS2812 LED strip directly, WITHOUT the Blinkin LED Driver that was used in 2020. 
 * This requires more complex controls work but allows more low-level software control. 
 */
public class Lights extends SubsystemBase {

  private AddressableLED m_led;
  private AddressableLEDBuffer m_ledBuffer;

  /** Creates a new Lights. */
  public Lights() {

    m_led = new AddressableLED(/* TODO: kLedPort (must be PWM port of Rio) */);

    // This is an expensive operation and must NOT be done periodically. 
    // Reuse this buffer. 
    m_ledBuffer = new AddressableLEDBuffer(/* TODO: kLedLength */);
    m_led.setLength(m_ledBuffer.getLength());

    // Set the data.
    m_led.setData(m_ledBuffer);
    m_led.start();

  }

  /**
   * Sets a section of the LED strip from 0-based index start (inclusive) to index end (exclusive)
   * to the color specified by r, g, and b. 
   * If the range specified is invalid, this method does nothing.
   */
  public void setSectionRGB(int start, int end, int r, int g, int b) {
    if (start >= 0 && end > start && end <= m_ledBuffer.getLength()) {
      for (int i = start; i < end; i++) {
        m_ledBuffer.setRGB(i, r, g, b);
      }

      m_led.setData(m_ledBuffer);
    }
  }

  /**
   * Sets a section of the LED strip from 0-based index start (inclusive) to index end (exclusive)
   * to the color specified by h, s, and v.
   * If the range specified is invalid, this method does nothing.
   */
  public void setSectionHSV(int start, int end, int h, int s, int v) {
    if (start >= 0 && end > start && end <= m_ledBuffer.getLength()) {
      for (int i = start; i < end; i++) {
        m_ledBuffer.setHSV(i, h, s, v);
      }

      m_led.setData(m_ledBuffer);
    }
  }

  /**
   * Turns off the entire LED strip.
   */
  public void clear() {
    setSectionRGB(0, m_ledBuffer.getLength(), 0, 0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
