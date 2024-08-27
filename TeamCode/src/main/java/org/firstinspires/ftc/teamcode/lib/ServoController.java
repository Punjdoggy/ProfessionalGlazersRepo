package org.firstinspires.ftc.teamcode.lib;

import androidx.core.view.PointerIconCompat;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import com.arcrobotics.ftclib.controller.PIDController;


public class ServoController {

    private static CRServo intakeservo1;
    private static CRServo intakeservo2;
    public static Servo armservo;
    private static CRServo testservo;

    public static double lastpowerrange =0;
    public static boolean backpower = false;



    public static void initservos(CRServo servo1, CRServo servo2, Servo servo3, CRServo testerservo) {
        intakeservo1 = servo1;
        intakeservo2 = servo2;
        armservo = servo3;
        testservo = testerservo;
        intakeservo1.setDirection(CRServo.Direction.FORWARD);
        intakeservo2.setDirection(CRServo.Direction.FORWARD);
        armservo.setDirection(Servo.Direction.REVERSE);
        testservo.setDirection(CRServo.Direction.FORWARD);
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


    public static void runarmservo(boolean a, boolean b, boolean dpadleft, boolean dpadright) {
        boolean power = false;


        if (a){
            power = true;
            lastpowerrange += 0.001;
            if(lastpowerrange > 0.9){
                lastpowerrange = 0.9;
            }
        }

        if (lastpowerrange >= 0.9 && b){
            power = false;
            backpower= true;
            lastpowerrange -= 0.001;
        }

        if (power && dpadright){
            lastpowerrange = 0.883; 
        }

        if(backpower && dpadleft){
            lastpowerrange = 0.01;
        }



        armservo.setPosition(lastpowerrange);


    }




}
