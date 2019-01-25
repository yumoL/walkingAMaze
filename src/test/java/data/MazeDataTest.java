package data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MazeDataTest {

    private MazeData data;

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
        data = new MazeData("labyrinth_101_101.txt");
    }

    @After
    public void tearDown() {
    }

    @Test(expected = Exception.class)
    public void throwExceptionIfFilenameEmptyWhenreadingAMazeFile() {
        String emptyFilename = null;
        data = new MazeData(emptyFilename);
    }

    @Test(expected = Exception.class)
    public void throwExceptionIfFilenameIsWrongWhenreadingAMazeFile() {
        String wrongFilename = "wrongName";
        data = new MazeData(wrongFilename);
    }

    @Test
    public void canGetRightColumnAndLineNumbers() {
        int columns = 101;
        int lines = 101;
        assertEquals(columns, data.getColumn());
        assertEquals(lines, data.getRow());
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
    public void canGerRightCharacterFromMaze() {
        char character = data.getMaze(2, 2);
        char wall = '#';
        assertEquals(wall, character);
    }

    @Test(expected = Exception.class)
    public void throwExceptionWhenChratersNumberInEachLineNotEqual() {
        data = new MazeData("wrongLabyrinth.txt");
    }

}
