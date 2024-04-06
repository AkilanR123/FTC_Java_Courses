package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name="AkilanTelemetry")

public class AkilanTelemetry extends LinearOpMode {
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
    
    @Override
    public void runOpMode() {
        robotConfig.init(hardwareMap);
        
        // It will display the Play button to the driver on the Driver Hub after finishing
        // the above steps.
        
        //print hello to the driver on the driver hub
        updateDriversWithSystemStatus();
        
        //Wait for the game to start (driver has to press PLAY)
        waitForStart();
        while (opModeIsActive()){
        }
    }
}
