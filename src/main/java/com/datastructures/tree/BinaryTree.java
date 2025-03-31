package com.datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Implementation of a generic binary tree.
 * A binary tree is a tree data structure in which each node has at most two children,
 * which are referred to as the left child and the right child.
 * 
 * Time Complexity:
 * - Search: O(n) worst case - may need to check all nodes
 * - Insert: O(n) worst case - may need to traverse to find insertion point
 * - Delete: O(n) worst case - may need to traverse to find node to delete
 * - Access: O(n) worst case - may need to traverse to find node
 * 
 * Space Complexity: O(n) where n is the number of nodes
 * 
 * @param <T> the type of elements in this tree
 */
public class BinaryTree<T> {
    
    // Root node of the tree
    private TreeNode<T> root;
    
    /**
     * Constructs an empty binary tree.
     */
    public BinaryTree() {
        root = null;
    }
    
    /**
     * Constructs a binary tree with a given root.
     * 
     * @param root the root node of the tree
     */
    public BinaryTree(TreeNode<T> root) {
        this.root = root;
    }
    
    /**
     * Get the root node of the tree.
     * 
     * @return the root node
     */
    public TreeNode<T> getRoot() {
        return root;
    }
    
    /**
     * Set the root node of the tree.
     * 
     * @param root the new root node
     */
    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }
    
    /**
     * Checks if the tree is empty.
     * 
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * Performs an in-order traversal of the tree.
     * In-order traversal visits left subtree, then the node, then the right subtree.
     * 
     * @return a list containing the elements in in-order sequence
     */
    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }
    
    /**
     * Helper method for in-order traversal.
     * 
     * @param node the current node
     * @param result the list to store the elements
     */
    private void inOrderTraversal(TreeNode<T> node, List<T> result) {
        if (node != null) {
            // First, traverse the left subtree
            inOrderTraversal(node.getLeft(), result);
            
            // Then, visit the node itself
            result.add(node.getData());
            
            // Finally, traverse the right subtree
            inOrderTraversal(node.getRight(), result);
        }
    }
    
    /**
     * Performs a pre-order traversal of the tree.
     * Pre-order traversal visits the node, then the left subtree, then the right subtree.
     * 
     * @return a list containing the elements in pre-order sequence
     */
    public List<T> preOrderTraversal() {
        List<T> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return result;
    }
    
    /**
     * Helper method for pre-order traversal.
     * 
     * @param node the current node
     * @param result the list to store the elements
     */
    private void preOrderTraversal(TreeNode<T> node, List<T> result) {
        if (node != null) {
            // First, visit the node itself
            result.add(node.getData());
            
            // Then, traverse the left subtree
            preOrderTraversal(node.getLeft(), result);
            
            // Finally, traverse the right subtree
            preOrderTraversal(node.getRight(), result);
        }
    }
    
    /**
     * Performs a post-order traversal of the tree.
     * Post-order traversal visits the left subtree, then the right subtree, then the node.
     * 
     * @return a list containing the elements in post-order sequence
     */
    public List<T> postOrderTraversal() {
        List<T> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }
    
    /**
     * Helper method for post-order traversal.
     * 
     * @param node the current node
     * @param result the list to store the elements
     */
    private void postOrderTraversal(TreeNode<T> node, List<T> result) {
        if (node != null) {
            // First, traverse the left subtree
            postOrderTraversal(node.getLeft(), result);
            
            // Then, traverse the right subtree
            postOrderTraversal(node.getRight(), result);
            
            // Finally, visit the node itself
            result.add(node.getData());
        }
    }
    
    /**
     * Performs a level-order (breadth-first) traversal of the tree.
     * Level-order traversal visits nodes level by level from top to bottom,
     * and left to right within each level.
     * 
     * @return a list containing the elements in level-order sequence
     */
    public List<T> levelOrderTraversal() {
        List<T> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        // Use a queue to keep track of nodes to visit
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            // Remove the next node from the queue
            TreeNode<T> node = queue.poll();
            
            // Visit the node
            result.add(node.getData());
            
            // Add the left child to the queue if it exists
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            
            // Add the right child to the queue if it exists
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
        
        return result;
    }
    
    /**
     * Calculates the height of the tree.
     * The height is the length of the longest path from the root to a leaf.
     * 
     * @return the height of the tree, -1 if the tree is empty
     */
    public int height() {
        return height(root);
    }
    
    /**
     * Helper method to calculate the height of a subtree.
     * 
     * @param node the root of the subtree
     * @return the height of the subtree, -1 if the subtree is empty
     */
    private int height(TreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        
        // Recursively calculate the height of the left and right subtrees
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        
        // The height is the maximum height of the subtrees plus 1
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    /**
     * Counts the number of nodes in the tree.
     * 
     * @return the number of nodes in the tree
     */
    public int size() {
        return size(root);
    }
    
    /**
     * Helper method to count the number of nodes in a subtree.
     * 
     * @param node the root of the subtree
     * @return the number of nodes in the subtree
     */
    private int size(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        
        // The size is the sum of the sizes of the left and right subtrees, plus 1 for the node itself
        return size(node.getLeft()) + size(node.getRight()) + 1;
    }
    
    /**
     * Counts the number of leaf nodes in the tree.
     * A leaf node is a node with no children.
     * 
     * @return the number of leaf nodes in the tree
     */
    public int countLeaves() {
        return countLeaves(root);
    }
    
    /**
     * Helper method to count the number of leaf nodes in a subtree.
     * 
     * @param node the root of the subtree
     * @return the number of leaf nodes in the subtree
     */
    private int countLeaves(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        
        // If the node is a leaf, count it
        if (node.isLeaf()) {
            return 1;
        }
        
        // Otherwise, the number of leaves is the sum of the leaves in the left and right subtrees
        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }
    
    /**
     * Checks if the tree is a full binary tree.
     * A full binary tree is a tree in which every node has 0 or 2 children.
     * 
     * @return true if the tree is a full binary tree, false otherwise
     */
    public boolean isFullBinaryTree() {
        return isFullBinaryTree(root);
    }
    
    /**
     * Helper method to check if a subtree is a full binary tree.
     * 
     * @param node the root of the subtree
     * @return true if the subtree is a full binary tree, false otherwise
     */
    private boolean isFullBinaryTree(TreeNode<T> node) {
        if (node == null) {
            return true;
        }
        
        // If the node is a leaf, it's a full binary tree
        if (node.isLeaf()) {
            return true;
        }
        
        // If the node has both left and right children, check if both subtrees are full binary trees
        if (node.getLeft() != null && node.getRight() != null) {
            return isFullBinaryTree(node.getLeft()) && isFullBinaryTree(node.getRight());
        }
        
        // If the node has only one child, it's not a full binary tree
        return false;
    }
    
    /**
     * Checks if the tree is a perfect binary tree.
     * A perfect binary tree is a binary tree in which all internal nodes have exactly two children
     * and all leaf nodes are at the same level.
     * 
     * @return true if the tree is a perfect binary tree, false otherwise
     */
    public boolean isPerfectBinaryTree() {
        if (root == null) {
            return true;
        }
        
        // Calculate the height of the tree
        int height = height();
        
        // Calculate the expected number of nodes in a perfect binary tree of this height
        int expectedNodes = (int) Math.pow(2, height + 1) - 1;
        
        // Check if the actual number of nodes matches the expected number
        return size() == expectedNodes;
    }
    
    /**
     * Checks if the tree is a complete binary tree.
     * A complete binary tree is a binary tree in which every level, except possibly the last,
     * is completely filled, and all nodes are as far left as possible.
     * 
     * @return true if the tree is a complete binary tree, false otherwise
     */
    public boolean isCompleteBinaryTree() {
        if (root == null) {
            return true;
        }
        
        // Use a queue for level-order traversal
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        
        // Flag to indicate that we've seen a non-full node
        boolean nonFullNodeSeen = false;
        
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            
            // Check the left child
            if (node.getLeft() == null) {
                nonFullNodeSeen = true;
            } else {
                // If we've already seen a non-full node and now we see a child,
                // the tree is not complete
                if (nonFullNodeSeen) {
                    return false;
                }
                queue.offer(node.getLeft());
            }
            
            // Check the right child
            if (node.getRight() == null) {
                nonFullNodeSeen = true;
            } else {
                // If we've already seen a non-full node and now we see a child,
                // the tree is not complete
                if (nonFullNodeSeen) {
                    return false;
                }
                queue.offer(node.getRight());
            }
        }
        
        // If we haven't found any violations, the tree is complete
        return true;
    }
    
    /**
     * Checks if the tree is balanced.
     * A balanced tree is a tree in which the height of the left and right subtrees
     * of any node differ by at most 1.
     * 
     * @return true if the tree is balanced, false otherwise
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }
    
    /**
     * Helper method to check if a subtree is balanced.
     * 
     * @param node the root of the subtree
     * @return true if the subtree is balanced, false otherwise
     */
    private boolean isBalanced(TreeNode<T> node) {
        if (node == null) {
            return true;
        }
        
        // Calculate the height of the left and right subtrees
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        
        // Check if the heights differ by at most 1
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            // Recursively check if both subtrees are balanced
            return isBalanced(node.getLeft()) && isBalanced(node.getRight());
        }
        
        return false;
    }
    
    /**
     * Creates a mirror image of the tree.
     * In a mirror image, the left and right children of every node are swapped.
     */
    public void mirror() {
        root = mirror(root);
    }
    
    /**
     * Helper method to create a mirror image of a subtree.
     * 
     * @param node the root of the subtree
     * @return the root of the mirrored subtree
     */
    private TreeNode<T> mirror(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        
        // Recursively mirror the left and right subtrees
        TreeNode<T> left = mirror(node.getLeft());
        TreeNode<T> right = mirror(node.getRight());
        
        // Swap the left and right children
        node.setLeft(right);
        node.setRight(left);
        
        return node;
    }
    
    /**
     * String representation of the tree using level-order traversal.
     * 
     * @return a string representation of the tree
     */
    @Override
    public String toString() {
        if (root == null) {
            return "[]";
        }
        
        return levelOrderTraversal().toString();
    }
}
