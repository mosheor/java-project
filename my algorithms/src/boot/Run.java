package boot;

import java.util.Scanner;

import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.SimpleMaze3dGenerator;
import classes.Maze3d;
import classes.Position;

/**
*<h1>  Run class <h1>
*The main of Matala 1 is in this class.
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public class Run
{
	private static void testMazeGenerator(Maze3dGenerator mg)
	{
		// prints the time it takes the algorithm to run
		Scanner s = new Scanner(System.in);
		
		System.out.println("please enter the maze sizes: ");
		System.out.print("z (height): ");
		int z = s.nextInt();
		System.out.print("y (depth): ");
		int y = s.nextInt();
		System.out.print("x (width): ");
		int x = s.nextInt();
		
		System.out.println(mg.measureAlgorithmTime(z, y, x));
		// generate another 3d maze
		Maze3d maze=mg.generate(z, y, x);
		// get the maze entrance
		Position p=maze.getStartPosition();
		// print the position
		System.out.println(p); // format "{x,y,z}"
		// get all the possible moves from a position
		String[] moves=maze.getPossibleMoves(p);
		// print the moves
		for(String move : moves)
		System.out.println(move);
		// prints the maze exit position
		System.out.println(maze.getEndPosition());
		
		try{
			// get 2d cross sections of the 3d maze
			int[][] maze2dx=maze.getCrossSectionByX(2);
			int[][] maze2dy=maze.getCrossSectionByY(5);
			int[][] maze2dz=maze.getCrossSectionByZ(0);
			
			// this should throw an exception!
			maze.getCrossSectionByX(-1);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("good!");
		}
		maze.printMaze();
	}
	
	/**
	 * the main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		testMazeGenerator(new SimpleMaze3dGenerator());
		testMazeGenerator(new MyMaze3dGenerator());
	}
}
