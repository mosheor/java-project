package classes;

/**
*<h1>  State class <h1>
* This class define state
* This class is Comparable<State<T>>
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/

public class State<T> implements Comparable<State<T>>
{
	private T state;           // the state represented by T
	private double cost;       // cost to reach this state
	private State<T> cameFrom; // the state we came from to this state
	
	/**
	 * default Ctor
	 */
	public State() {}
	
	/**
	 * Constructor with state parameter
	 * @param T state
	 */
	public State(T state)
	{
		this.state = state;
	}
	
	/**
	 * Override method hashCode, from Object
	 * @return int
	 */
	@Override
	public int hashCode() {
		return this.state.hashCode();
	}
	
	/**
	 * Equals method
	 * @param State<T>
	 * @return boolean
	 */
	public boolean equals(State<T> s) {
		return this.state.equals(s.getState());
	}
	
	/**
	 * Equals method, override from Object
	 * @param State<T>
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass())
			return state.equals(((State<T>)obj).getState());
		return false;
	}
	
	/**
	 * Set cameFrom
	 * @param State<T>
	 */
	public void setCameFrom(State<T> state)
	{
		this.cameFrom = state;
	}
	
	/**
	 * Get getCameFrom(father)
	 * @return State<T>
	 */
	public State<T> getCameFrom()
	{
		return this.cameFrom;
	}
	
	/**
	 * Get cost
	 * @return double
	 */
	public double getCost()
	{
		return this.cost;
	}
	
	/**
	 * Set cost
	 * @return T
	 */
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	
	/**
	 * Set state
	 * @param T
	 */
	public void setState(T s)
	{
		this.state = s;
	}
	
	/**
	 * Get state
	 * @return T
	 */
	public T getState()
	{
		return this.state;
	}

	/**
	 * Override method to string, from Object
	 * @return String -> {x, y, z}
	 */
	@Override
	public String toString()
	{
		return state.toString();
	}

	/**
	 * Override method comperTo
	 * @return int 
	 */
	@Override
	public int compareTo(State<T> s) {
		if(this.getCost()>s.getCost())
			return 1;
		if(this.getCost()<s.getCost())
			return -1;
		return 0;
	}
}
