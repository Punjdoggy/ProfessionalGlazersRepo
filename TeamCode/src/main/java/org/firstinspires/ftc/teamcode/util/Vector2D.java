package org.firstinspires.ftc.teamcode.util;

public class Vector2D {

    private double i;
    private double j;



    public Vector2D(double na, double nb, boolean isCart) {
        i = na;
        j = nb;
        if (isCart == false) {
             i = na * Math.cos(Math.toRadians(nb));
             j = na * Math.sin(Math.toRadians(nb));
        }
    }

    //getter for I, J

    public double getM() {
        double m = Math.sqrt(Math.pow(j,2) + Math.pow(i,2));
        return m; // <-- calculate M
    }

    public double getD(){
        double d = Math.toDegrees(Math.atan2(j, i));
        return d;
    }
    //^ same as above for D

    public Vector2D rot(double rot) {
        return new Vector2D(getM(), (getD() + rot)%360, true);
    }

    public Vector2D mul(Vector2D vector1){
        return new Vector2D(i * vector1.i, j * vector1.j, true);
    }

    public Vector2D vecrot(Vector2D vector1){
        return new Vector2D(getM(),(vector1.getD() + getD())%360, false);
    }

    Vector2D vector1 = new Vector2D(1,2,true);
    Vector2D vector2 = new Vector2D(2,2,false);
}

//must accept BOTH cartesian and non cartesian, and store it as cartesian
