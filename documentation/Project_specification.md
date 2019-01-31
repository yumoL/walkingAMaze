# Project Specification

### Problem to solve
This project is about generating a maze wihout weights and walking through it using different algorithms.

In this project I'm going to use different algorithms to generate a maze and then walk through it. I'll use DFS(depth-first-search) and randomized Pim to generate a maze. After generating a maze, I'll use DFS, BFS(breadth-first-search) and A*-algorithm to walk through it. The purpose of this project is to compare the performence of different path finding algorithms in different mazes (depending on the algorithm used to generate it 

### Data structers and algorithms
The data structures to be used are ArrayList, stack, queue, PriorityQueue and LinkedList
The algorithms to be used are DFS, BFS, A* and randomized Prim.                                     

### Program input and use of them
When drawing a new maze, the program will get the size of the maze (how many lines and how many columns does the maze have) as inputs, then the program will draw a new maze with given information automatically. After the maze being gennerated, the user can walk through it using different algorithms mentioned before. 

### Time and space complexity 
| Algorithms     | Time complexity | Space complexity|
| :-------------:| :----------:    | :-----------:   |
|  DFS           | O(V+E)          | O(V)            |
|  BFS           | O(V+E)          | O(V)            |
|  A*-search     | O(E) (worst case) | O(V)(worst case)|
|  Randomized Prim| O(V^2)| O(V)|

V=number of nodes; E=number of edges

### Sources
[A*search](https://en.wikipedia.org/wiki/A*_search_algorithm)

[Different algorithms to walk a maze](http://bryukh.com/labyrinth-algorithms/)

[Maze generation](https://en.wikipedia.org/wiki/Maze_generation_algorithm)
