package a6;
import a5.Node;
public class ThreeDNode extends Node {

    private int z;

    ///Default constructor with x,y and z initialized to default values.
    public ThreeDNode() throws Exception {
        this(DEFAULT_X, DEFAULT_Y, DEFAULT_Z);
    }
    /**
	 * Parameter constructor
	 * @param x, y, z
	 * @throws Exception
	 */
    public ThreeDNode(int x, int y, int z) throws Exception {
        super(x, y);
        setZ(z);
    }
    /**
	 * Copy constructor
	 * @param node
	 * @throws Exception
	 */
    public ThreeDNode(ThreeDNode node) throws Exception {
        this(node.getX(), node.getY(), node.getZ());
    }
    /**
     * Get the z-coordinate.
     ** @returns the z value
     */
    public int getZ() {
        return z;
    }
    /**
    * Set the z-coordinate.
    * @param z to set z-coordinate value
    * @throws Exception if z is out of range
    */
    public void setZ(int z) throws Exception {
    	if (isValidZ(z))
			this.z = z;
    	else
    		throw new Exception("Invalid operation: z value shoud be in the range: ["+LOWER_LIMIT+","+UPPER_LIMIT+"]");
    }

    private boolean isValidZ(int z) {
    	if (z<=UPPER_LIMIT && z>=LOWER_LIMIT)
			return true;
		return false;
    }
    /**
     * Add another node to this node.
     * @param 'node' to add to the caller node
     * @throws exception if the result is out of range
     */
    @Override
    public void add(Node node) throws Exception {
        if (node instanceof ThreeDNode) {
            ThreeDNode other = (ThreeDNode) node;
            int newX = getX() + other.getX();
            int newY = getY() + other.getY();
            int newZ = z + other.getZ();
            if (isValidX(newX) && isValidY(newY) && isValidZ(newZ)) {
                setX(newX);
                setY(newY);
                this.z = newZ;
            } else {
                throw new Exception("Invalid operation, the result exceeds the xyz-space boundaries");
            }
        } else {
            throw new Exception("Invalid node type. Expected ThreeDNode.");
        }
    }
    /**
     * Override toString method to return a string that represents the Node.
     * @return string representation of the node
     */
    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + this.z + ")";
    }
   /**
    * Checks if object is equal to this ThreeDNode.
    * Two ThreeDNodes are considered equal if they have the same coordinates.
    * @param obj the object to compare
    * @return true if equal, false otherwise
    */
    @Override
    public boolean equals(Object obj) {
              
      //to restrict call with only objects of type Node
      		if (obj instanceof ThreeDNode) {
      			ThreeDNode ref = (ThreeDNode) obj;
      			if (getX()==ref.getX() && getY() == ref.getY() && this.z == ref.getZ())
      				return true;
      			return false;
      		}
      		return false;
      	}
    /**
     * Compares this ThreeDNode with the specified object for order. 
     * Returns a negative integer, zero or a positive integer as this ThreeDNode is less than, equal to or greater than the specified object. 
     * @param o The object to be compared
     * @return A negative integer, zero or a positive integer as this ThreeDNode is less than, equal to or greater than the specified object
     */
    @Override
	public int compareTo(Object o) {
		if (o instanceof ThreeDNode) {
			ThreeDNode ref = (ThreeDNode) o;
		int sum1 = getX() + getY()+getZ();
        int sum2 = ref.getX() + ref.getY()+ref.getZ();
        return Integer.compare(sum1, sum2);
		}
		else
			return 0;
	}
    public static void main(String[] args) {
        try {
            // Create a ThreeDNode using default constructor
            ThreeDNode node1 = new ThreeDNode();
            System.out.println("Default ThreeDNode: " + node1);

            // Create a ThreeDNode with custom coordinates
            ThreeDNode node2 = new ThreeDNode(10, 20, 30);
            System.out.println("Custom ThreeDNode: " + node2);

            // Create a copy of a ThreeDNode
            ThreeDNode node3 = new ThreeDNode(node2);
            System.out.println("Copy of ThreeDNode: " + node3);

            // Test equality of ThreeDNodes
            System.out.println("Node2 equals Node3: " + node2.equals(node3));

            // Test adding Two ThreeDNodes
            ThreeDNode node4 = new ThreeDNode(5, 15, 20);
            node2.add(node4);
            
         // Test compare to Two ThreeDNodes
            ThreeDNode node5 = new ThreeDNode(10, 20, 30);
            System.out.println("After comparing Node5 to Node2: " + node5.compareTo(node2));
            System.out.println("After comparing Node5 to Node2: " + node2.compareTo(node2));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
