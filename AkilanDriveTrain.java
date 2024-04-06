
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name="AkilanDriveTrain")
public class AkilanDriveTrain extends LinearOpMode {
    WarriorsMyRobotConfig2 robotConfig = new WarriorsMyRobotConfig2();
    String genStatus = "Akil";
    String armStatus = "Ready";
    String driveSpeed = "Not Normal";
    String turnSpeed = "Not Normal";
    
    public void updateDriversWithSystemStatus(){
        telemetry.clear();
        telemetry.addLine();
        telemetry.addData("Status", genStatus);
        telemetry.addLine();
        telemetry.addData("Arm", armStatus);
        
        telemetry.addLine();
        telemetry.addData("Drive Speed", driveSpeed);
        
        telemetry.addLine();
        telemetry.addData("Turn Speed", turnSpeed);
        telemetry.update();
    }
     public void moveForward(){
        robotConfig.frontLeftW.setPower(0.1);
        robotConfig.frontRightW.setPower(0.1);
        robotConfig.backLeftW.setPower(0.1);
        robotConfig.backRightW.setPower(0.1);
        sleep(800);
        robotConfig.frontLeftW.setPower(0);
        robotConfig.frontRightW.setPower(0);
        robotConfig.backLeftW.setPower(0);
        robotConfig.backRightW.setPower(0);
    }
    
    public void moveBackwards(){
        robotConfig.frontLeftW.setPower(-0.1);
        robotConfig.frontRightW.setPower(-0.1);
        robotConfig.backLeftW.setPower(-0.1);
        robotConfig.backRightW.setPower(-0.1);
        sleep(800);
        robotConfig.frontLeftW.setPower(0);
        robotConfig.frontRightW.setPower(0);
        robotConfig.backLeftW.setPower(0);
        robotConfig.backRightW.setPower(0);
    }
    
    public void strafeLeftMecanumWheels(){
        robotConfig.frontLeftW.setPower(-0.2);
        robotConfig.frontRightW.setPower(0.2);
        robotConfig.backLeftW.setPower(0.2);
        robotConfig.backRightW.setPower(-0.2);
        sleep(800);
        robotConfig.frontLeftW.setPower(0);
        robotConfig.frontRightW.setPower(0);
        robotConfig.backLeftW.setPower(0);
        robotConfig.backRightW.setPower(0);
    }
    
    public void strafeRightMecanumWheels(){
        robotConfig.frontLeftW.setPower(0.2);
        robotConfig.frontRightW.setPower(-0.2);
        robotConfig.backLeftW.setPower(-0.2);
        robotConfig.backRightW.setPower(0.2);
        sleep(800);
        robotConfig.frontLeftW.setPower(0);
        robotConfig.frontRightW.setPower(0);
        robotConfig.backLeftW.setPower(0);
        robotConfig.backRightW.setPower(0);
    }
    public void turnRight(){
        robotConfig.frontLeftW.setPower(0.2);
        robotConfig.frontRightW.setPower(0);
        robotConfig.backLeftW.setPower(0);
        robotConfig.backRightW.setPower(-0.2);
        sleep(800);
        robotConfig.frontLeftW.setPower(0);
        robotConfig.frontRightW.setPower(0);
        robotConfig.backLeftW.setPower(0);
        robotConfig.backRightW.setPower(0);
    }
    public void turnLeft(){
        robotConfig.frontLeftW.setPower(-1);
        robotConfig.frontRightW.setPower(0.2);
        robotConfig.backLeftW.setPower(-0.2);
        robotConfig.backRightW.setPower(0);
        sleep(800);
        robotConfig.frontLeftW.setPower(0);
        robotConfig.frontRightW.setPower(0);
        robotConfig.backLeftW.setPower(0);
        robotConfig.backRightW.setPower(0);
    }
    
    @Override
    public void runOpMode() {
        robotConfig.init(hardwareMap);
        
        // It will display the Play button to the driver on the Driver Hub after finishing
        // the above steps.
        
        //print hello to the driver on the driver hub
        updateDriversWithSystemStatus();
        
        //Wait for the game to start (driver has to press PLAY)
        waitForStart();
        moveForward();
        strafeRightMecanumWheels();
        moveForward();
        strafeRightMecanumWheels();
        moveForward();
        strafeRightMecanumWheels();
        moveForward();
        strafeRightMecanumWheels();

        while (opModeIsActive()){
        }
    }
    
}
