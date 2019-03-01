package performanceComparison;

import algo.labyrinthGenerator.DfsGenerator;
import algo.labyrinthGenerator.PrimGenerator;
import algo.shortestPathSolver.AstarWithEuclidean;
import algo.shortestPathSolver.AstarWithEuclideanSquare;
import algo.shortestPathSolver.AstarWithManhattan;
import algo.shortestPathSolver.Bfs;
import data.GraphData;
import graphVisualization.GraphFrame;
import graphVisualization.GraphVisualizer;

/**
 * Compare the performance of different path finding algorithms
 */
public class Comparator {

    private Bfs bfs;
    private AstarWithManhattan astarManhattan;
    private AstarWithEuclidean astarEu;
    private AstarWithEuclideanSquare astarEuSq;
    private GraphData data;
    private GraphFrame frame;
    private PrimGenerator primGen;
    private DfsGenerator dfsGen;
    private int shortest;

    public Comparator(int rows, int columns, String generate) {
        data = new GraphData(rows, columns);
        frame = new GraphFrame(null, 0, 0);

        dfsGen = new DfsGenerator(data, frame);
        primGen = new PrimGenerator(data, frame);
        if (generate.equals(GraphVisualizer.DFS)) {
            dfsGen.generateLabyrinth();
        } else if (generate.equals(GraphVisualizer.PRIM)) {
            primGen.generateLabyrinth();
        }
    }

    /**
     * Test the efficiency of bfs
     */
    public void testBfs() {
        int expandedRoads = 0;
        long time = 0;
        for (int i = 0; i < 10; i++) {
            bfs = new Bfs(data, frame);
            long start = System.currentTimeMillis();
            if (bfs.searchWay()) {
                long end = System.currentTimeMillis();
                time += (end - start);
            }
            if (i == 9) {
                expandedRoads = bfs.countExpandedRoads();
                shortest = bfs.countResult();
            }
            data.resetTables();

        }
        System.out.println("Bfs average time: " + time / 10 + " ms");
        System.out.println("Expanded roads in Bfs: " + expandedRoads);
        frame.dispose();

    }

    /**
     * Test the efficiency of A* when using Manhattan distance as heuristic
     * function
     */
    public void testAstarManhattan() {
        int expandedRoads = 0;
        long time = 0;
        for (int i = 0; i < 10; i++) {
            astarManhattan = new AstarWithManhattan(data, frame);
            long start = System.currentTimeMillis();
            if (astarManhattan.searchWay()) {
                long end = System.currentTimeMillis();
                time += (end - start);
            }
            if (i == 9) {
                expandedRoads = astarManhattan.countExpandedRoads();
            }
            data.resetTables();

        }
        System.out.println("Astar with Manhattan average time: " + time / 10 + " ms");
        System.out.println("Expanded roads in astar with Manhattan: " + expandedRoads);
        frame.dispose();

    }

    /**
     * Test the efficiency of A* when using Euclidean distance as heuristic
     * function
     */
    public void testAstarEu() {
        int expandedRoads = 0;
        long time = 0;
        for (int i = 0; i < 10; i++) {
            astarEu = new AstarWithEuclidean(data, frame);
            long start = System.currentTimeMillis();
            if (astarEu.searchWay()) {
                long end = System.currentTimeMillis();
                time += (end - start);
            }
            if (i == 9) {
                expandedRoads = astarEu.countExpandedRoads();
            }
            data.resetTables();

        }
        System.out.println("Astar with Euclidean average time: " + time / 10 + " ms");
        System.out.println("Expanded roads in astar with Euclidean: " + expandedRoads);
        frame.dispose();

    }

    /**
     * Test the efficiency of A* when using squared Euclidean distance as
     * heuristic function
     */
    public void testAstarSquaredEu() {
        int expandedRoads = 0;
        long time = 0;
        for (int i = 0; i < 10; i++) {
            astarEuSq = new AstarWithEuclideanSquare(data, frame);
            long start = System.currentTimeMillis();// for smaller size such as 51x51, use nonoTime
            if (astarEuSq.searchWay()) {
                long end = System.currentTimeMillis();
                time += (end - start);
            }
            if (i == 9) {
                expandedRoads = astarEuSq.countExpandedRoads();
                break;
            }
            data.resetTables();

        }
        System.out.println("Astar with squared Euclidean average time: " + time / 10 + " ms");
        System.out.println("Expanded roads in astar with squared Euclidean: " + expandedRoads);
        System.out.println("shortest: " + shortest);
        System.out.println(astarEuSq.findShortestPathOrNot(shortest));
        frame.dispose();

    }

    public static void main(String[] args) {
        Comparator comp = new Comparator(1001/*rows*/, 1001/*columns*/, "dfs"/*how to generate dfs=DFS and prim=Prim*/);
        comp.testBfs();
        comp.testAstarManhattan();
        comp.testAstarEu();
        comp.testAstarSquaredEu();

    }
}
