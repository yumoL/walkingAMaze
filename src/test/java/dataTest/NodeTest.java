package dataTest;

import data.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luoyumo
 */
public class NodeTest {

    private Node n1, n2, n3;

    public NodeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        n1 = new Node(1, 2);
        n2 = new Node(3, 4);
        n3 = new Node(1, 2, n2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void canDefineIfTwoNodesEqual() {
        assertTrue(n1.equals(n3));
        assertFalse(n1.equals(n2));
    }

    @Test
    public void canCompareTwoNodes() {
        assertTrue(n1.compareTo(n2) == 0);
        n1.setF(1);
        n3.setF(2);
        assertTrue(n1.compareTo(n3) < 0);
    }
}
