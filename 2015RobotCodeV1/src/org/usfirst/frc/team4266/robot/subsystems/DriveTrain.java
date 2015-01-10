package org.usfirst.frc.team4266.robot.subsystems;

import org.usfirst.frc.team4266.robot.commands.DriveWithSticks;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Author: Zach
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithSticks());
    }
    
    
}

