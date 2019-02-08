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
 *
 * @author luoyumo
 */
public class MazeSolverTest {

    private Bfs bfs;
    private AstarWithManhattan astarManhattan;
    private AstarWithEuclidean astarEu;
    private AstarWithEuclideanSquare astarEuSq;
    private GraphData data;
    private GraphFrame mockFrame;
    private PrimGenerator primGen;
    private boolean hasSolution;

    public MazeSolverTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    public void init() {
        mockFrame = mock(GraphFrame.class);
        int rows = 101;
        int columns = 101;
        data = new GraphData(rows, columns);

        if (hasSolution) {
            primGen = new PrimGenerator(data, mockFrame);
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

    @Test
    public void returnTrueWhenPathFoundUsingBfs() {
        hasSolution = true;
        init();
        assertTrue(bfs.searchWay());
    }

    @Test
    public void returnFalseWhenPathNotFoundUsingBfs() {
        hasSolution = false;
        init();
        assertFalse(bfs.searchWay());
    }

    @Test
    public void returnTrueWhenPathFoundUsingAstarWithManhattan() {
        //for (int i = 0; i < 10; i++) {
        hasSolution = true;
        init();
        System.out.println("Manhattan");
//            int road = 0;
//            for (int k = 0; k < data.getRow(); k++) {
//                for (int j = 0; j < data.getColumn(); j++) {
//                    System.out.print(data.maze[k][j]);
//                    if (data.maze[k][j] == MazeData.ROAD) {
//                        road++;
//                    }
//                }
//                System.out.println("");
//
//            }
//            System.out.println("road " + road);
        assertTrue(astarManhattan.searchWay());
        //System.out.println(road);
        //}
    }

    @Test
    public void returnTrueWhenPathFoundUsingAstarWithEuclidean() {
        hasSolution = true;
        init();
        System.out.println("Euclidean");
//            int road = 0;
//            for (int k = 0; k < data.getRow(); k++) {
//                for (int j = 0; j < data.getColumn(); j++) {
//                    System.out.print(data.maze[k][j]);
//                    if (data.maze[k][j] == MazeData.ROAD) {
//                        road++;
//                    }
//                }
//                System.out.println("");
//
//            }
//            System.out.println("road " + road);
        assertTrue(astarEu.searchWay());
        //System.out.println(road);
        //}
    }

    @Test
    public void returnTrueWhenPathFoundUsingAstarWithEuclideanSquare() {
        hasSolution = true;
        init();
        System.out.println("Squared Euclidean");
        assertTrue(astarEuSq.searchWay());
    }

    @Test
    public void returnFalseWhenPathNotFoundUsingAstar() {
        hasSolution = false;
        init();
        assertFalse(astarManhattan.searchWay());
    }

    @Test
    public void canFindShortestPath() {
        hasSolution = true;
        init();
        bfs.searchWay();
        int bfsResult = bfs.countResult();

        data.resetTables();
        astarManhattan.searchWay();
        int astarManResult = astarManhattan.countResult();

        data.resetTables();
        astarEu.searchWay();
        int astarEuResult = astarEu.countResult();

        assertEquals(bfsResult, astarManResult);
        assertEquals(bfsResult, astarEuResult);

    }
}
