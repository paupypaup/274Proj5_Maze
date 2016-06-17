import java.awt.Point;
import java.io.*;
import java.util.Scanner;
/**
 * Creates a program that imports in mazes from files. 
 * Allows user to solve the mazes using stacks (DFS) or queues (BFS)
 * Allows user to solve the mazes him/herself
 * @author Chung Kim
 *
 */
public class MazeSolver 
{
	public static void main ( String [] args)
	{
		char[][] maze = null; 
		boolean menu = true;
		do 
		{
			displayMenu();
			int menuInput = CheckInput.checkInt(1,3);
			switch(menuInput)
			{
				case 1: //Choose maze level (1-4)
					System.out.println("Choose the maze level (1-4)");
					int difficulty = CheckInput.checkInt(1,4);
					switch(difficulty)
					{
						case 1: 
							maze = createMaze("Maze-Level0.txt"); 
							System.out.println("1. DFS\n2. BFS");
							int choice = CheckInput.checkInt(1,2);
							if (choice == 1)
							{
								DFS(maze,0 ,0);
							}else
							{
								BFS(maze);
							}
							break;
						case 2: 
							maze = createMaze("Maze-Level1.txt"); 
							System.out.println("1. DFS\n2. BFS");
							choice = CheckInput.checkInt(1,2);
							if (choice == 1)
							{
								DFS(maze, 0, 0);
							}else
							{
								BFS(maze);
							}									
							break;
						case 3:
							maze = createMaze("Maze-Level2.txt"); 
							System.out.println("1. DFS\n2. BFS");
							choice = CheckInput.checkInt(1,2);
							if (choice == 1)
							{
								DFS(maze,0 ,0);
							}else
							{
								BFS(maze);
							}									
							break;
						case 4:
							maze = createMaze("Maze-Level3.txt"); 
							System.out.println("1. DFS\n2. BFS");
							choice = CheckInput.checkInt(1,2);
							if (choice == 1)
							{
								DFS(maze, 0, 0);
							}else
							{
								BFS(maze);
							}									
							break;
						}
						System.out.println("");
						break;
						
				case 2: //allow user to solve
					System.out.println("Choose the maze level (1-4)");
					int mazeDifficulty = CheckInput.checkInt(1,4);
					switch(mazeDifficulty)
					{
						case 1: 
							maze = createMaze("Maze-Level0.txt"); 
							userSolve(maze);
							
							break;
						case 2: 
							maze = createMaze("Maze-Level1.txt"); 
							userSolve(maze);
		
							break;
						case 3:
							maze = createMaze("Maze-Level2.txt"); 
							userSolve(maze);
			
							break;
						case 4:
							maze = createMaze("Maze-Level3.txt"); 
							userSolve(maze);
				
							break;
						}
						System.out.println("");
						break;
						
				case 3: //Quit
						System.out.println("Exiting.");
						menu = false;
						break;
			}
		} while (menu);
	}
	
	/**
	 * Displays the main menu
	 */
	public static void displayMenu ()
	{
		System.out.println("MAIN MENU");
		System.out.println("1. Choose the maze level");
		System.out.println("2. Manually solve the maze");
		System.out.println("3. Quit");
	}
	
	/**
	 * Imports a maze from a file and places it in a 2D array
	 * @param fileName the name of the file containing the maze
	 * @return returns a 2D array maze
	 */
	public static char[][] createMaze( String fileName )
	{	
		char[][] grid = null;
		
		try 
		{
			Scanner read = new Scanner(new File (fileName));
			int y = read.nextInt();
			int x = read.nextInt();
			int yCord = 0;
			
			grid = new char [x][y];
			 
			while ( read.hasNext() )
			{
				String s = read.nextLine();

				if ( yCord >= 1 )
				{
				    for (int i = 0; i < x; i++)
				    {
				    	char firstChar = s.charAt(i);
				    	grid[i][(yCord-1)] = firstChar;
				    
				    }
				}	
				yCord++;				
			}
					
			//Printing the maze
			for (int i = 0; i < y; i ++)
			{
	            for (int j = 0; j < x; j++)
	            {
	                System.out.print (grid[j][i]);
	            }
	            System.out.println();
			}
		} catch (FileNotFoundException e) 
		{
			System.out.println("File not found.");
		}
		
		return grid;
	}
	
