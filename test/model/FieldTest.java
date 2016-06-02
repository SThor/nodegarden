/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
