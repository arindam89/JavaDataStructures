package com.datastructures.tree;

import java.util.List;

/**
 * Example class to demonstrate the usage of BinaryTree implementation.
 * This class contains a method that shows different operations
 * that can be performed on a binary tree.
 */
public class BinaryTreeExample {
    
    /**
     * Runs examples demonstrating binary tree operations.
     */
    public static void runExample() {
        // Create a sample binary tree
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        //  /
        // 7
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);
        node4.setLeft(node7);
        
        BinaryTree<Integer> tree = new BinaryTree<>(root);
        
        System.out.println("Tree created with structure:");
        System.out.println("       1");
        System.out.println("      / \\");
        System.out.println("     2   3");
        System.out.println("    / \\   \\");
        System.out.println("   4   5   6");
        System.out.println("  /");
        System.out.println(" 7");
        
        // Example 1: Tree traversals
        System.out.println("\nTree Traversals:");
        
        // In-order traversal (Left, Root, Right)
        List<Integer> inOrder = tree.inOrderTraversal();
        System.out.println("In-order traversal: " + inOrder);
        
        // Pre-order traversal (Root, Left, Right)
        List<Integer> preOrder = tree.preOrderTraversal();
        System.out.println("Pre-order traversal: " + preOrder);
        
        // Post-order traversal (Left, Right, Root)
        List<Integer> postOrder = tree.postOrderTraversal();
        System.out.println("Post-order traversal: " + postOrder);
        
        // Level-order traversal (Breadth-first)
        List<Integer> levelOrder = tree.levelOrderTraversal();
        System.out.println("Level-order traversal: " + levelOrder);
        
        // Example 2: Tree properties
        System.out.println("\nTree Properties:");
        System.out.println("Height: " + tree.height());
        System.out.println("Size (number of nodes): " + tree.size());
        System.out.println("Number of leaf nodes: " + tree.countLeaves());
        
        // Example 3: Tree checks
        System.out.println("\nTree Checks:");
        System.out.println("Is Full Binary Tree? " + tree.isFullBinaryTree());
        System.out.println("Is Perfect Binary Tree? " + tree.isPerfectBinaryTree());
        System.out.println("Is Complete Binary Tree? " + tree.isCompleteBinaryTree());
        System.out.println("Is Balanced? " + tree.isBalanced());
        
        // Example 4: Tree operations
        System.out.println("\nTree Operations:");
        System.out.println("Original level-order traversal: " + tree.levelOrderTraversal());
        
        // Create a mirrored version of the tree
        System.out.println("Creating a mirror image of the tree...");
        tree.mirror();
        System.out.println("Mirrored level-order traversal: " + tree.levelOrderTraversal());
        
        System.out.println("\nTree structure after mirroring:");
        System.out.println("       1");
        System.out.println("      / \\");
        System.out.println("     3   2");
        System.out.println("    /   / \\");
        System.out.println("   6   5   4");
        System.out.println("            \\");
        System.out.println("             7");
        
        // Example 5: Creating a balanced binary tree
        System.out.println("\nCreating a new balanced binary tree:");
        //      10
        //     /  \
        //    5   15
        //   / \    \
        //  2   7   20
        TreeNode<Integer> balancedRoot = new TreeNode<>(10);
        TreeNode<Integer> node5Balanced = new TreeNode<>(5);
        TreeNode<Integer> node15 = new TreeNode<>(15);
        TreeNode<Integer> node2Balanced = new TreeNode<>(2);
        TreeNode<Integer> node7Balanced = new TreeNode<>(7);
        TreeNode<Integer> node20 = new TreeNode<>(20);
        
        balancedRoot.setLeft(node5Balanced);
        balancedRoot.setRight(node15);
        node5Balanced.setLeft(node2Balanced);
        node5Balanced.setRight(node7Balanced);
        node15.setRight(node20);
        
        BinaryTree<Integer> balancedTree = new BinaryTree<>(balancedRoot);
        
        System.out.println("Balanced tree structure:");
        System.out.println("      10");
        System.out.println("     /  \\");
        System.out.println("    5   15");
        System.out.println("   / \\    \\");
        System.out.println("  2   7   20");
        
        System.out.println("Level-order traversal: " + balancedTree.levelOrderTraversal());
        System.out.println("Is Balanced? " + balancedTree.isBalanced());
        System.out.println("Height: " + balancedTree.height());
    }
}
