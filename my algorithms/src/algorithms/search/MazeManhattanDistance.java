package algorithms.search;

import classes.Position;
import classes.State;


/**
*<h1>  MazeManhattanDistance class <h1>
* This class present specific Heuristic function
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public class MazeManhattanDistance extends CommonMazeHeuristic<Position>
{
	/**
	 * Constructor that gets Searchable<Position> 
	 * And uses CommonHeuristic constructor
	 * @param Searchable<T>
	 */
	public MazeManhattanDistance(Searchable<Position> s)
	{
		super(s);
	}
	
	/**
	* This method return evaluation to the path
	* @param State<T> 
	* @return double evaluation
	*/
	@Override
	public double h(State<Position> currentPosition)
	{
		double z = this.searchable.getEndState().getState().getZ() - currentPosition.getState().getZ();
		double y = this.searchable.getEndState().getState().getY() - currentPosition.getState().getY();
		double x = this.searchable.getEndState().getState().getX() - currentPosition.getState().getX();
		
		z = Math.abs(z);
		y = Math.abs(y);
		x = Math.abs(x);
		
		return (z + y + x);
	}
}
