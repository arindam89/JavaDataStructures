package com.datastructures.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem: LRU Cache (Design)
 * 
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * 
 * Implement the LRUCache class:
 * - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * - int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * - void put(int key, int value) Update the value of the key if the key exists. 
 *   Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity 
 *   from this operation, evict the least recently used key.
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * Example:
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * 
 * Constraints:
 * - 1 <= capacity <= 3000
 * - 0 <= key <= 10^4
 * - 0 <= value <= 10^5
 * - At most 2 * 10^5 calls will be made to get and put.
 * 
 * This implementation uses a HashMap for O(1) lookups and a doubly linked list for O(1) removals
 * and insertions to maintain the order of elements.
 */
public class LRUCacheII {
    // Node class for doubly linked list
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
    private Map<Integer, Node> cache;
    private Node head; // Most recently used
    private Node tail; // Least recently used
    
    /**
     * Initializes the LRU cache with the specified capacity.
     * 
     * @param capacity the capacity of the cache
     */
    public LRUCacheII(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Initialize dummy head and tail nodes
        this.head = new Node();
        this.tail = new Node();
        
        // Connect head and tail
        head.next = tail;
        tail.prev = head;
    }
    
    /**
     * Retrieves the value for the specified key if it exists in the cache.
     * Also moves the key to the front of the list (most recently used).
     * 
     * @param key the key to look up
     * @return the value associated with the key, or -1 if not found
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        
        // Move the accessed node to the front (most recently used)
        moveToHead(node);
        
        return node.value;
    }
    
    /**
     * Updates the value of the key if it exists, or adds a new key-value pair.
     * If the cache exceeds capacity, removes the least recently used key.
     * 
     * @param key the key to update or add
     * @param value the value to associate with the key
     */
    public void put(int key, int value) {
        Node node = cache.get(key);
        
        if (node == null) {
            // Create a new node
            Node newNode = new Node(key, value);
            
            // Add to the cache
            cache.put(key, newNode);
            
            // Add to the front of the list
            addNode(newNode);
            
            // Check if we need to remove the least recently used item
            if (cache.size() > capacity) {
                // Remove the least recently used node (tail.prev)
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
        } else {
            // Update existing node's value
            node.value = value;
            
            // Move to the front (most recently used)
            moveToHead(node);
        }
    }
    
    /**
     * Helper method to add a node right after the head (most recently used).
     * 
     * @param node the node to add
     */
    private void addNode(Node node) {
        // Connect node to head and head's next
        node.prev = head;
        node.next = head.next;
        
        // Update head's next and its prev
        head.next.prev = node;
        head.next = node;
    }
    
    /**
     * Helper method to remove a node from the list.
     * 
     * @param node the node to remove
     */
    private void removeNode(Node node) {
        // Connect node's prev and next to each other
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    /**
     * Helper method to move a node to the head (most recently used).
     * 
     * @param node the node to move
     */
    private void moveToHead(Node node) {
        // Remove from current position
        removeNode(node);
        
        // Add to the front
        addNode(node);
    }
}