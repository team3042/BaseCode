package org.usfirst.frc.team3042.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3042.robot.RobotMap;
import org.usfirst.frc.team3042.robot.commands.Snout_HoldPosition;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.CANTalon.MotionProfileStatus;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
/**
 *
 */
public class SnoutPractice extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
  public CANTalon talonRotate = new CANTalon(RobotMap.SNOUT_TALON);
  public double PotZero = 100;
  private double LowLimit = 0;
	private double HighLimit = 690;
	private double BallStorage = 624;
	private double BallPickup = 0; 
	//private double shoot = 240;
	private double LowGoal = 73;
	private double AutonomousShoot = 240;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

