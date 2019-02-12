package algoTest;

import algo.labyrinthGenerator.PrimGenerator;
import algo.shortestPathSolver.Bfs;
import algo.shortestPathSolver.AstarWithEuclidean;
import algo.shortestPathSolver.AstarWithEuclideanSquare;
import algo.shortestPathSolver.AstarWithManhattan;
import data.GraphData;
import graphVisualization.GraphFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Test path finding algorithms
 */
public class GraphSolverTest {

    private Bfs bfs;
    private AstarWithManhattan astarManhattan;
    private AstarWithEuclidean astarEu;
    private AstarWithEuclideanSquare astarEuSq;
    private GraphData data;
    private GraphFrame mockFrame;
    private PrimGenerator primGen;
    private boolean hasSolution;

    public GraphSolverTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    public void init(int rows, int columns) {
        mockFrame = mock(GraphFrame.class);
        data = new GraphData(rows, columns);

        if (hasSolution) {
            primGen = new PrimGenerator(data, mockFrame);
            primGen.setRandomSeed(1037);
            primGen.generateLabyrinth();
        }
        bfs = new Bfs(data, mockFrame);
        astarManhattan = new AstarWithManhattan(data, mockFrame);
        astarEu = new AstarWithEuclidean(data, mockFrame);
        astarEuSq = new AstarWithEuclideanSquare(data, mockFrame);
        data.resetTables();
    }

    @After
    public void tearDown() {
    }

    private void pathFoundUsingBfs(int rows, int columns, int rightCheckedNodes) {
        hasSolution = true;
        init(rows, columns);
        assertTrue(bfs.searchWay());
        assertEquals(rightCheckedNodes, bfs.checkedNodes());
    }

    private void pathFoundUsingAstarWithManhattan(int rows, int columns, int rightCheckedNodes) {
        hasSolution = true;
        init(rows, columns);
        System.out.println("Manhattan");
        assertTrue(astarManhattan.searchWay());
        assertEquals(rightCheckedNodes, astarManhattan.checkedNodes());
    }

    private void pathFoundUsingAstarWithEuclidean(int rows, int columns, int rightCheckedNodes) {
        hasSolution = true;
        init(rows, columns);
        System.out.println("Euclidean");
        assertTrue(astarEu.searchWay());
        assertEquals(rightCheckedNodes, astarEu.checkedNodes());
    }

    private void pathFoundUsingAstarWithEuclideanSquare(int rows, int columns, int rightCheckedNodes) {
        hasSolution = true;
        init(rows, columns);
        System.out.println("Squared Euclidean");
        assertTrue(astarEuSq.searchWay());
        assertEquals(rightCheckedNodes, astarEuSq.checkedNodes());
    }

    private void rightPathLength(int rows, int columns, int shortest, int longerWhenSq) {
        hasSolution = true;
        init(rows, columns);
        bfs.searchWay();
        int bfsResult = bfs.countResult();

        data.resetTables();
        astarManhattan.searchWay();
        int astarManResult = astarManhattan.countResult();

        data.resetTables();
        astarEu.searchWay();
        int astarEuResult = astarEu.countResult();

        data.resetTables();
        astarEuSq.searchWay();
        int astarEuSqResult = astarEuSq.countResult();

        assertEquals(shortest, bfsResult);
        assertEquals(bfsResult, astarManResult);
        assertEquals(bfsResult, astarEuResult);
        assertEquals(longerWhenSq, astarEuSqResult);

    }

    @Test
    public void returnFalseWhenPathNotFoundUsingAstar() {
        hasSolution = false;
        init(101, 101);
        assertFalse(bfs.searchWay());
        assertFalse(astarManhattan.searchWay());
        assertFalse(astarEu.searchWay());
        assertFalse(astarEuSq.searchWay());
    }

    @Test
    public void pathFoundUsingBfs() {
        pathFoundUsingBfs(101, 101, 5232);
        pathFoundUsingBfs(501, 501, 131018);
    }

    @Test
    public void pathFoundUsingAstarWithManhattan() {
        pathFoundUsingAstarWithManhattan(101, 101, 1520);
        pathFoundUsingAstarWithManhattan(501, 501, 77715);
    }

    @Test
    public void pathFoundUsingAstarWithEuclidean() {
        pathFoundUsingAstarWithEuclidean(101, 101, 4257);
        pathFoundUsingAstarWithEuclidean(501, 501, 117849);
    }

    @Test
    public void pathFoundUsingAstarWithEuclideanSquare() {
        pathFoundUsingAstarWithEuclideanSquare(101, 101, 541);
        pathFoundUsingAstarWithEuclideanSquare(501, 501, 4979);
    }

    @Test
    public void getRightPathLength() {
        rightPathLength(101, 101, 207, 249);
        rightPathLength(501, 501, 1045, 1593);
    }

}
