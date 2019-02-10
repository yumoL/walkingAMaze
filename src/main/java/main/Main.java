package main;

import performanceComparison.Comparator;
import algo.shortestPathSolver.AstarWithManhattan;
import data.Node;
import data.GraphData;
import java.util.HashMap;
import java.util.HashSet;
import graphVisualization.GraphFrame;
import graphVisualization.GraphVisualizer;
import java.util.Scanner;
import util.IndexPriorityQueue;
import util.MyHashMap;

public class Main {

    public static void main(String[] args) {
        //Here's just a crude version. If you'd like to walk the labyrinth, please set the 'choose'variable as 0.
        //If you'd like to test the performance of algorithms, please set the 'choose' variable as 1
        
        //When walking the labyrinth,, press keyboard 'a' for bfs, 'b' for A* using manhattan disctance, 'c'for A* using euclidean distance and 'd' for A* using squared euclidean distance
        // please walk the labyrinth in other algorithms before using A* with squared euclidean distance
        int choose = 0;
        if (choose == 0) {
            GraphVisualizer gvis = new GraphVisualizer(501/*rows*/, 501/*columns*/, 1/*which way to generate the graph,0=dfs,1=randomized Prim*/);
        } else if (choose == 1) {
            Comparator comp = new Comparator(2001, 2001, 0);//Comparator is initialized in the same way as GraphVisualizer
            comp.testBfs();
            comp.testAstarManhattan();
        }

    }

//    public static void printMaze(char[][] m) {
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(m[i][j]);
//            }
//            System.out.println("");
//        }
//    }
}
