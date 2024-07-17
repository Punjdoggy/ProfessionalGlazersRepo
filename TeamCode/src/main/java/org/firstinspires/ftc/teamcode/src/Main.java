package org.firstinspires.ftc.teamcode.src;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.lib.MotorController;
import org.firstinspires.ftc.teamcode.lib.SliderController;

/*
 * This file contains an example of a Linear "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When a selection is made from the menu, the corresponding OpMode is executed.
 *
 * This particular OpMode illustrates driving a 4-motor Omni-Directional (or Holonomic) robot.
 * This code will work with either a Mecanum-Drive or an X-Drive train.
 * Both of these drives are illustrated at https://gm0.org/en/latest/docs/robot-design/drivetrains/holonomic.html
 * Note that a Mecanum drive must display an X roller-pattern when viewed from above.
 *
 * Also note that it is critical to set the correct rotation direction for each motor.  See details below.
 *
 * Holonomic drives provide the ability for the robot to move in three axes (directions) simultaneously.
 * Each motion axis is controlled by one Joystick axis.
 *
 * 1) Axial:    Driving forward and backward               Left-joystick Forward/Backward
 * 2) Lateral:  Strafing right and left                     Left-joystick Right and Left
 * 3) Yaw:      Rotating Clockwise and counter clockwise    Right-joystick Right and Left
 *
 * This code is written assuming that the right-side motors need to be reversed for the robot to drive forward.
 * When you first test your robot, if it moves backward when you push the left stick forward, then you must flip
 * the direction of all 4 motors (see code below).
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

@TeleOp(name="Mechanum Drive", group="Linear OpMode")
//@Disabled

public class Main extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors and runtime if needed.
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
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


        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        runtime.reset();

        SliderController.resetEncoder();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            MotorController.drivemotors(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

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