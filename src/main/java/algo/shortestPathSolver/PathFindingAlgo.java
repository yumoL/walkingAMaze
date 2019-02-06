package algo.shortestPathSolver;

import data.MazeData;
import mazeVisualisation.MazeFrame;
import mazeVisualisation.VisualizationHelper;

/**
 * An abstract class for different path finding algorithms
 *
 */
public abstract class PathFindingAlgo {

    public MazeData data;
    protected MazeFrame frame;
    protected int delay;
    protected static final int DIRECTION[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public PathFindingAlgo(MazeData data, MazeFrame frame) {
        this.data = data;
        this.frame = frame;
        this.delay = 0;
    }

    /**
     * Find the path from exit back to entrance. This will be used when marking
     * the path in the maze
     *
     * @param destination exit point
     */
    public void findPath(Node destination) {
        Node current = destination;
        while (current != null) {
            data.result[current.getX()][current.getY()] = true;
            current = current.getPre();
        }
    }

    /**
     * Document whether a point is on the path
     *
     * @param x x-coordinate of the node
     * @param y y-coordinate of the node
     * @param isPath if the point is a path, isPath=true, otherwise isPath=false
     */
    public void setData(int x, int y, boolean isPath) {

        if (data.inArea(x, y)) {
            data.path[x][y] = isPath;
        }

        frame.render(data);

        VisualizationHelper.pause(delay);
    }

    public void setDelay(int t) {
        this.delay = t;
    }

    /**
     * Define if it's possible to access the exit through this point
     *
     * @param x x-coordinate of the point
     * @param y y-coordinate of the point
     * @return true if the point is in the area of the maze and it's a road and
     * it hasn't be visited yet. Otherwise false
     */
    public boolean access(int x, int y) {
        return data.inArea(x, y)
                && !data.visited[x][y]&& data.getMaze(x, y) == MazeData.ROAD;
    }

    /**
     * Print the result of the path finding
     *
     * @param hasPath If a path has been found, hasPath=true, otherwise
     * hasPath=false
     */
    public void printResult(boolean hasPath) {
        if (hasPath) {
            System.out.println("Path has been found");
        } else {
            System.out.println("This maze has no solution");
        }
    }

    /**
     * Find path using different algorithms, will be implemented in the classes
     * of algorithms
     *
     * @return true if a path has been found, otherwise false
     */
    public abstract boolean searchWay();

}
