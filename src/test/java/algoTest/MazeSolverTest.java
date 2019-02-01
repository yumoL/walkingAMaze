package Algo;

import algo.MazeSolver;
import data.MazeData;
import mazeVisualisation.MazeFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author luoyumo
 */
public class MazeSolverTest {

    private MazeSolver testSolver;
    private MazeData data;
    private MazeFrame mockFrame;
    private boolean hasSolution;

    public MazeSolverTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    public void setUp() {
        mockFrame = mock(MazeFrame.class);

        if (hasSolution) {
            data = new MazeData("labyrinth_101_101.txt");
            testSolver = new MazeSolver(data, mockFrame);
        } else {
            data = new MazeData("labyrinthNoPath.txt");
            testSolver = new MazeSolver(data, mockFrame);
        }
        testSolver.setDelay(0);//to make tests running faster
    }

    @After
    public void tearDown() {
    }

    @Test
    public void returnTrueWhenPathFoundUsingDfsWithRecursion() {
        hasSolution = true;
        setUp();
        assertTrue(testSolver.dfsWithRecursion(data.getEntranceX(), data.getEntranceY()));
    }

    @Test
    public void returnFalseWhenPathNotFoundUsingDfsWithRecursion() {
        hasSolution = false;
        setUp();
        assertFalse(testSolver.dfsWithRecursion(data.getEntranceX(), data.getEntranceY()));
    }

    @Test
    public void returnTrueWhenPathFoundUsingDfsWithoutRecursion() {
        hasSolution = true;
        setUp();
        assertTrue(testSolver.dfsWithoutRecursion());
    }

    @Test
    public void returnFalseWhenPathNotFoundUsingDfsWithoutRecursion() {
        hasSolution = false;
        setUp();
        assertFalse(testSolver.dfsWithoutRecursion());
    }

    @Test
    public void returnTrueWhenPathFoundUsingBfs() {
        hasSolution = true;
        setUp();
        assertTrue(testSolver.bfs());
    }

    @Test
    public void returnFalseWhenPathNotFoundUsingBfs() {
        hasSolution = false;
        setUp();
        assertFalse(testSolver.bfs());
    }

}
