/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author silmathoron
 */
public class LinkTest {
    private Link instance;

    public LinkTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Link(new Node(1, 1,"1"), new Node(2, 2,"2"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of equals method, of class Link.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Link link = new Link(new Node(1, 1,"1"), new Node(2, 2,"2"));
        boolean result = instance.equals(link);
        assertTrue(result);
        
    }
    
    @Test
    public void testEqualsReversed() {
        System.out.println("equals Reversed");
        Link link = new Link(new Node(2, 2,"2"), new Node(1, 1,"1"));
        boolean result = instance.equals(link);
        assertTrue(result);
        
    }

    /**
     * Test of hashCode method, of class Link.
     */
    @Test
    public void testHashCode() {
        System.out.println("HashCode");
        Link link = new Link(new Node(1, 1,"1"), new Node(2, 2,"2"));
        assertEquals(instance.hashCode(), link.hashCode());
    }
    
    /**
     * Test of hashCode method, of class Link.
     */
    @Test
    public void testHashCodeReversed() {
        System.out.println("HashCode Reversed");
        Link link = new Link(new Node(2, 2,"2"), new Node(1, 1,"1"));
        assertEquals(instance.hashCode(), link.hashCode());
    }

    /**
     * Test of getNode1 method, of class Link.
     */
    @Test
    public void testGetNode1() {
        System.out.println("getNode1");
        Node expResult = new Node(1,1,"1");
        Node result = instance.getNode1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNode2 method, of class Link.
     */
    @Test
    public void testGetNode2() {
        System.out.println("getNode2");
        Node expResult = new Node(2,2,"2");
        Node result = instance.getNode2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getThickness method, of class Link.
     */
    @Test
    public void testGetThickness() {
        System.out.println("getThickness");
        Link instance = new Link(new Node(1,1,20), new Node(2,2,100));
        double expResult = 50;
        double result = instance.getThickness();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLength method, of class Link.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        double expResult = Math.sqrt(2);
        double result = instance.getLength();
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of getForceOn method, of class Link.
     */
    @Test
    public void testGetForceOn() {
        System.out.println("getForceOn");
        Node node = new Node(2,2,"2");
        double angle = (-3*Math.PI)/4;
        Vector expResult = Vector.fromAngle(angle, instance.getStrength());
        Vector result = instance.getForceOn(node);
        assertEquals(expResult, result);
    }
}
