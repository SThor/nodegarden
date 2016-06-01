/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Point;
import java.util.List;
import java.util.Set;
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
public class FieldTest {

    private Field instance;
    
    public FieldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Field();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updateLinks method, of class Field.
     */
    /*@Test
    public void testUpdateLinks() {
        System.out.println("updateLinks");
        Field instance = new Field();
        instance.updateLinks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNodes method, of class Field.
     */
    /*@Test
    public void testGetNodes() {
        System.out.println("getNodes");
        Field instance = new Field();
        List<Node> expResult = null;
        List<Node> result = instance.getNodes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLinks method, of class Field.
     */
    /*@Test
    public void testGetLinks() {
        System.out.println("getLinks");
        Field instance = new Field();
        Set<Link> expResult = null;
        Set<Link> result = instance.getLinks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNode method, of class Field.
     */
    /*@Test
    public void testAddNode_int_int() {
        System.out.println("addNode");
        int x = 0;
        int y = 0;
        Field instance = new Field();
        instance.addNode(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNode method, of class Field.
     */
    /*@Test
    public void testAddNode_Point() {
        System.out.println("addNode");
        Point p = null;
        Field instance = new Field();
        instance.addNode(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNode method, of class Field.
     */
    /*@Test
    public void testAddNode_Node() {
        System.out.println("addNode");
        Node n = null;
        Field instance = new Field();
        instance.addNode(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
    @Test
    public void testLinks(){
        Set<Link> links = instance.getLinks();
        Link link = new Link(new Node(2, 2,"2"), new Node(1, 1,"1"));
        boolean ajout = links.add(link);
        System.out.println("ajout = " + ajout);
        assertTrue(links.contains(new Link(new Node(2, 2,"2"), new Node(1, 1,"1"))));
    }
    
    @Test
    public void testLinksReversed(){
        Set<Link> links = instance.getLinks();
        Link link = new Link(new Node(2, 2,"2"), new Node(1, 1,"1"));
        boolean ajout = links.add(link);
        System.out.println("ajout = " + ajout);
        assertTrue(links.contains(new Link(new Node(1, 1,"1"), new Node(2, 2,"2"))));
    }
    
}
