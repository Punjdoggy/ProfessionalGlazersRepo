package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.util.MotorController;
import org.firstinspires.ftc.teamcode.util.SliderController;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.ArrayList;

@Autonomous
public class ProfessionalGlazersAutonREDLEFTPARK extends LinearOpMode
{   
    //INTRODUCE VARIABLES HERE

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;



    OpenCvCamera camera;
    AprilTagDetectionPipeline aprilTagDetectionPipeline;

    static final double FEET_PER_METER = 3.28084;
   

    // Lens intrinsics
    // UNITS ARE PIXELS
    // You will need to do your own calibration for other configurations!
    double fx = 578.272;
    double fy = 578.272;
    double cx = 402.145;
    double cy = 221.506;

    // UNITS ARE METERS
    double tagsize = 0.166;

     // Tag ID 1,2,3 from the 36h11 family 
     /*EDIT IF NEEDED!!!*/

    int ONE = 1;
    int TWO = 2;
    int THREE = 3;
    int FOUR = 4;

    AprilTagDetection tagOfInterest = null;

    @Override
    public void runOpMode()
    {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        TrajectorySequence idOne = drive.trajectorySequenceBuilder(new Pose2d(-40.81, -62.78, Math.toRadians(90.00)))
                                        .splineToLinearHeading(new Pose2d(19, -42.5,Math.toRadians(-90)), Math.toRadians(-180))
                                        .forward(10)
//                                        .waitSeconds(5)
                .addDisplacementMarker(() -> {
                    SliderController.setTarget(212);
                })
                                        .splineToSplineHeading(new Pose2d(0, -42.6, Math.toRadians(-180)), Math.toRadians(0))
                                        .forward(20)
                                        .splineToSplineHeading(new Pose2d(-41.0,42.9, Math.toRadians(180)), Math.toRadians(90))
                                        .forward(17)
                                        .build();

        TrajectorySequence idTwo = drive.trajectorySequenceBuilder(new Pose2d(-40.81, -62.78, Math.toRadians(90.00)))
                                        .splineToLinearHeading(new Pose2d(0, -42.5,Math.toRadians(-90)), Math.toRadians(-180))
                                        .forward(10)
//                                        .waitSeconds(5)
                .addDisplacementMarker(() -> {
                    SliderController.setTarget(212);
                })
                                        .splineToSplineHeading(new Pose2d(0, -42.6, Math.toRadians(-180)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                        .forward(20)
                                        .splineToSplineHeading(new Pose2d(-41.0,42.9, Math.toRadians(180)), Math.toRadians(90))
                                        .forward(17)
                                        .build();

        TrajectorySequence idThree = drive.trajectorySequenceBuilder(new Pose2d(-40.81, -62.78, Math.toRadians(90.00)))
                                .splineToLinearHeading(new Pose2d(-19, -42.5,Math.toRadians(-90)), Math.toRadians(-180))
                                .forward(10)
//                                .waitSeconds(5)
                .addDisplacementMarker(() -> {
                    SliderController.setTarget(212);
                })
                                .splineToSplineHeading(new Pose2d(0, -42.6, Math.toRadians(-180)), Math.toRadians(0)) //ask lachie why it does a turn then does a rotation to forward
                                .forward(20)
                                .splineToSplineHeading(new Pose2d(-41.0,42.9, Math.toRadians(180)), Math.toRadians(90))
                                .forward(17)
                                .build();

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        aprilTagDetectionPipeline = new AprilTagDetectionPipeline(tagsize, fx, fy, cx, cy);

        camera.setPipeline(aprilTagDetectionPipeline);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                camera.startStreaming(800,448, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode)
            {

            }
        });

        telemetry.setMsTransmissionInterval(50);


        //HARDWARE MAPPING HERE etc.

        MotorController.Initmotor(
                hardwareMap.get(DcMotor.class, "3"),
                hardwareMap.get(DcMotor.class, "0"),
                hardwareMap.get(DcMotor.class, "2"),
                hardwareMap.get(DcMotor.class, "1")
        );

        SliderController.initialiseSLide(
                hardwareMap.get(DcMotor.class, "slider")
        );

        /*
         * The INIT-loop:
         * This REPLACES waitForStart!
         */
        while (!isStarted() && !isStopRequested())
        {
            ArrayList<AprilTagDetection> currentDetections = aprilTagDetectionPipeline.getLatestDetections();

            if(currentDetections.size() != 0)
            {
                boolean tagFound = false;

                for(AprilTagDetection tag : currentDetections)
                {
                    if(tag.id == ONE || tag.id == TWO || tag.id == THREE || tag.id == FOUR)
                    {
                        tagOfInterest = tag;
                        tagFound = true;
                        break;
                    }
                }

                if(tagFound)
                {
                    telemetry.addLine("Tag of interest is in sight!\n\nLocation data:");
                    tagToTelemetry(tagOfInterest);
                }
                else
                {
                    telemetry.addLine("Don't see tag of interest :(");

                    if(tagOfInterest == null)
                    {
                        telemetry.addLine("(The tag has never been seen)");
                    }
                    else
                    {
                        telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                        tagToTelemetry(tagOfInterest);
                    }
                }

            }
            else
            {
                telemetry.addLine("Don't see tag of interest :(");

                if(tagOfInterest == null)
                {
                    telemetry.addLine("(The tag has never been seen >;( )");
                }
                else
                {
                    telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                    tagToTelemetry(tagOfInterest);
                }

            }

            telemetry.update();
            sleep(20);
        }



        if(tagOfInterest != null)
        {
            telemetry.addLine("Tag snapshot:\n");
            tagToTelemetry(tagOfInterest);
            telemetry.update();
        }
        else
        {
            telemetry.addLine("No tag snapshot available, it was never sighted during the init loop :(");
            telemetry.update();
        }

//        telemetry.addLine(runtime);

        //PUT AUTON CODE HERE (DRIVER PRESSED THE PLAY BUTTON!)

        waitForStart();

        if(tagOfInterest == null){
            //This is where we put code for what the robot does when it does not see anything

        }else{
            switch(tagOfInterest.id){
                case 1:
                    drive.followTrajectorySequence(idOne);
                    break;
                case 2:
                    //see tag 2, this is what the robot does
                   drive.followTrajectorySequence(idTwo);

                    break;
                case 3:
                    drive.followTrajectorySequence(idThree);
                    // see tag 3, this is what the robot does

                    break;
		        case 4:
                    // see tag 4, this is what the robot does
                    
                    break;
            }
        }
        
        
        
    }

    void tagToTelemetry(AprilTagDetection detection)
    {
        telemetry.addLine(String.format("\nDetected tag ID=%d", detection.id));
        telemetry.addLine(String.format("Translation X: %.2f feet", detection.pose.x*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Y: %.2f feet", detection.pose.y*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Z: %.2f feet", detection.pose.z*FEET_PER_METER));
        telemetry.addData("Status", "Run Time: " + runtime.toString());
//        telemetry.addLine(String.format("Rotation Yaw: %.2f degrees", Math.toDegrees(detection.pose.yaw)));
//        telemetry.addLine(String.format("Rotation Pitch: %.2f degrees", Math.toDegrees(detection.pose.pitch)));
//        telemetry.addLine(String.format("Rotation Roll: %.2f degrees", Math.toDegrees(detection.pose.roll)));
    }






}