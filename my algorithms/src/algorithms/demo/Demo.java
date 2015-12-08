package algorithms.demo;

import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import algorithms.search.StateCostComparator;
import classes.Maze3d;
import classes.Position;
import classes.State;

/**
*<h1>  Demo class <h1>
*This class present run function that 
*creates an object adapter that performs an 
*adaptation from Maze3d to Searchable.
*
* @author  Or Moshe
* @version 1.0
* @since   1/12/15
*/
public class Demo 
{
	/**
	* This method gets z,y,x
	*
	*@param int z,int y, int x
	*/
		public void run(int zSize, int ySize, int xSize)
		{
			//Create Maze3dGeneretor
			Maze3dGenerator maze = new MyMaze3dGenerator();
			maze.generate(zSize,ySize,xSize);
			
			//Print the maze
			System.out.println("The maze :");
			for(int z = 0; z < maze.getzSize(); z++)
			{
				for(int y = 0; y < maze.getySize(); y++)
				{
					for(int x = 0; x < maze.getxSize(); x++)
						System.out.print(maze.getValueInPosition(z, y, x)+" ");
					System.out.println();
				}
				System.out.println();
			}
			
			//Print start and goal positions
			System.out.println("start : " + maze.getStartPosition());		
			System.out.println("End : " + maze.getEndPosition());
			System.out.println();
			
			//Linking searchable and Searcher
			Searchable<Position> searchable = new Maze3dDomain(maze.getMaze());
			Searcher<Position> searcher = new BFS<Position>(new StateCostComparator<Position>());
			/**
			 * Start search method
			 * @param Searchable<Position>
			 * @return Solution<Position>
			 */
			Solution<Position> s = searcher.search(searchable);
			ArrayList<State<Position>> a = s.getSolution();
			//a.sort(new StateCostComparator<Position>());
			
			//Print number of evaluatedNodes , the path & the cast of each node 
			System.out.println("BFS :");
			System.out.println("evaluatedNodes = " +searcher.getNumberOfNodesEvaluated() );
			for (State<Position> state : a) {
				System.out.println(state + " " + state.getCost());
			}
			
			//Linking searchable and Searcher
			Searcher<Position> searcher1 = new AStar<Position>(new MazeManhattanDistance(searchable), new StateCostComparator<Position>());
			/**
			 * Start search method
			 * @param Searchable<Position>
			 * @return Solution<Position>
			 */
			Solution<Position> s1 = searcher1.search(searchable);
			ArrayList<State<Position>> a1 = s1.getSolution();
			//a.sort(new StateCostComparator<Position>());
			
			//Print number of evaluatedNodes , the path & the cast of each node 
			System.out.println("Astar MazeManhattanDistance:");
			System.out.println("evaluatedNodes = " +searcher1.getNumberOfNodesEvaluated() );
			for (State<Position> state : a1) {
				System.out.println(state + " " + state.getCost());
			}
			
			//Linking searchable and Searcher
			Searcher<Position> searcher2 = new AStar<Position>(new MazeAirDistance(searchable), new StateCostComparator<Position>());
			/**
			 * Start search method
			 * @param Searchable<Position>
			 * @return Solution<Position>
			 */
			Solution<Position> s2 = searcher2.search(searchable);
			ArrayList<State<Position>> a2 = s2.getSolution();
			//a.sort(new StateCostComparator<Position>());
			
			//Print number of evaluatedNodes , the path & the cast of each node 
			System.out.println("Astar MazeAirDistance:");
			System.out.println("evaluatedNodes = " +searcher2.getNumberOfNodesEvaluated() );
			for (State<Position> state : a2) {
				System.out.println(state + " " +state.getCost());
			}
			
		}

/**
 * the main method
 * @param args
 */
	public static void main(String[] args) {
		new Demo().run(5,5,5);
	}
}
