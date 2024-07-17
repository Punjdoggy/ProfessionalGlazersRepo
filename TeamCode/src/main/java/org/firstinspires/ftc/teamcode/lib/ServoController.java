package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.CRServo;

public class ServoController {

    private static CRServo armservo;

    public static void initservo(CRServo servo) {
        armservo = servo;
    }

    public static void runServo(boolean leftBumper, boolean rightBumper){
        if (leftBumper) {
            armservo.setPower(1);
        }else if (rightBumper){
            armservo.setPower(-1);
        } else {
            armservo.setPower(0);
        }
    }


}
