package algorithms.search;

import classes.State;

/**
*<h1>  StateComperator interface <h1>
* This interface help define Comparator
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public interface StateComparator<T> {

	/**
	* This method compare between 2 states
	* @param State<T> 
	* @return double evaluation
	*/
	int compare(State<T> s1,State<T> s2);
	
}
