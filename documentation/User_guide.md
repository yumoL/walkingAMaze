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
- Enter an available row number and column number and choose the way in which your graph will be generated
- A new graph with defaulted entrance and exit will be generated. Entrance is on the top left corner and exit is on the bottom right corner of the graph.
- Make sure your mouse is on the graph
- Find the path of the graph using defferent algorithms. Press 'a' to use BFS, 'b' to use A* whose heuristic function is Manhattan distance, 'c' to use A* whose heuristic function is Euclidean distance and 'd' to use A* whose heuristic function is squared Euclidean function. Please use some other algorithm to find the shortest path before you use A* with squared Euclidean distance. 
- You can see the time that each algorithm used and the number of roads that each algorithm expanded. You can also see whether the A* with squared Euclidean distance found the shortest path or not and if not, how many more nodes the path found by A* with squared Euclidean distance has compared to the shortest path. 
- Press '3' to generate a new graph. 
- Close the frame of your graph or enter -1 as the number of row to close the program.
