# Project Specification

### Problem to solve
This project is about generating a maze and walking through it using different algorithms.

In this project I'm going to use different algorithms to generate a maze with multiple solutions and then walk through it by finding the shortest path. I'll use randomized Prim to generate a maze. After generating a maze, I'll use BFS(breadth-first-search), A*-algorithm and Dijkstra-algorithm to find the shirtest path. The purpose of this project is to compare the performence of different shortest path finding algorithms. 

### Data structers and algorithms
The data structures to be used are ArrayList, HashSet, HshMap, queue, PriorityQueue and LinkedList
The algorithms to be used are BFS, A* , Dijkstra and randomized Prim.                                     

### Program input and use of them
When generating a new maze, the program will get the size of the maze (how many lines and how many columns does the maze have) as inputs, then the program will generate a new maze with given information automatically. After the maze being gennerated, the user can use different algorithms mentioned before to find the shortest path in the maze. 

### Time and space complexity 
| Algorithms     | Time complexity | Space complexity|
| :-------------:| :----------:    | :-----------:   |
|  BFS           | O(V+E)          | O(V)            |
|  A*-search     | O(E) (worst case) | O(V)(worst case)|
|Dijkstra | O(ElogV) | O(V^2)|
|  Randomized Prim| O(V^2)| O(V)|

V=number of nodes; E=number of edges

### Sources
[A*search](https://en.wikipedia.org/wiki/A*_search_algorithm)

[Different algorithms to walk a maze](http://bryukh.com/labyrinth-algorithms/)

[Maze generation](https://en.wikipedia.org/wiki/Maze_generation_algorithm)
