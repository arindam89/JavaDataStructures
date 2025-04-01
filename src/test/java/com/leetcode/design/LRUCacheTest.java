package com.leetcode.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LRUCache implementation.
 */
public class LRUCacheTest {

    @Test
    void testLRUCacheExample1() {
        LRUCache cache = new LRUCache(2); // capacity = 2
        
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1)); // returns 1
        
        cache.put(3, 3); // evicts key 2
        assertEquals(-1, cache.get(2)); // returns -1 (not found)
        
        cache.put(4, 4); // evicts key 1
        assertEquals(-1, cache.get(1)); // returns -1 (not found)
        assertEquals(3, cache.get(3)); // returns 3
        assertEquals(4, cache.get(4)); // returns 4
    }
    
    @Test
    void testLRUCacheCapacityOne() {
        LRUCache cache = new LRUCache(1); // capacity = 1
        
        cache.put(1, 1);
        assertEquals(1, cache.get(1)); // returns 1
        
        cache.put(2, 2); // evicts key 1
        assertEquals(-1, cache.get(1)); // returns -1 (not found)
        assertEquals(2, cache.get(2)); // returns 2
    }
    
    @Test
    void testLRUCacheUpdateExistingKey() {
        LRUCache cache = new LRUCache(2);
        
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1)); // returns 1
        
        cache.put(1, 10); // update key 1
        assertEquals(10, cache.get(1)); // returns 10
        
        cache.put(3, 3); // evicts key 2 (not key 1, since key 1 was used more recently)
        assertEquals(-1, cache.get(2)); // returns -1 (not found)
        assertEquals(10, cache.get(1)); // returns 10
    }
    
    @Test
    void testLRUCacheFrequentAccess() {
        LRUCache cache = new LRUCache(3);
        
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        
        // Access keys in reverse order
        assertEquals(3, cache.get(3));
        assertEquals(2, cache.get(2));
        assertEquals(1, cache.get(1));
        
        // Add a new key, should evict key 3
        cache.put(4, 4);
        assertEquals(-1, cache.get(3)); // returns -1 (evicted)
        
        // Access keys again
        assertEquals(1, cache.get(1));
        assertEquals(2, cache.get(2));
        
        // Add a new key, should evict key 4
        cache.put(5, 5);
        assertEquals(-1, cache.get(4)); // returns -1 (evicted)
    }
    
    @Test
    void testLRUCacheKeyNotFound() {
        LRUCache cache = new LRUCache(2);
        
        assertEquals(-1, cache.get(1)); // returns -1 (not found)
        
        cache.put(1, 1);
        assertEquals(1, cache.get(1)); // returns 1
        assertEquals(-1, cache.get(2)); // returns -1 (not found)
    }
    
    @Test
    void testLRUCacheEvictionOrder() {
        LRUCache cache = new LRUCache(3);
        
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        
        cache.get(1); // Access key 1, making it most recently used
        
        cache.put(4, 4); // Should evict key 2
        assertEquals(1, cache.get(1));
        assertEquals(-1, cache.get(2)); // returns -1 (evicted)
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}