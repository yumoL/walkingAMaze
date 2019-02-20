# Project Specification

### Problem to solve
This project is about generating a graph of labyrinth and walking through it using different algorithms.

In this project I'm going to generate a graph of labyrinth with multiple solutions and then walk through it by looking for the shortest path (the term of shortest means walking thorugh the least noded to the exit). The entrance and exit are given in the labyrinth. In the labyrinth user can walk in four directions (left,right,up,down). User cannot walk diagnonally. 

I'll use randomized DFS(depth-first-search) and randomized Prim to generate a graph of labyrinth. After generating a labyrinth, I'll use BFS(breadth-first-search) and A*-algorithm to find the shortest path. I'll use different heuristic functions (Manhattan distance, Euclidean distance and squared Euclidean distance) when implementing A*-algorithm. In this project I'll compare the performence of different shortest path finding algorithms in different graphs. Because using squared Euclidean distance can find a path in a shorter time than using other heuristic functions mentioned before, but it will not always find the shortest path, I'm also going to find out the relationship between the sacrifice of accurancy and time saving when using squared Euclidean distance as the heuristic function. 

### Data structers and algorithms
The data structures to be used are ArrayList, HashSet, HashMap, LinkedList, queue and PriorityQueue.
The algorithms to be used are BFS, A* and randomized Prim.                                     

### Program input and use of them
When generating a new labyrinth, the program will get the size of the labyrinth (how many rows and how many columns does the labyrinth have) and also the information about which way to use to generate the graph as inputs, then the program will generate a new labyrinth with given information automatically. After the labyrinth being gennerated, the user can use different algorithms mentioned before to find the (relatively)shortest path in the labyrinth. 

### Time and space complexity 

The graph will be generated as a matirx. Assumed rows=the number of rows in the matrx and cols=the number of columns in the matrix

| Algorithms     | Time complexity | Space complexity|
| :-------------:| :----------:    | :-----------:   |
|  BFS           | O(rows x cols)          | O(rows x cols)            |
|  A*-search     | O(rows x cols x log(rows x cols)) | O(rows x cols)|
|  Randomized Prim| O(rows x cols)| O(rows x cols)|
|Randomized DFS|O(rows x cols)|O(rows x cols)|



### Sources
[A*search](https://en.wikipedia.org/wiki/A*_search_algorithm)

[Heuristic finctions in A*](http://theory.stanford.edu/~amitp/GameProgramming/Heuristics.html)

[Graph generation](https://en.wikipedia.org/wiki/Maze_generation_algorithm)

