package algorithms.search;

import classes.State;

/**
*<h1>  Heuristic interface <h1>
* This interface help evaluated the best path
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public interface Heuristic<T>
{
	/**
	* This method returns evaluation to the path
	* @param State<T> 
	* @return double evaluation
	*/
	public double h(State<T> currentState);
}
