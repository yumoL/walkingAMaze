package algoTest;

import algo.shortestPathSolver.Bfs;
import algo.*;
import algo.shortestPathSolver.AstarWithEuclidian;
import algo.shortestPathSolver.AstarWithEuclidianSquare;
import algo.shortestPathSolver.AstarWithManhattan;
import data.MazeData;
import mazeVisualisation.MazeFrame;
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
    private AstarWithEuclidian astarEu;
    private AstarWithEuclidianSquare astarEuSq;
    private MazeData data;
    private MazeFrame mockFrame;
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
        mockFrame = mock(MazeFrame.class);
        int rows = 101;
        int columns = 101;
        data = new MazeData(rows, columns);

        if (hasSolution) {
            primGen = new PrimGenerator(data, mockFrame);
            primGen.generateLabyrinth();
        }
        bfs = new Bfs(data, mockFrame);
        astarManhattan = new AstarWithManhattan(data, mockFrame);
        astarEu = new AstarWithEuclidian(data, mockFrame);
        astarEuSq = new AstarWithEuclidianSquare(data, mockFrame);
        bfs.setDelay(0);//to make tests run faster
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
    public void returnTrueWhenPathFoundUsingAstarWithEuclidian() {
        hasSolution = true;
        init();
        System.out.println("Euclidian");
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
    public void returnTrueWhenPathFoundUsingAstarWithEuclidianSquare() {
        hasSolution = true;
        init();
        System.out.println("Squared Euclidian");
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
        int bfsResult = countResult(data);

        data.resetTables();
        astarManhattan.searchWay();
        int astarManResult = countResult(data);

        data.resetTables();
        astarEu.searchWay();
        int astarEuResult = countResult(data);

        assertEquals(bfsResult, astarManResult);
        assertEquals(bfsResult, astarEuResult);

    }

    private int countResult(MazeData data) {
        int count = 0;
        for (int i = 0; i < data.getRow(); i++) {
            for (int j = 0; j < data.getColumn(); j++) {
                if (data.result[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

}
