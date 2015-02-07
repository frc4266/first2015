package org.usfirst.frc.team4266.robot.subsystems;



import org.usfirst.frc.team4266.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Conveyor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	
    }
    
    
    public void motorOnToUnload(){
    	
    }
    
    public void turnOn(){
    	
    }
    
    public void stop(){
    	
    }
    
    public boolean hasTote(){
    	//return sensor.get();
    	return false;
    }
    
    public void updateStatus(){
    	SmartDashboard.putBoolean("Loading Status", Robot.isLoadingTote);
    }
    
   
}

