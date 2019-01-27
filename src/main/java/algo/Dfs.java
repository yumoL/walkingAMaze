
package algo;

import data.MazeData;
import java.util.Stack;
import mazeVisualisation.MazeFrame;


public class Dfs extends PathFindingAlgo {
    
    public Dfs(MazeData data,MazeFrame frame){
        super(data,frame);
    }
    
    @Override
    public boolean searchWay() {
        boolean findPath=dfsWithRecursion(data.getEntranceX(),data.getEntranceY());
        printResult(findPath);
        return findPath;
    }
    
    /**
     * Find a path from a certain point using DFS (with recursion)
     *
     * @param x x-coordinate of the point
     * @param y y-coordinate of the point
     * @return true is a path to exit was found, otherwise false
     */
    private boolean dfsWithRecursion(int x, int y) {
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
    public boolean searchWayWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node entrance = new Node(data.getEntranceX(), data.getEntranceY());
        stack.push(entrance);
        data.visited[entrance.getX()][entrance.getY()] = true;

        boolean hasSolution = false;

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            setData(currentNode.getX(), currentNode.getY(), true);

            if (currentNode.getX() == data.getExitX() && currentNode.getY() == data.getExitY()) {
                hasSolution = true;
                findPath(currentNode);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = currentNode.getX() + DIRECTION[i][0];
                int newY = currentNode.getY() + DIRECTION[i][1];

                if (access(newX, newY)) {
                    stack.push(new Node(newX, newY, currentNode));
                    data.visited[newX][newY] = true;

                }
            }

        }
        printResult(hasSolution);
        return hasSolution;
    }


    
}
