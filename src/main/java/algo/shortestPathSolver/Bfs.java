
package algo;

import data.MazeData;
import java.util.LinkedList;
import mazeVisualisation.MazeFrame;


public class Bfs extends PathFindingAlgo{
    
    public Bfs(MazeData data,MazeFrame frame){
        super(data,frame);
    }

    /**
     * Find a path from a certain point using DFS (without recursion)
     *
     * @return true is a path to exit was found, otherwise false
     */
    @Override
    public boolean searchWay() {
        LinkedList<Node> queue = new LinkedList<>();
        Node entrance = new Node(data.getEntranceX(), data.getEntranceY());
        queue.addLast(entrance);
        data.visited[entrance.getX()][entrance.getY()] = true;

        boolean hasSolution = false;

        while (!queue.isEmpty()) {
            Node currentNode = queue.pop();
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
                    queue.addLast(new Node(newX, newY, currentNode));
                    data.visited[newX][newY] = true;
                }
            }
        }
        printResult(hasSolution);
        return hasSolution;
    }
    
}
