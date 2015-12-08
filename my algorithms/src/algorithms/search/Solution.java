package algorithms.search;

import java.util.ArrayList;

import classes.State;

/**
*<h1>  Solution class <h1>
* This class defines the solution of
* any search problem
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public class Solution<T>
{
	private ArrayList<State<T>> solution;

	/**
	 * Constructor with ArrayList<State<T>> argument
	 * @param ArrayList<State<T>>
	 */
	public Solution(ArrayList<State<T>> sol)
	{
		this.solution = sol;
	}
	
	/**
	 * Get arrayList
	 * @return ArrayList<State<T>>
	 */
	public ArrayList<State<T>> getSolution()
	{
		return this.solution;
	}
	

	/**
	 * Get arrayList size
	 * @return ArrayList<State<T>>
	 */
	public int getSolutionSize()
	{
		return this.solution.size();
	}
	
	/**
	 * Adds State<T> to ArratList<State<T>>
	 * @param State<T> s
	 */
	public void addSolution(State<T> s)
	{
		this.solution.add(s);
	}
	
	/**
	 * prints the Solution
	 */
	public void printSolution()
	{
		System.out.println("The solution: ");
		
		for (int i = 0; i < this.solution.size(); i++) 
		{
			System.out.println(this.solution.get(i));
		}
	}
}
