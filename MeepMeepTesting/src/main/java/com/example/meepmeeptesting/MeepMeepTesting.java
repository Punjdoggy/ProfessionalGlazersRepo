package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedLight;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MeepMeepTesting {

    private static RoadRunnerBotEntity RedBot1;
    private static RoadRunnerBotEntity RedBot2;
    private static RoadRunnerBotEntity BlueBot1;
    private static RoadRunnerBotEntity BlueBot2;
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(900);

    switch (Util. PREDEFINED_STATE) {

        case LEFT:
            System.out.println("LEFT");
             RedBot1 = new DefaultBotBuilder(meepMeep) //LEFT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeRedDark())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(-40.81, -62.78, Math.toRadians(90.00)))
                                            .splineToLinearHeading(new Pose2d(19, -42.5,Math.toRadians(-90)), Math.toRadians(-180))
                                            .forward(10)
                                            .waitSeconds(5)
                                            .splineToSplineHeading(new Pose2d(0, -42.6, Math.toRadians(-180)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                            .forward(20)
                                            .splineToSplineHeading(new Pose2d(-41.0,42.9, Math.toRadians(180)), Math.toRadians(90))
                                            .forward(17)
                                            .build()

//                        original code
//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(-90))
//                                .forward(60)
//                                .turn(Math.toRadians(-90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(90))
//                                .forward(25)
//                                .turn(Math.toRadians(-90))
//                                .forward(80)
//                                .turn(Math.toRadians(90))
//                                .forward(15)
//                                .build()

                    );

             RedBot2 = new DefaultBotBuilder(meepMeep) //RIGHT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeRedLight())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(-40.81, -62.78, Math.toRadians(90.00)))

                                            .splineToLinearHeading(new Pose2d(19, -42.5,Math.toRadians(-90)), Math.toRadians(-180))
                                            .forward(10)
                                            .waitSeconds(5)
                                            .splineToSplineHeading(new Pose2d(0, -42.6, Math.toRadians(0)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                            .forward(20)
                                            .splineToSplineHeading(new Pose2d(41.0,42.9, Math.toRadians(0)), Math.toRadians(90))
                                            .forward(17)
                                            .build()

//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(-90))
//                                .forward(60)
//                                .turn(Math.toRadians(-90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(-90))
//                                .forward(25)
//                                .turn(Math.toRadians(90))
//                                .forward(80)
//                                .turn(Math.toRadians(-90))
//                                .forward(15)


                    );

             BlueBot1 = new DefaultBotBuilder(meepMeep) //LEFT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeBlueDark())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(-40.81, 62.78, Math.toRadians(-90)))
                                            .splineToLinearHeading(new Pose2d(19, 42.5,Math.toRadians(90)), Math.toRadians(-180))
                                            .forward(10)
                                            .waitSeconds(5)
                                            .splineToSplineHeading(new Pose2d(0, 42.6, Math.toRadians(0)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                            .forward(20)
                                            .splineToSplineHeading(new Pose2d(41.0,-42.9, Math.toRadians(0)), Math.toRadians(90))
                                            .forward(17)
                                            .build()

//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(90))
//                                .forward(60)
//                                .turn(Math.toRadians(90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(90))
//                                .forward(25)
//                                .turn(Math.toRadians(-90))
//                                .forward(80)
//                                .turn(Math.toRadians(90))
//                                .forward(15)
//
//                                .build()
                    );


             BlueBot2 = new DefaultBotBuilder(meepMeep) //RIGHT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeBlueDark())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(-40.81, 62.78, Math.toRadians(-90)))
                                            .splineToLinearHeading(new Pose2d(19, 42.5,Math.toRadians(90)), Math.toRadians(-180))
                                            .forward(10)
                                            .waitSeconds(5)
                                            .splineToSplineHeading(new Pose2d(0, 42.6, Math.toRadians(-180)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                            .forward(20)
                                            .splineToSplineHeading(new Pose2d(-41.0,-42.9, Math.toRadians(-180)), Math.toRadians(90))
                                            .forward(17)
                                            .build()

//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(90))
//                                .forward(60)
//                                .turn(Math.toRadians(90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(-90))
//                                .forward(60)
//                                .turn(Math.toRadians(90))
//                                .forward(80)
//                                .turn(Math.toRadians(-90))
//                                .forward(15)

//                                .build()
                    );
             break;
        case MIDDLE:
            System.out.println("MIDDLE");
            RedBot1 = new DefaultBotBuilder(meepMeep) //LEFT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeRedDark())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(-40.81, -62.78, Math.toRadians(90.00)))
                                            .splineToLinearHeading(new Pose2d(0, -42.5,Math.toRadians(-90)), Math.toRadians(-180))
                                            .forward(10)
                                            .waitSeconds(5)
                                            .splineToSplineHeading(new Pose2d(0, -42.6, Math.toRadians(-180)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                            .forward(20)
                                            .splineToSplineHeading(new Pose2d(-41.0,42.9, Math.toRadians(180)), Math.toRadians(90))
                                            .forward(17)
                                            .build()

//                        original code
//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(-90))
//                                .forward(60)
//                                .turn(Math.toRadians(-90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(90))
//                                .forward(25)
//                                .turn(Math.toRadians(-90))
//                                .forward(80)
//                                .turn(Math.toRadians(90))
//                                .forward(15)
//                                .build()

                    );

            RedBot2 = new DefaultBotBuilder(meepMeep) // RIGHT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeRedLight())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(-40.81, -62.78, Math.toRadians(90.00)))

                                            .splineToLinearHeading(new Pose2d(0, -42.5,Math.toRadians(-90)), Math.toRadians(-180))
                                            .forward(10)
                                            .waitSeconds(5)
                                            .splineToSplineHeading(new Pose2d(0, -42.6, Math.toRadians(0)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                            .forward(20)
                                            .splineToSplineHeading(new Pose2d(41.0,42.9, Math.toRadians(0)), Math.toRadians(90))
                                            .forward(17)
                                            .build()

//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(-90))
//                                .forward(60)
//                                .turn(Math.toRadians(-90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(-90))
//                                .forward(25)
//                                .turn(Math.toRadians(90))
//                                .forward(80)
//                                .turn(Math.toRadians(-90))
//                                .forward(15)


                    );

            BlueBot1 = new DefaultBotBuilder(meepMeep) //LEFT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeBlueDark())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(-40.81, 62.78, Math.toRadians(-90)))
                                            .splineToLinearHeading(new Pose2d(0, 42.5,Math.toRadians(90)), Math.toRadians(-180))
                                            .forward(10)
                                            .waitSeconds(5)
                                            .splineToSplineHeading(new Pose2d(0, 42.6, Math.toRadians(0)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                            .forward(20)
                                            .splineToSplineHeading(new Pose2d(41.0,-42.9, Math.toRadians(0)), Math.toRadians(90))
                                            .forward(17)
                                            .build()

//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(90))
//                                .forward(60)
//                                .turn(Math.toRadians(90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(90))
//                                .forward(25)
//                                .turn(Math.toRadians(-90))
//                                .forward(80)
//                                .turn(Math.toRadians(90))
//                                .forward(15)
//
//                                .build()
                    );


            BlueBot2 = new DefaultBotBuilder(meepMeep) //RIGHT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeBlueDark())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(-40.81, 62.78, Math.toRadians(-90)))
                                            .splineToLinearHeading(new Pose2d(0, 42.5,Math.toRadians(90)), Math.toRadians(-180))
                                            .forward(10)
                                            .waitSeconds(5)
                                            .splineToSplineHeading(new Pose2d(0, 42.6, Math.toRadians(-180)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                            .forward(20)
                                            .splineToSplineHeading(new Pose2d(-41.0,-42.9, Math.toRadians(-180)), Math.toRadians(90))
                                            .forward(17)
                                            .build()

                    );

//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(90))
//                                .forward(60)
//                                .turn(Math.toRadians(90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(-90))
//                                .forward(60)
//                                .turn(Math.toRadians(90))
//                                .forward(80)
//                                .turn(Math.toRadians(-90))
//                                .forward(15)

//                                .build()
            break;
        case RIGHT:
            System.out.println("RIGHT");
            RedBot1 = new DefaultBotBuilder(meepMeep) //LEFT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeRedDark())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(-40.81, -62.78, Math.toRadians(90.00)))
                                            .splineToLinearHeading(new Pose2d(-19, -42.5,Math.toRadians(-90)), Math.toRadians(-180))
                                            .forward(10)
                                            .waitSeconds(5)
                                            .splineToSplineHeading(new Pose2d(0, -42.6, Math.toRadians(-180)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                            .forward(20)
                                            .splineToSplineHeading(new Pose2d(-41.0,42.9, Math.toRadians(180)), Math.toRadians(90))
                                            .forward(17)
                                            .build()

//                        original code
//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(-90))
//                                .forward(60)
//                                .turn(Math.toRadians(-90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(90))
//                                .forward(25)
//                                .turn(Math.toRadians(-90))
//                                .forward(80)
//                                .turn(Math.toRadians(90))
//                                .forward(15)
//                                .build()

                    );

            RedBot2 = new DefaultBotBuilder(meepMeep) //RIGHT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeRedLight())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(-40.81, -62.78, Math.toRadians(90.00)))

                                            .splineToLinearHeading(new Pose2d(-19, -42.5,Math.toRadians(-90)), Math.toRadians(-180))
                                            .forward(10)
                                            .waitSeconds(5)
                                            .splineToSplineHeading(new Pose2d(0, -42.6, Math.toRadians(0)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                            .forward(20)
                                            .splineToSplineHeading(new Pose2d(41.0,42.9, Math.toRadians(0)), Math.toRadians(90))
                                            .forward(17)
                                            .build()

//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(-90))
//                                .forward(60)
//                                .turn(Math.toRadians(-90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(-90))
//                                .forward(25)
//                                .turn(Math.toRadians(90))
//                                .forward(80)
//                                .turn(Math.toRadians(-90))
//                                .forward(15)


                    );

            BlueBot1 = new DefaultBotBuilder(meepMeep) //LEFT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeBlueDark())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(-40.81, 62.78, Math.toRadians(-90)))
                                            .splineToLinearHeading(new Pose2d(-19, 42.5,Math.toRadians(90)), Math.toRadians(-180))
                                            .forward(10)
                                            .waitSeconds(5)
                                            .splineToSplineHeading(new Pose2d(0, 42.6, Math.toRadians(0)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                            .forward(20)
                                            .splineToSplineHeading(new Pose2d(41.0,-42.9, Math.toRadians(0)), Math.toRadians(90))
                                            .forward(17)
                                            .build()

//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(90))
//                                .forward(60)
//                                .turn(Math.toRadians(90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(90))
//                                .forward(25)
//                                .turn(Math.toRadians(-90))
//                                .forward(80)
//                                .turn(Math.toRadians(90))
//                                .forward(15)
//
//                                .build()
                    );


            BlueBot2 = new DefaultBotBuilder(meepMeep) //RIGHT PARK
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeBlueDark())
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                            drive.trajectorySequenceBuilder(new Pose2d(-40.81, 62.78, Math.toRadians(-90)))
                                    .splineToLinearHeading(new Pose2d(-19, 42.5,Math.toRadians(90)), Math.toRadians(-180))
                                    .forward(10)
                                    .waitSeconds(5)
                                    .splineToSplineHeading(new Pose2d(0, 42.6, Math.toRadians(-180)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                    .forward(20)
                                    .splineToSplineHeading(new Pose2d(-41.0,-42.9, Math.toRadians(-180)), Math.toRadians(90))
                                    .forward(17)
                                    .build()

                    );

//                                .turn(Math.toRadians(0))
//                                .forward(20)
//                                .turn(Math.toRadians(90))
//                                .forward(60)
//                                .turn(Math.toRadians(90))
//                                .forward(10)
//                                .waitSeconds(5)
//                                .turn(Math.toRadians(-180))
//                                .forward(10)
//                                .turn(Math.toRadians(-90))
//                                .forward(60)
//                                .turn(Math.toRadians(90))
//                                .forward(80)
//                                .turn(Math.toRadians(-90))
//                                .forward(15)

//                                .build()
    }





        Image img = null;
        try { img = ImageIO.read(new File("MeepMeepTesting/src/resources/PostalPanic_Stage.png")); }
        catch (IOException e) {}

        //These are all for April Tag Detection, and these instances all go to the 3rd box, still need to do 2nd and 1st box mapping


        meepMeep.setBackground(img)
                .setBackgroundAlpha(0.95f)
                .addEntity(RedBot1)
                .addEntity(RedBot2)
                .addEntity(BlueBot1)
                .addEntity(BlueBot2)
                .start();
    }
}


