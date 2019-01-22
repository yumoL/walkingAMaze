package maze;

import mazeVisualisation.MazeVisualizer;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file="labyrinth_101_101.txt";
        MazeVisualizer vis=new MazeVisualizer(file);
    }
}