	/**
	 * Solves the maze using Depth First Search (a stack)
	 * @param maze the maze to be solved
	 */
	public static void DFS( char [][] maze, int xGiven, int yGiven)
	{	
		int startX = xGiven;
		int startY = yGiven;
		int row = maze.length; //x length
		int col = maze[0].length; //y length
		boolean finished = false;
		
		//find starting point
		for (int j = 0; j < col; j ++)
		{
        		for (int i = 0; i < row; i++)
        		{
		                if (maze[i][j] == 's')
		                {
		                	startX = i;
		                	startY = j;
		                }
            		}
		}
 
		//create stack
		LinkedStack stack = new LinkedStack();
		
		//Start point
		Point start = new Point (startX, startY);
		
		//Add starting point to the stack
		stack.push(start);
		
		int x = startX;
		int y = startY;

		char up = maze[x][y+1] ;
		char down = maze[x][y-1] ;
		char left =  maze[x-1][y] ;
		char right = maze[x+1][y] ;
		             
		while (!finished)
		{
			if (up != 'f' && down != 'f' && left != 'f' && right != 'f')
			{
				if (up == ' ' || down == ' ' || left == ' ' || right == ' ' || up == '.' || down == '.' || left == '.' || right == '.')
				{
					if ( up == ' ' || up == '.')
					{
						Point p = new Point (x, (y+1) );
						stack.push(p);
						maze[ (int) p.getX()][ (int) p.getY()] = 'X';		
						
					}
					if ( down == ' ' || down == '.')
					{
						Point p = new Point (x, (y-1) );
						stack.push(p);
						maze[ (int) p.getX()][ (int) p.getY()] = 'X';		
	
					}
					if ( left == ' ' || left =='.')
					{
						Point p = new Point ( (x-1), y);
						stack.push(p);
						maze[ (int) p.getX()][ (int) p.getY()] = 'X';		
	
					}
					if ( right == ' ' || right == '.')
					{
						Point p = new Point ( (x+1), y);
						stack.push(p);
						maze[ (int) p.getX()][ (int) p.getY()] = 'X';
						
					}
					
					Point next = stack.peek();
					x = (int) next.getX();
					y = (int) next.getY();
					up = maze[x][y+1];
					down = maze[x][y-1];
					left =  maze[x-1][y];
					right = maze[x+1][y];
					
				}else
				{
					while ( up != ' ' && down != ' ' && left != ' ' && right != ' ' && up != '.' && down != '.' && left != '.' && right != '.')
					{
						stack.pop();
						
						Point next = stack.peek();
						x = (int) next.getX();
						y = (int) next.getY();
						up = maze[x][y+1];
						down = maze[x][y-1];
						left =  maze[x-1][y];
						right = maze[x+1][y];
					}
				}
					
			}else 
			{
				finished = true;
			}
		} 
				
		while (stack.peek().getX() != startX || stack.peek().getY() != startY)
		{
			Point path = stack.pop();
			maze[(int) path.getX()][(int) path.getY()] = '.';
		}		
		
		//Print finished maze
		for (int i = 0; i < col; i ++)
		{
			for (int j = 0; j < row; j++)
	            	{
	                	System.out.print (maze[j][i]);
	            	}
			System.out.println();
		}
	}
	
	/**
	 * Solves the maze using Breadth First Search (a queue)
	 * @param maze the maze to be solved
	 */
	public static void BFS( char [][] maze )
	{	
		int startX = -1;
		int startY = -1;
		int row = maze.length; //x length
		int col = maze[0].length; //y length
		boolean finished = false;
		Point next = null;
		
		//find starting point
		for (int j = 0; j < col; j ++)
		{
            for (int i = 0; i < row; i++)
            {
                if (maze[i][j] == 's')
                {
                	startX = i;
                	startY = j;
                }
            }
	}
 
		//create queue
		LinkedQueue queue = new LinkedQueue();
		
		//Start point
		Point start = new Point (startX, startY);
		
		//Add starting point to the stack
		queue.add(start);
		
		int x = startX;
		int y = startY;
		
		char up = maze[x][y+1] ;
		char down = maze[x][y-1] ;
		char left =  maze[x-1][y] ;
		char right = maze[x+1][y] ;
		             
		while (!finished)
		{
			if (up != 'f' && down != 'f' && left != 'f' && right != 'f')
			{
				if (up == ' ' || down == ' ' || left == ' ' || right == ' ')
				{
					if ( up == ' ')
					{
						Point p = new Point (x, (y+1) );
						queue.add(p);		
						maze[ (int) p.getX()][ (int) p.getY()] = '.';
						
						next = p;
						
						
					} 
					if ( down == ' ')
					{
						Point p = new Point (x, (y-1) );
						queue.add(p);
						maze[ (int) p.getX()][ (int) p.getY()] = '.';
						
						next = p;
						
					} 
					if ( left == ' ')
					{
						Point p = new Point ( (x-1), y);
						queue.add(p);
						maze[ (int) p.getX()][ (int) p.getY()] = '.';
						
						next = p;
	
					} 
					if ( right == ' ')
					{
						Point p = new Point ( (x+1), y);
						queue.add(p);
						maze[ (int) p.getX()][ (int) p.getY()] = '.';
						
						next = p;
						
					}
					
					x = (int) next.getX();
					y = (int) next.getY();
					up = maze[x][y+1];
					down = maze[x][y-1];
					left =  maze[x-1][y];
					right = maze[x+1][y];
					
				}else
				{
					
					
					while (!queue.isEmpty())
					{
						Point p = queue.remove();
						x = (int) p.getX();
						y = (int) p.getY();
						
						maze[x][y] = ' ';
						
					}
					
					maze[startX][startY] = 's';
					maze [(int) next.getX()][(int) next.getY()] = 'X';
					
					queue.add(start);
					x = (int) start.getX();
					y = (int) start.getY();
					up = maze[x][y+1];
					down = maze[x][y-1];
					left =  maze[x-1][y];
					right = maze[x+1][y];
				}
					
			}else 
			{
				finished = true;
			}
		} 	
		
		//Print finished maze
		for (int i = 0; i < col; i ++)
		{
            for (int j = 0; j < row; j++)
            {
                System.out.print (maze[j][i]);
            }
            System.out.println();
		}
	}
	
