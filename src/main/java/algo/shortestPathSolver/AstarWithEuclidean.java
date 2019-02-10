package algo.shortestPathSolver;

import data.Node;
import data.GraphData;
import graphVisualization.GraphFrame;

public class AstarWithEuclidean extends AstarTemplate {

    public AstarWithEuclidean(GraphData data, GraphFrame frame) {
        super(data, frame);
    }

    /*
    Implement heuristic function using Euclidean distance
     */
    @Override
    protected void countH(Node node, Node exitNode) {
        int hSquare = (node.getX() - exitNode.getX()) * (node.getX() - exitNode.getX()) + (node.getY() - exitNode.getY()) * (node.getY() - exitNode.getY());
        int h = (int) Math.sqrt(hSquare) * COST;
        node.setH(h);
    }

}
