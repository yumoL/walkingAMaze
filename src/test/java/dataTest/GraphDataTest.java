package dataTest;

import data.GraphData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphDataTest {

    private GraphData data;
    private final int ROWS = 51;
    private final int COLUMNS = 31;

    public GraphDataTest() {
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
    public void returnTrueWhenCoordinatePairInGraph() {
        boolean result = data.inArea(3, 3);
        assertTrue(result);
    }

    @Test
    public void returnFalseWhenCoordinatePairOutsideGraph() {
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
    public void throwExceptionIfCoordinatePairOutsideGraphWhenGettingCertainCharFromGraph() {
        char wrongCoordinates = data.getGraph(301, 301);
    }

    @Test
    public void canGetRightCharacterFromGraph() {
        char character = data.getGraph(2, 2);
        char wall = GraphData.WALL;
        assertEquals(wall, character);

        char character2 = data.getGraph(3, 3);
        char path = GraphData.ROAD;
        assertEquals(path, character2);

    }

    @Test(expected = Exception.class)
    public void throwExceptionIfGivenRowsEven() {
        int wrongRows = 100;
        data = new GraphData(wrongRows, COLUMNS);
    }

    @Test(expected = Exception.class)
    public void throwExceptionIfGivenCOlsEven() {
        int wrongCols = 100;
        data = new GraphData(ROWS, wrongCols);
    }

}
