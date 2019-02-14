# Implementation Document

## Project structure
The project consists of five parts, which are [algorihtms](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/algo), [initial data of a graph](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/data), [a console UI](https://github.com/yumoL/walkingAMaze/blob/master/src/main/java/main/App.java), [a GUI](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/mazeVisualisation) and [data structures](https://github.com/yumoL/walkingAMaze/tree/master/src/main/java/util).

### Algorithms
The DFS and randomized Prim-algorithm are used to generate a labyrinth with multipule solutions. The BFS(breadth-first-search)- and A*-algorithm are used to find a path in the labyrinth. I use three different heuristic functions (Manhattan distance, Euclidean distance and squared Euclidean distance to implement the A* algorithm. BFS and A* which are implemented by using Manhattan distance and Euclidean distance will find the shortest path all the time. A* which is implemented by using squared Euclidean distance will not always find the shortest path, but it can find a relatively short path in a remarkably shorter time compared to the A*-algorithm which is implemented using Manhattan or Euclidean distance. 

### Initialized Data of a Graph
This package includes the initialized data of a graph. The initialized graph before being modified by DFS- or randomized Prim-algorithm is a graph where is no edge between any two nodes. The node(1,0) is defined as the entrance and node(number of rows-2,number of columns -1) as the exit.

### Console UI
The text UI is quite simple, which is used to show some introduction about how to use the program and ask the user to enter some required data, such as the size of the graph and choose in which way the graph will be generated. In addtion, the text UI is used to show the performance results of the algorithms, such as how many milliseconds a algorithm cost and how many nodes a algorithm checked while being executed.

### GUI
The graphic UI is implemented by using Java Swing. When user run the program, after entering the required data he can see a graph shown as a labyrinth. When user starts to find the path in the labyrinth, the nodes which have been cheked will be shown in yellow and when the path has been found, it will be shown in red in the labyrinth. 

### Data Structures
The implemented data structures in this project includes ArrayList, queue, PriorityQueue and HashMap. Space requirements in all data structures will be genenrally O(n).

## Implemented Time and Space Complexity
The gragh is saved as an adjacency matrix. Assumed that rows = the number of rows in the matrix, cols = the number of columns in the matrix. 

### Graph Generation
Initialized graph, where '#'=wall and'*'=road
<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/dfsGen.jpg" width="200" height="200">

#### Randomized DFS
This algorithm is a randomized verion of DFS. The principle is to start from the first road(A) marked in the graph above and add its neighbouring roads into the queue. Then the algorithm chooses a road(B) from the queue randomly, sets the wall between road A and B as a road. Then the algorithm adds the neibouring roads into the queue and choose a road randomly from the queue and sets the wall between road B and C as a road. The algorithm continues doing this process until all roads have been visited. 
```
function RandomizedDfs()
  RandomQueue queue (adding and removing an element randomly)

  queue.add (first)
  while (queue is not empty)
    Node currentRoad = queue.remove()
    for (neighbourRoad: neighbouring roads of currentRoad in four directions) //four directions = up, down, left, right
      if (neighbourRoad hasn't been visited)
        queue.add (neighbourRoad)
        visited[neighbourRoad.x][neighbourRoad.y]=true
        set the wall between currentRoad and neighbourRoad as a road
    
```
Time complexity: O(2 x rows x cols) = O(rows x cols). We need to traverse all road nodes twice (add them into the queue and remove them from the queue), adding,removing and checking a node are all O(1)-actions.

Space complaxity: O(rows x cols). We need an extra queue to save all road nodes. 

#### Randomized Prim
This algorithm is a randomized version of Prim's algorithm.
```
1. Pick a road, mark it as visited. Add the walls next to the road into a list
2. While there are walls in the list

  1. Pick a random wall from the list. If one of the two roads that the wall divides is visited:
  
    1. Mark the wall as a road and the road(A) which hasn't been visited as visited
    2. Add the neighbouring walls of the road A to the list
    
  2. Remove the wall
```
```
function RandomizedPrim():
  ArrayList walls

  Node from=new Node(entranceX, entranceY+1)
  visited[entranceX][entranceY]=true
  visited[from.x][from.y]=true
  visited[exitX][exitY]=true

  for(neighbourWall: walls next to from)
    if(neighbourWall isn't the outermost)
      walls.add(neighbourWall)
    
  While (walls is not empty)
   Node wall = walls.remove(randomIndex)
   Node next = another road of two roads that the wall divides
    if (visited[next.x][next.y]==false)
      visited[next.x][next.y]=true
      visited[wall.x][wall.y]=true
      from = next
    else
      continue
    for(neighbourWall: walls next to from)
      if(neighbourWall isn't the outermost)
        wall.precessor = from
        walls.add(neighbourWall)
```
Time complexity: O(rows x cols). We need to check all the walls and the roads next to them.

Space complexity: O(rows x cols). We need an extra list to save the walls.

Using randomized DFS and Prim we get a graph which is a spanning tree. Then we can randomly choose some mroe walls and mark them as roads. In this way we get a graph with circles, therefore, the graph has more than one path between two nodes. 
The time complexity of marking more walls as roads is O(rows x cols) and doesn't require extra space. Therefore, the time complexity of generating a graph is O(rows x cols) and space complexity O(ros x cols). 

### Path Finding
#### BFS
```
function Bfs(): 
  Queue queue

  queue.enqueue (entranceNode)
  visited[entranceX][entranceY] = true

  boolean hasSolution = false
  while (queue is not empty)
    Node currentNode  = queue.poll()
    if(currentNode.equals(exitNode)
      hasSolution = true
      break
    for (neighbour: neighbouring nodes of currentNode)
      if (!visited[neighbour.x][neighbour.y] and neighbour is a road)
        neighbour.precessor = currentNode
        queue.enqueue(neighbour)
        visited[neighbourX][neighbourY] = true
  return hasSolution
```
Time complexity: O(rows x cols). We need to traverse all nodes in the worst situation.

Space complexity: O(rows x cols). We need an extra queue to save road nodes.

#### A*
```
g = distance from entrance to current node
h = estimated distance from current node to the exit using heuristic function
f = g + h
PriorityQueue pq

function CheckPath (x,y,preNode,exitNode):
  Node node = new Node(x,y,preNode)
  if(node is not inside the graph)
    return false
  if(node is a wall)
    return false
  if(visited[x][y])
    return false
  if(pq.contains(node))
    preNode.g+1<node.g
    node.g=preNode.g+1
    pq.change(node) //insert node with new g and remove node with old g
  else
    pq.add(node)
    
function Astar():
  pq.add(entranceNode)
  while(pq is not empty)
    if(pq.contains(exitNode)
      return true
    Node currentNode = pq.poll()
    visited[currentNode.x][currentNode.y]=true
    for(neighbour: neibouring nodes of the currentNode)
      CheckPath(neighbour.x,neighbour.y,currentNode, exitNode)
  return false
  ```
  Time complexity: O(rows x cols). We need to traverse all nodes in the worst case.
  
  Space complexity: O(rows x cols). We need an extra priority queue to save the roads.
  
  ## Comparative performance and complexity analysis
  Labyrinths generated by randomized DFS and randomized Prim have different features. Labyrinths generated by randomized DFS have a low branching factor and contain many long corridors. Labyrinths generated by randomized Prim are biased towards many short dead ends and their paths are usually shorter than paths in labyrinths generated by randomized DFS. This feature affects the performance of path finding algorithms even though BFS and A* have same time complexities in the worst case. Also different heiristic functions have an effect on the performance of A*. For more details please check from the [testing documentation](https://github.com/yumoL/walkingAMaze/blob/master/documentation/Testing_document.md). 
  
  ## Improvements
  
  ## Sources
  [Graph generation](https://en.wikipedia.org/wiki/Maze_generation_algorithm)
  
  [A*](https://en.wikipedia.org/wiki/A*_search_algorithm#Pseudocode)
  
  [HashMap implementation](https://dzone.com/articles/custom-hashmap-implementation-in-java)
 

