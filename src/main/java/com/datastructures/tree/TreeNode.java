package com.datastructures.tree;

/**
 * Node class for a binary tree.
 * Each node contains data and references to left and right children.
 * 
 * @param <T> the type of data stored in the node
 */
public class TreeNode<T> {
    // The data stored in this node
    private T data;
    
    // Reference to the left child node
    private TreeNode<T> left;
    
    // Reference to the right child node
    private TreeNode<T> right;
    
    /**
     * Constructor to create a node with data and no children.
     * 
     * @param data the data to be stored in the node
     */
    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    /**
     * Constructor to create a node with data and specific left and right children.
     * 
     * @param data the data to be stored in the node
     * @param left reference to the left child node
     * @param right reference to the right child node
     */
    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    /**
     * Get the data stored in this node.
     * 
     * @return the data stored in this node
     */
    public T getData() {
        return data;
    }
    
    /**
     * Set the data for this node.
     * 
     * @param data the data to be stored in this node
     */
    public void setData(T data) {
        this.data = data;
    }
    
    /**
     * Get the left child node.
     * 
     * @return reference to the left child node
     */
    public TreeNode<T> getLeft() {
        return left;
    }
    
    /**
     * Set the left child node.
     * 
     * @param left reference to the left child node
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }
    
    /**
     * Get the right child node.
     * 
     * @return reference to the right child node
     */
    public TreeNode<T> getRight() {
        return right;
    }
    
    /**
     * Set the right child node.
     * 
     * @param right reference to the right child node
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
    
    /**
     * Check if this node is a leaf node (has no children).
     * 
     * @return true if the node is a leaf, false otherwise
     */
    public boolean isLeaf() {
        return left == null && right == null;
    }
    
    /**
     * String representation of the node.
     * 
     * @return string representation of the node data
     */
    @Override
    public String toString() {
        return data.toString();
    }
}
