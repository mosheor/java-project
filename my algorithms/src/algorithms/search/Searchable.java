package algorithms.search;

import java.util.ArrayList;

import classes.State;

/**
*<h1>  Searchable interface <h1>
* This interface defines general Searchable
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public interface Searchable<T>
{
	/**
	 * This method return the Initial State
	 * @return State<T>
	 */
	State<T> getInitialState();
	
	/**
	 * This method return the End State
	 * @return State<T>
	 */
	State<T> getEndState();
	
	/**
	 * This method return all possible moves
	 * from state
	 * @param State<T>
	 * @return ArrayList<State<T>>
	 */
	ArrayList<State<T>> getAllPossibleStates(State<T> s);
}
