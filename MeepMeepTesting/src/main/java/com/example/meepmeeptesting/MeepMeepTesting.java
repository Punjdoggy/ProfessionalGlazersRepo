package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-40.81, -62.78, Math.toRadians(90.00)))
                                .turn(Math.toRadians(0))
                                .forward(20)
                                .turn(Math.toRadians(-90))
                                .forward(60)
                                .turn(Math.toRadians(-90))
                                .forward(10)
                                .waitSeconds(5)
                                .turn(Math.toRadians(-180))
                                .forward(10)
                                .turn(Math.toRadians(90))
                                .forward(60)
                                .turn(Math.toRadians(-90))
                                .forward(80)
                                .turn(Math.toRadians(90))
                                .forward(15)

                                .build()
                );

        Image img = null;
        try { img = ImageIO.read(new File("C:\\Users\\shubh133365\\OneDrive - Brisbane Grammar School\\Robotics\\Code\\Off-Season\\PostalPanic_Stage.png")); }
        catch (IOException e) {}


        meepMeep.setBackground(img)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}


