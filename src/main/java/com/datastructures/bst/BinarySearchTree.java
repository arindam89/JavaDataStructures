package com.datastructures.bst;

import com.datastructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Implementation of a Binary Search Tree (BST).
 * A BST is a binary tree where for each node, all elements in the left subtree
 * are less than the node's value, and all elements in the right subtree are greater.
 * 
 * Time Complexity:
 * - Search: O(log n) average case, O(n) worst case (unbalanced tree)
 * - Insert: O(log n) average case, O(n) worst case
 * - Delete: O(log n) average case, O(n) worst case
 * 
 * Space Complexity: O(n) for storage, O(h) for recursive operations (h is height)
 * 
 * @param <T> the type of elements in this tree, must be comparable
 */
public class BinarySearchTree<T extends Comparable<T>> {
    
    // Root node of the tree
    private TreeNode<T> root;
    
    /**
     * Constructs an empty binary search tree.
     */
    public BinarySearchTree() {
        root = null;
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
     * Checks if the tree is empty.
     * 
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * Inserts an element into the tree.
     * Time Complexity: O(log n) average case, O(n) worst case
     * 
     * @param data the element to insert
     */
    public void insert(T data) {
        root = insert(root, data);
    }
    
    /**
     * Helper method to recursively insert an element.
     * 
     * @param node the current node
     * @param data the element to insert
     * @return the updated node
     */
    private TreeNode<T> insert(TreeNode<T> node, T data) {
        // If the node is null, create a new node with the data
        if (node == null) {
            return new TreeNode<>(data);
        }
        
        // Compare the data with the current node's data
        int cmp = data.compareTo(node.getData());
        
        if (cmp < 0) {
            // If the data is less than the current node's data, insert into the left subtree
            node.setLeft(insert(node.getLeft(), data));
        } else if (cmp > 0) {
            // If the data is greater than the current node's data, insert into the right subtree
            node.setRight(insert(node.getRight(), data));
        } else {
            // If the data is equal to the current node's data, do nothing (no duplicates allowed)
            // Alternatively, you could update the node or increment a counter
        }
        
        return node;
    }
    
    /**
     * Searches for an element in the tree.
     * Time Complexity: O(log n) average case, O(n) worst case
     * 
     * @param data the element to search for
     * @return true if the element is found, false otherwise
     */
    public boolean search(T data) {
        return search(root, data);
    }
    
    /**
     * Helper method to recursively search for an element.
     * 
     * @param node the current node
     * @param data the element to search for
     * @return true if the element is found, false otherwise
     */
    private boolean search(TreeNode<T> node, T data) {
        // If the node is null, the element is not found
        if (node == null) {
            return false;
        }
        
        // Compare the data with the current node's data
        int cmp = data.compareTo(node.getData());
        
        if (cmp < 0) {
            // If the data is less than the current node's data, search in the left subtree
            return search(node.getLeft(), data);
        } else if (cmp > 0) {
            // If the data is greater than the current node's data, search in the right subtree
            return search(node.getRight(), data);
        } else {
            // If the data is equal to the current node's data, the element is found
            return true;
        }
    }
    
    /**
     * Finds the minimum element in the tree.
     * The minimum element is the leftmost node in the tree.
     * Time Complexity: O(log n) average case, O(n) worst case
     * 
     * @return the minimum element, or null if the tree is empty
     */
    public T findMin() {
        if (root == null) {
            return null;
        }
        
        TreeNode<T> minNode = findMin(root);
        return minNode.getData();
    }
    
    /**
     * Helper method to find the minimum node in a subtree.
     * 
     * @param node the root of the subtree
     * @return the node with the minimum value
     */
    private TreeNode<T> findMin(TreeNode<T> node) {
        // The minimum value is at the leftmost node
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        
        return node;
    }
    
    /**
     * Finds the maximum element in the tree.
     * The maximum element is the rightmost node in the tree.
     * Time Complexity: O(log n) average case, O(n) worst case
     * 
     * @return the maximum element, or null if the tree is empty
     */
    public T findMax() {
        if (root == null) {
            return null;
        }
        
        TreeNode<T> maxNode = findMax(root);
        return maxNode.getData();
    }
    
    /**
     * Helper method to find the maximum node in a subtree.
     * 
     * @param node the root of the subtree
     * @return the node with the maximum value
     */
    private TreeNode<T> findMax(TreeNode<T> node) {
        // The maximum value is at the rightmost node
        while (node.getRight() != null) {
            node = node.getRight();
        }
        
        return node;
    }
    
    /**
     * Deletes an element from the tree.
     * Time Complexity: O(log n) average case, O(n) worst case
     * 
     * @param data the element to delete
     */
    public void delete(T data) {
        root = delete(root, data);
    }
    
    /**
     * Helper method to recursively delete an element.
     * 
     * @param node the current node
     * @param data the element to delete
     * @return the updated node
     */
    private TreeNode<T> delete(TreeNode<T> node, T data) {
        // If the node is null, the element is not found
        if (node == null) {
            return null;
        }
        
        // Compare the data with the current node's data
        int cmp = data.compareTo(node.getData());
        
        if (cmp < 0) {
            // If the data is less than the current node's data, delete from the left subtree
            node.setLeft(delete(node.getLeft(), data));
        } else if (cmp > 0) {
            // If the data is greater than the current node's data, delete from the right subtree
            node.setRight(delete(node.getRight(), data));
        } else {
            // If the data is equal to the current node's data, delete this node
            
            // Case 1: Node has no children (leaf node)
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            
            // Case 2: Node has one child
            if (node.getLeft() == null) {
                return node.getRight();
            }
            
            if (node.getRight() == null) {
                return node.getLeft();
            }
            
            // Case 3: Node has two children
            // Find the minimum value in the right subtree (successor)
            TreeNode<T> successor = findMin(node.getRight());
            
            // Copy the successor's data to this node
            node.setData(successor.getData());
            
            // Delete the successor
            node.setRight(delete(node.getRight(), successor.getData()));
        }
        
        return node;
    }
    
    /**
     * Performs an in-order traversal of the tree.
     * In a BST, in-order traversal visits the nodes in ascending order.
     * 
     * @return a list containing the elements in ascending order
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
     * Performs a level-order traversal of the tree.
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
        
        // The height is the maximum height of the subtrees plus 1
        return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
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
     * Checks if the tree is a valid BST.
     * 
     * @return true if the tree is a valid BST, false otherwise
     */
    public boolean isValidBST() {
        return isValidBST(root, null, null);
    }
    
    /**
     * Helper method to check if a subtree is a valid BST.
     * 
     * @param node the root of the subtree
     * @param min the minimum value allowed in the subtree
     * @param max the maximum value allowed in the subtree
     * @return true if the subtree is a valid BST, false otherwise
     */
    private boolean isValidBST(TreeNode<T> node, T min, T max) {
        if (node == null) {
            return true;
        }
        
        T data = node.getData();
        
        // Check if the node's value is in the allowed range
        if (min != null && data.compareTo(min) <= 0) {
            return false;
        }
        
        if (max != null && data.compareTo(max) >= 0) {
            return false;
        }
        
        // Check the left and right subtrees
        return isValidBST(node.getLeft(), min, data) && isValidBST(node.getRight(), data, max);
    }
    
    /**
     * Finds the successor of a given value in the BST.
     * The successor is the node with the smallest value greater than the given value.
     * 
     * @param data the value to find the successor of
     * @return the successor value, or null if there is no successor
     */
    public T successor(T data) {
        // Find the node with the given value
        TreeNode<T> current = root;
        TreeNode<T> successor = null;
        
        while (current != null) {
            int cmp = data.compareTo(current.getData());
            
            if (cmp < 0) {
                // If the data is less than the current node's data,
                // the current node could be the successor
                successor = current;
                current = current.getLeft();
            } else if (cmp > 0) {
                // If the data is greater than the current node's data,
                // the successor must be in the right subtree
                current = current.getRight();
            } else {
                // Found the node with the given value
                // If it has a right subtree, the successor is the minimum in that subtree
                if (current.getRight() != null) {
                    return findMin(current.getRight()).getData();
                }
                
                // If it doesn't have a right subtree, the successor is the
                // closest ancestor whose left subtree contains the node
                break;
            }
        }
        
        return successor != null ? successor.getData() : null;
    }
    
    /**
     * Finds the predecessor of a given value in the BST.
     * The predecessor is the node with the largest value less than the given value.
     * 
     * @param data the value to find the predecessor of
     * @return the predecessor value, or null if there is no predecessor
     */
    public T predecessor(T data) {
        // Find the node with the given value
        TreeNode<T> current = root;
        TreeNode<T> predecessor = null;
        
        while (current != null) {
            int cmp = data.compareTo(current.getData());
            
            if (cmp > 0) {
                // If the data is greater than the current node's data,
                // the current node could be the predecessor
                predecessor = current;
                current = current.getRight();
            } else if (cmp < 0) {
                // If the data is less than the current node's data,
                // the predecessor must be in the left subtree
                current = current.getLeft();
            } else {
                // Found the node with the given value
                // If it has a left subtree, the predecessor is the maximum in that subtree
                if (current.getLeft() != null) {
                    return findMax(current.getLeft()).getData();
                }
                
                // If it doesn't have a left subtree, the predecessor is the
                // closest ancestor whose right subtree contains the node
                break;
            }
        }
        
        return predecessor != null ? predecessor.getData() : null;
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
