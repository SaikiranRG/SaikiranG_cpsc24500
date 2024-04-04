package a6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import a5.INode;
import a5.Node;
import a5.NodeFactory;
import a5.NodesSorter;

public class Nodes {
    private ArrayList<INode> nodeList;

    /**
     * Constructs a new Nodes object with an empty list of nodes.
     */
    public Nodes() {
        nodeList = new ArrayList<>();
    }
    /**
     * Fills the list of nodes with a random number of Nodes and ThreeDNodes.
     * @param size The size of the list
     * @throws Exception If there is an error while creating nodes
     */
    public void fill(int size) throws Exception {
        //nodeList.clear();
        Random random = new Random();
        int numNodes = random.nextInt(size + 1); // Randomly choose number of Nodes
        int numThreeDNodes = size - numNodes;    // Calculate number of ThreeDNodes
        //System.out.println(numNodes+""+numThreeDNodes);
        // Fill Nodes
        for (int i = 0; i < numNodes; i++) {
        	Node node = NodeFactory.getNode();
            //System.out.println("Nodes"+node.getX());
            nodeList.add(node);
        }

        // Fill ThreeDNodes
        for (int i = 0; i < numThreeDNodes; i++) {
        	ThreeDNode threeDNode = NodeFactory.getThreeDNode();
            nodeList.add(threeDNode);
        }
    }
    
    //Clears the list of nodes
    public void clear() {
        nodeList.clear();
    }
    /**
     * Counts the number of Nodes in the list.
     * @return The number of Nodes in the list
     */
    public int countNodes() {
        int count = 0;
        for (INode node : nodeList) {
            if (node instanceof Node) {
                count++;
            }
        }
        return count;
    }
    /**
     * Counts the number of ThreeDNodes in the list.
     * @return The number of ThreeDNodes in the list
     */
    public int countThreeDNones() {
        int count = 0;
        for (INode node : nodeList) {
            if (node instanceof ThreeDNode) {
                count++;
            }
        }
        return count;
    }
   //Sorts the list of nodes based on their sum of coordinates
    public void sort() {
    	 if (!nodeList.isEmpty()) {
             NodesSorter sorter = new NodesSorter();
             nodeList.sort(sorter);
             System.out.println("Nodes sorted successfully.");
         } else {
             System.out.println("No nodes to sort.");
         }
    }
    //Returns a string representation of the list of nodes
    @Override
    public String toString() {
    	if (nodeList.isEmpty()) {
            return ""; // Return empty string if the list is empty
        }
    	else {
    	StringBuilder sb = new StringBuilder();
        for (INode node : nodeList) {
            sb.append(node.toString()).append("\n");
        }
        return sb.toString();
    	}
    }
}
