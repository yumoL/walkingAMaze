# Testing Document

### Unit tests
The coverage of unit tests can be found [here](https://codecov.io/gh/yumoL/walkingAMaze).

#### graphVisualization and main
Methods in packages graphVisualization and main aren't tested automatically in unit tests since they're all about visualizing a graph and console UI. Whenever running the program it's quite easy to see whether these methods work or not. 

#### data
Methods in class GraphData are tested in unit tests to see if the graph can be initialised correctly. I created a GraphData-object and go through it line by line and row by row to check if there is correct character in each coordination. I also tested some methods which are needed when implementing algorithms by giving these methods different variables to make sure they work in the right way with valuable variables and are able to throw exceptions when given variables are illegal. 

Most of the methods in class Node aren't tested separately in its own test class since they're simple getting or setting methods. Methods to define if two nodes are same and compare two nodes are tested seperately. I generate some nodes to test these two methods to make sure equals-method can determine two nodes as same when they have same coordinations and compare-method can determine if one node is smaller/lager than another one when these two nodes have different f-values. 

#### algorithms
Algorithms to generate gaphs and find path are tested automatically in unit tests. I created ten new graphs, five of them using randomized DFS and the rest randomized Prim. I use BFS to find paths from generated graphs to make sure there is at least one path in each graph. 
I test path finding algorithms by giving the random numbers used in randomized Prim a seed so that the generated graphs are same in the test all the time. Then I use implemented path finding algoithms to walk the graph and make sure BFS and A* using Manhattam distance and Euclidean distance can find the shortest path and all algorithms can traverse the correct number of nodes. 

### Performance Testing
In performance tests,  we would like to know how long it takes an algorithm to find the path without needing to see the concrete path, so I used a (separate class)[https://github.com/yumoL/walkingAMaze/blob/master/src/main/java/performanceComparison/Comparator.java] to do the performance testing to save time, because when the size of the graph increases, it takes quite much time to wait for the rendering of graphs. 

In the performance testing I'm going to test the efficiency of BFS-algorithm and A*-algorithm. A*-algorithm is implmented by using different heuristic functions including Manhattan distance, Euclidean distance and squared Euclidean distance. Algorithms' execution time and traversed roads will be measured. I'm going to test the efficiency of the algorithms mentioned before in different sizes of graphs. Also a graph with the same size will be generated in different ways, using DFS- and randomized Prim's algorithms. Each graph will be walked ten times and average time will be taken as the result.

*Assumed DFS = randomized DFS and Prim = randomized Prim*

|size(rows x columns)|generation method|performance time using BFS(ms)|traversed roads using BFS|
|:------------------:|:---------------:|:--------------:|:-------------:|
|51 x 51| DFS |2|1133|
||Prim|3|1309|
|101 x 101|DFS|10|5241|
||Prim|8|5248|
|501 x 501|DFS|19|92483|
||Prim|45|131006|
|1001 x 1001|DFS|58|441386|
||Prim|244|523987|
|1551 x 1551|DFS|127|922146|
||Prim|681|1259432|
|2001 x 2001|DFS|263|1653375|
||Prim|1516|2095685|
|2551 x 2551|DFS|561|3052598|
||Prim|3271|3407605|
|3001 x 3001|DFS|781|4205328|
||Prim|5324|4715672|

|size(rows x columns)|generation method|performance time using A* with Manhattan distance(ms)|traversed roads using  A* with Manhattan distance|
|:------------------:|:---------------:|:--------------:|:-------------:|
|51 x 51|DFS|3|978|
||Prim|2|467|
|101 x 101|DFS|6|2980|
||Prim|4|1910|
|501 x 501|DFS|33|86643|
||Prim|37|66539|
|1001 x 1001|DFS|97|438942|
||Prim|86|240734|
|1551 x 1551|DFS|207|916604|
||Prim|192|602543|
|2001 x 2001|DFS|371|1648883|
||Prim|260|741253|
|2551 x 2551|DFS|738|2981815|
||Prim|656|1569072|
|3001 x 3001|DFS|1271|4106521|
||Prim|661|1591259|

|size(rows x columns)|generation method|performance time using A* with Euclidean distance(ms)|traversed roads using  A* with Euclidean distance|
|:------------------:|:---------------:|:--------------:|:-------------:|
|51 x 51|DFS|1|987|
||Prim|2|978|
|101 x 101|DFS|5|3015|
||Prim|6|4271|
|501 x 501|DFS|35|89058|
||Prim|38|116712|
|1001 x 1001|DFS|98|447720|
||Prim|122|457725|
|1551 x 1551|DFS|221|917713|
||Prim|352|1108891|
|2001 x 2001|DFS|449|1650035|
||Prim|661|1797958|
|2551 x 2551|DFS|919|2995895|
||Prim|1136|2970924|
|3001 x 3001|DFS|1452|4118835|
||Prim|1886|4043582|

|size(rows x columns)|generation method|performance time using A* with squared Euclidean distance(ms)|traversed roads using squared A* with Euclidean distance|shortest path|found path longer than shortest path
|:------------------:|:---------------:|:--------------:|:-------------:|:--:|:--:|
|51 x 51|DFS|1|799|343|0|
||Prim|0.14|210|99|12|
|101 x 101|DFS|3|2315|871|0|
||Prim|0.83|647|205|70|
|501 x 501|DFS|16|51606|13803|2920|
||Prim|5|4406|1037|308|
|1001 x 1001|DFS|92|353511|43315|6870|
||Prim|8|7047|2079|526|
|1551 x 1551|DFS|159|608340|70036|27974|
||Prim|9|11045|3231|1108|
|2001 x 2001|DFS|406|1340691|84063|29304|
||Prim|9|14191|4129|1432|
|2551 x 2551|DFS|661|2050116|120431|113546|
||Prim|9|17299|5275|1136|
|3001 x 3001|DFS|928|2520426|115807|91164|
||Prim|10|21036|6209|2006|

<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/Time%20used%20in%20walking%20graphs%20generated%20by%20randomized%20DFS.png">

<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/Time%20used%20in%20walking%20graphs%20generated%20by%20randomized%20Prim.png">

<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/Traversed%20roads%20in%20graphs%20generated%20by%20randomized%20DFS.png">

<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/Traversed%20roads%20in%20graphs%20generated%20by%20randomized%20Prim.png">

<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/Error%20comparison%20in%20A_%20implemented%20using%20squared%20Euclidean%20distance.png">

#### Conclusions
##### Shortest path finding algorithms
*Doesn't include A* *implemented with squared Euclidean distance*
- The performance of BFS is better than A* in graphs generated by ranodomized DFS and worse than A* in graphs generated by randomized Prim. 
  * Reason: Graphs generated by randomized DFS has low branching factor and their paths are usually long corridors. The heuristic function used in A* affect the efficiency of A*. The feature that paths have many long corridors means the real distance between two nodes is always substantially longer than the distance that heuristic function estimates. The lower estimated distance is, the more nodes A* has to expand.In BFS we use a normal queue(first in first out) and in A* we use a priority queue, removing an element from normal queue is an O(1) action and from priority queue is an O(log n)-action. From the third graph we can see the roads that BFS traverses and the roads that A* traverses don't differ from each other quite much and therefore BFS performes better than A* in graphs generated by randomized DFS.
On the other hand, graphs generated by randomized Prim have higher branching factor and shorter paths, which means the distance between two nodes estimated by heuristic function is closer to the real distance , so A* expands much less nodes than BFS(see the forth graph) and therefore performces better regradless of the O(log n) removing action. 

- The performance of A* implemented using Manhattan distance is better than A* implemented using Euclidean distance. 
  * Reason: Manhattan distance = |x1-x2|+|y1-y2| and Euclidean distance = sqrt[(x1-x2)^2+(y1-y2)^2], which means Manhattan distance is longer than Euclidean distance and therefore closer to the real distance between two nodes. Traversing less nodes make A* implemented using Manhattan distance become more efficiency than A* implemented using Euclidean distance. 
  
##### A* implemented using squared Euclidean distance
- A* implemented using squared Euclidean distance finds a path most quickly among the three A* algorithms. 
  * Reason: Distance between two nodes estimated by squared Euclidean distance is always longer than the real distance, it traversed substantially less nodes than other algorithms (see the third and forth graph) and therefore can find a path faster than other algorithms. On the other hand, A* implemented using squared Euclidean distance isn't guaranteed to find the shortest path. 

- A* implemented using squared Euclidean distance works more stably in graphs generated by randomized Prim than graphs generated by randomized DFS (see the fifth graph). The error between the shortest path and the found path in graphs generated by randomized Prim becomes more stable than in graphs generated by randomized DFS when the size of the graph increases.
  * Reason: A* computes f=g+h, where g is the distance from entrance to current node and h the estimated distance using heuristic function. The square of distance will be much higher than g, so when the size of graph grows bigger, this will approach the extreme that g dosen't contribute to f and A* degrades into greedy best-fist search. Since graphs generated by randomized DFS have many long corridors, the situation shown below may exist quite often and therefore A* chooses a path much longer than the shortest one espacially in a large graph. On the other hand, graphs generated using randomized Prim have less corridors, thus the path found by A* doesn't differ as much from the shortest one as it does in graphs generated by randomized DFS. 
 
<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/bfs.png" width="300" height="300">  <img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/a*.png" width="300" height="300"> (Left one is the shortest path and right one is the path found by A* implemented using squared Euclidean distance)

(A* implemented using squared Euclidean distance chooses nodes close to the exit but the path consisting of these nodes have much more corridors than the actual shortest path.)



