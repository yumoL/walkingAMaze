package mazeVisualisation;


import algo.MazeSolver;
import data.MazeData;
import java.awt.EventQueue;

/**
 * Visualise the maze
 */
public class MazeSolverVisualizer {

    private static int DELAY = 0;
    private static int blockSide = 8;

    private int method = 1;

    private MazeData data;
    private MazeFrame frame;

    private MazeSolver solver;
    

    public MazeSolverVisualizer(String mazeFile) {

        //initialise the maze data
        data = new MazeData(mazeFile);
        int sceneHeight = data.getRow() * blockSide;
        int sceneWidth = data.getColumn() * blockSide;

        //initialise the window and the canvas
        EventQueue.invokeLater(() -> {
            frame = new MazeFrame("Walking The Maze", sceneWidth, sceneHeight);
            solver = new MazeSolver(data, frame);
            
            new Thread(() -> {
                run();
            }).start();
        });

    }

    /**
     * Show the process of path finding
     */
    public void run() {

        solver.setData(-1, -1, false);
        if (method == 1) {
            data.resetTables();
            if (!solver.dfsWithRecursion(data.getEntranceX(), data.getEntranceY())) {
                System.out.println("The maze has no solution");
            }
        }
        if (method == 2) {
            data.resetTables();
            if (!solver.dfsWithoutRecursion()) {
                System.out.println("The maze has no solution");
            }
        }

        if (method == 3) {
            data.resetTables();
            if (!solver.bfs()) {
                System.out.println("The maze has no solution");
            }
        }

//        if(method==4){
//            astar.setData(-1, -1, false);
//            data.resetTables();
//            if (!astar.searchWay()) {
//                System.out.println("The maze has no solution");
//            }
//            astar.setData(-1, -1, false);
//        }
        solver.setData(-1, -1, false);
    }

}