	/**
	 * Allows the user to solve the maze
	 * @param maze the maze to be solved
	 */
	public static void userSolve( char [][] maze )
	{
		System.out.println("2 - down \n4 - left \n6 - right \n8 - up");
		int startX = -1;
		int startY = -1;
		int row = maze.length; //x length
		int col = maze[0].length; //y length
		boolean finished = false;
		
		//find starting point
		for (int j = 0; j < col; j ++)
		{
            for (int i = 0; i < row; i++)
            {
                if (maze[i][j] == 's')
                {
                	startX = i;
                	startY = j;
                }
            }
		}
		
		System.out.println("Press 0 at any time to go back to the main menu");
		System.out.println("");


		//Start coordinates		
		int x = startX;
		int y = startY;
		
		int userInput = CheckInput.checkInt();

		while ( !finished )
		{
			if ( userInput == 8 || userInput == 4|| userInput == 6 || userInput == 2 || userInput == 0)
			{
				if ( userInput == 8)
				{
					y = y-1;
					
					if ( maze[x][y] == 'f')
					{
						System.out.println("You reached the end of the maze!");
						finished = true;
					} else
					{
						if ( maze[x][y] == '*')
						{
							System.out.println("You hit a wall. Try again.");
							y = y+1;
							userInput = CheckInput.checkInt();
							
						}else
						{					
							System.out.println("You are at: (" + x + ", "+ y +")");
	
							maze[x][y+1] = '.';
							maze[startX][startY] ='s';
							maze[x][y] = 'X';
						
							//Print maze
							for (int i = 0; i < col; i ++)
							{
					            for (int j = 0; j < row; j++)
					            {
					                System.out.print (maze[j][i]);
					            }
					            System.out.println();
							}
							
							userInput = CheckInput.checkInt();
						}
					}
				}
				
				if ( userInput == 2)
				{
					y = y + 1;
					
					if ( maze[x][y] == 'f')
					{
						System.out.println("You reached the end of the maze!");
						finished = true;
					} else
					{
						if ( maze[x][y] == '*')
						{
							System.out.println("You hit a wall. Try again.");
							y = y - 1;
							userInput = CheckInput.checkInt();
							
						}else
						{					
							System.out.println("You are at: (" + x + ", "+ y +")");
	
							maze[x][y-1] = '.';
							maze[startX][startY] ='s';
							maze[x][y] = 'X';
						
							//Print maze
							for (int i = 0; i < col; i ++)
							{
					            for (int j = 0; j < row; j++)
					            {
					                System.out.print (maze[j][i]);
					            }
					            System.out.println();
							}
							
							userInput = CheckInput.checkInt();
						}
					}
				}
				
				if ( userInput == 4)
				{
					x = x - 1;
					
					if ( maze[x][y] == 'f')
					{
						System.out.println("You reached the end of the maze!");
						finished = true;
					} else
					{
						if ( maze[x][y] == '*')
						{
							System.out.println("You hit a wall. Try again.");
							x = x + 1;
							userInput = CheckInput.checkInt();
							
						}else
						{					
							System.out.println("You are at: (" + x + ", "+ y +")");
	
							maze[x+1][y] = '.';
							maze[startX][startY] ='s';
							maze[x][y] = 'X';
						
							//Print maze
							for (int i = 0; i < col; i ++)
							{
					            for (int j = 0; j < row; j++)
					            {
					                System.out.print (maze[j][i]);
					            }
					            System.out.println();
							}
							
							userInput = CheckInput.checkInt();
						}
					}
				}
				
				if ( userInput == 6)
				{
					x = x + 1;
					
					if ( maze[x][y] == 'f')
					{
						System.out.println("You reached the end of the maze!");
						finished = true;
					} else
					{
						if ( maze[x][y] == '*')
						{
							System.out.println("You hit a wall. Try again.");
							x = x - 1;
							userInput = CheckInput.checkInt();
							
						}else
						{					
							System.out.println("You are at: (" + x + ", "+ y +")");
	
							maze[x-1][y] = '.';
							maze[startX][startY] ='s';
							maze[x][y] = 'X';
						
							//Print maze
							for (int i = 0; i < col; i ++)
							{
					            for (int j = 0; j < row; j++)
					            {
					                System.out.print (maze[j][i]);
					            }
					            System.out.println();
							}
							
							userInput = CheckInput.checkInt();
						}
					}
				}
				
				if ( userInput == 0 )
				{
					finished = true;
					DFS(maze, x, y);
					System.out.println("Back to main menu.");

				}
				
			}else
			{
				System.out.println("Invalid input.");
				userInput = CheckInput.checkInt();				
			}
			
		}
		
	}
}
