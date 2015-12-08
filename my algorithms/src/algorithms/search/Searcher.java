package algorithms.search;


/**
*<h1>  Searcher interface <h1>
* This interface presents any searcher
* that finds path from the start state<T>
* to the goal State<T>
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public interface Searcher <T>
{
    // the search method
	/**
	 * This method finds the best path, gets a Searchable<T> and creates the path
	 * @param Searchable<T>
	 * @return Solution<T>
	 */
	public Solution<T> search(Searchable<T> s);
	
    // get how many nodes were evaluated by the algorithm
	/**
	 * This method return the number of nodes that are popped from the openList
	 * @return Solution<T>
	 */
	public int getNumberOfNodesEvaluated();
}
