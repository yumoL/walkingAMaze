package mazeVisualisation;

import data.MazeData;
import java.awt.*;
import javax.swing.*;

/**
 * Create the window with a canvas
 */
public class MazeFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;
    private MazeData data;

    /**
     * Create the canvas
     */
    private class MazeCanvas extends JPanel {

        public MazeCanvas() {
            //double buffering
            super(true);
        }

        /**
         * draw the maze on the canvas using Graphics
         *
         * @param g the Graphics which will be used to draw the walls and the
         * roads of the maze and set colours to the them
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);

            Graphics2D graphic2D = (Graphics2D) g;

            int width = canvasWidth / data.getColumn();
            int height = canvasHeight / data.getLine();

            for (int i = 0; i < data.getLine(); i++) {
                for (int j = 0; j < data.getColumn(); j++) {
                    if (data.getMaze(i, j) == MazeData.WALL) {
                        VisualizationHelper.setColor(graphic2D, Color.BLUE);
                    } else {
                        VisualizationHelper.setColor(graphic2D, Color.WHITE);
                    }
                    VisualizationHelper.fillRectangle(graphic2D, j * width, i * height, width, height);
                }
            }
        }
    }

    /**
     * Initialise the window with a canvas
     *
     * @param title the title shown on the top of the window
     * @param canvasWidth the width of the canvas
     * @param canvasHeight the height of the canvas
     */
    public MazeFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        MazeCanvas canvas = new MazeCanvas();
        this.setContentPane(canvas);
        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setSize(getPreferredDimension());
        this.setVisible(true);
    }

    public int getCanvasWidth() {
        return this.canvasWidth;
    }

    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    /**
     * The logic of the animation
     *
     * @param data the data of the maze which will be visualised
     */
    public void render(MazeData data) {
        this.data = data;
        this.repaint();
    }

    /**
     * Get the size of the window, which will be a bit larger than the size of
     * the canvas
     *
     * @return a Dimension which includes the width and height of the window
     */
    public Dimension getPreferredDimension() {
        return new Dimension(canvasWidth + 20, canvasHeight + 25);
    }
}
