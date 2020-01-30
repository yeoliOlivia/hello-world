/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.texastorque.torquelib.util.*;
import frc.texastorque.torquelib.component.*;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private final boolean clockwise = true; 
  private final DifferentialDrive m_robotDrive
      = new DifferentialDrive(new PWMVictorSPX(0), new PWMVictorSPX(1));
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();
  private GenericController driver = new GenericController(0, 0, .05);
  private TorqueMotor Left1 = new TorqueMotor(new VictorSP(0), clockwise); 
  private TorqueMotor Left2 = new TorqueMotor(new VictorSP(0), clockwise);
  private TorqueMotor Left3 = new TorqueMotor(new VictorSP(0), clockwise);
  private TorqueMotor Right1 = new TorqueMotor(new VictorSP(0), !clockwise);
  private TorqueMotor Right2 = new TorqueMotor(new VictorSP(0), !clockwise);
  private TorqueMotor Right3 = new TorqueMotor(new VictorSP(0), !clockwise);


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
  }

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
     // stop robot
    }
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() {
  }

  /**
   * This function is called periodically during teleoperated mode.
   */
  @Override
  public void teleopPeriodic() {
    double forwardSpeed = -driver.getLeftYAxis();
    double turningSpeed = driver.getRightXAxis();
    double leftSpeed = (forwardSpeed + turningSpeed)/2;
    double rightSpeed = (forwardSpeed - turningSpeed)/2;
    Left1.set(leftSpeed);
    Left2.set(leftSpeed);
    Left3.set(leftSpeed);
    Right1.set(rightSpeed);
    Right2.set(rightSpeed);
    Right3.set(rightSpeed);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    
  }
}
