package classes;

import java.util.Random;
import java.util.Scanner;

/**
*<h1>  Maze3d class <h1>
*This class present 3 dimensioal maze
* 
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public class Maze3d {
	private int[][][] maze;
	
	private int xSize;
	private int ySize;
	private int zSize;
	
	private Position startPos;
	private Position endPos;
	
	
	/**
	 * Constructor that creates Maze3d
	 * @param int z, int y, int x - the sizes of the maze
	 */
	public Maze3d(int zSize, int ySize, int xSize)
	{
		Random rand = new Random();
		Scanner s = new Scanner(System.in);
		
		while(xSize <= 0)
		{
			System.out.print("please enter a valid x size parameter (>0): ");
			xSize = s.nextInt();
		}
		
		while(ySize <= 0)
		{
			System.out.print("please enter a valid y size parameter (>0): ");
			ySize = s.nextInt();
		}
		
		while(zSize <= 0)
		{
			System.out.print("please enter a valid z size parameter (>0): ");
			zSize = s.nextInt();
		}
		
		this.xSize = xSize;
		this.ySize = ySize;
		this.zSize = zSize;
		this.maze = new int[this.zSize][this.ySize][this.xSize];
		
		for (int i = 0; i < this.zSize; i++)
		{
			for (int j = 0; j < this.ySize; j++)
			{
				for (int k = 0; k < this.xSize; k++)
				{
					this.maze[i][j][k] = 1;
				}
			}
		}
		
		this.startPos = new Position(rand.nextInt(this.zSize),rand.nextInt(this.ySize),rand.nextInt(this.xSize));
		
		//start position != end position
		do{			
			endPos = new Position(rand.nextInt(this.zSize),rand.nextInt(this.ySize),rand.nextInt(this.xSize));
		}while(startPos.equalsPositions(endPos));
		
		// s.close();
	}
	
	/**
	 * Set start Position 
	 * @return void 
	 */
	public void setStartPos(Position startPos) {
		this.startPos = startPos;
	}

	/**
	 * Set end Position
	 * @return void 
	 */
	public void setEndPos(Position endPos) {
		this.endPos = endPos;
	}

	/**
	 * Get maze 
	 * @return int[][][] Three-dimensional array
	 */
	public int[][][] getMaze() {
		return this.maze;
	}
	
	/**
	 * returns all possible moves from position
	 * @param Postion
	 * @return String[]
	 */
	public String[] getPossibleMoves(Position pos)
	{
		String neighbors = new String("");
		
		if(pos.getX() >= 0 && pos.getX() < this.xSize-1)
		{
			if(this.maze[pos.getZ()][pos.getY()][pos.getX()+1] ==  0)
				neighbors += "Left ";
		}
		
		if(pos.getX() > 0 && pos.getX() <= this.xSize-1)
		{
			if(this.maze[pos.getZ()][pos.getY()][pos.getX()-1] ==  0)
			neighbors += "Right ";
		}		
		
		if(pos.getY() >= 0 && pos.getY() < this.ySize-1)
		{
			if(this.maze[pos.getZ()][pos.getY()+1][pos.getX()] ==  0)
				neighbors += "Forward ";
		}
		
		if(pos.getY() > 0 && pos.getY() <= this.ySize-1)
		{
			if(this.maze[pos.getZ()][pos.getY()-1][pos.getX()] ==  0)
				neighbors += "Backward ";
		}
			
		if(pos.getZ() >= 0 && pos.getZ() < this.zSize-1)
		{
			if(this.maze[pos.getZ()+1][pos.getY()][pos.getX()] ==  0)
				neighbors += "Up ";
		}
		
		if(pos.getZ() > 0 && pos.getZ() <= this.zSize-1)
		{
			if(this.maze[pos.getZ()-1][pos.getY()][pos.getX()] ==  0)
				neighbors += "Down";
		}
		
		return neighbors.split(" ");		
	}
	
	/**
	 * return all possible Position from position
	 * @param Postion
	 * @return Position[]
	 */
	public Position[] getPossiblePositions(Position pos)
	{
		String[] s = this.getPossibleMoves(pos);
		Position[] p = new Position[s.length];
		
		for (int i = 0; i < p.length; i++)
		{
			Position currentPos = new Position(pos);
			
			switch (s[i])
			{
				case "Left":
					currentPos.setX(currentPos.getX()+1);
					break;
				case "Right":
					currentPos.setX(currentPos.getX()-1);
					break;
				case "Forward":
					currentPos.setY(currentPos.getY()+1);
					break;
				case "Backward":
					currentPos.setY(currentPos.getY()-1);
					break;
				case "Up":
					currentPos.setZ(currentPos.getZ()+1);
					break;
				case "Down":
					currentPos.setZ(currentPos.getZ()-1);
					break;
			}
			
			p[i] = currentPos;
		}
		return p;
	}
	
	/**
     * changes the position value
	 * if the parameters are proper
	 * @param int z, int y, int x , int value
	 * @return int 
	 */
	public void setPositionValue(int z, int y, int x, int value)
	{//check!!
		Scanner s = new Scanner(System.in);
		
		while(!(value == 0 || value == 1))
		{
			System.out.println("enter:");
			value = s.nextInt();
		}		
			this.maze[z][y][x] = value;
		// s.close();
	}
	/**
	 * changes the position value
	 * if the parameters are proper
	 * @param Position pos , int value
	 * @return int 
	 */
	public void setPositionValue(Position pos, int value)
	{//check!!
		Scanner s = new Scanner(System.in);
		
		while(!(value == 0 || value == 1))
		{
			System.out.println("enter:");
			value = s.nextInt();
		}		
			this.maze[pos.getZ()][pos.getY()][pos.getX()] = value;
		// s.close();
	}
	
	/**
	 * Returns the value in position
	 * @param int z, int y, int x
	 * @return int value
	 */
	//maze[z][y][x]
	public int getValueInPosition(int z, int y, int x)
	{
		Scanner s = new Scanner(System.in);
		
		while(x < 0 || x >= this.xSize)
		{
			System.out.print("please enter a valid x size parameter (>0): ");
			x = s.nextInt();
		}
		
		while(y < 0 || y >= this.ySize)
		{
			System.out.print("please enter a valid y size parameter (>0): ");
			y = s.nextInt();
		}
		
		while(z < 0 || z >= this.zSize)
		{
			System.out.print("please enter a valid z size parameter (>0): ");
			z = s.nextInt();
		}
		return maze[z][y][x];
	}
	
	/**
	 * Returns the value in position
	 * @param Position pos
	 * @return int value
	 */
	public int getValueInPosition(Position pos)
	{
		Scanner s = new Scanner(System.in);
		
		while(pos.getX() < 0 || pos.getX() >= this.xSize)
		{
			System.out.print("please enter a valid x size parameter (>0): ");
			pos.setX(s.nextInt());
		}
		
		while(pos.getY() < 0 || pos.getY() >= this.ySize)
		{
			System.out.print("please enter a valid y size parameter (>0): ");
			pos.setY(s.nextInt());
		}
		
		while(pos.getZ() < 0 || pos.getZ() >= this.zSize)
		{
			System.out.print("please enter a valid z size parameter (>0): ");
			pos.setZ(s.nextInt());
		}
		return maze[pos.getZ()][pos.getY()][pos.getX()];
	}
	
	/**
	 * Get maze sizes
	 * @return int
	 */
	public int getxSize() {
		return xSize;
	}

	public int getySize() {
		return ySize;
	}

	public int getzSize() {
		return zSize;
	}

	/**
	 * Get maze start pos
	 * @return int
	 */
	public Position getStartPosition(){
		return startPos;
	}
	
	/**
	 * Get maze end pos
	 * @return int
	 */
	public Position getEndPosition(){
		return endPos;
	}
	
	/**
	 * Get x and return Two-dimensional array on this x
	 * @param int x
	 * @return int[][]
	 */
	public int[][] getCrossSectionByX(int xIndex)
	{
		if((xIndex < 0) || (xIndex > this.xSize - 1))
			throw new IndexOutOfBoundsException();
		
		int[][] maze2d = new int[this.zSize][this.ySize];
		
		for(int i = 0; i < this.zSize; i++)
			for(int j = 0; j < this.ySize; j++)
				maze2d[i][j] = this.maze[i][j][xIndex];	
		
		return maze2d;
	}
	
	/**
	 * Get y and return Two-dimensional array on this y
	 * @param int y
	 * @return int[][]
	 */
	public int[][] getCrossSectionByY(int yIndex)
	{
		if((yIndex < 0) || (yIndex > this.xSize - 1))
			throw new IndexOutOfBoundsException();
		
		int[][] maze2d = new int[this.zSize][this.xSize];
		
		for(int i = 0; i < this.zSize; i++)
			for(int j = 0; j < this.xSize; j++)
				maze2d[i][j] = this.maze[i][yIndex][j];	
		
		return maze2d;
	}
	
	/**
	 * Get z and return Two-dimensional array on this z
	 * @param int z
	 * @return int[][]
	 */
	public int[][] getCrossSectionByZ(int zIndex)
	{
		if((zIndex < 0) || (zIndex > this.xSize - 1))
			throw new IndexOutOfBoundsException();
		
		int[][] maze2d = new int[this.ySize][this.xSize];
		
		for(int i = 0; i < this.ySize; i++)
			for(int j = 0; j < this.xSize; j++)
				maze2d[i][j] = this.maze[zIndex][i][j];	
		
		return maze2d;
	}
	
	/**
	 * Prints the maze
	 */
	public void printMaze()
	{
		System.out.println("the maze:");
		for (int i = 0; i < this.zSize; i++)
		{
			System.out.println("maze[" + i + "][][]: ");
			for (int j = 0; j < this.ySize; j++)
			{
				System.out.print("maze[" + i + "][" +j + "][]: ");
				for (int k = 0; k < this.xSize; k++)
				{
					System.out.print(maze[i][j][k] + " ");
				}
				System.out.println("");
			}
			System.out.println("\n");
		}
	}
}
