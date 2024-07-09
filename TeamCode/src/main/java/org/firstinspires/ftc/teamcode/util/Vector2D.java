package org.firstinspires.ftc.teamcode.util;

public class Vector2D {
    public double getM() {
        return m;
    }

    public double getD() {
        return d;
    }

    public void setM(double m) {
        this.m = m;
    }

    public void setD(double d) {
        this.d = d;
    }

    private double m;
    private double d;
    public Vector2D(double nm, double nd) {
        m = nm;
        d = nd;
    }

    public Vector2D mul(Vector2D vec2) {
        return new Vector2D(m * vec2.getM(), d * vec2.getD());
    }

    public Vector2D rot(double rot) {
        return new Vector2D(m, (d + rot)%360);
    }

    public Vector2D vecrot (Vector2D vec2) {
        return new Vector2D(m,(d + vec2.getD())%360);
    }
}


Vector2D vec1 = new Vector2D(1, 2);

Vector2D vec2 = new Vector2D(1, 2);

vec1.getD(); // == 2
vec1.setD(1);
vec1.getD(); // == 1


vec2.mul(vec1);
vec1.mul(vec2);

vec1.mul(vec1) == vec1 * vec1
Vector2D vec1 = new Vector2D(1, 2);

Vector2D vec2 = new Vector2D(2, 3);

vec1.mul(vec1) == vec1 * vec2 =
new Vector2D(vec1.getM() * vec2.getM(), vec1.getD() * vec2.getD());