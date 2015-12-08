package algorithms.search;

import classes.State;

/**
*<h1>  Astar class <h1>
* This class finds a path in the maze
* Astar is a type of BFS
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public class AStar<T> extends BFS<T>
{
	private Heuristic<T> heuristic;
	
	/**
	 * Constructor that get StateCostComparator<T> 
	 * and Heuristic<T>. this is the type of search
	 * @param StateCostComparator<T> ,Heuristic<T>
	 */
	public AStar(Heuristic<T> heuristic,StateCostComparator<T> c)
	{
		super(c);
		this.heuristic = heuristic;
	}
	
	/**
	 * Constructor that get StateCostComparator<T> 
	 * @param StateCostComparator<T>
	 * @return 
	 */
	public AStar(StateCostComparator<T> c) 
	{
		super(c);
	}
	
	/**
	 * Override the method cost from BFS
	 * This method sets the cost of the state<T> with any heuristic<T>
	 * @param State<T>
	 * @return double
	 */
	@Override
	public double calculate(State<T> s)
	{
		return super.calculate(s) + heuristic.h(s);
	}
}
