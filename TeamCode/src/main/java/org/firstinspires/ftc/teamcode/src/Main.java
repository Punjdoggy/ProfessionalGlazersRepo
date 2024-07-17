package org.firstinspires.ftc.teamcode.src;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.lib.MotorController;
import org.firstinspires.ftc.teamcode.lib.SliderController;
import org.firstinspires.ftc.teamcode.lib.ServoController;


@TeleOp(name="Mechanum Drive", group="Linear OpMode")
//@Disabled

public class Main extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        // Left Back Drive = 3, Right Back Drive = 0, Left Front Drive = 2, Right Front Drive = 1
        MotorController.Initmotor(
                hardwareMap.get(DcMotor.class, "3"),
                hardwareMap.get(DcMotor.class, "0"),
                hardwareMap.get(DcMotor.class, "2"),
                hardwareMap.get(DcMotor.class, "1")
        );

        SliderController.initialiseSLide(
                hardwareMap.get(DcMotor.class, "slider")
        );

        ServoController.initservo(
                hardwareMap.get(CRServo.class,"servo"));


        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        runtime.reset();

        SliderController.resetEncoder();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            MotorController.drivemotors(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            ServoController.runServo(gamepad1.left_bumper, gamepad1.right_bumper);

            if (gamepad1.a) {
                SliderController.setTarget(SliderController.slidermaxheight); //arbitrary highest
            } else {
                SliderController.setTarget(SliderController.sliderminheight); //arbitrary lowest
            }
            SliderController.updateSlide();

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }}