package data;

/**
 * Data of a maze
 */
public class GraphData{

    public static final char ROAD = ' ';
    public static final char WALL = '#';

    private int rows, columns;
    public char[][] maze;

    private int entranceX, entranceY;
    private int exitX, exitY;
    
    public boolean visited[][];
    public boolean path[][];
    public boolean result[][];

    public GraphData(int rows, int columns) {

        if (rows % 2 == 0 || columns % 2 == 0) {
            throw new IllegalArgumentException("The numbers of the row and the column should be odd ");
        }

        this.rows = rows;
        this.columns = columns;

        maze = new char[rows][columns];
        visited=new boolean[rows][columns];
        path=new boolean[rows][columns];
        result=new boolean[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    maze[i][j] = ROAD;
                } else {
                    maze[i][j] = WALL;
                }
            }
        }

        entranceX = 1;
        entranceY = 0;
        exitX = rows - 2;
        exitY = columns - 1;

        maze[entranceX][entranceY] = ROAD;
        maze[exitX][exitY] = ROAD;
    }

    public int getRow() {
        return rows;
    }

    public int getColumn() {
        return columns;
    }

    public int getEntranceX() {
        return entranceX;
    }

    public int getEntranceY() {
        return entranceY;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }
    
    public boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }
    
    /**
     * get certain character of the maze
     *
     * @param i the x-coordinate of the character in the maze
     * @param j the y-coordinate of the character in the maze
     * @return character whose x-coordinate is i and y-coordinate is j in the
     * maze
     */
    public char getMaze(int i, int j) {
        if (!inArea(i, j)) {
            throw new IllegalArgumentException("i or j out of index");
        }
        return maze[i][j];
    }
    
    
    
    //Initialise tables
    public void resetTables() {
        visited = new boolean[rows][columns];
        path = new boolean[rows][columns];
        result = new boolean[rows][columns];
    }
}