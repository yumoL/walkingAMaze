package graphVisualization;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Some functions used in visualisation
 */
public class VisualizationHelper {

    /**
     * Set colours to the graphics
     *
     * @param g Graphics used in the visualisation
     * @param color the colour set to the graphics
     */
    public static void setColor(Graphics2D g, Color color) {
        g.setColor(color);
    }

    /**
     * Draw a solid rectangle
     *
     * @param g Graphics used in the visualisation
     * @param x the x-coordination of the rectangle
     * @param y the y-coordination of the rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public static void fillRectangle(Graphics2D g, int x, int y, int width, int height) {
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, width, height);
        g.fill(rectangle);
    }

}
