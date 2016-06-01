package model;

import java.awt.Color;
import java.awt.Point;

public class Link {

    private final Node node1, node2;

    public Link(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public double getThickness() {
        double base_thickness = (Math.max(node1.getDiameter(), node2.getDiameter())) / 2;
        return base_thickness * getDisplayStrength();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Link) {
            Link link2 = (Link) obj;
            return ((node1.equals(link2.node1) && node2.equals(link2.node2)) || (node1.equals(link2.node2) && node2.equals(link2.node1)));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 67 * node1.hashCode() * node2.hashCode();
        return hash;
    }

    public Color getColor() {
        Color color = Constants.DEFAULT_LINK_COLOR;
        int alpha = (int) (Constants.LINK_MAXIMUM_ALPHA * getDisplayStrength());
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    }

    private double getDisplayStrength() {
        double strength = 0;
        double distance = getLength();
        if (distance < Constants.LINK_MINIMAL_DISTANCE) {
            strength = 1;
        } else if (distance < Constants.LINK_MAXIMAL_DISTANCE) {
            //distance = 1-distance;
            strength = (distance - Constants.LINK_MAXIMAL_DISTANCE) / (Constants.LINK_MINIMAL_DISTANCE - Constants.LINK_MAXIMAL_DISTANCE);
        }
        return strength;
    }

    public double getLength() {
        return node1.getPoint().distance(node2.getPoint());
    }

    public double getStrength() {
        double distance = getLength();
        return (Constants.GRAVITATIONAL_CONSTANT * node1.getMass() * node2.getMass()) / (distance * distance);
    }
    
    public Vector getForceOn(Node node){
        Point point1;
        Point point2;
        if(node.equals(node1)){
            point1 = node1.getPoint();
            point2 = node2.getPoint();
        }else{
            point1 = node2.getPoint();
            point2 = node1.getPoint();
        }
        double angle = Math.atan2(point2.y-point1.y, point2.x-point1.x);
        return Vector.fromAngle(angle, getStrength());
    }
}
