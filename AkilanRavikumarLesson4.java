package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name ="AkilanRavikumarLesson4")

public class AkilanRavikumarLesson4  extends LinearOpMode {
    AkilanRavikumarRobotConfig robotConfig = new AkilanRavikumarRobotConfig();
    String name = "Akilan Ravikumar";
    public void runOpMode(){
        robotConfig.init(hardwareMap);
        waitForStart();
        telemetry.addData("My name is", name);
        telemetry.update();
        while (opModeIsActive()){
        
        }
    }
}
    // todo: write your code here
