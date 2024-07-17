package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.Servo;

public class ServoController {

    private static Servo armservo;

    public static void initservo(Servo servo) {
        armservo = servo;
        ServoController.armservo.setDirection(Servo.Direction.FORWARD);
    }

    public static void openservo(boolean gamepad_left_bumper){
        if (gamepad_left_bumper) {
            ServoController.armservo.;
        }else{

        }
    }




}
