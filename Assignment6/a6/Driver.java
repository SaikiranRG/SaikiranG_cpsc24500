package a6;

import java.util.Scanner;
/**
 * CPSC 24500-001- Object-Oriented Programming
 * Assignment 6
 * This class represents the main driver program for the Nodes application
 */
public class Driver {
    
    private static Nodes nodes;
    private static Scanner sc;

    public static void main(String[] args) {
        nodes = new Nodes();
        //Scanner sc = new Scanner(System.in);
        sc = new Scanner(System.in);
        int choice;
        do {
        	 System.out.println("\nMenu:");
             System.out.println("1. Fill");
             System.out.println("2. Clear");
             System.out.println("3. Count Nodes");
             System.out.println("4. Count ThreeDNodes");
             System.out.println("5. Sort");
             System.out.println("6. Display");
             System.out.println("7. Exit");
             System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            processChoice(choice);
        } while (choice != 7);
        sc.close();
    }


    private static void processChoice(int choice) {
        try {
            switch (choice) {
                case 1:
                    fillNodes();
                    break;
                case 2:
                    clearNodes();
                    break;
                case 3:
                    countNodes();
                    break;
                case 4:
                    countThreeDNodes();
                    break;
                case 5:
                    sortNodes();
                    break;
                case 6:
                    displayNodes();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    /**
     * Fill the list of nodes based on user input.
     *  @throws Exception If there is an error while filling the nodes
     */
    private static void fillNodes() throws Exception {
        System.out.print("Enter the size of the list: ");
        int size = sc.nextInt();
        nodes.fill(size);
        System.out.println("Nodes filled successfully.");
    }
    //Clear the list of nodes
    private static void clearNodes() {
        nodes.clear();
        System.out.println("Nodes cleared successfully.");
    }
    //Count the number of Nodes in the list and display the result.
    private static void countNodes() {
        int count = nodes.countNodes();
        System.out.println("Number of Nodes: " + count);
    }
    //Count the number of ThreeDNodes in the list and display the result.
    private static void countThreeDNodes() {
        int count = nodes.countThreeDNones();
        System.out.println("Number of ThreeDNodes: " + count);
    }
    //Sort the list of nodes based on their coordinates.
    private static void sortNodes() {
        nodes.sort();
      }
    //Display the list of nodes.
    private static void displayNodes() {
        String nodesString = nodes.toString();
        if (nodesString.isEmpty()) {
            System.out.println("No nodes to display.");
        } else {
            System.out.println("Nodes:\n" + nodesString);
        }
    }
}
