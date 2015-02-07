package org.usfirst.frc.team4266.robot.commands;

import org.usfirst.frc.team4266.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {

	double howLong = 0;
	boolean isDrivingForward = true;
	double autoDrivePower = 0.5;
	
    public AutoDrive(double howLong, boolean isDrivingForward, double autoDrivePower) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.autoDrivePower = autoDrivePower;
    	this.isDrivingForward = isDrivingForward;
    	requires(Robot.driveTrain);
    	this.howLong = howLong;
    	this.setTimeout(howLong);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.autoDrive(autoDrivePower, isDrivingForward);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
