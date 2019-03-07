package data;

/**
 * Data of a graph
 */
public class GraphData {

    public static final char ROAD = ' ';
    public static final char WALL = '#';

    private int rows, columns;
    public char[][] graph;

    private int entranceX, entranceY;
    private int exitX, exitY;

    /**
     * visited[i][j]=true if the node(i,j)has already been visited
     */
    public boolean visited[][];

    /**
     * path[i][j]=true if the node(i,j) probably belongs to the final path found
     * by an algorithm
     */
    public boolean path[][];

    /**
     * result[i][j]=true if node(i,j)is on the final path
     */
    public boolean result[][];

    public GraphData(int rows, int columns) {

        if (rows % 2 == 0 || columns % 2 == 0) {
            throw new IllegalArgumentException("The numbers of the row and the column should be odd ");
        }

        this.rows = rows;
        this.columns = columns;

        graph = new char[rows][columns];
        visited = new boolean[rows][columns];
        path = new boolean[rows][columns];
        result = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    graph[i][j] = ROAD;
                } else {
                    graph[i][j] = WALL;
                }
            }
        }

        entranceX = 1;
        entranceY = 0;
        exitX = rows - 2;
        exitY = columns - 1;

        graph[entranceX][entranceY] = ROAD;
        graph[exitX][exitY] = ROAD;
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

    /**
     * Determine if node(x,y) is inside the graph
     *
     * @param x the x-coordinate of the node
     * @param y the y-coordinate of the node
     * @return true if the node is inside the graph, otherwise false
     */
    public boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

    /**
     * get certain character of the graph
     *
     * @param i the x-coordinate of the character in the graph
     * @param j the y-coordinate of the character in the graph
     * @return character whose x-coordinate is i and y-coordinate is j in the
     * graph
     */
    public char getGraph(int i, int j) {
        if (!inArea(i, j)) {
            throw new IllegalArgumentException("i or j out of index");
        }
        return graph[i][j];
    }

    /**
     * initialise tables
     */
    public void resetTables() {
        visited = new boolean[rows][columns];
        path = new boolean[rows][columns];
        result = new boolean[rows][columns];
    }
}
