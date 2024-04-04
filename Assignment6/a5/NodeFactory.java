package a5;

import java.util.Random;
import a6.ThreeDNode;
public class NodeFactory {
	/**
	 * Create a ThreeDNode according to the given parameters, if parameters are invalid
	 * return a default ThreeDNode 
	 * @return
	 * @throws Exception 
	 */
	public static ThreeDNode getThreeDNode() throws Exception {
		try {
		Random r = new Random();
		int z = INode.LOWER_LIMIT + r.nextInt(INode.UPPER_LIMIT-  INode.LOWER_LIMIT+1);
		Node node = getNode();
		//System.out.println(node.getX()+" threeNodes NFactory");
	    return new ThreeDNode(node.getX(),node.getY(),z);
		}catch (Exception e) {
	        //System.err.println("Error creating ThreeDNode: ");
            return new ThreeDNode();
		}
	}
	
	public static Node getNode() throws Exception {
		try {
		Random r = new Random();
		//System.out.println("kk"+r.nextInt(INode.UPPER_LIMIT-  INode.LOWER_LIMIT+1));
		int x = INode.LOWER_LIMIT + r.nextInt(INode.UPPER_LIMIT-  INode.LOWER_LIMIT+1);
		int y = INode.LOWER_LIMIT + r.nextInt(INode.UPPER_LIMIT-  INode.LOWER_LIMIT+1);
		//System.out.println(x+" bn"+y);
		return new Node(x,y);
		}catch (Exception e) {
	        //System.err.println("Error creating Node: ");
            return new Node();
		}
	}

}
