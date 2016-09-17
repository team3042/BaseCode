package org.usfirst.frc.team3042.robot.commands;
import org.usfirst.frc.team3042.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTrain_TankDrive extends Command{
	private final double speedScale = 1.0;
	private final double deadzone = 0.07;
	
	//Inertial dampening
    final int LEFT = 0, RIGHT = 1;
    Timer time = new Timer();
    double[] oldTime = new double[] {0, 0};
    double[] currentPower = new double[] {0,0};
    double maxAccel = 3.6; //motor power per second
    
    public DriveTrain_TankDrive(){
    	requires(Robot.driveTrain);
    }

	protected void initialize() {
		
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
}
