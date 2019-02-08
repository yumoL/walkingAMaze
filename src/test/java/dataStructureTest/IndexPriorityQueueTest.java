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
import util.IndexPriorityQueue;

public class IndexPriorityQueueTest {

    private int capacity = 10;
    private IndexPriorityQueue<String> pq;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.pq = new IndexPriorityQueue<>(capacity);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void returnTrueWhenQueueIsEmpty() {
        assertTrue(pq.isEmpty());
    }

    @Test
    public void returnFalseWhenQueueHasElements() {
        pq.add(0, "zero");
        assertFalse(pq.isEmpty());
    }

    @Test
    public void canAddElement() {
        int index = 1;
        String element = "one";
        pq.add(index, element);
        assertEquals(element, pq.getElement(index));

    }

    @Test(expected = Exception.class)
    public void cannotAddElementWhenQueueIsFull() {
        this.pq = new IndexPriorityQueue<>(1);
        pq.add(0, "zero");
        pq.add(1, "one");
    }

    @Test(expected = Exception.class)
    public void cannotAddElementWhenIndexOutOfCapasity() {
        pq.add(capacity + 1, "wrongIndex");
    }
    
    @Test(expected = Exception.class)
    public void cannotAddElementWhenIndexNegative() {
        pq.add(-1, "wrongIndex");
    }

    @Test(expected = Exception.class)
    public void cannotAddElementWhenIndexAlreadyReferencesToAnotherElement() {
        pq.add(0, "zero");
        pq.add(0, "zero1");
    }

    @Test(expected = Exception.class)
    public void throwExceptionWhenExtractElementFromEmptyQueue() {
        pq.pollElement();
    }

    @Test
    public void canExtractSmallestElement() {
        pq.add(4, "c");
        pq.add(1, "a");
        pq.add(0, "b");
        assertEquals("a", pq.pollElement());
    }

    @Test(expected = Exception.class)
    public void cannotGetElementFromIndexWhichDoesNotReferenceToAnything() {
        pq.getElement(2);
    }

    @Test
    public void canGetElementAccordingToItsIndex() {
        pq.add(1, "one");
        pq.add(2, "two");
        assertEquals("two", pq.getElement(2));
    }

    @Test(expected = Exception.class)
    public void cannotChangeElementWhenGivenIndexDoesNotReferenceToAnything() {
        pq.change(2, "newTwo");
    }

    @Test
    public void canChangeElementAccordingToIndex() {
        pq.add(0, "zero");
        pq.add(3, "three");
        pq.change(3, "newThree");
        assertEquals("newThree", pq.getElement(3));

    }

}
