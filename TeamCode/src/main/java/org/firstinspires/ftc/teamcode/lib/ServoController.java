package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoController {

    private static CRServo intakeservo1;
    private static CRServo intakeservo2;
    public static Servo armservo;
    public static boolean apressed;



    public static void initservos(CRServo servo1, CRServo servo2, Servo servo3) {
        intakeservo1 = servo1;
        intakeservo2 = servo2;
        armservo = servo3;
        intakeservo1.setDirection(CRServo.Direction.FORWARD);
        intakeservo2.setDirection(CRServo.Direction.FORWARD);
        armservo.setDirection(Servo.Direction.REVERSE);
    }

    public static void runintakeServo(boolean leftBumper, boolean rightBumper){
        double power = 0;

        if(leftBumper){
            power +=1;
        }
        if (rightBumper){
            power-=1;
        }
        intakeservo1.setPower(power);
        intakeservo2.setPower(power);
    }

    public static void runarmservo(boolean a) {
        double power = 0;
        apressed = false;
        int debounce = 0;


        //if a and not pressed, pressed = true and power ++
        //if not a and pressed, pressed = false
        if (a && !apressed){
            apressed = true;
            power += 0.3;
        }
        if(a && apressed == true){
            apressed = false;
            power =0;
        }
//        if(a){
//         apressed = true;
//         debounce +=1;
//        }
//        if (apressed && debounce >= 1){
//            debounce = 0;
//        }
//
//        if (apressed && debounce == 1){
//            power += 0.3;
//        }else if (debounce == 0) {
//            power =0;
//        }

        armservo.setPosition(power);


    }




}
