package maze;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file="labyrinth_101_101.txt";
        MazeData data=new MazeData(file);
        data.print();
    }
}
