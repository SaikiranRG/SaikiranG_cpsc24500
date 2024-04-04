package a5;

import java.util.Comparator;

public class NodesSorter implements Comparator<INode>{
	/**
	 * Compares two INode objects for order.
	 * @param node1 The first INode to be compared
	 * @param node2 The second INode to be compared
	 * @return A negative integer, zero or a positive integer as the first INode is less than, equal to or greater than the second INode
	 */
	public int compare(INode node1, INode node2) {
	        return node1.compareTo(node2);
	    }
}
