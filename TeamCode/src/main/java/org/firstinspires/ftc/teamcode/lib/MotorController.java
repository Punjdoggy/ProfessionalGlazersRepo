package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class MotorController {
    public static DcMotor LeftBackDrive;
    public static DcMotor RightBackDrive;
    public static DcMotor LeftFrontDrive;
    public static DcMotor RightFrontDrive;

    public static void Initmotor(DcMotor LeftBackDrive, DcMotor RightBackDrive, DcMotor LeftFrontDrive, DcMotor RightFrontDrive) {
        MotorController.LeftBackDrive = LeftBackDrive;
        MotorController.RightBackDrive = RightBackDrive;
        MotorController.LeftFrontDrive = LeftFrontDrive;
        MotorController.RightFrontDrive = RightFrontDrive;

        MotorController.LeftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        MotorController.RightBackDrive.setDirection(DcMotor.Direction.REVERSE);
        MotorController.LeftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        MotorController.RightFrontDrive.setDirection(DcMotor.Direction.FORWARD);

        MotorController.LeftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorController.LeftBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorController.RightBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorController.RightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public static void Initautomotor(DcMotor LeftBackDrive, DcMotor RightBackDrive, DcMotor LeftFrontDrive, DcMotor RightFrontDrive) {
        MotorController.LeftBackDrive = LeftBackDrive;
        MotorController.RightBackDrive = RightBackDrive;
        MotorController.LeftFrontDrive = LeftFrontDrive;
        MotorController.RightFrontDrive = RightFrontDrive;

        MotorController.LeftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        MotorController.RightBackDrive.setDirection(DcMotor.Direction.REVERSE);
        MotorController.LeftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        MotorController.RightFrontDrive.setDirection(DcMotor.Direction.FORWARD);

        MotorController.LeftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorController.LeftBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorController.RightBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorController.RightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public static void driveMotors(double y, double x, double rx) {
       double max;
        double LeftFrontPower  = y + x + rx;
        double RightFrontPower = y - x - rx;
        double LeftBackPower   = y - x + rx;
        double RightBackPower  = y + x - rx;

        max = Math.max(Math.abs(LeftFrontPower), Math.abs(RightFrontPower));
        max = Math.max(max, Math.abs(LeftBackPower));
        max = Math.max(max, Math.abs(RightBackPower));

        if (max > 1.0) {
            max += 0.3;
            LeftFrontPower  /= max;
            RightFrontPower /= max;
            LeftBackPower   /= max;
            RightBackPower  /= max;
        }

        LeftBackDrive.setPower(LeftBackPower);
        RightBackDrive.setPower(RightBackPower);
        LeftFrontDrive.setPower(LeftFrontPower);
        RightFrontDrive.setPower(RightFrontPower);
    }

    public static void driveForward(double speed)
    {
        LeftFrontDrive.setPower(speed);
        RightBackDrive.setPower(speed);
        LeftBackDrive.setPower(speed);
        RightFrontDrive.setPower(speed);
    }


    public static void driveBackward(double speed)
    {
        LeftFrontDrive.setPower(-speed);
        RightBackDrive.setPower(-speed);
        LeftBackDrive.setPower(-speed);
        RightFrontDrive.setPower(-speed);
    }

    public static void strafeRight(double speed) {

        LeftFrontDrive.setPower(-speed);
        RightBackDrive.setPower(-speed);
        LeftBackDrive.setPower(speed);
        RightFrontDrive.setPower(speed);

    }

    public static void strafeLeft(double speed) {

        LeftFrontDrive.setPower(speed);
        RightBackDrive.setPower(speed);
        LeftBackDrive.setPower(-speed);
        RightFrontDrive.setPower(-speed);

    }

    public static  void turnleft90deg(double speed){
        LeftFrontDrive.setPower(-speed);
        RightBackDrive.setPower(speed);
        LeftBackDrive.setPower(-speed);
        RightFrontDrive.setPower(speed);
    }

    public static  void turnright90deg(double speed){
        LeftFrontDrive.setPower(-speed);
        RightBackDrive.setPower(speed);
        LeftBackDrive.setPower(-speed);
        RightFrontDrive.setPower(speed);
    }

    public static void stopmotors(){
        LeftFrontDrive.setPower(0);
        RightBackDrive.setPower(0);
        LeftBackDrive.setPower(0);
        RightFrontDrive.setPower(0);
    }

}