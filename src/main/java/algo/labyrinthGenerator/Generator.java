package algo.labyrinthGenerator;

import data.GraphData;
import graphVisualization.GraphFrame;

public abstract class Generator {

    protected GraphData data;
    protected GraphFrame frame;
    protected final int DELAY = 0;
    protected static final int DIRECTION[][] = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    public Generator(GraphData data, GraphFrame frame) {
        this.data = data;
        this.frame = frame;
    }

    /**
     * Mark node(x,y) as road
     */
    protected void setRoadData(int x, int y) {
        if (data.inArea(x, y)) {
            data.graph[x][y] = GraphData.ROAD;
        }
        frame.render(data);
    }

    /**
     * Change more walls into road so that we have circles in the spanning tree.
     * Therefore, the generated labyrinth has more than one solutions
     */
    protected abstract void breakMoreWalls();

    /**
     * Generate labyrinth using different algorithms
     */
    public abstract void generateLabyrinth();
}
