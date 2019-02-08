package algoTest;

import algo.labyrinthGenerator.DfsGenerator;
import algo.shortestPathSolver.Bfs;
import algo.labyrinthGenerator.PrimGenerator;
import data.GraphData;
import graphVisualization.GraphFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MazeGeneratorTest {

    private GraphData data;
    private GraphFrame frame;
    private Bfs bfs;

    public MazeGeneratorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        int rows = 51;
        int columns = 71;
        data = new GraphData(rows, columns);
        frame = mock(GraphFrame.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void graphGeneratedByPrimHasPath() {
        PrimGenerator primGen = new PrimGenerator(data, frame);
        primGen.generateLabyrinth();
        bfs = new Bfs(data, frame);
        data.resetTables();
        assertTrue(bfs.searchWay());
    }
    
    @Test
    public void graphGeneratedByDfsHasPath() {
        DfsGenerator dfsGen = new DfsGenerator(data, frame);
        dfsGen.generateLabyrinth();
        bfs = new Bfs(data, frame);
        data.resetTables();
        assertTrue(bfs.searchWay());
    }

}
