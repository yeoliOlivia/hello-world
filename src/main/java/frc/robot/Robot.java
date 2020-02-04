/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import frc.robot.TorqueMotor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends TimedRobot {
  private final boolean clockwise = true; 
  
  private TorqueMotor Left1;
  private TorqueMotor Left2;
  private TorqueMotor Left3;
  private TorqueMotor Right1;
  private TorqueMotor Right2;
  private TorqueMotor Right3;
  private GenericController driver;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    driver = new GenericController(0, 0, .05);
    Left1 = new TorqueMotor(new VictorSP(0), clockwise); 
    Left2 = new TorqueMotor(new VictorSP(0), clockwise);
    Left3 = new TorqueMotor(new VictorSP(0), clockwise);
    Right1 = new TorqueMotor(new VictorSP(0), !clockwise);
    Right2 = new TorqueMotor(new VictorSP(0), !clockwise);
    Right3 = new TorqueMotor(new VictorSP(0), !clockwise);
  
  }

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
     // stop robot
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
