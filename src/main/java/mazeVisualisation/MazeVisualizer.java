package mazeVisualisation;

import data.MazeData;
import java.awt.EventQueue;

/**
 * Visualise the maze
 */
public class MazeVisualizer {

    private static int DELAY = 20;
    private static int blockSide = 8;

    private MazeData data;
    private MazeFrame frame;

    public MazeVisualizer(String mazeFile) {
        //initialise the maze data
        data = new MazeData(mazeFile);
        int sceneHeight = data.getLine() * blockSide;
        int sceneWidth = data.getColumn() * blockSide;

        //initialise the window and the canvas
        EventQueue.invokeLater(() -> {
            frame = new MazeFrame("Walking The Maze", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    /**
     * Start the animation
     */
    public void run() {
        setData();
    }

    private void setData() {
        frame.render(data);
        VisualizationHelper.pause(DELAY);
    }
}
