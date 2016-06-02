package model;

import tools.Generator;
import java.awt.Color;
import java.awt.Point;

public class Node {

    private Point point;
    private int diameter;
    private Color color;
    private String name;
    private Vector netForce = new Vector(0, 0);
    private Vector acceleration = new Vector(0, 0);
    private Vector speed = new Vector(0, 0);

    public Node(Point coordinates, String name) {
        this.point = coordinates;
        this.diameter = Constants.DEFAULT_NODE_DIAMETER;
        this.color = Generator.getRandomColor();
        this.name = name;
    }

    public Node(int x, int y, String name) {
        this.point = new Point(x, y);
        this.diameter = Constants.DEFAULT_NODE_DIAMETER;
        this.color = Generator.getRandomColor();
        this.name = name;
    }

    public Node(Point coordinates, int diameter) {
        this.point = coordinates;
        this.diameter = diameter;
        this.color = Generator.getRandomColor();
    }

    public Node(int x, int y, int diameter) {
        this.point = new Point(x, y);
        this.diameter = diameter;
        this.color = Generator.getRandomColor();
    }

    public Vector getNetForce() {
        return netForce;
    }

    public void setNetForce(Vector netForce) {
        this.netForce = netForce;
        acceleration = this.netForce.div(getMass());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node node = (Node) obj;
            return name.equals(node.name);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public Color getColor() {
        return color;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public double getMass() {
        double radius = diameter / 2;
        return (4 / 3 * Math.PI * Math.pow(radius, 3)) * Constants.DEFAULT_VOLUMIC_MASS;
    }

    public String getName() {
        return name;
    }

    public void move(int msPassed) {
        Vector moveDelta = speed.mult(msPassed);
        point.x += moveDelta.getX();
        point.y += moveDelta.getY();
    }

    public void computeSpeed(int msPassed) {
        Vector speedDelta = acceleration.mult(msPassed);
        speed.add(speedDelta);
    }

    public Vector getAcceleration() {
        return acceleration;
    }

    public Vector getSpeed() {
        return speed;
    }
}
