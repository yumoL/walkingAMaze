package algo.shortestPathSolver;

import data.Node;
import data.GraphData;
import graphVisualization.GraphFrame;

/**
 * An abstract class for different path finding algorithms
 *
 */
public abstract class PathFindingAlgo {

    public GraphData data;
    protected GraphFrame frame;
    protected static final int DIRECTION[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public PathFindingAlgo(GraphData data, GraphFrame frame) {
        this.data = data;
        this.frame = frame;
    }

    /**
     * Find the path from exit back to entrance. This will be used when marking
     * the path in the graph
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
    }

    /**
     * Define if it's possible to access the exit through this point
     *
     * @param x x-coordinate of the point
     * @param y y-coordinate of the point
     * @return true if the point is in the area of the graph and it's a road and
     * it hasn't be visited yet. Otherwise false
     */
    public boolean access(int x, int y) {
        return data.inArea(x, y)
                && !data.visited[x][y] && data.getGraph(x, y) == GraphData.ROAD;
    }

    /**
     * count how many roads were expanded during the path finding
     *
     * @return the number of expanded roads
     */
    public int countExpandedRoads() {
        int checked = 0;
        for (int i = 0; i < data.getRow(); i++) {
            for (int j = 0; j < data.getColumn(); j++) {
                if (data.path[i][j]) {
                    checked++;
                }
            }
        }
        return checked;
    }

    /**
     * count how many nodes are on the path
     *
     * @return the length of the path
     */
    public int countResult() {
        int path = 0;
        for (int i = 0; i < data.getRow(); i++) {
            for (int j = 0; j < data.getColumn(); j++) {
                if (data.result[i][j]) {
                    path++;
                }
            }
        }
        return path;
    }

    /**
     * Find path using different algorithms, will be implemented in the classes
     * of algorithms
     *
     * @return true if a path has been found, otherwise false
     */
    public abstract boolean searchWay();

}
