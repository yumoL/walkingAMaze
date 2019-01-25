package algo;

import data.MazeData;
import java.util.LinkedList;
import java.util.Stack;
import mazeVisualisation.MazeFrame;
import mazeVisualisation.VisualizationHelper;

public class MazeSolver {

    private MazeData data;
    private MazeFrame frame;

    private int delay = 5;
    private static final int DIRECTION[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public MazeSolver(MazeData data, MazeFrame frame) {
        this.data = data;
        this.frame = frame;
    }

    /**
     * Find a path from a certain point using DFS (with recursion)
     *
     * @param x x-coordinate of the point
     * @param y y-coordinate of the point
     * @return true is a path to exit was found, otherwise false
     */
    public boolean dfsWithRecursion(int x, int y) {
        if (!data.inArea(x, y)) {
            throw new IllegalArgumentException("x,y are out of index");
        }
        data.visited[x][y] = true;
        setData(x, y, true);

        if (x == data.getExitX() && y == data.getExitY()) {
            findPath(new Node(data.getEntranceX(), data.getEntranceY()));
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + DIRECTION[i][0];
            int newY = y + DIRECTION[i][1];
            if (access(newX, newY)) {
                if (dfsWithRecursion(newX, newY)) {
                    findPath(new Node(newX, newY));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Find a path from a certain point using DFS (without recursion)
     *
     * @return true is a path to exit was found, otherwise false
     */
    public boolean dfsWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node entrance = new Node(data.getEntranceX(), data.getEntranceY());
        stack.push(entrance);
        data.visited[entrance.getX()][entrance.getY()] = true;

        boolean hasSolution = false;

        while (!stack.isEmpty()) {
            Node currentPosition = stack.pop();
            setData(currentPosition.getX(), currentPosition.getY(), true);

            if (currentPosition.getX() == data.getExitX() && currentPosition.getY() == data.getExitY()) {
                hasSolution = true;
                findPath(currentPosition);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = currentPosition.getX() + DIRECTION[i][0];
                int newY = currentPosition.getY() + DIRECTION[i][1];

                if (access(newX, newY)) {
                    stack.push(new Node(newX, newY, currentPosition));
                    data.visited[newX][newY] = true;

                }
            }

        }

        return hasSolution;
    }

    /**
     * Find a path from a certain point using DFS (without recursion)
     *
     * @return true is a path to exit was found, otherwise false
     */
    public boolean bfs() {
        LinkedList<Node> queue = new LinkedList<>();
        Node entrance = new Node(data.getEntranceX(), data.getEntranceY());
        queue.addLast(entrance);
        data.visited[entrance.getX()][entrance.getY()] = true;

        boolean hasSolution = false;

        while (!queue.isEmpty()) {
            Node currentPosition = queue.pop();
            setData(currentPosition.getX(), currentPosition.getY(), true);

            if (currentPosition.getX() == data.getExitX() && currentPosition.getY() == data.getExitY()) {
                hasSolution = true;
                findPath(currentPosition);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newX = currentPosition.getX() + DIRECTION[i][0];
                int newY = currentPosition.getY() + DIRECTION[i][1];

                if (access(newX, newY)) {
                    queue.addLast(new Node(newX, newY, currentPosition));
                    data.visited[newX][newY] = true;
                }
            }
        }

        return hasSolution;
    }

    /**
     * Define if it's possible to access the exit through this point
     *
     * @param x x-coordinate of the point
     * @param y y-coordinate of the point
     * @return true if the point is in the area of the maze and it's a road and
     * it hasn't be visited yet. Otherwise false
     */
    private boolean access(int x, int y) {
        return data.inArea(x, y)
                && data.getMaze(x, y) == MazeData.ROAD
                && !data.visited[x][y];
    }

    /**
     * Find the path from exit back to entrance. This will be used when marking
     * the path in the maze
     *
     * @param destination exit point
     */
    private void findPath(Node destination) {
        Node current = destination;
        while (current != null) {
            data.result[current.getX()][current.getY()] = true;
            current = current.getPre();
        }
    }

    /**
     * Document whether a point is a path
     *
     * @param x x-coordinate of the point
     * @param y y-coordinate of the point
     * @param isPath if the point is a path, isPath=true, otherwise
     * isPath=false
     */
    public void setData(int x, int y, boolean isPath) {

        if (data.inArea(x, y)) {
            data.path[x][y] = isPath;
        }

        frame.render(data);

        VisualizationHelper.pause(delay);
    }
    
    public void setDelay(int t){
        this.delay=t;
    }
}
