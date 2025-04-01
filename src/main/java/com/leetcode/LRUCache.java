package com.leetcode;

import java.util.HashMap;

/**
 * LeetCode #146: LRU Cache (Medium)
 * 
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * 
 * Implement the LRUCache class:
 * - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * - int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * - void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
 *   If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * Time Complexity: O(1) for both get() and put()
 * Space Complexity: O(capacity) to store at most 'capacity' key-value pairs
 */
public class LRUCache {
    
    /**
     * Internal node class for the doubly linked list.
     */
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node() {}
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> cache; // Maps key to node in the list
    private Node head; // Dummy head of the doubly linked list
    private Node tail; // Dummy tail of the doubly linked list
    
    /**
     * Initialize the LRU cache with a positive size capacity.
     * 
     * @param capacity the maximum number of items the cache can hold
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Initialize dummy head and tail for easier handling
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    /**
     * Return the value of the key if the key exists, otherwise return -1.
     * Also moves the accessed key to the most recently used position.
     * 
     * @param key the key to look up
     * @return the value associated with the key, or -1 if not found
     */
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        // Get the node from the cache
        Node node = cache.get(key);
        
        // Move the node to the front (most recently used)
        moveToHead(node);
        
        return node.value;
    }
    
    /**
     * Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
     * If the number of keys exceeds the capacity, evict the least recently used key.
     * 
     * @param key the key to add or update
     * @param value the value to associate with the key
     */
    public void put(int key, int value) {
        // Check if the key already exists
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // Update the value
            moveToHead(node); // Move to the front as most recently used
            return;
        }
        
        // Create a new node for the key-value pair
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addNode(newNode);
        
        // Check if we need to evict the least recently used item
        if (cache.size() > capacity) {
            // Remove the tail node (least recently used)
            Node lru = removeTail();
            cache.remove(lru.key);
        }
    }
    
    /**
     * Adds a node right after the dummy head.
     */
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    /**
     * Removes a node from the doubly linked list.
     */
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    /**
     * Moves a node to the front of the list (right after dummy head).
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
    
    /**
     * Removes and returns the node right before the dummy tail (least recently used).
     */
    private Node removeTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
}