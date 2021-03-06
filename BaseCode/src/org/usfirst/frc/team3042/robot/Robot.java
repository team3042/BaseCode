
package org.usfirst.frc.team3042.robot;

import org.usfirst.frc.team3042.robot.commands.AutoMode_DoNothing;
import org.usfirst.frc.team3042.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import org.usfirst.frc.team3042.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3042.robot.subsystems.ExampleSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static final DriveTrain driveTrain = new DriveTrain();
	public static OI oi;
	public static Logger logger = new Logger(true, true, 3);
	
	Command autonomousCommand;
    SendableChooser autonomousChooser;
    public static FileIO fileIO = new FileIO();
    private int LOGGER_LEVEL = 5;
    boolean useConsole = true, useFile = true;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        logger = new Logger(useConsole, useFile, LOGGER_LEVEL);
        
		autonomousChooser = new SendableChooser();
        autonomousChooser.addDefault("Default (Do Nothing)", 0);
        autonomousChooser.addObject("Autonomous 1", 1);
        SmartDashboard.putData("Autonomous Chooser", autonomousChooser);
    }
     
    public void disabledInit(){
    	Robot.logger.log("Disabled Init", 1);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above, adding additional choosers,
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	Robot.logger.log("Autonomous Init", 1);
    	
    	int autonomousCommandNumber = (int) autonomousChooser.getSelected();
    	switch (autonomousCommandNumber) {
        case 0:  autonomousCommand = new AutoMode_DoNothing();
                 break;
        case 1:  //autonomousCommand = new exampleCommand();
    			//uncomment above line once you have an autonomous command to run.
             break;
    	}
    	
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	Robot.logger.log("Teleop Init", 1);
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this (below) line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();  
        //Here is where you would put smart dashboard outputs, to put a number on the smart dashbard follow this format
        //SmartDashboard.putNumber("example number", number or variable here);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public enum Alliance {
    	RED_ALLIANCE, BLUE_ALLIANCE;
    }
    
}

    