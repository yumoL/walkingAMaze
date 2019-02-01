# Week3 Report

Used hours: 28h

*I modified and added some details to the [project specification](https://github.com/yumoL/walkingAMaze/blob/master/documentation/Project_specification.md). Please have a check and hope it can give you some more details about what kind of maze I'm going to generate*:)

### What I did
- I implemented the A*-algorithm. I had a hard time with implementing the A*-algorithm. For me, it's not so difficult to understand the logic of the algorihtms, but implementing them using a concrete programming language is really difficult.
- I generated maze with multiple solutions using the randomized Prim-algorithm.
- I implemented my own PriorityQueue, which is an "improved" version compared to Java's PriorityQueue. In my PriorityQueue it's also possible to add an index to the added element, thus we can search any element and modify them easily according to its index with O(1)-time complexity. 
- I removed the impplementation of DFS because now my maze have more than one solution and I want to find the shortest one but DFS can't do this. 

### What I learnt
- I understood the idea of A*-algorithm better than last week after implementing it myself.
- I understood the idea of MinHeap better than when I was in Tira-course, especially the processes of sifting a node up and down when some node was added or removed.
- I knew how to generate a maze with multiple solutions. First I tried to use Google to find out if there are any algorithms to generate a maze with multiple solutions, but I didn't find it. Then I realised that when I used randomized Prim-algorithm to generate a maze, I got a spanning tree. If I contine to break more walls after getting a spanning tree, I'll get a graph with circle, thus the maze has multiple solutions.

### What I'm goting to do
- Next week I'm going to implement the Dijkstra's algorithm to find the shortest path
- I'm also going to continue to implement my own data structures including ArrayList, HashSet, HashMap, LinkedList and queue. 
- I'm also going to start the performance evaluation.
- If there's time remaining, I'll try to figure out I can repeat the tests in preformance evaluation. 

### Some questions
- Is it enough that I evaluate the performance between BFS, A* and Dijkstra, or do I still need some more algorithms?
- Last week it was written in the Labtool that I need to remove the gradle wrapper and gradlew files. I have these files because I'd like to run the program in console using ./gradlew commands. I just ask for sure if I still need to remove them?
