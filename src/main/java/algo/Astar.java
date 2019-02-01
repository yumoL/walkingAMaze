package algo;

import data.MazeData;
import java.util.HashMap;
import java.util.HashSet;
import mazeVisualisation.MazeFrame;
import util.IndexPriorityQueue;

public class Astar extends PathFindingAlgo {

    private IndexPriorityQueue<Node> openList; //list of nodes to be checked
    private HashSet<Node> closeList; //list where nodes have already been checked
    private int i;//index which will be inserted into IndexHeap
    private HashMap<Node, Integer> map;

    private final int COST = 1;

    public Astar(MazeData data, MazeFrame frame) {
        super(data, frame);
        this.openList = new IndexPriorityQueue<>(data.getColumn() * data.getRow());
        this.closeList = new HashSet<>();
        this.i = 0;
        this.map = new HashMap<>();
    }

    @Override
    public boolean searchWay() {
        boolean findPath = astar();
        printResult(findPath);
        return findPath;
    }

    /**
     * Find path using a
     *
     *
     * @return true if a path has been found, otherwise false
     */
    public boolean astar() {

        Node entranceNode = new Node(data.getEntranceX(), data.getEntranceY());
        Node exitNode = new Node(data.getExitX(), data.getExitY());
        Node curNode = entranceNode;

        openList.add(i, entranceNode);
        map.put(curNode, i);
        i++;
        while (!openList.isEmpty()) {        
            curNode = openList.pollElement();
            setData(curNode.getX(), curNode.getY(), true);
            if (curNode.equals(exitNode)) {
                findPath(curNode);
                return true;
            }

            for (int k = 0; k < 4; k++) {
                int newX = curNode.getX() + DIRECTION[k][0];
                int newY = curNode.getY() + DIRECTION[k][1];
                checkPath(newX, newY, curNode, exitNode, COST);
            }

            closeList.add(curNode);
        }

        return false;

    }

    /**
     * Check if node(x,y) is on the path and update cost if it's needed
     *
     * @param x x-coordinate of the node
     * @param y y-coordinate of the node
     * @param preNode parent node of the node
     * @param exitNode exit
     * @param cost cost from parent node to current node
     * @return true if node(x,y) is on the path, otherwise false
     */
    private boolean checkPath(int x, int y, Node preNode, Node exitNode,
            int cost) {
        Node node = new Node(x, y, preNode);
        
        if (!data.inArea(x, y)) {
            return false;
        }
        if (data.getMaze(x, y) == MazeData.WALL) {
            closeList.add(node);
            return false;
        }

        if (closeList.contains(new Node(x, y))) {
            return false;
        }
        int index = map.getOrDefault(new Node(x, y), -1);
        if (index != -1) {
            node.setG(openList.getElement(index).getG());
            if (preNode.getG() + cost < node.getG()) {
                count(node, exitNode, cost);
                openList.change(index, node);

            }
        } else {
            count(node, exitNode, cost);
            openList.add(i, node);
            map.put(node, i);
            i++;
        }

        return true;
    }

    /**
     * Calculate g,h,f, g is the distance from entrance node to current node,h
     * is the distance from current node to exit node, f=g+h
     *
     * @param node current node
     * @param exitNode exit
     * @param cost cost from parent node to current node
     */
    private void count(Node node, Node exitNode, int cost) {
        countG(node, cost);
        countH(node, exitNode);
        countF(node);
    }

    // Calculate the distance from entrance node to current node
    private void countG(Node node, int cost) {

        node.setG(node.getPre().getG() + cost);

    }

    // Calculate the estimated distance from current node to exit node uing Manhanttan distance
    private void countH(Node node, Node exitNode) {
        node.setH((Math.abs(node.getX() - exitNode.getX()) + Math.abs(node.getY()
                - exitNode.getY())) * COST);
    }

    // Calculate the total distance from entrance to exit passing the node
    private void countF(Node node) {
        node.setF(node.getG() + node.getH());
    }

}
