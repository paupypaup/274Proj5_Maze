import java.util.Scanner;
/**
 * Checks for valid user input
 * @author Chung Kim
 *
 */
public class CheckInput 
{
	/**
	 * Checks that the user has inputed an integer
	 * @return	Returns the valid input
	 */
	public static int checkInt()
	{
		Scanner in = new Scanner(System.in);
		int validNum = 0;
		boolean valid = false;
		while(!valid) 
		{
			if(in.hasNextInt()) 
			{
				validNum = in.nextInt();
				valid = true;
			} else 
			{
				System.out.println("Invalid input");
				in.next();
			}
		}
		return validNum;
	}
	
	/**
	 * Checks that the user inputed an integer within a given range
	 * @param low 	The smallest integer that the user can input
	 * @param high	The largest integer that the user can input
	 * @return Returns the inputed integer if it was valid
	 */
	public static int checkInt(int low, int high)
	{
		Scanner in = new Scanner(System.in);
		int validNum = 0;
		boolean valid = false;
		while(!valid) 
		{
			if(in.hasNextInt()) 
			{
				validNum = in.nextInt();
				if (validNum >= low && validNum <= high)
				{
					valid = true;
				} else 
				{
					System.out.println("Invalid integer");
				}
			} else 
			{
				System.out.println("Invalid input");
				in.next();
			}
		}
		return validNum;
	}
}