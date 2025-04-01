package com.datastructures;

import com.datastructures.linkedlist.LinkedListExample;
import com.datastructures.heap.HeapExample;
import com.datastructures.tree.BinaryTreeExample;
import com.datastructures.bst.BSTExample;
import com.datastructures.graph.GraphExample;
import com.datastructures.trie.TrieExample;
import com.datastructures.leetcode.LeetCodeExample;
import com.datastructures.leetcode.LeetCodeExamplePart2;
import com.datastructures.leetcode.LeetCodeExamplePart3;
import com.datastructures.visualization.VisualizationExample;

import java.util.Scanner;

/**
 * Main class to demonstrate all the data structures implementations.
 * This class serves as an entry point to the application and runs
 * examples for each data structure.
 * 
 * @author DataStructures Team
 * @version 1.0
 */
public class Main {
    
    /**
     * Main method to run examples of all data structures.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Data Structures Learning Platform ===\n");
        
        // Display menu
        displayMenu();
        
        // Get user choice
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            choice = 0;
        }
        
        executeChoice(choice);
    }
    
    /**
     * Displays the main menu.
     */
    private static void displayMenu() {
        System.out.println("Choose an option to explore:\n");
        System.out.println("1. Run all examples (complete demonstration)");
        System.out.println("2. Linked List examples");
        System.out.println("3. Heap examples");
        System.out.println("4. Binary Tree examples");
        System.out.println("5. Binary Search Tree examples");
        System.out.println("6. Graph examples");
        System.out.println("7. Trie examples");
        System.out.println("8. LeetCode problems (Part 1)");
        System.out.println("9. LeetCode problems (Part 2)");
        System.out.println("10. LeetCode problems (Part 3)");
        System.out.println("11. Data Structure Visualizations");
        System.out.println("0. Exit");
        
        System.out.print("\nEnter your choice: ");
    }
    
    /**
     * Executes the user's menu choice.
     * 
     * @param choice the user's menu selection
     */
    private static void executeChoice(int choice) {
        switch (choice) {
            case 1:
                runAllExamples();
                break;
            case 2:
                System.out.println("\n=== Linked List Examples ===");
                LinkedListExample.runExample();
                break;
            case 3:
                System.out.println("\n=== Heap Examples ===");
                HeapExample.runExample();
                break;
            case 4:
                System.out.println("\n=== Binary Tree Examples ===");
                BinaryTreeExample.runExample();
                break;
            case 5:
                System.out.println("\n=== Binary Search Tree Examples ===");
                BSTExample.runExample();
                break;
            case 6:
                System.out.println("\n=== Graph Examples ===");
                GraphExample.runExample();
                break;
            case 7:
                System.out.println("\n=== Trie Examples ===");
                TrieExample.runExample();
                break;
            case 8:
                System.out.println("\n=== LeetCode Problem Examples (Part 1) ===");
                LeetCodeExample.runExample();
                break;
            case 9:
                System.out.println("\n=== LeetCode Problem Examples (Part 2) ===");
                LeetCodeExamplePart2.runExample();
                break;
            case 10:
                System.out.println("\n=== LeetCode Problem Examples (Part 3) ===");
                LeetCodeExamplePart3.runExample();
                break;
            case 11:
                System.out.println("\n=== Data Structure Visualizations ===");
                VisualizationExample.runExample();
                break;
            case 0:
                System.out.println("\nExiting the Data Structures Learning Platform. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid choice. Running all examples as default.");
                runAllExamples();
                break;
        }
    }
    
    /**
     * Runs all the examples sequentially.
     */
    private static void runAllExamples() {
        System.out.println("\nData Structures Examples\n");
        
        System.out.println("=== Linked List Examples ===");
        LinkedListExample.runExample();
        
        System.out.println("\n=== Heap Examples ===");
        HeapExample.runExample();
        
        System.out.println("\n=== Binary Tree Examples ===");
        BinaryTreeExample.runExample();
        
        System.out.println("\n=== Binary Search Tree Examples ===");
        BSTExample.runExample();
        
        System.out.println("\n=== Graph Examples ===");
        GraphExample.runExample();
        
        System.out.println("\n=== Trie Examples ===");
        TrieExample.runExample();
        
        System.out.println("\n=== LeetCode Problem Examples (Part 1) ===");
        LeetCodeExample.runExample();
        
        System.out.println("\n=== LeetCode Problem Examples (Part 2) ===");
        LeetCodeExamplePart2.runExample();
        
        System.out.println("\n=== LeetCode Problem Examples (Part 3) ===");
        LeetCodeExamplePart3.runExample();
        
        System.out.println("\n=== Data Structure Visualizations ===");
        VisualizationExample.runExample();
    }
}
