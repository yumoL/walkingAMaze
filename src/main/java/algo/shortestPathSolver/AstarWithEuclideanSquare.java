package algo.shortestPathSolver;

import data.GraphData;
import graphVisualization.GraphFrame;

public class AstarWithEuclideanSquare extends AstarTemplate {

    public AstarWithEuclideanSquare(GraphData data, GraphFrame frame) {
        super(data, frame);
    }

    /*
    Implement heuristic function using squared Euclidean distance. Using this dunction doesn't always find the shortest path
     */
    @Override
    protected void countH(Node node, Node exitNode) {
        int hSquare = (node.getX() - exitNode.getX()) * (node.getX() - exitNode.getX()) + (node.getY() - exitNode.getY()) * (node.getY() - exitNode.getY());
        node.setH(hSquare);
    }
    
    public String findShortestPathOrNot(int shortest){
        int difference=countResult()-shortest;
        if(difference==0){
            return "Shortest path has been found";
        }
        return "Didn't find the shortest path. Found path is "+difference+" nodes longer than the shortest path";
        
        
    }
    
   
    
  
    

}
