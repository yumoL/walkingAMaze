package algoTest;

import algo.*;
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
    private Astar astar;
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
            primGen.generateMaze();
        }
        bfs = new Bfs(data, mockFrame);
        astar = new Astar(data, mockFrame);
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
    public void returnTrueWhenPathFoundUsingAstar() {
        hasSolution = true;
        init();
        assertTrue(astar.searchWay());
    }

    @Test
    public void returnFalseWhenPathNotFoundUsingAstar() {
        hasSolution = false;
        init();
        assertFalse(astar.searchWay());
    }

    @Test
    public void canFindShortestPath() {
        hasSolution = true;
        init();
        bfs.searchWay();
        int bfsResult = countResult(data);

        data.resetTables();
        astar.searchWay();
        int astarResult = countResult(data);

        assertEquals(bfsResult, astarResult);

    }

    private int countResult(MazeData data) {
        int count = 0;
        for (int i = 0; i < data.getRow(); i++) {
            for (int j = 0; j < data.getRow(); j++) {
                if (data.result[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

}
