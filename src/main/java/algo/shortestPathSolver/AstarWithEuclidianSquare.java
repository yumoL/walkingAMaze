package algo.shortestPathSolver;

import data.MazeData;
import mazeVisualisation.MazeFrame;

public class AstarWithEuclidianSquare extends AstarTemplate {

    public AstarWithEuclidianSquare(MazeData data, MazeFrame frame) {
        super(data, frame);
    }

    /*
    Implement heuristic function using squared Euclidian distance. Using this dunction doesn't always find the shortest path
     */
    @Override
    protected void countH(Node node, Node exitNode) {
        int hSquare = (node.getX() - exitNode.getX()) * (node.getX() - exitNode.getX()) + (node.getY() - exitNode.getY()) * (node.getY() - exitNode.getY());
        node.setH(hSquare);
    }

}
