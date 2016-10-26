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
  public double potZero = 100;
  private double lowLimit = 0;
	private double highLimit = 690;
	private double ballStorage = 624;
	private double ballPickup = 0; 
	private double shoot = 240;
	private double lowGoal = 73;
	private double autonomousShoot = 240;
	private double p = 0;
	private double i = 0;
	private double d = 0;
	private int iZone = 0;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public SnoutPractice() {
		talonRotate.setFeedbackDevice(CANTalon.FeedbackDevice.AnalogPot);
		talonRotate.setStatusFrameRateMs(CANTalon.StatusFrameRate.Feedback, 10);
		talonRotate.reverseOutput(true);
		talonRotate.setInverted(true);
		
		talonRotate.setPID(p, i, d);
		talonRotate.setF(0);
		talonRotate.setIZone(iZone);
		talonRotate.setAllowableClosedLoopErr(0);
		
		setToCurrentPosition();
		
		//Beginning motion profile
		talonRotate.changeMotionControlFramePeriod(5);
	}
    
    public void setToCurrentPosition() {
    	double position = getPosition();
    	setPosition(position);
    }
    
    public void setPosition(double position){
    	double pos = potZero - position;
    	talonRotate.setPosition(pos);
    }
    
    public double getPosition() {
    	double position = potZero - getPotValue();
    	return position;
    }
    
    public double getPotValue() {
    	double potValue = talonRotate.getAnalogInRaw();
    	return potValue;
    }
    
    public void goToStorage() {
    	setPosition(ballStorage);
    }
    
    public void goToPickup() {
    	setPosition(ballPickup);
    }
}

