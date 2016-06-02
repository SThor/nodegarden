/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Silma Thoron
 */
public class VectorTest {
    
    public VectorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of fromAngle method, of class Vector.
     */
    @Test
    public void testFromAngle() {
        System.out.println("fromAngle");
        double angle = 0.0;
        double length = 1;
        Vector expResult = new Vector(1,0);
        Vector result = Vector.fromAngle(angle, length);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAngle method, of class Vector.
     */
    @Test
    public void testGetAngle() {
        System.out.println("getAngle");
        Vector instance = new Vector(1,1);
        double expResult = Math.PI/4;
        double result = instance.getAngle();
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of getLength method, of class Vector.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Vector instance = new Vector(1,1);
        double expResult = Math.sqrt(2);
        double result = instance.getLength();
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of getX method, of class Vector.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Vector instance = new Vector(2,1);
        double expResult = 2.0;
        double result = instance.getX();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getY method, of class Vector.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Vector instance = new Vector(1,2);
        double expResult = 2.0;
        double result = instance.getY();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of add method, of class Vector.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Vector other = new Vector(1,2);
        Vector instance = new Vector(2,4);
        Vector expResult = new Vector(3,6);
        instance.add(other);
        assertEquals(expResult, instance);
    }

    /**
     * Test of sub method, of class Vector.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        Vector other = new Vector(2,2);
        Vector instance = new Vector(1,4);
        Vector expResult = new Vector(-1,2);
        instance.sub(other);
        assertEquals(expResult, instance);
    }

    /**
     * Test of toString method, of class Vector.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vector instance = new Vector(1,2);
        String expResult = "(1.0, 2.0)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of netForce method, of class Vector.
     */
    @Test
    public void testNetForce_VectorArr() {
        System.out.println("netForce");
        Vector[] vectors = new Vector[3];
        vectors[0] = new Vector(0, 2);
        vectors[1] = new Vector(1,0);
        vectors[2] = new Vector(0,1);
        Vector expResult = new Vector(1,3);
        Vector result = Vector.netForce(vectors);
        assertEquals(expResult, result);
    }

    /**
     * Test of netForce method, of class Vector.
     */
    @Test
    public void testNetForce_List() {
        System.out.println("netForce");
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(1,1));
        vectors.add(new Vector(-1,1));
        vectors.add(new Vector(1,-1));
        vectors.add(new Vector(-1,-1));
        Vector expResult = new Vector(0,0);
        Vector result = Vector.netForce(vectors);
        assertEquals(expResult, result);
    }

    /**
     * Test of div method, of class Vector.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        double constant = 2.0;
        Vector instance = new Vector(1,2);
        Vector expResult = new Vector(0.5,1);
        Vector result = instance.div(constant);
        assertEquals(expResult, result);
    }

    /**
     * Test of mult method, of class Vector.
     */
    @Test
    public void testMult() {
        System.out.println("mult");
        double constant = 2.0;
        Vector instance = new Vector(1,2);
        Vector expResult = new Vector(2,4);
        Vector result = instance.mult(constant);
        assertEquals(expResult, result);
    }
    
}
