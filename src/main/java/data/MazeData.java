package data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Read the data of a maze from a file
 */
public class MazeData {

    /**
     * rows=how many lines in the maze, columns=how many columns in the maze
     */
    private int rows, columns;
    public char[][] maze;

    public static final char ROAD = ' ';
    public static final char WALL = '#';

    private int entranceX, entranceY;
    private int exitX, exitY;

    public boolean[][] visited;
    public boolean[][] path;
    public boolean[][] result;

    /**
     * initialise the maze
     *
     * @param filename the name of the maze file
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
            setMaze(scanner);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        entranceX=1;
        entranceY=0;
        exitX=rows-2;
        exitY=columns-1;
//        entranceX = 0;
//        entranceY = 0;
//        exitX = 0;
//        exitY = 3;
    }

    public int getColumn() {
        return this.columns;
    }

    public int getRow() {
        return this.rows;
    }

    public int getEntranceX() {
        return this.entranceX;
    }

    public int getEntranceY() {
        return this.entranceY;
    }

    public int getExitX() {
        return this.exitX;
    }

    public int getExitY() {
        return this.exitY;
    }

    /**
     * get certain character of the maze
     *
     * @param i the x-coordinate of the character in the maze
     * @param j the y-coordinate of the character in the maze
     * @return character whose x-coordinate is i and y-coordinate is j in the
     * maze
     */
    public char getMaze(int i, int j) {
        if (!inArea(i, j)) {
            throw new IllegalArgumentException("i or j out of index");
        }
        return maze[i][j];
    }

    /**
     * define whether the given coordinate pair is valuable or not
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return true if both x- and y-coordinates are in the maze, otherwise
     * false
     */
    public boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

    private Scanner setScanner(File file) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
        return scanner;
    }

    private void setMaze(Scanner scanner) {
        String firstLine = scanner.nextLine();
        String[] info = firstLine.trim().split("\\s+");
        rows = Integer.parseInt(info[0]);
        columns = Integer.parseInt(info[1]);

        maze = new char[rows][columns];
        resetTables();

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            if (line.length() != columns) {
                throw new IllegalArgumentException("The maze file is not correct");
            }

            for (int j = 0; j < columns; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

    }

    public void resetTables() {
        visited = new boolean[rows][columns];
        path = new boolean[rows][columns];
        result = new boolean[rows][columns];
    }
}
