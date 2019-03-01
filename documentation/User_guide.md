# User Guide
### Download the Program
- Enter the command below in your console
```
git clone git@github.com:yumoL/walkingAMaze.git
```
- Access the program by enter the command
 ```
cd thePlaceWhereYouSavedTheProgram/walkingAMaze
```

### Use the program
- Start the program by entering the command
```
./gradlew run
```
- A short introduction will be shown
<img src=https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/intro.png>

- Enter an available row number and column number and choose the way in which your graph will be generated
<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/generate.png">

- A new graph with defaulted entrance and exit will be generated. Entrance is on the top left corner and exit is on the bottom right corner of the graph.
<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/newGraph.png" width="300" height="300">

- Make sure your mouse is on the graph

- Find the path of the graph using defferent algorithms. Press 'a' to use BFS, 'b' to use A* whose heuristic function is Manhattan distance, 'c' to use A* whose heuristic function is Euclidean distance and 'd' to use A* whose heuristic function is squared Euclidean function. Please use some other algorithm to find the shortest path before you use A* with squared Euclidean distance. 

(BFS)<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/bfsResult.png" width="300" height="300">

(A* with Manhattan distance)<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/a*ManhattanResult.png" width="300" height="300">

(A* with Euclidean distance)<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/a*EuclideanResult.png" width="300" height="300">

(A* with squared Euclidean distance)<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/a*SquaredEuclideanResult.png" width="300" height="300">

- You can see the time that each algorithm used and the number of roads that each algorithm expanded. You can also see whether the A* with squared Euclidean distance found the shortest path or not and if not, how many more nodes the path found by A* with squared Euclidean distance has compared to the shortest path. 

<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/result.png">

- Press 'n' to generate a new graph. 

- Close the frame of your graph or enter 'e' as the number of row to close the program.
<img src="https://github.com/yumoL/walkingAMaze/blob/master/documentation/pictures/close.png" width="300" height="300">
