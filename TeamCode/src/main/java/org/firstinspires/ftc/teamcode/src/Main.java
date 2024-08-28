package org.firstinspires.ftc.teamcode.src;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.lib.MotorController;
import org.firstinspires.ftc.teamcode.lib.SliderController;
import org.firstinspires.ftc.teamcode.lib.ServoController;


@TeleOp(name="MainTest", group="OpMode")
@Config()
public class Main extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    public static double  strafeTuning = 1;
    @Override
    public void runOpMode() {

        // Left Back Drive = 3, Right Back Drive = 0, Left Front Drive = 2, Right Front Drive = 1
        MotorController.Initmotor(
                hardwareMap.get(DcMotor.class, "3"),
                hardwareMap.get(DcMotor.class, "0"),
                hardwareMap.get(DcMotor.class, "2"),
                hardwareMap.get(DcMotor.class, "1")
        );

        ServoController.initservos(
                hardwareMap.get(CRServo.class,"servo1"),
                hardwareMap.get(Servo.class,"intakeservo")
                );


        telemetry.addData("Status", "Initialized");
        telemetry.update();
        ServoController.lastpowerrange =-0.228;
        waitForStart();
        runtime.reset();
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            MotorController.driveMotors(-gamepad1.left_stick_y, -gamepad1.left_stick_x * strafeTuning, -gamepad1.right_stick_x);

            ServoController.runarmservo(gamepad1.a, gamepad1.b, gamepad1.dpad_left, gamepad1.dpad_right);
            ServoController.runintakeServo(gamepad1.left_bumper, gamepad1.right_bumper);

             // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addLine("LastPowerRangeServo :" + ServoController.lastpowerrange);
            telemetry.addLine("Gamepad Left Stick Y (Axial):" + gamepad1.left_stick_y);
            telemetry.addLine("Gamepad Left Stick X (Laterial):" + gamepad1.left_stick_x);
            telemetry.addLine("Gamepad Right Stick X (Yaw):" + gamepad1.right_stick_x);
            telemetry.addLine("Armpower" + ServoController.power);
            telemetry.addLine("ArmBackPower" + ServoController.backpower);
            telemetry.update();
        }
    }}