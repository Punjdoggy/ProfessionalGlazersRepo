package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.CRServo;

public class ServoController {

    private static CRServo armservo1;
    private static CRServo armservo2;

    public static void initservo(CRServo servo1, CRServo servo2) {
        armservo1 = servo1;
        armservo2 = servo2;
    }

    public static void runServo(boolean leftBumper, boolean rightBumper){
        if (leftBumper) {
            armservo1.setPower(1);
            armservo2.setPower(-1);
        }else if (rightBumper){
            armservo1.setPower(-1);
            armservo2.setPower(1);
        } else {
            armservo1.setPower(0);
            armservo2.setPower(0);
        }
    }


}
