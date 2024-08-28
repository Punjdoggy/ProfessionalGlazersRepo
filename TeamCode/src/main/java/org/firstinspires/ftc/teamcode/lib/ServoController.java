package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import kotlin._Assertions;


public class ServoController {

    private static CRServo armservo;
    private static Servo intakeservo1;


    public static double lastpowerrange =-0.228;
    public static boolean backpower = false;
    public static boolean power = false;
    public static boolean intakeservorun = false;




    public static void initservos(CRServo servo1, Servo intakeservo) {
        armservo = servo1;
        intakeservo1 = intakeservo;
        armservo.setDirection(CRServo.Direction.REVERSE);
        intakeservo1.setDirection(Servo.Direction.FORWARD);
    }

    public static void runintakeServo(boolean leftBumper, boolean rightBumper){
        if(leftBumper){
            intakeservorun = true;
        } else if (rightBumper) {
            intakeservorun = false;
        }
        if(!intakeservorun){
            intakeservo1.setPosition(-1);
        }
        if(intakeservorun){
            intakeservo1.setPosition(1);
        }

    }


    public static void runarmservo(boolean a, boolean b, boolean dpadleft, boolean dpadright) {

        if (a){
            lastpowerrange += 0.001;
            if(lastpowerrange > 0.9){
                lastpowerrange = 0.9;
            }
        }

        if(b){
            lastpowerrange -=0.001;
            if(lastpowerrange < -0.228){
                lastpowerrange = -0.228;
            }
        }

        if (a && dpadright){
            lastpowerrange = 0.883; 
        }

        if(b && dpadleft){
            lastpowerrange = -0.228;
        }

        armservo.setPower(lastpowerrange);


    }




}
