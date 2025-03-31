package com.datastructures.linkedlist;

/**
 * Node class for a singly linked list.
 * Each node contains data and a reference to the next node.
 * 
 * @param <T> the type of data stored in the node
 */
public class Node<T> {
    // The data stored in this node
    private T data;
    
    // Reference to the next node in the linked list
    private Node<T> next;
    
    /**
     * Constructor to create a node with data and no next node.
     * 
     * @param data the data to be stored in the node
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    /**
     * Constructor to create a node with data and a reference to the next node.
     * 
     * @param data the data to be stored in the node
     * @param next reference to the next node
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
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
     * Get the next node in the linked list.
     * 
     * @return reference to the next node
     */
    public Node<T> getNext() {
        return next;
    }
    
    /**
     * Set the next node in the linked list.
     * 
     * @param next reference to the next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
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
