import java.awt.Point;

/**
 * Stack Class that places a Node to the top of the stack and removes from top first
 * @author Chung Kim
 *
 */
public class LinkedStack 
{
	/**
	 * The Node that is at the top of the Stack
	 */
	private Node top;
	
	/**
	 * Constructor for the stack
	 */
	public LinkedStack() 
	{
		top = null;
	}
	
	/**
	 * Checks if the stack is empty
	 * @return True if stack is empty, else returns false
	 */
	public boolean isEmpty() 
	{
		return top == null;
	}
	
	/**
	 * Adds a Node to the top of the stack
	 * @param p The point to be contained in the Node
	 */
	public void push( Point p ) 
	{
		top = new Node( p, top );
	}
	
	/**
	 * Removes the Node that is at the top of the stack
	 * @return The Node that was removed from the stack
	 */
	public Point pop() 
	{
		Point p = null;
		
		if( isEmpty() )
		{
			System.out.println("Nothing to Remove");
		} else 
		 {
			p = top.getValue();
			top = top.getNext();
		 }
		return p;
	}
	
	/**
	 * Finds the Pointed in the top Node, without removing the Node
	 * @return the Point contained in the top-most Node
	 */
	public Point peek() 
	{
		Point p = null;
		if( isEmpty() )
		{
			System.out.println("Stack is Empty");
		} else 
		{
			p = top.getValue();
		}
		return p;
	}
	
	/**
	 *Overridden function converting all the Points contained in the stack into String format
	 * @return the String of the all the Points in the queue
	 */
	public String toString() 
	{
		String s = "";
		Node n = top;
		while( n != null ) 
		{
			s = s + n.getValue() + "";
			n = n.getNext();
		}
		return s;
	}
}