/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import tools.Generator;
import java.awt.BasicStroke;
import static java.awt.BasicStroke.CAP_ROUND;
import static java.awt.BasicStroke.JOIN_ROUND;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.Field;
import model.Link;
import model.Node;

/**
 *
 * @author silmathoron
 */
public class FieldPanel extends javax.swing.JPanel {

    private int millis = 10;
    private boolean running;
    private Field field;
    private MainFrame parent;

    /**
     * Creates new form NodeGardenPanel
     */
    public FieldPanel() {
        initComponents();
        this.field = new Field();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(51, 51, 51));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        field.addNode(evt.getX(), evt.getY());
        parent.updateStats(field.getNodesNumber(), field.getLinksNumber());
        repaint();
    }//GEN-LAST:event_formMouseClicked

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        paintNodes(g2);
        paintLinks(g2);
    }

    private void paintLinks(Graphics2D g2) {
        Set<Link> links = field.getLinks();
        for (Link link : links) {
            g2.setColor(link.getColor());

            int x1 = link.getNode1().getPoint().x;
            int y1 = link.getNode1().getPoint().y;
            int x2 = link.getNode2().getPoint().x;
            int y2 = link.getNode2().getPoint().y;
            g2.setStroke(new BasicStroke((float) link.getThickness(), CAP_ROUND, JOIN_ROUND));
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    private void paintNodes(Graphics2D g2) {
        List<Node> nodes = field.getNodes();
        for (Node node : nodes) {
            g2.setColor(node.getColor());

            Point center = node.getPoint();
            int x = center.x - (node.getDiameter() / 2);
            int y = center.y - (node.getDiameter() / 2);
            g2.fillOval(x, y, node.getDiameter(), node.getDiameter());
        }
    }

    public void run() {
        Thread t = new Thread() {
            @Override
            public void run() {
                running = true;
                while (running) {
                    try {
                        field.updateForces();
                        field.move(millis);
                        parent.updateStats(field.getNodesNumber(), field.getLinksNumber());
                        Thread.sleep(millis);
                        repaint();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FieldPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t.start();
    }

    public void reset() {
        this.field = new Field();
        parent.updateStats(field.getNodesNumber(), field.getLinksNumber());
        repaint();
    }

    public void stop() {
        running = false;
    }

    public void setParent(MainFrame parent) {
        this.parent = parent;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
