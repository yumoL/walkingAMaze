package algo.shortestPathSolver;

import data.Node;
import data.GraphData;
import graphVisualization.GraphFrame;
import util.MyQueue;

public class Bfs extends PathFindingAlgo {

    public Bfs(GraphData data, GraphFrame frame) {
        super(data, frame);
    }

    /**
     * Find a path from a certain point using DFS (without recursion)
     *
     * @return true is a path to exit was found, otherwise false
     */
    @Override
    public boolean searchWay() {
        MyQueue<Node> queue = new MyQueue<>();
        Node entrance = new Node(data.getEntranceX(), data.getEntranceY());
        queue.add(entrance);
        data.visited[entrance.getX()][entrance.getY()] = true;

        boolean hasSolution = false;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
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
                    queue.add(new Node(newX, newY, currentNode));
                    data.visited[newX][newY] = true;
                }
            }
        }
        
        return hasSolution;
    }

}
