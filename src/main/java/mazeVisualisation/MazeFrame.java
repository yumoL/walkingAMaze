package mazeVisualisation;

import data.MazeData;
import java.awt.*;
import javax.swing.*;

public class MazeFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public MazeFrame(String title, int canvasWidth, int canvasHeight) {

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public MazeFrame(String title) {

        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    // data
    private MazeData data;

    public void render(MazeData data) {
        this.data = data;
        repaint();
    }

    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            // double buffering
            super(true);
        }

        /**
         * Generate and walk the maze on the canvas using Graphics
         *
         * @param g the Graphics which will be used to draw the walls and the
         * roads of the maze and set colours to the them
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D graphics2d = (Graphics2D) g;

            int width = canvasWidth / data.getColumn();
            int height = canvasHeight / data.getRow();

            for (int i = 0; i < data.getRow(); i++) {
                for (int j = 0; j < data.getColumn(); j++) {
                    
                    if (data.maze[i][j] == MazeData.WALL) {
                        VisualizationHelper.setColor(graphics2d, Color.BLUE);
                    } else {
                        VisualizationHelper.setColor(graphics2d, Color.WHITE);
                    }

                    if (data.path[i][j]) {
                        VisualizationHelper.setColor(graphics2d, Color.YELLOW);
                    }
                    if (data.result[i][j]) {
                        VisualizationHelper.setColor(graphics2d, Color.RED);
                    }

                    VisualizationHelper.fillRectangle(graphics2d, j * width, i * height, width, height);
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
