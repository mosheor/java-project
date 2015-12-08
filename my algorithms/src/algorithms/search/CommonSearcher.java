package algorithms.search;

import java.util.ArrayList;
import java.util.PriorityQueue;

import classes.State;

/**
*<h1>  CommonSearcher class <h1>
* This class implements Searcher<T> interface
* In this class we define general methods that matches
* to any Searcher class
* to the goal State<T>
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public abstract class CommonSearcher<T> implements Searcher<T>{

	protected PriorityQueue<State<T>> openList;
	private int evaluatedNodes;
	
	/**
	 * Constructor that gets StateCostComparator<T> 
	 * @param StateCostComparator<T>
	 */
	public CommonSearcher(StateCostComparator<T> c)
	{
		this.openList = new PriorityQueue<State<T>>(c);
		this.evaluatedNodes = 0;
	}	
	
	/**
	 * Pop the top state
	 * @return State<T> the state with the lowest cost
	 */
	protected State<T> popOpenList()
	{
		this.evaluatedNodes++;
		return this.openList.poll();
	}
	
	/**
	 * This method finds the best path, gets type of Searchable<T> and creates the path
	 * @param Searchable<T>
	 * @return Solution<T>
	 */
	@Override
	public abstract Solution<T> search(Searchable<T> s);
	
	/**
	 * Override the method from Searcher<T>
	 * This method returns the number of nodes
	 * that are poped from openList 
	 * @return int number of evaluated Nodes
	 */
	@Override
	public int getNumberOfNodesEvaluated()
	{
		return this.evaluatedNodes;
	}
	
	/**
	 * This method calculates the cost of the state<T>
	 * @param State<T>
	 * @return double
	 */
	protected abstract double calculate(State<T> s);
	
	/**
	 * Pushes/adds state and set the cost
	 * @param State<T>
	 */
	protected void addToOpenList(State<T> state)
	{
		if(state.getCameFrom() != null)
			state.setCost(calculate(state));
		
		this.openList.add(state);
	}
	
	/**
	 * This method returns path form the End to the start
	 * @param State<T> goalState,State<T> startState
	 * @return Solution<T>
	 */
	protected Solution<T> backTrace(State<T> end,State<T> start)
	{
		State<T> state;
		ArrayList<State<T>> a = new ArrayList<State<T>>();
		a.add(end);
		state = end.getCameFrom();
		while(state!=null )
		{
			a.add(state);
			state = state.getCameFrom();	
		}
		Solution<T> sol = new Solution<T>(a);
		
		return sol;
	}
	
	/**
	 * Override method hashCode
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		return toString().hashCode();
	}
}
