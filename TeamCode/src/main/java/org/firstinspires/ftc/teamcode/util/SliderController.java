package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.hardware.DcMotor;

public class SliderController {

    private static DcMotor slidermotor;

    public static void initslidemotor(DcMotor slidermotor0, ) {
        SliderController.slidermotor = slidermotor0;

        SliderController.slidermotor.setDirection(DcMotor.Direction.FORWARD);
    }
    


}
