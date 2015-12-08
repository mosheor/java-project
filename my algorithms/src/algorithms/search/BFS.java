package algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

import classes.State;

/**
*<h1>  BFS class <h1>
* This class finds a path in the maze
* BFS is an extend from CommonSearcher<T>
* 
*
* @author  Or Moshe
* @version 1.0
* @since   2/12/15
*/
public class BFS<T> extends CommonSearcher<T>
{
	/**
	 * Constructor that gets StateCostComparator<T> 
	 * @param StateCostComparator<T>
	 */
	public BFS (StateCostComparator<T> c)
	{
		super(c);
	}
	
	/**
	 * This method finds the best path, gets type of Searchable<T> and creates the path
	 * @param Searchable<T>
	 * @return Solution<T>
	 */
	public Solution<T> search(Searchable<T> s)
	{
		addToOpenList(s.getInitialState());
		HashSet<State<T>> closedSet = new HashSet<State<T>>();
		
		while(openList.size() > 0)
		{
			State<T> n = popOpenList(); //dequeue
			closedSet.add(n);
			
			if(n.equals(s.getEndState()))
				return backTrace(n, s.getInitialState());
			
			ArrayList<State<T>> succesors = s.getAllPossibleStates(n);
			
			for(State<T> state : succesors)
			{
				if(!closedSet.contains(state) && !openList.contains(state))
				{
					state.setCameFrom(n);
					addToOpenList(state);
				}
				
				else
				{
					if(state.getCost() > this.calculate(state))
					{
						if(!openList.contains(state))
						{
							state.setCameFrom(n);
							addToOpenList(state);
						}
						
						else
						{
							openList.remove(state);
							state.setCameFrom(n);
							addToOpenList(state);
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * This method calculates the cost of the state<T>
	 * @param State<T>
	 * @return double
	 */
	public double calculate(State<T> s)
	{ 
		if(s.getCameFrom() == null) 
			return 0;
		
		return s.getCameFrom().getCost() + 1;
	}
}
