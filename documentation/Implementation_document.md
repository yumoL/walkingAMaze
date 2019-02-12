# Implementation Document

## Project structure
The project consists of five parts, which are [algorihtms](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/algo), [initial data of a graph](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/data), [a text UI](https://github.com/yumoL/walkingAMaze/blob/master/src/main/java/main/App.java), [a graphic UI](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/mazeVisualisation) and [data structures](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/util).

### Algorithms
The DFS and randomized Prim-algorithm are used to generate a labyrinth with multipule solutions. The BFS(breadth-first-search)- and A*-algorithm are used to find a path in the labyrinth. I use three different heuristic functions (Manhattan distance, Euclidean distance and squared Euclidean distance to implement the A* algorithm. BFS and A* which are implemented by using Manhattan distance and Euclidean distance will find the shortest path all the time. A* which is implemented by using squared Euclidean distance will not always find the shortest path, but it can find a relatively short path in a remarkably shorter time compared to the A*-algorithm which is implemented using Manhattan or Euclidean distance. 

### Initialized Data of a Graph
This package includes the initialized data of a graph. The initialized graph before being modified by DFS- or randomized Prim-algorithm is a graph where is no edge between any two nodes.

### Text UI
The text UI is quite simple, which is used to show some introduction about how to use the program and ask the user to enter some required data, such as the size of the graph and choose in which way the graph will be generated. In addtion, the text UI is used to show the performance results of the algorithms, such as how many milliseconds a algorithm cost and how many nodes a algorithm checked while being executed.

### Graphic UI
The graphic UI is implemented by using Java Swing. When user run the program, after entering the required data he can see a graph shown as a labyrinth. When user starts to find the path in the labyrinth, the nodes which have been cheked will be shown in yellow and when the path has been found, it will be shown in red in the labyrinth. 

### Data Structures
The implemented data structures in this project includes ArrayList, queue, PriorityQueue and HashMap.

## Implemented Time and Space Complexity

### Randomized Prim
