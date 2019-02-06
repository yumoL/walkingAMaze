package algo;

import algo.shortestPathSolver.Node;
import data.MazeData;
import java.util.Random;
import mazeVisualisation.MazeFrame;
import mazeVisualisation.VisualizationHelper;
import util.MyArrayList;

/**
 * Use randomized Prim to generate a labyrinth
 */
public class PrimGenerator {

    protected MazeData data;
    protected MazeFrame frame;
    protected final int DELAY = 0;
    protected static final int DIRECTION[][] = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    private int markNode[][];
    private MyArrayList<Node> walls;
    private final int VISITED_ROAD = 3;//the road has been visited or a wall has been broken into a road
    private final int NON_VISITED_ROAD = 1; //the road has not been visited
    private final int WALL = 0;
    private Random r;

    public PrimGenerator(MazeData data, MazeFrame frame) {
        this.data = data;
        this.frame = frame;

        r = new Random();
        walls = new MyArrayList<>();
        markNode = new int[data.getRow()][data.getColumn()];
        for (int i = 0; i < data.getRow(); i++) {
            for (int j = 0; j < data.getColumn(); j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    markNode[i][j] = NON_VISITED_ROAD;
                } else {
                    markNode[i][j] = WALL;
                }
            }
        }
    }

    /**
     * Mark node(x,y) as road
     */
    private void setRoadData(int x, int y) {
        if (data.inArea(x, y)) {
            data.maze[x][y] = MazeData.ROAD;
        }
        frame.render(data);
        VisualizationHelper.pause(DELAY);
    }

    /**
     * By using randomized Prim we have a smallest spanning tree, by breaking
     * more walls we can have a graph with circle thus the maze has more than
     * one solution
     */
    private void breakMoreWalls() {
        for (int i = 0; i < data.getColumn() * data.getRow() / 20; i++) {
            int row = (int) (Math.random() * (data.getRow() - 2)) + 1;
            int column = (int) (Math.random() * (data.getColumn() - 2)) + 1;
            if (data.maze[row][column] == MazeData.WALL) {
                setRoadData(row, column);

            }
        }
    }

    /**
     * Generate a labyrinth
     */
    public void generateLabyrinth() {
        setRoadData(-1, -1);
        markNode[data.getEntranceX()][data.getEntranceY()] = VISITED_ROAD;
        markNode[data.getExitX()][data.getExitY()] = VISITED_ROAD;

        Node from = new Node(data.getEntranceX(), data.getEntranceY() + 1);
        markNode[from.getX()][from.getY()] = VISITED_ROAD;

        for (int i = 0; i < 4; i++) {
            int newX = from.getX() + DIRECTION[i][0];
            int newY = from.getY() + DIRECTION[i][1];
            if (valuable(newX, newY)) {
                Node wall = new Node(newX, newY, from);
                walls.addLast(wall);
            }
        }

        while (!walls.isEmpty()) {
            int index = r.nextInt(walls.size());

            Node wall = walls.remove(index);

            int deltaX = wall.getX() - wall.getPre().getX();
            int deltaY = wall.getY() - wall.getPre().getY();
            Node next = new Node(wall.getX() + deltaX, wall.getY() + deltaY);

            if (markNode[next.getX()][next.getY()] == NON_VISITED_ROAD) {
                markNode[next.getX()][next.getY()] = VISITED_ROAD;
                markNode[wall.getX()][wall.getY()] = VISITED_ROAD;
                from = next;
            } else {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int newX = from.getX() + DIRECTION[i][0];
                int newY = from.getY() + DIRECTION[i][1];
                if (valuable(newX, newY)) {
                    wall = new Node(newX, newY, from);
                    walls.addLast(wall);
                }
            }

        }

        for (int i = 0; i < data.getRow(); i++) {
            for (int j = 0; j < data.getColumn(); j++) {
                if (markNode[i][j] == VISITED_ROAD) {
                    setRoadData(i, j);
                }
            }
        }
        breakMoreWalls();
    }

    /**
     * Define if a wall is inside the maze, which means the x-coordinate of the
     * wall should in [1,the number of rows of the maze-2] and the y-coordinate
     * of the wall should in [1,the number of columns of the maze-2]
     *
     * @param x the x-coordinate of the wall
     * @param y the y-coordinate of the wall
     * @return true if the wall is inside, otherwise false
     */
    private boolean valuable(int x, int y) {
        return x > 0 && x < data.getRow() - 1 && y > 0 && y < data.getColumn() - 1;

    }

}
