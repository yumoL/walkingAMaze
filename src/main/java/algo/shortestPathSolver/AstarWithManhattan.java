/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.shortestPathSolver;

import data.GraphData;
import graphVisualization.GraphFrame;

public class AstarWithManhattan extends AstarTemplate {

    public AstarWithManhattan(GraphData data, GraphFrame frame) {
        super(data, frame);
    }

    /*
    Implement heuristic function using Manhattan distance
     */
    @Override
    protected void countH(Node node, Node exitNode) {
        node.setH((Math.abs(node.getX() - exitNode.getX()) + Math.abs(node.getY()
                - exitNode.getY())) * COST);
    }

}
