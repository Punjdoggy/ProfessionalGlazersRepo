package org.firstinspires.ftc.teamcode.lib;

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
    public Vector2D add(Vector2D vector1){
        return new Vector2D(i + vector1.i, j + vector1.j, false);
    }
    public Vector2D sub(Vector2D vector1) {
        return new Vector2D(i - vector1.i, j - vector1.j, false);
    }

    Vector2D vector1 = new Vector2D(1,2,true);
    Vector2D vector2 = new Vector2D(2,2,false);
}

//must accept BOTH cartesian and non cartesian, and store it as cartesian
// // Guans Versio
//package org.firstinspires.ftc.teamcode.utils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Vector2D {
//
//    // Magnitude and Direction values
//    private double m;
//    private double d;
//
//    // Constructor
//    public Vector2D(double valOne, double valTwo, boolean isCart) {
//        if (isCart) {
//            // If Cartesian is true, valOne is 'x' and valTwo is 'y'
//            m = Math.sqrt((valOne*valOne) + (valTwo*valTwo));
//            d = Util.toDeg(Math.atan2(valOne,valTwo));
//        } else {
//            m = valOne;
//            d = valTwo;
//        }
//    }
//
//    /*
//    Vector2D add adds the current vector to the vector passed as an argument.
//    Returns another vectors that is the sum of the two vectors.
//     */
//
//    public Vector2D add(Vector2D vec) {
//        double newX = this.getX() + vec.getX();
//        double newY = this.getY() + vec.getY();
//
//        return new Vector2D(newX, newY, true);
//    }
//
//    public Vector2D sub(Vector2D vec) {
//        double newX = this.getX() - vec.getX();
//        double newY = this.getY() - vec.getY();
//        return new Vector2D(newX, newY, true);
//    }
//
//    public Vector2D mul(Vector2D vec) {
//        double newX = this.getX() * vec.getX();
//        double newY = this.getY() * vec.getY();
//
//        return new Vector2D(newX, newY, true);
//    }
//
//    public double[] getValues() {
//        return new double[]{this.getX(), this.getY()};
//    }
//
//
//    public Vector2D rot(double angle) {
//        return new Vector2D(m,(d+angle)%360,false);
//    }
//
//    public double getX() {
//        return Math.cos(d)*m;
//    }
//
//    public double getY() {
//        return Math.sin(d)*m;
//    }
//
//    public double getMag() {
//        return m;
//    }
//
//    public double getDir() {
//        return d;
//    }
//
//    public String toString() {
//        return "(" + this.getX() + ", " + this.getY() + ")";
//    }
//
//}