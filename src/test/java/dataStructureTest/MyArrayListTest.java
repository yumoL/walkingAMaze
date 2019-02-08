/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStructureTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.MyArrayList;

/**
 *
 * @author luoyumo
 */
public class MyArrayListTest {

    private MyArrayList<Integer> list;

    public MyArrayListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.list = new MyArrayList<>();
        list.add(0, 0);
        list.add(1, 1);
    }

    @After
    public void tearDown() {
    }

    @Test(expected = Exception.class)
    public void cannotAddElementWhenGivenIndexNegative() {
        list.add(-1, 9);
    }

    @Test(expected = Exception.class)
    public void cannotAddElementWhenGivenIndexLargerThanSize() {
        list.add(list.size() + 1, 9);
    }

    @Test
    public void addedElementCanBeFound() {
        assertEquals(0, (int) list.get(0));
        assertEquals(1, (int) list.get(1));
    }

    @Test
    public void canResizeCorrectlyWhenSizeWillLargerThanCapacityAfterAdding() {
        list = new MyArrayList<>();
        int capacity = 10;//defaulted capacity
        for (int i = 0; i < capacity; i++) {
            list.add(i, i + 10);
        }
        list.add(10, 20);
        assertEquals(20, (int) list.get(10));
    }

    @Test
    public void canAddToLast() {
        list.addLast(2);
        assertEquals(2, (int) list.get(list.size() - 1));
    }

    @Test
    public void canAddToFirst() {
        list.addFirst(3);
        assertEquals(3, (int) list.get(0));
        assertEquals(0, (int) list.get(1));
        assertEquals(1, (int) list.get(2));

    }

    @Test
    public void canRemoveElementFromIndex() {
        int removed = list.remove(0);
        assertFalse(list.contains(removed));
        assertTrue(list.contains(1));
    }

    @Test
    public void canRemoveFirstElement() {
        list.addLast(2);
        int removed = list.removeFirst();
        assertEquals(0, removed);
        assertFalse(list.contains(removed));
    }

    @Test
    public void canRemoveLastElement() {
        list.addLast(2);
        int removed = list.removeLast();
        assertEquals(2, removed);
        assertFalse(list.contains(removed));
    }

}
