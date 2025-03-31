package com.datastructures.bst;

import java.util.List;

/**
 * Example class to demonstrate the usage of BinarySearchTree implementation.
 * This class contains a method that shows different operations
 * that can be performed on a binary search tree.
 */
public class BSTExample {
    
    /**
     * Runs examples demonstrating binary search tree operations.
     */
    public static void runExample() {
        // Create a new binary search tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        
        // Example 1: Inserting elements
        System.out.println("Inserting elements: 50, 30, 70, 20, 40, 60, 80");
        bst.insert(50);  // Root
        bst.insert(30);  // Left of 50
        bst.insert(70);  // Right of 50
        bst.insert(20);  // Left of 30
        bst.insert(40);  // Right of 30
        bst.insert(60);  // Left of 70
        bst.insert(80);  // Right of 70
        
        System.out.println("BST structure (ideally):");
        System.out.println("        50");
        System.out.println("       /  \\");
        System.out.println("      30   70");
        System.out.println("     / \\  / \\");
        System.out.println("    20 40 60 80");
        
        // Example 2: Traversals
        System.out.println("\nBST Traversals:");
        
        // In-order traversal (Left, Root, Right) - Should be sorted
        List<Integer> inOrder = bst.inOrderTraversal();
        System.out.println("In-order traversal (sorted): " + inOrder);
        
        // Pre-order traversal (Root, Left, Right)
        List<Integer> preOrder = bst.preOrderTraversal();
        System.out.println("Pre-order traversal: " + preOrder);
        
        // Post-order traversal (Left, Right, Root)
        List<Integer> postOrder = bst.postOrderTraversal();
        System.out.println("Post-order traversal: " + postOrder);
        
        // Level-order traversal (Breadth-first)
        List<Integer> levelOrder = bst.levelOrderTraversal();
        System.out.println("Level-order traversal: " + levelOrder);
        
        // Example 3: Searching
        System.out.println("\nSearching for elements:");
        System.out.println("Contains 40? " + bst.search(40));
        System.out.println("Contains 55? " + bst.search(55));
        
        // Example 4: Finding min and max
        System.out.println("\nFinding min and max:");
        System.out.println("Minimum element: " + bst.findMin());
        System.out.println("Maximum element: " + bst.findMax());
        
        // Example 5: BST properties
        System.out.println("\nBST Properties:");
        System.out.println("Size (number of nodes): " + bst.size());
        System.out.println("Height: " + bst.height());
        System.out.println("Is Valid BST? " + bst.isValidBST());
        
        // Example 6: Successor and predecessor
        System.out.println("\nSuccessor and Predecessor:");
        System.out.println("Successor of 40: " + bst.successor(40));  // Should be 50
        System.out.println("Predecessor of 60: " + bst.predecessor(60));  // Should be 50
        
        // Example 7: Deleting elements
        System.out.println("\nDeleting elements:");
        
        // Delete a leaf node (20)
        System.out.println("Deleting 20 (a leaf node)...");
        bst.delete(20);
        System.out.println("In-order after deleting 20: " + bst.inOrderTraversal());
        
        // Delete a node with one child (60)
        System.out.println("Deleting 60 (a node with no children)...");
        bst.delete(60);
        System.out.println("In-order after deleting 60: " + bst.inOrderTraversal());
        
        // Delete a node with two children (30)
        System.out.println("Deleting 30 (a node with two children)...");
        bst.delete(30);
        System.out.println("In-order after deleting 30: " + bst.inOrderTraversal());
        
        // Delete the root (50)
        System.out.println("Deleting 50 (the root node)...");
        bst.delete(50);
        System.out.println("In-order after deleting 50: " + bst.inOrderTraversal());
        
        // Example 8: Create a balanced BST
        System.out.println("\nCreating a balanced BST:");
        BinarySearchTree<Integer> balancedBST = new BinarySearchTree<>();
        
        // Insert elements to form a balanced tree
        int[] elements = {50, 25, 75, 12, 37, 62, 87, 6, 18, 31, 43, 56, 68, 81, 93};
        System.out.print("Inserting elements: ");
        for (int element : elements) {
            System.out.print(element + " ");
            balancedBST.insert(element);
        }
        System.out.println();
        
        System.out.println("In-order traversal: " + balancedBST.inOrderTraversal());
        System.out.println("Height: " + balancedBST.height());
        System.out.println("Is Valid BST? " + balancedBST.isValidBST());
    }
}
