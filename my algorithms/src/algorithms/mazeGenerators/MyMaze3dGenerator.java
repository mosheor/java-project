package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//import java.util.Stack;
import classes.Maze3d;
import classes.Position;

/**
*<h1> MyMaze3dGenerator class <h1>
* This class creates maze with DFS algorithm
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public class MyMaze3dGenerator extends CommonMaze3dGenerator
{
	private boolean endProcces = false;
	

	/**
	 * Default constructor
	 */
	public MyMaze3dGenerator() {}
	
	/**
	 * Constructor that creates Maze3d and start the generate
	 * method that find path
	 * @param int z, int y, int x- the sizes of the maze
	 */
	public MyMaze3dGenerator(int z,int y,int x) { 
		maze = new Maze3d(z,y,x);
		generate(z, y, x);
	}
	
	/**
	 * The DFS algo
	 * @param Position pos - the search start pos
	 */
	public void DFS(Position pos) //the DFS recursive algorithm
	{
		if(endProcces == true)
			return;
	
		if(pos.equalsPositions(maze.getEndPosition()))
		{
			maze.setPositionValue(maze.getEndPosition(), 0);
			endProcces = true;
			return;
		}
			
		ArrayList<String> positions = new ArrayList<String>();
		int z = pos.getZ();
		int y = pos.getY();
		int x = pos.getX();
		
		if(z > 0)
			positions.add("Down");
		
		if((z + 1) < maze.getzSize())
			positions.add("Up");
		
		if(y > 0)
			positions.add("Backward");
		
		if((y + 1) < maze.getySize())
			positions.add("Forward");
		
		if((x + 1) < maze.getxSize())
			positions.add("Left");
		
		if(x > 0)
			positions.add("Right");
		
		Collections.shuffle(positions);
		
		int m = new Random().nextInt(positions.size());
			
		if(positions.get(m) == "Down")
		{
			Position posNew = new Position(z-1, y, x);
			maze.setPositionValue(z-1, y, x, 0);
			this.DFS(posNew);
		}
		
		if(positions.get(m) == "Up")
		{
			Position posNew = new Position(z+1, y, x);
			maze.setPositionValue(z+1, y, x, 0);
			this.DFS(posNew);
		}
		
		if(positions.get(m) == "Backward")
		{
			Position posNew = new Position(z, y-1, x);
			maze.setPositionValue(z, y-1, x, 0);
			this.DFS(posNew);
		}
		
		if(positions.get(m) == "Forward")
		{
			Position posNew = new Position(z, y+1, x);
			maze.setPositionValue(z, y+1, x, 0);
			this.DFS(posNew);
			
		}
		
		if(positions.get(m) == "Right")
		{
			Position posNew = new Position(z, y, x-1);
			maze.setPositionValue(z, y, x-1, 0);
			this.DFS(posNew);
		}
		
		if(positions.get(m) == "Left")
		{
			Position posNew = new Position(z, y, x+1);
			maze.setPositionValue(z, y, x+1, 0);
			this.DFS(posNew);
		}
				
		return;
	}
	
	/**
	 * Override generate method from Maze3dGenerator 
	 * DFS algorithm
	 * @param int zSize, int ySize, int xSize - the sizes of the maze
	 * @return Maze3d the maze
	 */
	@Override
	public Maze3d generate(int zSize, int ySize, int xSize)
	{
		if(maze == null)
			maze = new Maze3d(ySize,zSize,xSize);
		
		maze.setPositionValue(maze.getStartPosition(), 0);		
		maze.setPositionValue(maze.getEndPosition(), 1);
				
		this.DFS(maze.getStartPosition());
		
		endProcces = false;
		
		return maze;
	}
	
}		
	
	
	
	
	
	//--------------------------------------------------------------------------------------------------------
	/*
	@Override
	public Maze3d generate(int zSize, int ySize, int xSize)
	{
		Maze3d maze = new Maze3d(zSize, ySize, xSize);
		
		this.iterativeBacktracker(maze);
		
		return maze;
	}
	
	//--------------------------------------------------------------------------------------------------------
	/*
	The depth-first search algorithm of maze generation is frequently implemented using backtracking:
	
	recursiveBacktracker()
	{
		1. Make the initial cell the current cell and mark it as visited
		
		2. While there are unvisited cells
				
			2.a.If the current cell has any neighbors which have not been visited
				2.a.1. Choose randomly one of the unvisited neighbors
				2.a.2. Push the current cell to the stack
				2.a.3. Remove the wall between the current cell and the chosen cell
				2.a.4. Make the chosen cell the current cell and mark it as visited
			
			2.b. Else if stack is not empty
				2.b.1 Pop a cell from the stack
				2.b.2 Make it the current cell
	}
	*/
	/*
	//it called recursiveBacktracker, but i did it iterative without recursion
	private void iterativeBacktracker(Maze3d maze)
	{
		Random rand = new Random();
		Stack<Position> s = new Stack<Position>();		
		Position currentPos = new Position(maze.getStartPosition());
		
		
		while (!(currentPos.equalsPositions(maze.getEndPosition())))
		{	
			
			ArrayList<String> possibleMoves = new ArrayList<String>();
	
			if (currentPos.getX()+1 < maze.getxSize())
				if(maze.getValueInPosition(currentPos.getZ(), currentPos.getY(), currentPos.getX()+1) == 1)
					possibleMoves.add("Left ");
			
			if (currentPos.getX() > 0)
				if(maze.getValueInPosition(currentPos.getZ(), currentPos.getY(), currentPos.getX()-1) == 1)
					possibleMoves.add("Right");
				
			if (currentPos.getY()+1 < maze.getySize()) 
				if(maze.getValueInPosition(currentPos.getZ(), currentPos.getY()+1, currentPos.getX()) == 1)
					possibleMoves.add("Forward");
			
			if (currentPos.getY() > 0) 
				if(maze.getValueInPosition(currentPos.getZ(), currentPos.getY()-1, currentPos.getX()) == 1)
					possibleMoves.add("Backward");
			
			if (currentPos.getZ()+1 < maze.getzSize()) 
				if(maze.getValueInPosition(currentPos.getZ()+1, currentPos.getY(), currentPos.getX()) == 1)
					possibleMoves.add("Up");	
			
			if (currentPos.getZ() > 0) 
				if(maze.getValueInPosition(currentPos.getZ()-1, currentPos.getY(), currentPos.getX()) == 1)
					possibleMoves.add("Down");
				
			System.out.println(currentPos);

			if (!possibleMoves.isEmpty()) 
			{
				String nextMove = possibleMoves.get(rand.nextInt(possibleMoves.size()));
				
				s.push(currentPos);

				switch (nextMove)
				{
					case "Left":
						int x1 = currentPos.getX();
						currentPos.setX(x1+1);
						break;
					case "Right":
						int x2 = currentPos.getX();
						currentPos.setX(x2-1);
						break;
					case "Forward":
						int y1 = currentPos.getY();
						currentPos.setY(y1+1);
						break;
					case "Backward":
						int y2 = currentPos.getY();
						currentPos.setY(y2-1);
						break;
					case "Up":
						int z1 = currentPos.getZ();
						currentPos.setZ(z1+1);
						break;
					case "Down":
						int z2 = currentPos.getZ();
						currentPos.setZ(z2-1);
						break;	
				}
				maze.setPositionValue(currentPos, 0);
				
				possibleMoves.clear();
				
			}
			else if(!s.isEmpty())
			{
				currentPos = s.pop();
			}
		}
		s.clear();

	}
	
	
/*	private boolean thereAreUnvisitedCells()
	{
		for (int i = 0; i < maze.getzSize(); i++) {
			for (int j = 0; j < maze.getySize(); j++) {
				for (int k = 0; k < maze.getxSize(); k++) {
					if (maze.getValueInPosition(i, j, k) == 1) {
						return true;
					}
				}
			}
		}
		return false;
	}
	*/