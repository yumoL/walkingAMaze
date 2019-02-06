package maze;


import algo.shortestPathSolver.AstarWithManhattan;
import algo.shortestPathSolver.Node;
import data.MazeData;
import java.util.HashMap;
import java.util.HashSet;
import mazeVisualisation.MazeFrame;
import mazeVisualisation.MazeVisualizer;
import util.IndexPriorityQueue;
import util.MyHashMap;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int rows = 71;
        int columns = 71;

        MazeVisualizer gvis = new MazeVisualizer(rows, columns);
//        char[][] m = new char[9][9];
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                m[i][j] = '#';
//            }
//
//        }
//        for (int j = 0; j < 8; j++) {
//            m[1][j] = ' ';
//        }
//        m[2][1] = ' ';
//        m[2][3] = ' ';
//        m[2][5] = ' ';
//        m[2][6] = ' ';
//        m[3][1]=' ';m[3][2]=' ';m[3][3]=' ';m[3][5]=' ';m[3][7]=' ';
//        m[4][1]=' ';m[4][3]=' ';m[4][7]=' ';
//        m[5][1]=' ';m[5][3]=' ';m[5][4]=' ';m[5][5]=' ';m[5][6]=' ';m[5][7]=' ';
//        m[6][3]=' ';
//        for(int i=1;i<9;i++){
//            m[7][i]=' ';
//        }
//        printMaze(m);
//        
//        MazeData data=new MazeData(9,9);
//        data.maze=m;
//        
//        AstarWithManhattan a=new AstarWithManhattan(data,new MazeFrame("m",50,50));
//        a.searchWay();
//        Node n1=new Node(1,16);n1.setF(14);
//        Node n2=new Node(1,16);n2.setF(16);
//        Node n3=new Node(1,16);n3.setF(10);
//        MyHashMap<Node,Integer>map=new MyHashMap<>();
//        IndexPriorityQueue<Node>pq=new IndexPriorityQueue<>(9);
//        map.put(n2, 1);
//        pq.add(2,n1);pq.add(1, n2);
//        pq.change(2, n3);
//        System.out.println(pq.pollElement());
//        System.out.println(pq.pollElement());
      
    }

    public static void printMaze(char[][] m) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println("");
        }
    }
}
