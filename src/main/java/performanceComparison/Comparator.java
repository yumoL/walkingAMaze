package performanceComparison;

import algo.labyrinthGenerator.DfsGenerator;
import algo.labyrinthGenerator.PrimGenerator;
import algo.shortestPathSolver.AstarWithEuclidean;
import algo.shortestPathSolver.AstarWithEuclideanSquare;
import algo.shortestPathSolver.AstarWithManhattan;
import algo.shortestPathSolver.Bfs;
import data.GraphData;
import graphVisualization.GraphFrame;

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
    private final int USE_DFS = 0;
    private final int USE_PRIM = 1;
    private int shortest;

    public Comparator(int rows, int columns, int generate) {
        data = new GraphData(rows, columns);
        frame = new GraphFrame(null, 0, 0);

        dfsGen = new DfsGenerator(data, frame);
        primGen = new PrimGenerator(data, frame);
        if (generate == USE_DFS) {
            dfsGen.generateLabyrinth();
        } else if (generate == USE_PRIM) {
            primGen.generateLabyrinth();
        }
    }

    /**
     * Test the efficiency of bfs
     */
    public void testBfs() {
        int checkedNodes = 0;
        long time = 0;
        for (int i = 0; i < 10; i++) {
            bfs = new Bfs(data, frame);
            long start = System.currentTimeMillis();
            if (bfs.searchWay()) {
                long end = System.currentTimeMillis();
                time += (end - start);
            }
            if (i == 9) {
                checkedNodes = bfs.checkedNodes();
                shortest = bfs.countResult();
            }
            data.resetTables();

        }
        System.out.println("Bfs average time: " + time / 10 + " ms");
        System.out.println("Checked nodes in Bfs: " + checkedNodes);
        frame.dispose();

    }

    /**
     * Test the efficiency of A* when using Manhattan distance as heuristic
     * function
     */
    public void testAstarManhattan() {
        int checkedNodes = 0;
        long time = 0;
        for (int i = 0; i < 10; i++) {
            astarManhattan = new AstarWithManhattan(data, frame);
            long start = System.currentTimeMillis();
            if (astarManhattan.searchWay()) {
                long end = System.currentTimeMillis();
                time += (end - start);
            }
            if (i == 9) {
                checkedNodes = astarManhattan.checkedNodes();
            }
            data.resetTables();

        }
        System.out.println("Astar with Manhattan average time: " + time / 10 + " ms");
        System.out.println("Checked nodes in astar with Manhattan: " + checkedNodes);
        frame.dispose();

    }

    /**
     * Test the efficiency of A* when using Euclidean distance as heuristic
     * function
     */
    public void testAstarEu() {
        int checkedNodes = 0;
        long time = 0;
        for (int i = 0; i < 10; i++) {
            astarEu = new AstarWithEuclidean(data, frame);
            long start = System.currentTimeMillis();
            if (astarEu.searchWay()) {
                long end = System.currentTimeMillis();
                time += (end - start);
            }
            if (i == 9) {
                checkedNodes = astarEu.checkedNodes();
            }
            data.resetTables();

        }
        System.out.println("Astar with Euclidean average time: " + time / 10 + " ms");
        System.out.println("Checked nodes in astar with Euclidean: " + checkedNodes);
        frame.dispose();

    }
    
    /**
     * Test the efficiency of A* when using squared Euclidean distance as heuristic
     * function
     */
    public void testAstarSquaredEu() {
        int checkedNodes = 0;
        long time = 0;
        for (int i = 0; i < 10; i++) {
            astarEuSq = new AstarWithEuclideanSquare(data, frame);
            long start = System.currentTimeMillis();
            if (astarEuSq.searchWay()) {
                long end = System.currentTimeMillis();
                time += (end - start);
            }
            if (i == 9) {
                checkedNodes = astarEuSq.checkedNodes();
            }
            data.resetTables();

        }
        System.out.println("Astar with squared Euclidean average time: " + time / 10 + " ms");
        System.out.println("Checked nodes in astar with squared Euclidean: " + checkedNodes);
        System.out.println("shortest: " + shortest);
        System.out.println(astarEuSq.findShortestPathOrNot(shortest));
        frame.dispose();

    }

    public static void main(String[] args) {
        Comparator comp = new Comparator(1001, 1001, 0);
        comp.testBfs();
        comp.testAstarManhattan();
        comp.testAstarEu();
        comp.testAstarSquaredEu();

    }
}
