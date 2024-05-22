package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CenterstageMeepMeeptesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        // Declare our first bot
        RoadRunnerBotEntity BlueBot1 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be blue
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                //This is if it reads the tag on the left side
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-61, -36, 0))
                                .splineToSplineHeading(new Pose2d(-31,-46, Math.toRadians(90)), Math.toRadians(0))
                                .forward(14)
                                .waitSeconds(2.5)
                                .back(5)
                                .strafeLeft(28)
                                .forward(82.5)




//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .build()
                                .build()
                );

        // Declare out second bot
        RoadRunnerBotEntity RedBot1 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be red
                .setColorScheme(new ColorSchemeRedDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(61, -36, Math.toRadians(180)))
                                .splineToSplineHeading(new Pose2d(31,-28, Math.toRadians(-90)), Math.toRadians(0))
                                .forward(10)
                                .waitSeconds(2.5)
                                .back(5)
                                .turn(Math.toRadians(180))
                                .strafeRight(28)
                                .forward(82.5)
                                .build()


//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .build()
                );

        //this is for middle detection
        RoadRunnerBotEntity RedBot2 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be red
                .setColorScheme(new ColorSchemeRedDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(61, -36, Math.toRadians(180)))
                                .forward(28)
                                .waitSeconds(2.5)
                                .back(5)
                                .turn(Math.toRadians(-90))
                                .strafeRight(20)
                                .forward(82.5)
                                .build()
//59,-33
//
////                                .forward(30)
////                                .turn(Math.toRadians(90))
////                                .forward(30)
////                                .turn(Math.toRadians(90))
////                                .forward(30)
////                                .turn(Math.toRadians(90))
////                                .forward(30)
////                                .turn(Math.toRadians(90))
////                                .build()
                );

        RoadRunnerBotEntity BlueBot2 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be red
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(-61, -36, Math.toRadians(0)))
                                        .forward(28)
                                        .waitSeconds(2.5)
                                        .back(5)
                                        .turn(Math.toRadians(90))
                                        .strafeLeft(20)
                                        .forward(82.5)
                                        .build()
                );

        //This is for Right Detection
        RoadRunnerBotEntity RedBot3 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be red
                .setColorScheme(new ColorSchemeRedDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(61, -36, Math.toRadians(180)))
                                        .splineToSplineHeading(new Pose2d(31,-46, Math.toRadians(90)), Math.toRadians(280))
                                        .forward(14)
                                        .waitSeconds(2.5)
                                        .back(5)
                                        .strafeRight(28)
                                        .forward(82.5)
                                        .build()

                );

        RoadRunnerBotEntity BlueBot3 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be red
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(-61, -36, Math.toRadians(0)))
                                        .splineToSplineHeading(new Pose2d(-31,-28, Math.toRadians(-90)), Math.toRadians(0))
                                        .forward(10)
                                        .waitSeconds(2.5)
                                        .back(5)
                                        .turn(Math.toRadians(180))
                                        .strafeLeft(28)
                                        .forward(82.5)
                                        .build()
                );

        //this is for the right Side of the Field

        // Declare our first bot
        RoadRunnerBotEntity BlueBot4 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be blue
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                //This is if it reads the tag on the left side
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(-61, 16, 0))
                                        .splineToSplineHeading(new Pose2d(-31,-6, Math.toRadians(90)), Math.toRadians(0))
                                        .forward(14)
                                        .waitSeconds(2.5)
                                        .back(5)
                                        .strafeLeft(28)
                                        .forward(82.5)




//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .build()
                                        .build()
                );

        // Declare out second bot
        RoadRunnerBotEntity RedBot4 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be red
                .setColorScheme(new ColorSchemeRedDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(61, 16, Math.toRadians(180)))
                                        .splineToSplineHeading(new Pose2d(31,12, Math.toRadians(-90)), Math.toRadians(0))
                                        .forward(10)
                                        .waitSeconds(2.5)
                                        .back(5)
                                        .turn(Math.toRadians(180))
                                        .strafeRight(28)
                                        .forward(82.5)
                                        .build()


//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .forward(30)
//                                .turn(Math.toRadians(90))
//                                .build()
                );

        //this is for middle detection
        RoadRunnerBotEntity RedBot5 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be red
                .setColorScheme(new ColorSchemeRedDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(61, 16, Math.toRadians(180)))
                                        .forward(28)
                                        .waitSeconds(2.5)
                                        .back(5)
                                        .turn(Math.toRadians(-90))
                                        .strafeRight(20)
                                        .forward(82.5)
                                        .build()
//59,-33
//
////                                .forward(30)
////                                .turn(Math.toRadians(90))
////                                .forward(30)
////                                .turn(Math.toRadians(90))
////                                .forward(30)
////                                .turn(Math.toRadians(90))
////                                .forward(30)
////                                .turn(Math.toRadians(90))
////                                .build()
                );

        RoadRunnerBotEntity BlueBot5 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be red
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-61, 16, Math.toRadians(0)))
                                .forward(28)
                                .waitSeconds(2.5)
                                .back(5)
                                .turn(Math.toRadians(90))
                                .strafeLeft(20)
                                .forward(82.5)
                                .build()
                );

        //This is for Right Detection
        RoadRunnerBotEntity RedBot6 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be red
                .setColorScheme(new ColorSchemeRedDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(61, 16, Math.toRadians(180)))
                                .splineToSplineHeading(new Pose2d(31,-6, Math.toRadians(90)), Math.toRadians(280))
                                .forward(14)
                                .waitSeconds(2.5)
                                .back(5)
                                .strafeRight(28)
                                .forward(82.5)
                                .build()

                );

        RoadRunnerBotEntity BlueBot6 = new DefaultBotBuilder(meepMeep)
                // We set this bot to be red
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(-61, 16, Math.toRadians(0)))
                                        .splineToSplineHeading(new Pose2d(-31,12, Math.toRadians(-90)), Math.toRadians(0))
                                        .forward(10)
                                        .waitSeconds(2.5)
                                        .back(5)
                                        .turn(Math.toRadians(180))
                                        .strafeLeft(28)
                                        .forward(82.5)
                                        .build()
                );
        


        Image img = null;
        try { img = ImageIO.read(new File("MeepMeepTesting/src/resources/Juice-CENTERSTAGE-Dark.png")); }
        catch (IOException e) {}

        meepMeep.setBackground(img)
                
                .addEntity(RedBot1)
                .addEntity(BlueBot1)
                .addEntity(RedBot2)
                .addEntity(BlueBot2)
                .addEntity(RedBot3)
                .addEntity(BlueBot3)
                .addEntity(RedBot4)
                .addEntity(BlueBot4)
                .addEntity(RedBot5)
                .addEntity(BlueBot5)
                .addEntity(RedBot6)
                .addEntity(BlueBot6)
                .start();
    }
}