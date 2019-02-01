package mazeVisualisation;

import algo.Astar;
import algo.Bfs;
import data.MazeData;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import algo.PrimGenerator;

public class MazeVisualizer {

    private static final int DELAY=0;
    private static int blockSide = 7;

    public MazeData data;
    private MazeFrame frame;
    
    private PrimGenerator primGenerator;

    private Bfs bfs;
    private Astar astar;

    public MazeVisualizer(int rows, int columns) {

        // initialise data
        data = new MazeData(rows, columns);
        int sceneHeight = data.getRow() * blockSide;
        int sceneWidth = data.getColumn() * blockSide;

        // initialise frame
        EventQueue.invokeLater(() -> {
            frame = new MazeFrame("Maze", sceneWidth, sceneHeight);
            
            primGenerator=new PrimGenerator(data,frame);
            
            bfs = new Bfs(data, frame);
            astar = new Astar(data, frame);

            frame.addKeyListener(new MazeKeyListener());
            new Thread(() -> {
                //dfsGenerator.generateMaze();
                primGenerator.generateMaze();
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
            
            if (event.getKeyChar() == 'c') {
                data.resetTables();

                new Thread(() -> {
                    long s = System.currentTimeMillis();
                    bfs.searchWay();
                    long e = System.currentTimeMillis();
                    System.out.println("bfs: " + (e - s)+"ms");
                }).start();

            }
            if (event.getKeyChar() == 'd') {
                data.resetTables();
                astar = new Astar(data, frame);

                new Thread(() -> {
                    long s = System.currentTimeMillis();
                    astar.searchWay();
                    long e = System.currentTimeMillis();
                    System.out.println("A*: " + (e - s)+"ms");
                }).start();

            }
        }
    }

}
