/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private static final WPI_TalonSRX m_intake = new WPI_TalonSRX(IntakeConstants.kIntakeMotor);
  private static final DoubleSolenoid m_intakeSol = new DoubleSolenoid(IntakeConstants.kIntakeSolenoidForward, IntakeConstants.kIntakeSolenoidReverse);
  
  /**
   * Creates a new Intake.
   */
  public Intake() {

  }

  public void runNow(){
    m_intake.set(ControlMode.PercentOutput, 0.5);
  }

  public void open(){
    m_intakeSol.set(Value.kForward);
  }

  public void retract(){
    m_intakeSol.set(Value.kReverse);
  }

  public void stopRunning(){
    m_intake.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
