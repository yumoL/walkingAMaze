package algo.shortestPathSolver;

import data.Node;
import data.GraphData;
import java.util.HashMap;
import java.util.HashSet;
import graphVisualization.GraphFrame;
import util.IndexPriorityQueue;
import util.MyHashMap;

/**
 * A template of A* algorithm
 */
public abstract class AstarTemplate extends PathFindingAlgo {

    private IndexPriorityQueue<Node> openList; //list of nodes to be checked
    private int i;//index which will be inserted into IndexHeap
    private HashMap<Node, Integer> map; //document the index of every node

    protected final int COST = 1;

    public AstarTemplate(GraphData data, GraphFrame frame) {
        super(data, frame);
        this.openList = new IndexPriorityQueue<>(data.getRow()*data.getColumn());
        this.i = 0;
        this.map = new HashMap<>();
    }

    @Override
    public boolean searchWay() {
        boolean findPath = astar();
        //printResult(findPath);
        return findPath;
    }

    /**
     * Find path using A* algorithm
     *
     *
     * @return true if a path has been found, otherwise false
     */
    private boolean astar() {

        Node entranceNode = new Node(data.getEntranceX(), data.getEntranceY());
        Node exitNode = new Node(data.getExitX(), data.getExitY());
        Node curNode = entranceNode;

        openList.add(i, entranceNode);
        map.put(curNode, i);
        i++;
        while (!openList.isEmpty()) {
            if (map.containsKey(exitNode)) {
                setData(exitNode.getX(), exitNode.getY(), true);
                int exitIndex = map.get(exitNode);
                exitNode=openList.getElement(exitIndex);
                findPath(exitNode);
                return true;
            }
            curNode = openList.pollElement();
            //System.out.println("extract "+curNode.getX()+","+curNode.getY()+" "+curNode.getF());
            //closeList.add(curNode);
            data.visited[curNode.getX()][curNode.getY()]=true;
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
        if (data.getMaze(x, y) == GraphData.WALL) {
            return false;
        }

//        if (closeList.contains(node)) {
//            return false;
//        }
        if(data.visited[node.getX()][node.getY()])return false;
        //System.out.println("contains (1,6) "+map.containsKey(node));
        if (map.containsKey(node)) {
            int index = map.get(node);
            //System.out.println("index "+index);
            node.setG(openList.getElement(index).getG());
            if (preNode.getG() + cost < node.getG()) {
                count(node, exitNode, cost);
                openList.change(index, node);
                map.put(node, index);
            }
        } else {
            count(node, exitNode, cost);
            openList.add(i, node);
            map.put(node, i);
            if (node.equals(exitNode)) {
                exitNode.setF(node.getF());
            }

            // System.out.println("i " + i);
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

    /**
     * Calculate the distance from entrance node to current node
     *
     * @param node current node
     * @param cost the cost which was used from previous code to current code
     */
    private void countG(Node node, int cost) {

        node.setG(node.getPre().getG() + cost);

    }

    /**
     * Calculate the total distance from entrance to exit passing the node
     *
     * @param node current code
     */
    private void countF(Node node) {
        node.setF(node.getG() + node.getH());
    }

    /**
     * Heuristic function
     *
     * @param node current node
     * @param exitNode exit node
     */
    protected abstract void countH(Node node, Node exitNode);

}
