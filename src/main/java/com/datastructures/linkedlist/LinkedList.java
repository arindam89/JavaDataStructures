package com.datastructures.linkedlist;

import java.util.NoSuchElementException;

/**
 * Implementation of a generic singly linked list.
 * A linked list is a linear data structure where elements are stored in nodes,
 * and each node points to the next node in the sequence.
 * 
 * Time Complexity:
 * - Access: O(n) - Need to traverse from head
 * - Search: O(n) - Need to traverse until element is found
 * - Insertion: O(1) at head, O(n) elsewhere - Need to find position first
 * - Deletion: O(1) at head, O(n) elsewhere - Need to find position first
 * 
 * Space Complexity: O(n) where n is the number of elements
 * 
 * @param <T> the type of elements in this list
 */
public class LinkedList<T> {
    
    // Reference to the first node in the list
    private Node<T> head;
    
    // Size of the linked list
    private int size;
    
    /**
     * Gets the head node of the linked list.
     * 
     * @return the head node
     */
    public Node<T> getHead() {
        return head;
    }
    
    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }
    
    /**
     * Adds an element to the beginning of the list.
     * Time Complexity: O(1)
     * 
     * @param data the element to add
     */
    public void addFirst(T data) {
        // Create a new node with the given data
        Node<T> newNode = new Node<>(data);
        
        // Make the new node point to the current head
        newNode.setNext(head);
        
        // Update the head to be the new node
        head = newNode;
        
        // Increment the size
        size++;
    }
    
    /**
     * Adds an element to the end of the list.
     * Time Complexity: O(n) as we need to traverse to the end
     * 
     * @param data the element to add
     */
    public void addLast(T data) {
        // Create a new node with the given data
        Node<T> newNode = new Node<>(data);
        
        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse to the last node
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            
            // Set the next of the last node to the new node
            current.setNext(newNode);
        }
        
        // Increment the size
        size++;
    }
    
    /**
     * Adds an element at a specific position in the list.
     * Time Complexity: O(n) to reach the position
     * 
     * @param data the element to add
     * @param position the position at which to add the element (0-based)
     * @throws IndexOutOfBoundsException if position is out of range
     */
    public void addAtPosition(T data, int position) {
        // Check if the position is valid
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Position out of range: " + position);
        }
        
        // If adding at the beginning, use addFirst
        if (position == 0) {
            addFirst(data);
            return;
        }
        
        // If adding at the end, use addLast
        if (position == size) {
            addLast(data);
            return;
        }
        
        // Create a new node with the given data
        Node<T> newNode = new Node<>(data);
        
        // Traverse to the node before the position
        Node<T> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }
        
        // Insert the new node between current and current.next
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        
        // Increment the size
        size++;
    }
    
    /**
     * Removes and returns the first element from the list.
     * Time Complexity: O(1)
     * 
     * @return the first element in the list
     * @throws NoSuchElementException if the list is empty
     */
    public T removeFirst() {
        // Check if the list is empty
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        
        // Store the data to return
        T data = head.getData();
        
        // Update the head to the next node
        head = head.getNext();
        
        // Decrement the size
        size--;
        
        return data;
    }
    
    /**
     * Removes and returns the last element from the list.
     * Time Complexity: O(n) to traverse to the end
     * 
     * @return the last element in the list
     * @throws NoSuchElementException if the list is empty
     */
    public T removeLast() {
        // Check if the list is empty
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        
        // If there's only one element
        if (head.getNext() == null) {
            T data = head.getData();
            head = null;
            size--;
            return data;
        }
        
        // Traverse to the second-to-last node
        Node<T> current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        
        // Store the data to return
        T data = current.getNext().getData();
        
        // Remove the last node
        current.setNext(null);
        
        // Decrement the size
        size--;
        
        return data;
    }
    
    /**
     * Removes and returns the element at a specific position.
     * Time Complexity: O(n) to reach the position
     * 
     * @param position the position of the element to remove (0-based)
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if position is out of range
     */
    public T removeAtPosition(int position) {
        // Check if the position is valid
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position out of range: " + position);
        }
        
        // If removing the first element, use removeFirst
        if (position == 0) {
            return removeFirst();
        }
        
        // If removing the last element, use removeLast
        if (position == size - 1) {
            return removeLast();
        }
        
        // Traverse to the node before the position
        Node<T> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }
        
        // Store the data to return
        T data = current.getNext().getData();
        
        // Remove the node at the position
        current.setNext(current.getNext().getNext());
        
        // Decrement the size
        size--;
        
        return data;
    }
    
    /**
     * Gets the element at a specific position without removing it.
     * Time Complexity: O(n) to reach the position
     * 
     * @param position the position of the element to get (0-based)
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if position is out of range
     */
    public T get(int position) {
        // Check if the position is valid
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position out of range: " + position);
        }
        
        // Traverse to the node at the position
        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        
        return current.getData();
    }
    
    /**
     * Updates the element at a specific position.
     * Time Complexity: O(n) to reach the position
     * 
     * @param data the new element
     * @param position the position of the element to update (0-based)
     * @throws IndexOutOfBoundsException if position is out of range
     */
    public void set(T data, int position) {
        // Check if the position is valid
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position out of range: " + position);
        }
        
        // Traverse to the node at the position
        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        
        // Update the data
        current.setData(data);
    }
    
    /**
     * Checks if the list contains a specific element.
     * Time Complexity: O(n) worst case to check all elements
     * 
     * @param data the element to search for
     * @return true if the list contains the element, false otherwise
     */
    public boolean contains(T data) {
        // Traverse the list
        Node<T> current = head;
        while (current != null) {
            // Check if the current node's data matches
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        
        return false;
    }
    
    /**
     * Finds the position of a specific element.
     * Time Complexity: O(n) worst case to check all elements
     * 
     * @param data the element to search for
     * @return the position of the element (0-based), or -1 if not found
     */
    public int indexOf(T data) {
        // Traverse the list
        Node<T> current = head;
        int position = 0;
        
        while (current != null) {
            // Check if the current node's data matches
            if (current.getData().equals(data)) {
                return position;
            }
            current = current.getNext();
            position++;
        }
        
        return -1; // Element not found
    }
    
    /**
     * Returns the size of the list.
     * Time Complexity: O(1)
     * 
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }
    
    /**
     * Checks if the list is empty.
     * Time Complexity: O(1)
     * 
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Clears the list by removing all elements.
     * Time Complexity: O(1)
     */
    public void clear() {
        head = null;
        size = 0;
    }
    
    /**
     * Reverses the linked list in-place.
     * Time Complexity: O(n) to traverse the list once
     */
    public void reverse() {
        // If the list is empty or has only one element
        if (head == null || head.getNext() == null) {
            return;
        }
        
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        
        // Traverse the list and reverse the links
        while (current != null) {
            // Store the next node
            next = current.getNext();
            
            // Reverse the link
            current.setNext(prev);
            
            // Move the pointers one position ahead
            prev = current;
            current = next;
        }
        
        // Update the head to the last node
        head = prev;
    }
    
    /**
     * String representation of the linked list.
     * Time Complexity: O(n) to traverse all elements
     * 
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        
        sb.append("]");
        return sb.toString();
    }
}
