# Project Specification

### Problem to solve
This project is about generating a graph of labyrinth and walking through it using different algorithms.

In this project I'm going to generate a graph of labyrinth with multiple solutions and then walk through it by finding the shortest path. The entrance and exit are given in the labyrinth. In the labyrinth user can walk in four directions (left,right,up,down). User cannot walk diagnonally. 

I'll use randomized Prim to generate a graoh of labyrinth. After generating a labyrinth, I'll use BFS(breadth-first-search), A*-algorithm and Dijkstra-algorithm to find the shortest path. The purpose of this project is to compare the performence of different shortest path finding algorithms. 

### Data structers and algorithms
The data structures to be used are ArrayList, HashSet, HashMap, TreeMap, queue and PriorityQueue.
The algorithms to be used are BFS, A* , Dijkstra and randomized Prim.                                     

### Program input and use of them
When generating a new maze, the program will get the size of the labyrinth (how many lines and how many columns does the labyrinth have) as inputs, then the program will generate a new maze with given information automatically. After the labyrinth being gennerated, the user can use different algorithms mentioned before to find the shortest path in the labyrinth. 

### Time and space complexity 
| Algorithms     | Time complexity | Space complexity|
| :-------------:| :----------:    | :-----------:   |
|  BFS           | O(V+E)          | O(V)            |
|  A*-search     | O(E) (worst case) | O(V)(worst case)|
|Dijkstra | O(VlogV) | O(V^2)|
|  Randomized Prim| O(V^2)| O(V)|

V=number of nodes; E=number of edges

### Sources
[A*search](https://en.wikipedia.org/wiki/A*_search_algorithm)

[Dijkstra](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)

