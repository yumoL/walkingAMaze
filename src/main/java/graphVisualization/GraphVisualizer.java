package mazeVisualisation;

import algo.shortestPathSolver.Bfs;
import data.MazeData;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import algo.PrimGenerator;
import algo.shortestPathSolver.AstarWithEuclidian;
import algo.shortestPathSolver.AstarWithEuclidianSquare;
import algo.shortestPathSolver.AstarWithManhattan;

public class MazeVisualizer {

    private static final int DELAY = 0;
    private static int blockSide = 7;

    public MazeData data;
    private MazeFrame frame;

    private PrimGenerator primGenerator;

    private Bfs bfs;
    private AstarWithManhattan astarManhattan;
    private AstarWithEuclidian astarEu;
    private AstarWithEuclidianSquare astarEuSq;

    public MazeVisualizer(int rows, int columns) {

        // initialise data
        data = new MazeData(rows, columns);
        int sceneHeight = data.getRow() * blockSide;
        int sceneWidth = data.getColumn() * blockSide;

        // initialise frame
        EventQueue.invokeLater(() -> {
            frame = new MazeFrame("Maze", sceneWidth, sceneHeight);

            primGenerator = new PrimGenerator(data, frame);

//            bfs = new Bfs(data, frame);
//            astarManhattan = new Astar(data, frame);
//            dijkstra=new Dijkstra(data,frame);
            frame.addKeyListener(new MazeKeyListener());
            new Thread(() -> {
                //dfsGenerator.generateMaze();
                primGenerator.generateLabyrinth();
            }).start();
        });
    }

    /**
     * Keyboard will be used when walking the maze. For example when pressing
     * character c program will use bfs with recursion to walk the maze
     */
    private class MazeKeyListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent event) {

            if (event.getKeyChar() == 'a') {
                data.resetTables();
                bfs = new Bfs(data, frame);
                new Thread(() -> {
                    long s = System.currentTimeMillis();
                    bfs.searchWay();
                    long e = System.currentTimeMillis();
                    System.out.println("bfs: " + (e - s) + "ms");
                }).start();

            }
            if (event.getKeyChar() == 'b') {
                data.resetTables();
                astarManhattan = new AstarWithManhattan(data, frame);

                new Thread(() -> {
                    long s = System.currentTimeMillis();
                    astarManhattan.searchWay();
                    long e = System.currentTimeMillis();
                    System.out.println("A* using Manhattan distance: " + (e - s) + "ms");
                }).start();

            }
            if (event.getKeyChar() == 'c') {
                data.resetTables();
                astarEu = new AstarWithEuclidian(data, frame);

                new Thread(() -> {
                    long s = System.currentTimeMillis();
                    astarEu.searchWay();
                    long e = System.currentTimeMillis();
                    System.out.println("A* using Euclidian distance: " + (e - s) + "ms");
                }).start();

            }
            if (event.getKeyChar() == 'd') {
                data.resetTables();
                astarEuSq = new AstarWithEuclidianSquare(data, frame);

                new Thread(() -> {
                    long s = System.currentTimeMillis();
                    astarEuSq.searchWay();
                    long e = System.currentTimeMillis();
                    System.out.println("A* using squared Euclidian distance: " + (e - s) + "ms");
                }).start();

            }

        }
    }
}
