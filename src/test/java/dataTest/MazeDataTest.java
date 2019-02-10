package dataTest;

import data.GraphData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MazeDataTest {

    private GraphData data;
    private final int ROWS = 51;
    private final int COLUMNS = 31;

    public MazeDataTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        data = new GraphData(ROWS, COLUMNS);
    }

    @After
    public void tearDown() {
    }

   
    @Test(expected = Exception.class)
    public void throwExceptionIfFilenameEmptyWhenreadingAMazeFile() {

        GraphData failedData = new GraphData(20, 30);
    }
    
    @Test
    public void initialiseCorrcectPattern() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (i == 1 && j == 0) {
                    assertEquals(GraphData.ROAD, data.graph[i][j]);
                } else if (i == ROWS - 2 && (j == COLUMNS - 1)) {
                    assertEquals(GraphData.ROAD, data.graph[i][j]);
                } else if (i % 2 == 1 && j % 2 == 1) {
                    assertEquals(GraphData.ROAD, data.graph[i][j]);
                } else {
                    assertEquals(GraphData.WALL, data.graph[i][j]);
                }
            }
        }
    }

    @Test
    public void canGetRightColumnAndRowNumbers() {
        assertEquals(COLUMNS, data.getColumn());
        assertEquals(ROWS, data.getRow());
    }

    
    @Test
    public void returnTrueWhenCoordinatePairInMaze() {
        boolean result = data.inArea(3, 3);
        assertTrue(result);
    }

    
    @Test
    public void returnFalseWhenCoordinatePairOutsideMaze() {
        boolean xOutside = data.inArea(300, 3);
        boolean yOutside = data.inArea(3, 300);
        boolean xNegative = data.inArea(-2, 9);
        boolean yNegative = data.inArea(9, -2);

        assertFalse(xOutside);
        assertFalse(yOutside);
        assertFalse(xNegative);
        assertFalse(yNegative);
    }

    
    @Test(expected = Exception.class)
    public void throwExceptionIfCoordinatePairOutsideMazeWhenGettingCertainCharFromMaze() {
        char wrongCoordinates = data.getMaze(300, 300);
    }

    
    @Test
    public void canGetRightCharacterFromMaze() {
        char character = data.getMaze(2, 2);
        char wall = GraphData.WALL;
        assertEquals(wall, character);

        char character2 = data.getMaze(3, 3);
        char path = GraphData.ROAD;
        assertEquals(path, character2);

    }

}
