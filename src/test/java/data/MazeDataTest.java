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
    
    /**
     * Should throw exception when trying to read from a maze file whose name is empty
     */
    @Test(expected = Exception.class)
    public void throwExceptionIfFilenameEmptyWhenreadingAMazeFile() {
        String emptyFilename = null;
        data = new MazeData(emptyFilename);
    }
    
    /**
     * Should throw exception when trying to read from a maze file whose name doesn't exist
     */
    @Test(expected = Exception.class)
    public void throwExceptionIfFilenameIsWrongWhenreadingAMazeFile() {
        String wrongFilename = "wrongName";
        data = new MazeData(wrongFilename);
    }
    
    /**
     * Can return the correct numbers of columns and rows
     */
    @Test
    public void canGetRightColumnAndRowNumbers() {
        int columns = 101;
        int lines = 101;
        assertEquals(columns, data.getColumn());
        assertEquals(lines, data.getRow());
    }
    
    /**
     * Should return true when the coordinate pair is in the maze
     */
    @Test
    public void returnTrueWhenCoordinatePairInMaze() {
        boolean result = data.inArea(3, 3);
        assertTrue(result);
    }
 
    /**
     * Should return false when the coordinate pair is in the outside of the maze
     */
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
    
    /**
     * Should throw exception when trying to get the coordinate pair which is in the outside of the maze
     */
    @Test(expected = Exception.class)
    public void throwExceptionIfCoordinatePairOutsideMazeWhenGettingCertainCharFromMaze() {
        char wrongCoordinates = data.getMaze(300, 300);
    }
    
    /**
     * Can get right character when given correct coordination pair
     */
    @Test
    public void canGetRightCharacterFromMaze() {
        char character = data.getMaze(2, 2);
        char wall = '#';
        assertEquals(wall, character);
        
        char character2=data.getMaze(2, 3);
        char path = ' ';
        assertEquals(path,character2);
        
    }
    
    /**
     * Should throw exception when different rows have different number of characters
     */
    @Test(expected = Exception.class)
    public void throwExceptionWhenChratersNumberInEachRowNotEqual() {
        data = new MazeData("wrongLabyrinth.txt");
    }

}
