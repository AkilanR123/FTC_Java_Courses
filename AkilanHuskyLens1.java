package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.dfrobot.HuskyLens;


@TeleOp(name="AkilanHuskyLens1")

public class AkilanHuskyLens1 extends LinearOpMode {
    WarriorsMyRobotConfig2 robotConfig = new WarriorsMyRobotConfig2();
    String genStatus = "Hello Drivers";
    String armStatus = "Ready";
    String driveSpeed = "Normal";
    String turnSpeed = "Normal";

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
    
//Will return true if it sees Red, otherwise it will return false
    public boolean isRedVisibleToCamera(){
        boolean RedAhead = false;
        for (int j = 0; j < 5; j++) {
            HuskyLens.Block[] blocks = robotConfig.huskyLens.blocks();
            telemetry.addData("Block count", blocks.length);
            telemetry.update();
            for (int i = 0; i < blocks.length; i++) {
                telemetry.addData("Block", blocks[i].toString());
                if ((blocks[i].toString()).charAt(3) =='2') {
                    RedAhead = true;
                    return true;
                }
            }
        }
        telemetry.update();
        return false;
    }

    @Override
    public void runOpMode() {

        robotConfig.init(hardwareMap);
        robotConfig.huskyLens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);

        // It will display the Play button to the driver on the Driver Hub after finishing
        // the above steps.

        //print hello to the driver on the driver hub
        updateDriversWithSystemStatus();
        
        // Wait for the game to start (driver has to press PLAY)
        waitForStart();

        while (opModeIsActive()){
            if (isRedVisibleToCamera()){
                telemetry.addData("Red", "Color Found");
                telemetry.update();
        }   else {
                telemetry.addData("Red:", "Color NOT Found");
                telemetry.update();
        }
            
            
        }

    }


}
