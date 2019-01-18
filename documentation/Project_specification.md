# Project Specification

### Problem to solve
This project is about drawing a maze and walking through it using different algorithms.

In this project I'm going to compare different algorithms to go through a maze. The algorithms to be compared include DFS(depth-first search), BFS(breadth-first search) and A*-search. In addition to walking through a maze, I'm also going to draw a maze using DFS and BFS, which means in the final program, user can not only chose a finished maze which will be saved as a txt.-file to walk through, but also can draw a new maze using different algorithms to walk through. 

### Data structers and algorithms
The data structures to be used are (at least) stack and queue. The algorithms to be used are DFS, BFS (in both drawing and walking a maze)  and A*-search (only in walking a maze). 

### Program input and use of them
When drawing a new maze, the program will get the size of the maze (how many lines and how many columns does the maze have) as inputs, then the program will draw a new maze with given information automatically. 

When walking a maze, the program will get the file name of the maze, then the program will walk the maze using the algorithms mentioned above. 

### Time and space complexity 
| Algorithms     | Time complexity     | Space complexity|
| :-------------:| :----------:        | :-----------:   |
|  DFS           | O(V+E)              | O(V)          |
|  BFS           | O(V+E)          | O(V)          |
|  A*-search     | O(E)              | O(V)          |

V=number of nodes; E=number of edges

### Sources
[A*search](https://en.wikipedia.org/wiki/A*_search_algorithm)

[Different algorithms to walk a maze](http://bryukh.com/labyrinth-algorithms/)
