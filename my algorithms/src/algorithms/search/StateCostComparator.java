package algorithms.search;

import java.util.Comparator;

import classes.State;

/**
*<h1>  StateCostComparator class <h1>
* This class compare by the states cost
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/

public class StateCostComparator<T> implements Comparator<State<T>>
{

	/**
	* Override compare
	* compares between 2 states
	* @param State<T> 
	* @return double evaluation
	*/
	@Override
	public int compare(State<T> st1, State<T> st2) {
		if(st1.getCost() > st2.getCost())
			return 1;
		if(st1.getCost() == st2.getCost())
			return 0;
		return -1;
	}
	
}
