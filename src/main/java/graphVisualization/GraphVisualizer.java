package graphVisualization;

import algo.labyrinthGenerator.DfsGenerator;
import algo.shortestPathSolver.Bfs;
import data.GraphData;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import algo.labyrinthGenerator.PrimGenerator;
import algo.shortestPathSolver.AstarWithEuclidean;
import algo.shortestPathSolver.AstarWithEuclideanSquare;
import algo.shortestPathSolver.AstarWithManhattan;

public class GraphVisualizer {
    private static int blockSide = 7;

    public GraphData data;
    private GraphFrame frame;

    private PrimGenerator primGenerator;
    private DfsGenerator dfsGenerator;

    private Bfs bfs;
    private AstarWithManhattan astarManhattan;
    private AstarWithEuclidean astarEu;
    private AstarWithEuclideanSquare astarEuSq;

    private int shortestPath;
    private int howToGenerate;

    public GraphVisualizer(int rows, int columns, int generator) {

        // initialise data
        data = new GraphData(rows, columns);
        int sceneHeight = data.getRow() * blockSide;
        int sceneWidth = data.getColumn() * blockSide;
        this.howToGenerate = generator;

        // initialise frame
        EventQueue.invokeLater(() -> {
            frame = new GraphFrame("Maze", sceneWidth, sceneHeight);

            primGenerator = new PrimGenerator(data, frame);
            dfsGenerator = new DfsGenerator(data, frame);

            //setShortestPath();
            frame.addKeyListener(new MazeKeyListener());
            new Thread(() -> {
                if (howToGenerate == 0) {
                    dfsGenerator.generateLabyrinth();
                } else if (howToGenerate == 1) {
                    primGenerator.generateLabyrinth();
                }
            }).start();
        });
    }

//    private void setShortestPath() {
//        bfs = new Bfs(data, frame);
//        bfs.searchWay();
//        shortestPath = bfs.countResult();
//        data.resetTables();
//
//    }

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
                    System.out.println("checked nodes in bfs: " + bfs.checkedNodes());
                    shortestPath=bfs.countResult();
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
                    System.out.println("checked nodes in A* using Manhattan distance: " + astarManhattan.checkedNodes());
                }).start();

            }
            if (event.getKeyChar() == 'c') {
                data.resetTables();
                astarEu = new AstarWithEuclidean(data, frame);

                new Thread(() -> {
                    long s = System.currentTimeMillis();
                    astarEu.searchWay();
                    long e = System.currentTimeMillis();
                    System.out.println("A* using Euclidean distance: " + (e - s) + "ms");
                    System.out.println("checked nodes in A* using Euclidean distance: " + astarEu.checkedNodes());
                }).start();

            }
            if (event.getKeyChar() == 'd') {
                data.resetTables();
                astarEuSq = new AstarWithEuclideanSquare(data, frame);

                new Thread(() -> {
                    long s = System.currentTimeMillis();
                    astarEuSq.searchWay();
                    long e = System.currentTimeMillis();
                    System.out.println("A* using squared Euclidian distance: " + (e - s) + "ms");
                    System.out.println("checked nodes in A* using squared Euclidean distance: " + astarEuSq.checkedNodes());
                    System.out.println("shotest "+shortestPath);
                    System.out.println(astarEuSq.findShortestPathOrNot(shortestPath));
                }).start();

            }

        }
    }
}