package algo;

import data.MazeData;
import java.util.HashMap;
import java.util.HashSet;
import mazeVisualisation.MazeFrame;
import util.IndexMinHeap;

public class Astar extends PathFindingAlgo {

    private IndexMinHeap<Node> openList; //list of nodes to checked
    private HashSet<Node> closeList; //list where nodes have already been checked
    private HashMap<Node, Integer> map; //map to document the index of a node, key=node and value = index
    private int i;//index which will be inserted into IndexHeap

    public Astar(MazeData data, MazeFrame frame) {
        super(data, frame);
        this.openList = new IndexMinHeap<>(data.getColumn() * data.getRow());
        this.closeList = new HashSet<>();
        this.map = new HashMap<>();
        this.i = 0;
    }

    @Override
    public boolean searchWay() {
        boolean findPath = astar();
        printResult(findPath);
        return findPath;
    }
    
    /**
     * Find path using a*
     * @return true if a path has been found, otherwise false
     */
    public boolean astar() {
        final int COST = 10;

        Node entranceNode = new Node(data.getEntranceX(), data.getEntranceY());
        Node exitNode = new Node(data.getExitX(), data.getExitY());
        Node curNode = entranceNode;

        openList.add(i, entranceNode);
        map.put(curNode, i);
        //System.out.println(i);
        i++;
        while (!openList.isEmpty()) {
            curNode = openList.pollElement();
            //System.out.println(curNode.getX() + ", " + curNode.getY());
            setData(curNode.getX(), curNode.getY(), true);
            // System.out.println(curNode.getX() + ", " + curNode.getY());
            if (curNode.equals(exitNode)) {
                //System.out.println("ok");
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

    private boolean checkPath(int x, int y, Node preNode, Node endPoint,
            int c) {
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

        int index = -1;
        if ((index = map.getOrDefault(new Node(x, y), -1)) != -1) {

            if ((preNode.g + c) < openList.getElement(index).g) {
                countG(node, c);
                countF(node);
                openList.change(index, node);
                map.put(node, index);
                //setData(node.getX(),node.getY(),true);
            }
        } else {

            node.setPre(preNode);
            count(node, endPoint, c);
            openList.add(i, node);
            map.put(node, i);
            //System.out.println(i);
            i++;
        }
        return true;
    }

    private void count(Node node, Node eNode, int cost) {
        countG(node, cost);
        countH(node, eNode);
        countF(node);
    }

    private void countG(Node node, int cost) {
        if (node.getPre() == null) {
            node.setG(cost);
        } else {
            node.setG(node.getPre().getG() + cost);
        }
    }

    private void countH(Node node, Node eNode) {
        node.setF((Math.abs(node.getX() - eNode.getX()) + Math.abs(node.getY()
                - eNode.getY())) * 10);
    }

    private void countF(Node node) {
        node.setF(node.getG() + node.getH());
    }

}
