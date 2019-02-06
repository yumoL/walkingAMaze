package algo.shortestPathSolver;

import data.MazeData;
import mazeVisualisation.MazeFrame;

public class AstarWithEuclidian extends AstarTemplate {

    public AstarWithEuclidian(MazeData data, MazeFrame frame) {
        super(data, frame);
    }

    /*
    Implement heuristic function using Euclidian distance
     */
    @Override
    protected void countH(Node node, Node exitNode) {
        int hSquare = (node.getX() - exitNode.getX()) * (node.getX() - exitNode.getX()) + (node.getY() - exitNode.getY()) * (node.getY() - exitNode.getY());
        int h = (int) Math.sqrt(hSquare) * COST;
        node.setH(h);
    }

}
