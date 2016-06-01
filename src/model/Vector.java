package model;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;

public class Vector {

    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Vector fromAngle(double angle, double length) {
        double x = length * Math.cos(angle);
        double y = length * Math.sin(angle);
        return new Vector(Math.round(x), Math.round(y));
    }    
    
    public Vector(Point point1, Point point2) {
        this.x = point2.x - point1.x;
        this.y = point2.y - point1.y;
    }

    public double getAngle() {
        return Math.atan2(y, x);
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void add(Vector other) {
        x += other.x;
        y += other.y;
    }

    public void sub(Vector other) {
        x -= other.x;
        y -= other.y;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector other = (Vector) obj;
        long roundX = Math.round(x);
        long roundX2 = Math.round(other.x);
        long roundY = Math.round(y);
        long roundY2 = Math.round(other.y);
        return roundX == roundX2 && roundY == roundY2;
    }

    public static Vector netForce(Vector... vectors){
        List<Vector> vectorList = Arrays.asList(vectors);
        return netForce(vectorList);
    }
    
    public static Vector netForce(List<Vector> vectors){
        Vector res = new Vector(0, 0);
        for (Vector vector : vectors) {
            res.add(vector);
        }
        return res;
    }

    public Vector div(double constant) {
        return new Vector(x/constant, y/constant);
    }
    
    public Vector mult(double constant) {
        return new Vector(x*constant, y*constant);
    }
}
