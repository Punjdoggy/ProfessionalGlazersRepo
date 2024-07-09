package org.firstinspires.ftc.teamcode.util;

public class Vector2DC {
    private double i;
    private double j;

    public Vector2DC(double ni, double nj) {
        i = ni;
        j = nj;
    }

    //getters
    public double getI() {
        return i;
    }

    public double getJ(){
        return j;
    }

    //Setters
    public double setI(double i){
        this.i = i;
        return i;
    }

    public double setJ(double j) {
        this.j = j;
        return j;
    }

    //Constructor

    Vector2DC vector1 = new Vector2DC(1,2);
    Vector2DC vector2 = new Vector2DC(2,2);

    // Setting Addition
    public Vector2DC vecadd(Vector2DC vector2) {
        return new Vector2DC(i + vector2.getI(), j + vector2.getJ());
    }

    // Setting Subtraction ( Vector 2 Subtract Vector 1)
    public Vector2DC vecsub (Vector2DC vector1) {
        return new Vector2DC(i - vector1.getI(), j - vector1.getJ());

    }

    //using these methods

    vector1.vecsub(vector2);
    vector1.vecadd(vector2);

}
