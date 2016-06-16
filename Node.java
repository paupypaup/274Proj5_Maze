import java.awt.Point;

/**
 * Node class that contains a Point with x and y coordinate to be used in stacks and queues
 * @author Chung Kim
 *
 */
public class Node 
{
	
	/**
	 * The Point contained in the Node
	 */
	private Point value;
	
	/**
	 * The pointed for the next Node
	 */
	private Node next;
	
	/**
	 * The constructor for the Node in the end of the stack/queue/LinkedList
	 * @param v The Point to be contained inside the Node
	 */
	public Node( Point v )
	{
		value = v;
		next = null;
	}
	
	/**
	 * Overloaded constructor for the Node to be placed somewhere other than at the end
	 * @param v The Point to be contained in the Node
	 * @param n Then next Node in the list
	 */
	public Node( Point v, Node n ) 
	{
		value = v;
		next = n;
	}
	
	/**
	 * Gets the Point inside the Node
	 * @return Point contained in the Node
	 */
	public Point getValue() 
	{
		return value;
	}
	
	/**
	 * Gets the next Node in the series
	 * @return next Node that this Node is pointing to
	 */
	public Node getNext() 
	{
		return next;
	}

	/**
	 * Sets a new Point inside this Node
	 * @param v New Point to be set
	 */
	public void setValue( Point v ) 
	{
		value = v;
	}
	
	/**
	 * Sets a new Node after this Node
	 * @param n new Node to place after this one
	 */
	public void setNext( Node n ) 
	{
		next = n;
	}
}