# Project Specification

### Problem to solve
This project is about generating a graph of labyrinth and walking through it using different algorithms.

In this project I'm going to generate a graph of labyrinth with multiple solutions and then walk through it by looking for the shortest path. The entrance and exit are given in the labyrinth. In the labyrinth user can walk in four directions (left,right,up,down). User cannot walk diagnonally. 

I'll use randomized Prim to generate a graph of labyrinth. After generating a labyrinth, I'll use BFS(breadth-first-search) and A*-algorithm to find the shortest path. I'll use different heuristic functions (Manhattan distance, Euclidian distance and squared Euclidian distance) when implementing A*-algorithm. In this project I'll compare the performence of different shortest path finding algorithms. Because using squared Euclidian distance can find a path in a shorter time than using other heuristic functions mentioned before, but it will not always find the shortest path, I'm also going to find out the relationship between the sacrifice of accurancy and time saving. 

### Data structers and algorithms
The data structures to be used are ArrayList, HashSet, HashMap, LinkedList, queue and PriorityQueue.
The algorithms to be used are BFS, A* and randomized Prim.                                     

### Program input and use of them
When generating a new maze, the program will get the size of the labyrinth (how many lines and how many columns does the labyrinth have) as inputs, then the program will generate a new maze with given information automatically. After the labyrinth being gennerated, the user can use different algorithms mentioned before to find the shortest path in the labyrinth. 

### Time and space complexity 
| Algorithms     | Time complexity | Space complexity|
| :-------------:| :----------:    | :-----------:   |
|  BFS           | O(V+E)          | O(V)            |
|  A*-search     | O(E) (worst case) | O(V)(worst case)|
|  Randomized Prim| O(V^2)| O(V)|

V=number of nodes; E=number of edges

### Sources
[A*search](https://en.wikipedia.org/wiki/A*_search_algorithm)

[Heuristic finctions in A*](http://theory.stanford.edu/~amitp/GameProgramming/Heuristics.html)

