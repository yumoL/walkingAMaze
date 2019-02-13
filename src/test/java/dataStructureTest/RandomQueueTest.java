/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStructureTest;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import util.RandomQueue;

/**
 *
 * @author luoyumo
 */
public class RandomQueueTest {

    private RandomQueue<Integer> rq;
    private Random r = mock(Random.class);

    public RandomQueueTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.rq = new RandomQueue<>();
        rq.setRandom(r);
        for (int i = 0; i < 3; i++) {
            rq.getQueue().add(i, i);
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addElementToBeginWhenRandomOdd() {
        when(r.nextInt()).thenReturn(5);
        rq.add(3);
        assertEquals(3, (int) rq.getQueue().get(0));
    }

    @Test
    public void addElementToEndWhenRandomEven() {
        when(r.nextInt()).thenReturn(4);
        rq.add(3);
        assertEquals(3, (int) rq.getQueue().get(3));
    }

    @Test
    public void removeFirstWhenRandomOdd() {
        when(r.nextInt()).thenReturn(5);
        int removed = rq.remove();
        assertEquals(0, removed);
        assertFalse(rq.getQueue().contains(removed));
    }

    @Test
    public void removeLastWhenRandomEven() {
        when(r.nextInt()).thenReturn(4);
        int removed = rq.remove();
        assertEquals(2, removed);
        assertFalse(rq.getQueue().contains(removed));
    }

    @Test
    public void canDefineIfaQueueIsEmpty() {
        rq.add(1);
        assertFalse(rq.isEmpty());
        rq = new RandomQueue<>();
        assertTrue(rq.isEmpty());
    }

    @Test(expected = Exception.class)
    public void cannotRemoveIfQueueEmpty() {
        rq = new RandomQueue<>();
        rq.remove();
    }
}
