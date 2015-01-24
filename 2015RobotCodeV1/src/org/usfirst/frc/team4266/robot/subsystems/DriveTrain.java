package org.usfirst.frc.team4266.robot.subsystems;

import org.usfirst.frc.team4266.robot.RobotMap;

import org.usfirst.frc.team4266.robot.commands.DriveWithSticks;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	RobotDrive drive;
    double powerLevel;
    double turnPower;
    double forwardPower;
    double distance;
    int count = 0;
    double right=0,left=0;
    
    
    Encoder rightEncoder = new Encoder(RobotMap.rightEncoder1,RobotMap.rightEncoder2,true,CounterBase.EncodingType.k4X);
    Encoder leftEncoder = new Encoder(RobotMap.leftEncoder1,RobotMap.leftEncoder2,false,CounterBase.EncodingType.k4X);
     
    public DriveTrain(){
        powerLevel=0.8;
        drive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        drive.setSafetyEnabled(false);
        rightEncoder.setDistancePerPulse(6*Math.PI/360);
        
        //rightEncoder.start();
        rightEncoder.reset();
        leftEncoder.setDistancePerPulse(6*Math.PI/360);
        //leftEncoder.start();
        leftEncoder.reset();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithSticks());
    }
    public void changePower(double x){
        powerLevel+=x;
        //setPower(powerLevel);
    }
    public void showEncoders(){
        System.out.println("ENCODERS " + leftEncoder.getDistance() + " " +rightEncoder.getDistance());
    }
    
    public void resetEncoders(){
        
        rightEncoder.reset();
        leftEncoder.reset();
       
    }
    
     public void setPower(double pl){
        if(powerLevel>1){
            powerLevel = 1;
        }
        else if(powerLevel < -1){
            powerLevel = -1;
        }
        else{
            powerLevel = pl;
        }
        System.out.println("power" + powerLevel);
    }
     public double getPower(){
        return powerLevel;
    }
     
     public double getEncoderDistance(){
         return (rightEncoder.getDistance()+leftEncoder.getDistance())/2.0;
     }
    public void arcadeDrive(Joystick right){
        distance = getEncoderDistance();
        //System.out.println("Distance--> "+distance);
        forwardPower = powerLevel * right.getY();
        turnPower= Math.abs(0.8*powerLevel)*right.getX();
         this.right = rightEncoder.getDistance();
        left = leftEncoder.getDistance();
        
        
        drive.arcadeDrive(-forwardPower,-turnPower);
    }
    public void autoDrive(double power){
        //distance = encoder.getDistance();
        distance = getEncoderDistance();
        right = rightEncoder.getDistance();
        left = leftEncoder.getDistance();
       // System.out.println(encoder.getRaw() + " " +count);
        
        count++;
       //rive.arcadeDrive(power,0);
       // drive.drive(power,-0.0075);
          drive.drive(power,-0.000055);
        
       
    }
    public void updateStatus(){
        SmartDashboard.putNumber("Distance: ", distance);
        SmartDashboard.putNumber("Right Distance: ", right);
        SmartDashboard.putNumber("Left Distance: ", left);
        
    }
    public double getDistance(){
        return distance;
    }
    public void stopDrive(){
    	drive.tankDrive(0, 0);
    }
    
    public Encoder getLeftEncoder(){
    	return leftEncoder;
    }
    public Encoder getRightEncoder(){
    	return rightEncoder;
    }
}

