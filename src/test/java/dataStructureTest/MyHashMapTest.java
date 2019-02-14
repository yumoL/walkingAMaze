/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStructureTest;

import data.Node;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.MyHashMap;

/**
 *
 * @author luoyumo
 */
public class MyHashMapTest {

    private MyHashMap map;
    private Node n1, n2, n3;

    public MyHashMapTest() {
        n1 = new Node(1, 1, null);
        n2 = new Node(2, 3, n1);
        n3 = new Node(4, 5, n2);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        map = new MyHashMap();
        map.put(n1, 1);
        map.put(n2, 2);
        map.put(n3, 3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void returnMinusOneIfKeyNotExistedWhenGetting() {
        Node n4 = new Node(8, 9, null);
        assertEquals(-1, map.get(n4));
    }

    @Test
    public void canGetCorrectValue() {
        assertEquals(1, map.get(n1));
    }
    
    @Test
    public void canGetCorectValuesWhenCollision(){
        Node n4=new Node(2,-70,n2);//has same hashcode with n1
        System.out.println("n1 "+n1.hashCode());
        System.out.println("n4 "+n4.hashCode());
        assertEquals(1,map.get(n1));
        assertEquals(-1,map.get(n4));
    }

    @Test
    public void canPutKey_ValuePair() {
        Node n4 = new Node(6, 9, n3);
        map.put(n4, 4);
        assertEquals(4, map.get(n4));
    }

    @Test
    public void canDefineIfMapContainsKey() {
        assertTrue(map.containsKey(n3));
        assertFalse(map.containsKey(new Node(7, 7, null)));
    }

    @Test
    public void canRemoveKey() {
        assertEquals(2,(int)map.remove(n2));
        assertFalse(map.containsKey(n2));
    }
    
    @Test
    public void returnNullIfKeyDoesNotExitWhenRemoving(){
        Node n4=new Node(99,99,null);
        assertTrue(map.remove(n4)==null);
        
        Node n5=new Node(2,-70,null);//has same hashcode as n1
        assertTrue(map.remove(n5)==null);
    }
}
