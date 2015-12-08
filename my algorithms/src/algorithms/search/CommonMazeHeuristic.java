package algorithms.search;

import classes.Position;
import classes.State;

/**
*<h1>  CommonHeuristic class <h1>
* This class presents CommonHeuristic
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public abstract class CommonMazeHeuristic<T> implements Heuristic<Position>
{
	protected Searchable<T> searchable;
	
	/**
	 * Constructor that gets Searchable<T> 
	 * @param Searchable<T>
	 */
	public CommonMazeHeuristic(Searchable<T> s)
	{
		this.searchable = s;
	}
	
	/**
	* This abstract method returns evaluation to the path
	* @param State<T> 
	* @return double evaluation
	*/
	@Override
	public abstract double h(State<Position> currentState);
}
