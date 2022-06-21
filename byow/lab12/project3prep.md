# Project 3 Prep

**For tessellating hexagons, one of the hardest parts is figuring out where to place each hexagon/how to easily place hexagons on screen in an algorithmic way.
After looking at your own implementation, consider the implementation provided near the end of the lab.
How did your implementation differ from the given one? What lessons can be learned from it?**

Answer:

Since I didn't the lab session , I am not sure what the staff solution was, but our 
planned implementation was to use 2-d array and increase the element by 2 every time. 
Then in the middle, I will decrease element by 2 until it reaches variable s. We tried to implement
this, but had a lot of errors so we were not able to finish this ..:(

**Can you think of an analogy between the process of tessellating hexagons and randomly generating a world using rooms and hallways?
What is the hexagon and what is the tesselation on the Project 3 side?**

Answer:

We think the hexagons represent the rooms that we are supposed to implement in the project 
while the tessellation represent the rooms being connected to each other through hallways. 
The whole random implementataion of the hexagons to show tellessation also reflects the random generation 
that we have to imbede in our project.

**If you were to start working on world generation, what kind of method would you think of writing first? 
Think back to the lab and the process used to eventually get to tessellating hexagons.**

Answer:

We are planning to start on making the hallways and rooms. The outermost part should be always the 
wall, so we could maybe use WQU to check this. We are still in the planning stage so 
we are not 100% sure with this plan.


**What distinguishes a hallway from a room? How are they similar?**

Answer:

Hallway has a static number of tile, for instance, has 1 tile always,  while rooms can have 
random tiles. It is similar in a way that they are surrounded by the walls! Other than this, 
we think that there are no similarities. 
