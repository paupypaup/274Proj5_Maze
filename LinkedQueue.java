import java.awt.Point;
/**
 * Queue Class that places a Node to the end of the queue and removes from front first
 * @author Chung Kim
 *
 */
public class LinkedQueue 
{
	/**
	 * Pointes to the Node that is in the first position in the queue
	 */
	private Node first;
	
	/**
	 * Points to the Node that is last in the queue
	 */
	private Node last;
	
	/**
	 * Constructor for the queue
	 */
	public LinkedQueue()
	{
		first = null;
		last = null;
	}
	
	/**
	 * Checks if the queue is empty
	 * @return True if stack is empty, else returns false
	 */
	public boolean isEmpty() 
	{
		return first == null;
	}

	/**
	 * Adds a Node to the end of the queue
	 * @param p The point contained inside the Node
	 */
	public void add( Point p ) 
	{
		if( isEmpty() ) 
		{
			first = new Node(p);
			last = first;
		} else 
		{
			Node n = new Node(p);
			last.setNext(n);
			last = n;
		}
	}
	
	/**
	 * Removes the Node that is first in the queue
	 * @return returns the Point that is contained inside the Node to be removed
	 */
	public Point remove() 
	{
		Point ret = null;
		if( isEmpty() ) 
		{
			System.out.println("Nothing to Remove");
		} else 
		{
			ret = first.getValue();
			first = first.getNext();
			if( first == null ) 
			{
				last = null;
			}
		}
		return ret;
	}
	
	/**
	 * Looks at the Node that is first in the queue without removing it
	 * @return the Point in the first Node
	 */
	public Point peek() 
	{
		Point ret = null;
		if( isEmpty() ) 
		{
			System.out.println("Queue is Empty");
		} else 
		 {
			ret = first.getValue();
		 } 
		return ret;
	}
	
	/**
	 * Checks for the number of Nodes in the queue
	 * @return the number of Nodes in the queue
	 */
	public int size() 
	{
		int count = 0;
		Node n = first;
		while( n != null ) 
		{
			count++;
			n = n.getNext();
		}
		return count;
	}
	
	/**
	 * Overridden function converting all the Points contained in the stack into String format
	 * @return the String of the all the Points in the queue
	 */
	public String toString()
	{
		String s = "";
		Node n = first;
		while( n != null)
		{
			s = s + n.getValue() +"";
			n = n.getNext();
		}
		return s;
	}
}