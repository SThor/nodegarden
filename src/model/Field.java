package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Field {

    private final List<Node> nodes;
    private final Set<Link> links;

    public Field() {
        nodes = new ArrayList<>();
        links = new HashSet<>();
    }

    public void updateLinks() {
        for (Node node1 : nodes) {
            updateLinks(node1);
        }
        //removeTrash();
    }

    public void updateLinks(Node node1) {
        List<Node> nodesCopy = new ArrayList(nodes);
        nodesCopy.remove(node1);
        for (Node node2 : nodesCopy) {
            Link link = new Link(node1, node2);
            links.add(link); // automatiquement, ne va pas ajouter le lien s'il est déjà présent (ou si son opposé l'est)
        }
        //removeTrash();
    }
    
    public void updateForces(){
        for (Node node : nodes) {
            node.setNetForce(Vector.netForce(getForces(node)));
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }
    
    public List<Vector> getForces(Node node){
        List<Vector> forces = new ArrayList<>();
        for (Link link : links) {
            forces.add(link.getForceOn(node));
        }
        return forces;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void addNode(int x, int y) {
        addNode(new Point(x, y));
    }

    public void addNode(Point p) {
        String name = "" + nodes.size();
        addNode(new Node(p, name));
    }

    public void addNode(Node n) {
        nodes.add(n);
        updateLinks(n);
    }

    private void removeTrash() {
        Set<Link> trash = new HashSet<>();
        for(Link link : links){
            if(link.getThickness()<=0)
                trash.add(link);
        }
        links.removeAll(trash);
    }

    public void move(int msPassed) {
        for (Node node : nodes) {
            node.computeSpeed(msPassed);
        }
        for (Node node : nodes) {
            node.move(msPassed);
        }
        updateLinks();
    }
    
    public int getNodesNumber(){
        return nodes.size();
    }
    
    public int getLinksNumber(){
        return links.size();
    }
}
