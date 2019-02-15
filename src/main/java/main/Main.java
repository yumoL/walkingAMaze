package main;

import performanceComparison.Comparator;

public class Main {

    public static void main(String[] args) {
        int choose = 0;
        if (choose == 0) {
            App app = new App();
            app.run();
        } else {
            Comparator comp = new Comparator(3, 3, 1);//Comparator is initialized in the same way as GraphVisualizer
            comp.testBfs();
            comp.testAstarManhattan();
            comp.testAstarEu();
            comp.testAstarSquaredEu();
        }
    }

}
