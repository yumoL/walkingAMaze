package main;

import graphVisualization.GraphVisualizer;
import java.util.Scanner;

/*
The lgogic of UI
 */
public class App {

    private GraphVisualizer gvis;
    private Scanner scanner;
    private String order;
    private final String NEW_ONE = "n";

    public App() {
        scanner = new Scanner(System.in);
    }

    private void printWelcome() {
        System.out.println("Welcome to the shortest path finding program");
    }

    private void printIntroduction() {
        System.out.println("Please enter the numbers of the rows and columns of your graph, the numbers of rows and columns should be odd numbers and between 51-1001. "
                + "Then choose in which way your graph will be generated. If you'd like to exit the program, just simply close the frame.");
    }

    private void requireCheck() {
        System.out.println("Please make sure your numbers are between 51-1001 and are odd numbers");
    }

    private void printChooseWay() {
        System.out.println("Which way would you like to use to generate your graph?"
                + "Enter dfs for DFS or prim for randomized Prim");
    }

    private void newOne() {
        System.out.println("Enter n to generate a new graph");
    }

    private void howToWalk() {
        System.out.println("Please make sure your mouse is on the graph. Press a to use BFS, b to use A* with Manhattan distance, "
                + "c to use A* with Eucidean distance and d to use A* with squared Euclidean distance to walk the graph. Please use some other algorithm to find the shortest path before you use A* with squared Euclidean distance");
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

            System.out.println("Rows:");
            String input = scanner.next();
            if (!isDigit(input)) {
                continue;
            }
            int rows = Integer.parseInt(input);

            System.out.println("Columns");
            input = scanner.next();
            if (!isDigit(input)) {
                continue;
            }
            int columns = Integer.parseInt(input);

            if (!valuableRowsAndColumns(rows, columns)) {
                requireCheck();
                continue;
            }
            chooseBlockSide(rows, columns);

            chooseGenerationWay(rows, columns);

            howToWalk();

            newOne();
            order = scanner.next();
            order = order.toLowerCase();
            if (order.equals(NEW_ONE)) {
                gvis.frame.dispose();
            }

        }
    }

    /**
     * Determine if an input is digit
     *
     * @param str Input
     * @return true if the input is digit, otherwise false
     */
    private boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * The logic of choosing the way in which a graph will be generated
     *
     * @param rows
     * @param columns
     */
    private void chooseGenerationWay(int rows, int columns) {
        while (true) {
            printChooseWay();

            order = scanner.next();
            order = order.toLowerCase();
            if (order.equals(GraphVisualizer.DFS)) {
                gvis = new GraphVisualizer(rows, columns, GraphVisualizer.DFS);
                break;
            } else if (order.equals(GraphVisualizer.PRIM)) {
                gvis = new GraphVisualizer(rows, columns, GraphVisualizer.PRIM);
                break;
            }

        }

    }
}
