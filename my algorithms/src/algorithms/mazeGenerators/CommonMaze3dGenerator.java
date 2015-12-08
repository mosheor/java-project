package algorithms.mazeGenerators;

import java.util.Scanner;

import classes.Maze3d;
import classes.Position;

/**
*<h1> CommonMaze3dGenerator  class <h1>
* This class present general class 
* Its defines 2 method that one abstract and one that common to any class that extends this class
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public abstract class CommonMaze3dGenerator implements Maze3dGenerator
{
	protected Maze3d maze = null;

	/**
	 * Generate method that creates a maze
	 * @param int z,int y,int x - the sizes of the maze
	 * @return Maze3d
	 */
	@Override
	public abstract Maze3d generate(int zSize, int ySize, int xSize);
	
	/**
	 * measureAlgorithmTime method that calculates the time that
	 * algo is working
	 * @param int z,int y,int x - the sizes of the maze
	 * @return String
	 */
	@Override
	public String measureAlgorithmTime(int zSize, int ySize, int xSize)
	{
		long start = System.currentTimeMillis();
		
		generate(zSize, ySize, xSize);
		
		long end = System.currentTimeMillis();
		
		return ("the the algorithm last " + (end-start) + " ms.");
	}

	/**
	 * Get maze sizes
	 * @return int
	 */
	public int getzSize()
	{
		if (this.maze != null)
		{
			return this.maze.getzSize();
		}
		return 0;
	}
	public int getySize()
	{
		if (this.maze != null)
		{
			return this.maze.getySize();
		}
		return 0;
	}
	
	public int getxSize()
	{
		if (this.maze != null)
		{
			return this.maze.getxSize();
		}
		return 0;
	}
	
	/**
	 * Returns the value in a position in the maze
	 * @param int z,int y,int x
	 * @return Maze3d
	 */
	
	public int getValueInPosition(int z, int y, int x)
	{
		Scanner s = new Scanner(System.in);
		
		while(x < 0 || x >= this.getxSize())
		{
			System.out.print("please enter a valid x size parameter (>0): ");
			x = s.nextInt();
		}
		
		while(y < 0 || y >= this.getySize())
		{
			System.out.print("please enter a valid y size parameter (>0): ");
			y = s.nextInt();
		}
		
		while(z < 0 || z >= this.getzSize())
		{
			System.out.print("please enter a valid z size parameter (>0): ");
			z = s.nextInt();
		}
		return this.getMazeAsArr()[z][y][x];
	}
	/**
	 * Returns the value in a position in the maze
	 * @param Position pos
	 * @return Maze3d
	 */
	public int getValueInPosition(Position pos)
	{
		Scanner s = new Scanner(System.in);
		
		while(pos.getX() < 0 || pos.getX() >= this.getxSize())
		{
			System.out.print("please enter a valid x size parameter (>0): ");
			pos.setX(s.nextInt());
		}
		
		while(pos.getY() < 0 || pos.getY() >= this.getySize())
		{
			System.out.print("please enter a valid y size parameter (>0): ");
			pos.setY(s.nextInt());
		}
		
		while(pos.getZ() < 0 || pos.getZ() >= this.getzSize())
		{
			System.out.print("please enter a valid z size parameter (>0): ");
			pos.setZ(s.nextInt());
		}
		return this.getMazeAsArr()[pos.getZ()][pos.getY()][pos.getX()];
	}
	
	/**
	 * Return start & goal position
	 * @return Position
	 */
	public Position getStartPosition(){
		return this.maze.getStartPosition();
	}
	
	public Position getEndPosition(){
		return this.maze.getEndPosition();
	}
	
	/**
	 * Returns the maze as int[][][]
	 * @return int[][][]
	 */
	public int[][][] getMazeAsArr() {
		return this.maze.getMaze();
	}

	/**
	 * Returns the maze
	 * @return Maze3d
	 */
	public Maze3d getMaze() {
		return maze;
	}
	

}
