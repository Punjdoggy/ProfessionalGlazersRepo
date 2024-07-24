package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class MotorController {
    private static DcMotor LeftBackDrive;
    private static DcMotor RightBackDrive;
    private static DcMotor LeftFrontDrive;
    private static DcMotor RightFrontDrive;

    public static void Initmotor(DcMotor LeftBackDrive, DcMotor RightBackDrive, DcMotor LeftFrontDrive, DcMotor RightFrontDrive) {
        MotorController.LeftBackDrive = LeftBackDrive;
        MotorController.RightBackDrive = RightBackDrive;
        MotorController.LeftFrontDrive = LeftFrontDrive;
        MotorController.RightFrontDrive = RightFrontDrive;

        MotorController.LeftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        MotorController.RightBackDrive.setDirection(DcMotor.Direction.FORWARD);
        MotorController.LeftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        MotorController.RightFrontDrive.setDirection(DcMotor.Direction.REVERSE);

        MotorController.LeftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorController.LeftBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorController.RightBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorController.RightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public static void drivemotors(double axial, double lateral, double yaw) {
       double max;
        double LeftFrontPower  = axial + lateral + yaw;
        double RightFrontPower = axial - lateral - yaw;
        double LeftBackPower   = axial - lateral + yaw;
        double RightBackPower  = axial + lateral - yaw;

        max = Math.max(Math.abs(LeftFrontPower), Math.abs(RightFrontPower));
        max = Math.max(max, Math.abs(LeftBackPower));
        max = Math.max(max, Math.abs(RightBackPower));

        if (max > 1.0) {
            max -= 0.1;
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

}