# Testing Document

### Unit tests
The coverage of unit tests can be found [here](https://codecov.io/gh/yumoL/walkingAMaze).

#### graphVisualization and main
Methods in packages graphVisualization and main aren't tested automatically in unit tests since they're all about visualizing a graph and console UI. Whenever running the program it's quite easy to see whether these methods work or not. 

#### data
Methods in class GraphData are tested in unit tests to see if the graph can be initialised correctly. I created a GraphData-object and go through it line by line and row by row to check if there is correct character in each coordination. I also tested some methods which are needed when implementing algorithms by giving these methods different variables to make sure they work in the right way with valuable variables to are able to throw exceptions when given variables are illegal. 

Most of the methods in class Node aren't tested separately in its own test class since they're simple getting or setting methods. Methods to define if two nodes are same and compare two nodes are tested seperately. I generate some nodes to test these two methods to make sure equals-method can determine two nodes as same when they have same coordinations and compare-method can determine if one node ss smaller/lager than another one when these two nodes have different f-values. 

#### algorithms
Algorithms to generate gaphs and find path are tested automatically in unit tests. I created ten new graphs, five of them using randomized DFS and the rest randomized Prim. I use BFS to find paths from generated graphs to make sure there is at least one path in each graph. 
I test path finding algorithms by giving the random numbers used in randomized Prim a seed so that the generated graphs are same in the test all the time. Then I use implemented path finding algoithms to walk the graph and make sure BFS and A* using Manhattam distance and Euclidean distance can find the shortest path and all algorithms can traverse the correct number of nodes. 

### Performance Testing

In the performance testing I'm going to test the efficiency of BFS-algorithm and A*-algorithm. A*-algorithm is implmented by using different heuristic functions including Manhattan distance, Euclidean distance and squared Euclidean distance. Algorithms' execution time and traversed roads will be measured. I'm going to test the efficiency of the algorithms mentioned before in different sizes of graphs. Also a graph with the same size will be generated in different ways, using DFS- and randomized Prim's algorithms. Each graph will be walked ten times and average time will be taken as the result.

*Assumed DFS = randomized DFS and Prim = randomized Prim*

|size(rows x columns)|generation method|performance time using BFS(ms)|traversed roads using BFS|
|:------------------:|:---------------:|:--------------:|:-------------:|
|51 x 51| DFS |2|836|
||Prim|4|1299|
|101 x 101|DFS|5|4744|
||Prim|15|5232|
|501 x 501|DFS|22|117537|
||Prim|41|131038|
|1001 x 1001|DFS|67|477731|
||Prim|226|523932|
|1551 x 1551|DFS|142|1013547|
||Prim|706|1258948|
|2001 x 2001|DFS|228|1495320|
||Prim|1459|2095870|
|2551 x 2551|DFS|571|2783285|
||Prim|2918|3407822|
|3001 x 3001|DFS|679|3676195|
||Prim|4720|4715972|

|size(rows x columns)|generation method|performance time using A* with Manhattan distance(ms)|traversed roads using  A* with Manhattan distance|
|:------------------:|:---------------:|:--------------:|:-------------:|
|51 x 51|DFS|3|738|
||Prim|2|353|
|101 x 101|DFS|5|4612|
||Prim|4|1520|
|501 x 501|DFS|39|115189|
||Prim|36|77715|
|1001 x 1001|DFS|106|465633|
||Prim|98|287738|
|1551 x 1551|DFS|201|992955|
||Prim|249|815550|
|2001 x 2001|DFS|320|1396264|
||Prim|436|1194841|
|2551 x 2551|DFS|748|2738740|
||Prim|581|1685124|
|3001 x 3001|DFS|1021|3581161|
||Prim|813|2165638|

|size(rows x columns)|generation method|performance time using A* with Euclidean distance(ms)|traversed roads using  A* with Euclidean distance|
|:------------------:|:---------------:|:--------------:|:-------------:|
|51 x 51|DFS|2|787|
||Prim|2|978|
|101 x 101|DFS|4|4677|
||Prim|4|4257|
|501 x 501|DFS|31|115447|
||Prim|37|117849|
|1001 x 1001|DFS|99|467008|
||Prim|130|469518|
|1551 x 1551|DFS|248|998050|
||Prim|328|1150733|
|2001 x 2001|DFS|369|1418970|
||Prim|648|1882423|
|2551 x 2551|DFS|793|2748069|
||Prim|1028|3009247|
|3001 x 3001|DFS|1316|3602496|
||Prim|1954|4117374|

|size(rows x columns)|generation method|performance time using A* with squared Euclidean distance(ms)|traversed roads using squared A* with Euclidean distance|shortest path|found path longer than shortest path
|:------------------:|:---------------:|:--------------:|:-------------:|:--:|:--:|
|51 x 51|DFS|0.074|598|251|0|
||Prim|0.038|210|99|12|
|101 x 101|DFS|0.35|3610|1095|0|
||Prim|0.77|541|207|42|
|501 x 501|DFS|10|103426|18323|3582|
||Prim|0.59|4979|1045|548|
|1001 x 1001|DFS|10|219019|35295|9706|
||Prim|1|6599|2087|818|
|1551 x 1551|DFS|22|771464|73911|17952|
||Prim|1|10573|3249|1020|
|2001 x 2001|DFS|29|1053244|66243|33076|
||Prim|1|14127|4175|1494|
|2551 x 2551|DFS|54|1859003|45039|103630|
||Prim|1|17374|5289|1536|
|3001 x 3001|DFS|86|2421024|82195|155796|
||Prim|1|18679|6207|2036|

<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/Time%20used%20in%20walking%20graphs%20generated%20by%20randomized%20DFS.png">

<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/Time%20used%20in%20walking%20graphs%20generated%20by%20randomized%20Prim.png">

<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/Traversed%20roads%20n%20graphs%20generated%20by%20randomized%20DFS.png">

<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/Traversed%20roads%20n%20graphs%20generated%20by%20randomized%20Prim.png">

<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/Error%20comparison%20in%20A_%20implemented%20using%20squared%20Euclidean%20distance.png">

#### Conclusions
##### Shortest path finding algorithms
*Doesn't include A* *implemented with squared Euclidean distance*
- The performance of BFS is better than A* in graphs generated by ranodomized DFS and worse than A* in graphs generated by randomized Prim. 
  * Reason: Graphs generated by randomized DFS has low branching factor and their paths are usually long corridors. The heuristic function used in A* affect the efficiency of A*. The feature that paths with many long corridors means the real distance between two nodes is always substantially longer than the distance that heuristic function estimates. The lower estimated distance is, the more nodes A* has to expand.In BFS we use a normal queue(first in first out) and in A* we use a priority queue, removing an element from normal queue is an O(1) action and from priority queue is an O(log n)-action. From the third graph we can see the roads that BFS traverses and the roads that A* traverses don't differ from each other quite much and therefore BFS performes better than A* in graphs generated by randomized DFS.
On the other hand, graphs generated by randomized Prim have higher branching factor and shorter paths, which means the distance between two nodes estimated by heuristic function is closer to the real distance , so A* expands much less nodes than BFS(see the forth graph) and therefore performces better regradless of the O(log n) removing action. 

- The performance of A* implemented using Manhattan distance is better than A* implemented using Euclidean distance. 
  * Reason: Manhattan distance = |x1-x2|+|y1-y2| and Euclidean distance = sqrt[(x1-x2)^2+(y1-y2)^2], which means Manhattan distance is longer than Euclidean distance and therefore closer to the real distance between two nodes. Traversing less nodes make A* implemented using Manhattan distance become more efficiency than A* implemented using Euclidean distance. 
  
##### A* implemented using squared Euclidean distance
- A* implemented using squared Euclidean distance finds a path most quickly. 
  * Reason: Distance between two nodes estimated by squared Euclidean distance is always longer than the real distance, it traversed substantially less nodes than other algorithms (see the third and forth graph) and therefore can find a path faster than other algorithms. On the other hand, A* implemented using squared Euclidean distance isn't guaranteed to find the shortest path. 

- A* implemented using squared Euclidean distance works more stably in graphs generated by randomized Prim than graphs generated by randomized DFS (see the fifth graph). The error between the shortest path and the found path in graphs generated by randomized Prim becomes more stable (about 30%) than in graphs generated by randomized DFS when the size of the graph increases.
 * Reason: A* computes f=g+h, where g is the distance from entrance to current node and h the estimated distance using heuristic function. The square of distance will be much higher than g, so when the size of graph grows bigger, this will approach the extreme that g dosen't contribute to f and A* degrades into greedy best-fist search. Since graphs generated by randomized DFS have many long corridors, the situation shown below may exist quite often and therefore A* chooses a path much longer than the shortest one espacially in a large graph. 
 
<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/bfs.png" width="300" height="300">  <img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/a*.png" width="300" height="300">
(A* implemented using squared Euclidean distance chooses nodes close to the exit but the path consisting of these nodes have more corridors than the actual shortest path.)



