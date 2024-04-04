package a5;

public interface INode {
	/* This interface represents a node with the coordinates.
	 */
	public static final int LOWER_LIMIT = -100;  
	public static final int UPPER_LIMIT =  100;
	static final int DEFAULT_X =10; 
	static final int DEFAULT_Y =20;
	static final int DEFAULT_Z =20;
	
	public void add(Node INode) throws Exception;

	int compareTo(Object o);
	
}