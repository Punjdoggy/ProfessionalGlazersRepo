package org.firstinspires.ftc.teamcode.util;


import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class SliderController {
    private static PIDController pid = new PIDController(0.62,0.01,0.03);

    private static DcMotor slidemotor;

    public static void initialiseSLide(DcMotor motor) {
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setPower(0);
        motor.setDirection(DcMotor.Direction.REVERSE);

        pid.setSetPoint(0);
        slidemotor = motor;
    }

    public static void updateSlide() {
        double output = pid.calculate(
                slidemotor.getCurrentPosition()
        );

        slidemotor.setPower(output);

    }
    public static void setTarget(double target) {pid.setSetPoint(target);}

    public static void resetEncoder() {
        slidemotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slidemotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }




}
