package classes;

/**
*<h1> Position class <h1>
* This class present position in the maze
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public class Position {

	private int x;
	private int y;
	private int z;
	
	/**
	 * Constructor that creates Position
	 * @param int z, int y , int x (the Position x,y,z)
	 */
	public Position(int z, int y, int x) {
		this.x = x;
		this.y= y;
		this.z = z;
	}
	
	/**
	 * Copy Ctor
	 * @param Position pos
	 */
	public Position(Position pos)
	{
		this.x = pos.getX();
		this.y = pos.getY();
		this.z = pos.getZ();
	}
	
	/**
	 * Position set
	 * @param Position pos
	 */
	public void setPosition(Position pos)
	{
		this.x = pos.getX();
		this.y = pos.getY();
		this.z = pos.getZ();
	}
	
	/**
	 * Position set
	 * @param int z, int y, int x
	 */
	public void setPosition(int z, int y, int x)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * like the func Object.equals
	 * @param Position
	 * @return boolean
	 */
	public boolean equalsPositions(Position pos) {
		return ((this.x == pos.getX()) && (this.y == pos.getY()) && (this.z == pos.getZ()));
	}
	
	/**
	 * Override method equals
	 * @param Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(obj.getClass() == this.getClass())
			return equals((Position)obj);
		return false;
	}
	
	/**
	 * Override method hashCode
	 * @return int
	 */
	@Override
	public int hashCode() {
		String s = "" + this.getX() + this.getY() + this.getZ();
		return s.hashCode();
	}
	
	/**
	 * Get x
	 * @return int
	 */
	public int getX() {
		return x;
	}

	/**
	 * Set x
	 * @param int
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get y
	 * @return int
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set y
	 * @return int
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Get z
	 * @return int
	 */
	public int getZ() {
		return z;
	}

	/**
	 * Set z
	 * @return int
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/**
	 * Override method to string
	 * @return String in this structure {x,y,})
	 */
	@Override
	public String toString() {
		return "{" + this.x + "," + this.y + "," + this.z + "}";
	}
}
