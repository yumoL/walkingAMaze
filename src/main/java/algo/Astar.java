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
    private HashMap<Node, Integer> map; //document the index of every node

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
            if(map.containsKey(exitNode)){
                setData(exitNode.getX(),exitNode.getY(),true);
                int exitIndex=map.get(exitNode);
                exitNode.setPre(openList.getElement(exitIndex).getPre());
                findPath(exitNode);
                return true;
            }
            curNode = openList.pollElement();
            closeList.add(curNode);
            map.remove(curNode);
            setData(curNode.getX(), curNode.getY(), true);

            for (int k = 0; k < 4; k++) {
                int newX = curNode.getX() + DIRECTION[k][0];
                int newY = curNode.getY() + DIRECTION[k][1];
                checkPath(newX, newY, curNode, exitNode, COST);
            }
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
            return false;
        }

        if (closeList.contains(node)) {
            return false;
        }
        
        if (map.containsKey(node)) {
            int index=map.get(node);
            node.setG(openList.getElement(index).getG());
            if (preNode.getG() + cost < node.getG()) {
                count(node, exitNode, cost);
                openList.change(index, node);
                map.put(node, index);
            }
        } else {
            count(node, exitNode, cost);
            System.out.println("(" + node.getX() + ", " + node.getY() + ")");
            openList.add(i, node);
            map.put(node, i);
            System.out.println("i " + i);
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
