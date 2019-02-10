package algo.labyrinthGenerator;

import data.Node;
import data.GraphData;
import graphVisualization.GraphFrame;
import util.RandomQueue;

public class DfsGenerator extends Generator {

    private RandomQueue<Node> queue;

    public DfsGenerator(GraphData data, GraphFrame frame) {
        super(data, frame);
        this.queue = new RandomQueue<>();
    }

    @Override
    public void generateLabyrinth() {
        setRoadData(-1, -1);
        Node first = new Node(data.getEntranceX(), data.getEntranceY() + 1);
        queue.add(first);
        data.visited[first.getX()][first.getY()] = true;

        while (queue.size() != 0) {
            Node curPos = queue.remove();

            for (int i = 0; i < 4; i++) {
                int newX = curPos.getX() + DIRECTION[i][0] * 2;
                int newY = curPos.getY() + DIRECTION[i][1] * 2;

                if (data.inArea(newX, newY)
                        && !data.visited[newX][newY]
                        && data.graph[newX][newY] == GraphData.ROAD) {
                    queue.add(new Node(newX, newY));
                    data.visited[newX][newY] = true;
                    setRoadData(curPos.getX() + DIRECTION[i][0], curPos.getY() + DIRECTION[i][1]);
                }
            }
        }
        breakMoreWalls();
        setRoadData(-1, -1);
    }

    @Override
    protected void breakMoreWalls() {
        for (int i = 0; i < data.getColumn() * data.getRow() / 1000; i++) {
            int row = (int) (Math.random() * (data.getRow() - 2)) + 1;
            int column = (int) (Math.random() * (data.getColumn() - 2)) + 1;
            if (data.graph[row][column] == GraphData.WALL) {
                setRoadData(row, column);

            }
        }
    }

}
