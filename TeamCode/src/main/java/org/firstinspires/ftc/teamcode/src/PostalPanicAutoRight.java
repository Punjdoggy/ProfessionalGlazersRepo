package org.firstinspires.ftc.teamcode.src;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.lib.MotorController;

@Autonomous(name="PostalPanicAutoRight")
public class PostalPanicAutoRight extends LinearOpMode {

public ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {

       MotorController.Initautomotor(hardwareMap.get(DcMotor.class, "3"),
               hardwareMap.get(DcMotor.class, "0"),
               hardwareMap.get(DcMotor.class, "2"),
               hardwareMap.get(DcMotor.class, "1"));

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way

        // Step 1:  Drive forward for 3 seconds
         MotorController.driveForward(0.3);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 4.45)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 2:  Spin right for 1.3 seconds

        MotorController.strafeRight(0.3);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.2)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        MotorController.driveForward(0.3);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.8)) {
            telemetry.addData("Path", "Leg 2: %4.1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 3:  Stop
       MotorController.stopmotors();
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}