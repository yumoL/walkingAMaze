package algoTest;

import algo.shortestPathSolver.Bfs;
import algo.PrimGenerator;
import data.MazeData;
import mazeVisualisation.MazeFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MazeGeneratorTest {

    private MazeData data;
    private MazeFrame frame;
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
        data = new MazeData(rows, columns);
        frame = mock(MazeFrame.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void mazeGeneratedByPrimHasSolution() {
        PrimGenerator primGen = new PrimGenerator(data, frame);
        primGen.generateLabyrinth();
        bfs = new Bfs(data, frame);
        data.resetTables();
        assertTrue(bfs.searchWay());
    }

}
