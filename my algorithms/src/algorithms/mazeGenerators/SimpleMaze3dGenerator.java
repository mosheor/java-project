package algorithms.mazeGenerators;

import java.util.Random;

import classes.Maze3d;
import classes.Position;

/**
*<h1> SimpleMaze3dGenerator class <h1>
* This class creates maze with a simple algorithm
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public class SimpleMaze3dGenerator extends CommonMaze3dGenerator
{
	/**
	 * Default Ctor
	 */
	public SimpleMaze3dGenerator() {}
	
	/**
	 * Constructor that creates Maze3d and calls the generate method that finds a path
	 * @param int z, int y, int x - the sizes of the maze
	 */
	public SimpleMaze3dGenerator(int z,int y,int x) { 
		maze = new Maze3d(z,y,x);
		generate(z, y, x);
	}
	
	/**
	 * Override generate method from Maze3dGenerator
	 * @param int z, int y, int x - the sizes of the maze
	 * @return Maze3d the maze
	 */
	@Override
	public Maze3d generate(int z, int y, int x) 
	{
		if (maze == null)
		{
			maze = new Maze3d(z, y, x);
		}
		Maze3d maze = new Maze3d(z, y, x);
		Random rand = new Random();
		Position startPos = new Position(maze.getStartPosition());
		Position endPos = new Position(maze.getEndPosition());
		Position pos = new Position(startPos);
		
		for (int i = 0; i < z; i++)
		{
			for (int j = 0; j < y; j++)
			{
				for (int k = 0; k < x; k++)
				{
					maze.setPositionValue(i, j, k, rand.nextInt(2));
				}
			}
		}
		
		for (int i = pos.getX(); i < endPos.getX();)
		{
			maze.setPositionValue(pos.getZ(), pos.getY(), i, 0);
			pos.setX(pos.getX()+1);
			if (maze.getStartPosition().getX() < maze.getEndPosition().getX())
				i++;
			else
				i--;
		}
	
		for (int i = pos.getY(); i < endPos.getY();)
		{
			maze.setPositionValue(pos.getZ(), i, pos.getX(), 0);
			pos.setY(pos.getY()+1);
			if (maze.getStartPosition().getY() < maze.getEndPosition().getY())
				i++;
			else
				i--;
		}
		
		for (int i = pos.getZ(); i < endPos.getZ();)
		{
			maze.setPositionValue(i, pos.getY(), pos.getX(), 0);
			pos.setZ(pos.getZ()+1);
			if (maze.getStartPosition().getZ() < maze.getEndPosition().getZ())
				i++;
			else
				i--;
		}
				
		return maze;
	}

}