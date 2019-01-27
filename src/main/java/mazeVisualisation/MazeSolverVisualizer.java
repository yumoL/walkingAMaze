package mazeVisualisation;

import algo.Astar;
import algo.Bfs;
import algo.Dfs;

import data.MazeData;
import java.awt.EventQueue;

/**
 * Visualise the maze
 */
public class MazeSolverVisualizer {

    private static int blockSide = 8;

    private int method = 4;

    public MazeData data;
    private MazeFrame frame;

    private Dfs dfs;
    private Bfs bfs;
    private Astar astar;

    public MazeSolverVisualizer(String mazeFile) {

        //initialise the maze data
        data = new MazeData(mazeFile);
        int sceneHeight = data.getRow() * blockSide;
        int sceneWidth = data.getColumn() * blockSide;

        //initialise the window and the canvas
        EventQueue.invokeLater(() -> {
            frame = new MazeFrame("Walking The Maze", sceneWidth, sceneHeight);
            dfs = new Dfs(data, frame);
            bfs = new Bfs(data, frame);
            astar = new Astar(data, frame);
            new Thread(() -> {
                run();
            }).start();
        });

    }

    /**
     * Show the process of path finding
     */
    public void run() {

        dfs.setData(-1, -1, false);
        if (method == 1) {
            data.resetTables();
            dfs.searchWay();
        }
        if (method == 2) {
            data.resetTables();
            dfs.searchWayWithoutRecursion();
        }

        if (method == 3) {
            data.resetTables();
            bfs.searchWay();
        }

        if (method == 4) {
            astar.searchWay();
        }
        dfs.setData(-1, -1, false);
    }

}
