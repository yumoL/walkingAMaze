# Implementation Document

## Project structure
The project consists of four parts, which are [algorihtms](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/algo), [initial data of a graph](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/data), [a graphic UI](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/mazeVisualisation) and [data structures](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/util).

### Graphic UI
The graphic UI is implemented by using Java Swing. When user run the program, he can see a graph shown as a labyrinth. When user starts to find the path in the labyrinth, the nodes which have been cheked will be shown in yellow and when the path has been found, it will be shown in red in the labyrinth. 

### Algorithms
The DFS and randomized Prim-algorithm is used to generate a labyrinth with multipule solutions. The BFS(breadth-first-search)- and A*-algorithm are used to find a path in the labyrinth. I use three different heuristic function (Manhattan distance, Euclidean distance and squared Euclidean distance to implement the A* algorithm. BFS and A* which is implemented by using Manhattan distance and Euclidean distance will find the shortest path all the time. A* which is implemented by using squared Euclidean distance will not always find the shortest path, but it can find a relatively short path in a remarkably shorter time compared to the A*-Algorithm which is implemented using Manhattan or Euclidean distance. 

### Data Structures
The implemented data structures in this project includes ArrayList, queue, PriorityQueue and HashMap.

## Implemented Time and Space Complexity

### Randomized Prim
