package maze;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MazeData {

    /**
     * lines=how many lines in the labyrinth columns=how many columns in the
     * labyrinth
     */
    private int lines, columns;
    private char[][] labyrinth;

    /**
     * initialise the labyrinth
     *
     * @param filename the name of the labyrinth file
     */
    public MazeData(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("Filename cannot be empty");
        }
        Scanner scanner = null;
        try {
            filename = "src/main/resources/" + filename;
            File file = new File(filename);
            if (!file.exists()) {
                throw new IllegalArgumentException("File " + filename + " doesn't exist");
            }
            scanner = setScanner(file);
            setLabyrinth(scanner);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public int getColumn() {
        return this.columns;
    }

    public int getLine() {
        return this.lines;
    }

    /**
     * get certain character of the labyrinth
     *
     * @param i the x-coordinate of the character in the labyrinth
     * @param j the y-coordinate of the character in the labyrinth
     * @return character whose x-coordinate is i and y-coordinate is j in the
     * labyrinth
     */
    public char getLabyrinth(int i, int j) {
        if (!inArea(i, j)) {
            throw new IllegalArgumentException("i or j out of index");
        }
        return labyrinth[i][j];
    }

    /**
     * define whether the given coordinate pair is valuable or not
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return true if both x- and y-coordinates are in the labyrinth, otherwise
     * false
     */
    public boolean inArea(int x, int y) {
        return x >= 0 && x < lines && y >= 0 && y < columns;
    }

    private Scanner setScanner(File file) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
        return scanner;
    }

    private void setLabyrinth(Scanner scanner) {
        String firstLine = scanner.nextLine();
        String[] info = firstLine.trim().split("\\s+");
        lines = Integer.parseInt(info[0]);
        columns = Integer.parseInt(info[1]);

        labyrinth = new char[lines][columns];
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            if (line.length() != columns) {
                throw new IllegalArgumentException("The labyrinth file is not correct");
            }

            for (int j = 0; j < columns; j++) {
                labyrinth[i][j] = line.charAt(j);
            }
        }

    }

    /**
     * print the labyrinth in text, only used in tests
     */
    public void print() {
        System.out.println(lines + " " + columns);
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(labyrinth[i][j]);
            }
            System.out.println("");
        }
    }
}