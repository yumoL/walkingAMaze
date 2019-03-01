package main;

import graphVisualization.GraphVisualizer;
import java.util.Scanner;

/*
The lgogic of UI
 */
public class App {

    private GraphVisualizer gvis;
    private Scanner scanner;
    private int order;
    private final int GENERATE_BY_DFS = 0;
    private final int GENERATE_BY_PRIM = 1;
    private final int NEW_ONE = 3;

    public App() {
        scanner = new Scanner(System.in);
        order = -1;
    }

    private void printWelcome() {
        System.out.println("Welcome to the shortest path finding program");
    }

    private void printIntroduction() {
        System.out.println("Please enter the numbers of the rows and columns of your graph "
                + "and choose in which way your graph will be generated. The numbers of rows and columns should be odd numbers and between 51-1001");
    }

    private void requireCheck() {
        System.out.println("Please make sure your numbers are between 51-1001 and are odd numbers");
    }

    private void printChooseWay() {
        System.out.println("Which way would you like to use to generate your graph?"
                + "Enter 0 for DFS or 1 for randomized Prim");
    }

    private void newOne() {
        System.out.println("Choose 3 to generate a new graph");
    }

    private void howToWalk() {
        System.out.println("Please make sure your mouse is on the graph. Press a to use BFS, b to use A* with Manhattan distance, "
                + "c to use A* with Eucidean distance and d to use A* with squared Euclidean distance to walk the graph. Please use some other algorithm to find the shortest path before you use A* with squared Euclidean distance");
    }

    private void exit() {
        System.out.println("If you'd like to exit the program, just simply close the frame of your graph or enter -1 as the number of rows");
    }

    /**
     * Determine if the given numbers of rows and columns are valuable
     *
     * @param rows number of rows given by user
     * @param columns number of columns given by user
     * @return true if numbers are valuable, otherwise false
     */
    private boolean valuableRowsAndColumns(int rows, int columns) {
        return rows >= 51 && columns >= 51 && rows <= 1001 && columns <= 1001 && rows % 2 == 1 && columns % 2 == 1;
    }

    /**
     * Choose fitted block side according to the area of the graph
     *
     * @param rows number of rows given by user
     * @param columns number of columns given by user
     */
    private void chooseBlockSide(int rows, int columns) {
        int area = rows * columns;
        if (area <= 40401) {
            GraphVisualizer.blockSide = 7;
        } else if (area <= 251001) {
            GraphVisualizer.blockSide = 2;
        } else {
            GraphVisualizer.blockSide = 1;
        }
    }

    /**
     * UI running
     */
    public void run() {
        printWelcome();

        while (true) {
            printIntroduction();
            exit();

            System.out.println("Rows:");
            int rows = scanner.nextInt();
            if (rows < 0) {
                break;
            }
            System.out.println("Columns");
            int columns = scanner.nextInt();

            if (!valuableRowsAndColumns(rows, columns)) {
                requireCheck();
                continue;
            }
            chooseBlockSide(rows, columns);

            printChooseWay();
            order = scanner.nextInt();
            if (order == GENERATE_BY_DFS) {
                gvis = new GraphVisualizer(rows, columns, GENERATE_BY_DFS);
            } else if (order == GENERATE_BY_PRIM) {
                gvis = new GraphVisualizer(rows, columns, GENERATE_BY_PRIM);
            }
            howToWalk();

            newOne();
            order = scanner.nextInt();
            if (order == NEW_ONE) {
                gvis.frame.dispose();
            }

        }
    }
}
