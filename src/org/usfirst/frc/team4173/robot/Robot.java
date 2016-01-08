
package org.usfirst.frc.team4173.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	private SpeedController RightMotor;
	private SpeedController LeftMotor;

	
	private Joystick stick;
	
	boolean MattIsAwesome = true;
	
	public Robot () {
		RightMotor = new Talon(0);
		LeftMotor = new Talon(1);
		
		stick = new Joystick(0);
	}
	
    public void robotInit() {
    }

    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        double y = stick.getY();
        double x = stick.getX();
        //gets joystick axis values and assigns them to variables       
        
        double speed = y * Math.abs(y);
        double direction = 0.5 * x;
        //maps the values for more precision and less permadeath
        
        double RightPower = limitBetween1(speed + direction);
        double LeftPower  = limitBetween1(speed - direction);
        
        
    }
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    private double limitBetween1(double n) {
    	if (n>1)
    		n = 1;
    	if (n<-1)
    		n = -1;
    	return n;
    }
    
}
