package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.hardware.dfrobot.HuskyLens;

public class WarriorsMyRobotConfig2 {
    //Declaring the variables for the 4 wheel motors
    public DcMotor frontLeftW;
    public DcMotor frontRightW;
    public DcMotor backLeftW;
    public DcMotor backRightW;
    public HuskyLens huskyLens;
    public final int bluePropID = 1;

    public DcMotor hangingMotor;
    //GoBilda 5203 117RPM motor Tick Count = Pulses per revolution x Gear Ratio = 28 pulses x 50.9
    public final double hangingMotorTickCount = 1425.2;
    public final double hangingTickCount = hangingMotorTickCount * 18;//18
    public final double startHangTickCount = - hangingMotorTickCount * 18;//18


    public Servo airplaneLauncher;
    public final double airplaneLauncherFire = 0.3;

    public Servo ServoArm1;
    public final double ServoArm1High = 0.65;
    public final double ServoArm1BackBoard1 = 0.6;
    public final double ServoArm1BackBoard2 = 0.6;
    public final double ServoArm1MoveWithPixel = 0.8;
    public final double ServoArm1PickupReady = 0.975;
    public final double ServoArm1PickupReady2 = 0.975;
    public final double ServoArm1PickupAuto = 0.9;

    public Servo ServoArm2;
    public final double ServoArm2Open = 0.3;//0.53
    public final double ServoArm2Close = 0.61;
    public final double ServoArm2Close2 = 0.63;
    public final double ServoArm2Close3 = 0.62;
    public final double ServoArm2Grab = 0.7;
    public Servo ServoArm2Left;
    public final double ServoArm2LeftOpen = 0.9;
    public final double ServoArm2LeftClose = 0.62;

    public Servo FingerServo1;
    public final double FingerServo1Stack5Ready = 0.25;
    public final double FingerServo1Stack4Ready = 0.3;
    public final double FingerServo1Stack3Ready = 0.33;
    public final double FingerServo1Stack2Ready = 0.43;
    public final double FingerServo1Stack1Ready = 0.50;//0.59

    public final double FingerServo1Stack5Pickup = 0.45; //Pickup top 2
    public final double FingerServo1Stack4Pickup = 0.52; //Pickup top 2
    public final double FingerServo1Stack3Pickup = 0.59; //Pickup top 2
    public final double FingerServo1Stack2Pickup = 0.64; //.65
    public final double FingerServo1Stack1Pickup = 0.63; //.65

    public Servo FingerMoveServo2;
    public final double FingerMoveServo2Release = 0.79;
    public final double FingerMoveServo2Grab = 0.96;

    public Servo lefthangingarm;


    //Warriors
    public final double LeftHangingArmReadyToHang = 0.28;
    public final double LeftHangingArmRestPosition = 0.66; //0.61
    //Orion
    //public final double LeftHangingArmReadyToHang = 0.0;
    //public final double LeftHangingArmRestPosition = 0.35;

    public Servo righthangingarm;
    //Warriors
    public final double RightHangingArmReadyToHang = 0.74;
    public final double RightHangingArmRestPosition = 0.35; //0.41
    //Orion
    //public final double RightHangingArmReadyToHang = 0.37;
    //public final double RightHangingArmRestPosition = 0.05;

    HardwareMap ourRobotConfig;
    private ElapsedTime period = new ElapsedTime();

    //Constructor
    public WarriorsMyRobotConfig2(){

    }

    //Initialize the hardware connecting variables
    public void init(HardwareMap aRobotConfig){
        //Save the reference to the robot confi
        ourRobotConfig = aRobotConfig;

        huskyLens = ourRobotConfig.get(HuskyLens.class, "huskylens");

        //Initialize the wheel motor variables
        frontLeftW  = ourRobotConfig.get(DcMotor.class, "FrontLeftWheel");
        frontRightW  = ourRobotConfig.get(DcMotor.class, "FrontRightWheel");
        backLeftW  = ourRobotConfig.get(DcMotor.class, "BackLeftWheel");
        backRightW  = ourRobotConfig.get(DcMotor.class, "BackRightWheel");

        hangingMotor = ourRobotConfig.get(DcMotor.class, "HangingMotor");

        //Initialize the arm servos
        ServoArm1 = ourRobotConfig.get(Servo.class, "ServoArm1");
        ServoArm2 = ourRobotConfig.get(Servo.class, "ServoArm2");
        ServoArm2Left = ourRobotConfig.get(Servo.class, "ServoArm2Left");
        FingerServo1 = ourRobotConfig.get(Servo.class, "FingerServo1");
        FingerMoveServo2 = ourRobotConfig.get(Servo.class, "FingerMoveServo2");

        //Hanging arm
        lefthangingarm = ourRobotConfig.get(Servo.class, "LeftHangingArm");
        lefthangingarm.setPosition(LeftHangingArmRestPosition);//

        righthangingarm = ourRobotConfig.get(Servo.class, "RightHangingArm");
        righthangingarm.setPosition(RightHangingArmRestPosition);

        //Initialize the airplane launcher servos
        airplaneLauncher = ourRobotConfig.get(Servo.class, "AirLauncher");

        //Testing
        ServoArm1.setPosition(ServoArm1PickupReady); //The main arm movement
        ServoArm2.setPosition(ServoArm2Open); //Works - it catches the pixels
        ServoArm2Left.setPosition(ServoArm2LeftOpen); //Works - it catches the pixels
        FingerServo1.setPosition(FingerServo1Stack5Ready); //The linear servo
        FingerMoveServo2.setPosition(FingerMoveServo2Release);

        /*
        ServoArm1.setPosition(ServoArm1PickupReady); //The main arm movement
        ServoArm2.setPosition(ServoArm2Open); //Works - it catches the pixels
        ServoArm2Left.setPosition(ServoArm2LeftOpen); //Works - it catches the pixels
        FingerServo1.setPosition(FingerServo1Stack3Ready); //The linear servo
        FingerMoveServo2.setPosition(FingerMoveServo2Release); //The servo to rotate the finger
        */

        /* Turns left and right
        frontLeftW.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftW.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightW.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightW.setDirection(DcMotorSimple.Direction.FORWARD);
        */
        //Strafe left and right
        frontLeftW.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftW.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightW.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightW.setDirection(DcMotorSimple.Direction.FORWARD);

        //set all wheel motors to zero power
        frontLeftW.setPower(0);
        frontRightW.setPower(0);
        backLeftW.setPower(0);
        backRightW.setPower(0);

        //set all motors to RUN_USING_ENCODER or RUN_WITHOUT_ENCODER
        //based on if encoder wires are connected or not
        frontLeftW.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightW.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftW.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightW.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
