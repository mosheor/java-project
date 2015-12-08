package algorithms.mazeGenerators;

import classes.Maze3d;
import classes.Position;

/**
 *<h1> Maze3dGenerator interface <h1>
 * This interface presents any algorithm that creates a maze
 *
 * @author  Or Moshe
 * @version 1.0
 * @since   1/12/15
 */
public interface Maze3dGenerator
{	
	/**
	 * Generate method that creates a maze
	 * @param int z,int y,int x
	 * @return Maze3d
	 */
	Maze3d generate(int zSize, int ySize, int xSize);
	
	/**
	 * Calculates the time that the algo is working
	 * @param int z ,int y ,int x - the sizes of the maze
	 * @return String
	 */
	String measureAlgorithmTime(int zSize, int ySize, int xSize);
	
	/**
	 * Get maze size
	 * @return int
	 */
	public int getzSize();
	public int getySize();
	public int getxSize();
	

	/**
	 * Returns the value of this position
	 * @param int z,int y,int x position sizes *OR* Position pos
	 * @return int
	 */
	public int getValueInPosition(int z, int y, int x);
	public int getValueInPosition(Position pos);
	
	/**
	 * Return start & end position
	 * @return Position
	 */
	public Position getStartPosition();
	public Position getEndPosition();
	
	/** Returns the maze
	 * @return Maze3d
	 */
	public Maze3d getMaze();
	
}
