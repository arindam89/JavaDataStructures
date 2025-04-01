package com.leetcode.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LRUCacheII implementation.
 */
public class LRUCacheIITest {

    @Test
    void testLRUCacheExample() {
        LRUCacheII lruCache = new LRUCacheII(2);
        
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertEquals(1, lruCache.get(1));
        
        lruCache.put(3, 3);
        assertEquals(-1, lruCache.get(2));
        
        lruCache.put(4, 4);
        assertEquals(-1, lruCache.get(1));
        assertEquals(3, lruCache.get(3));
        assertEquals(4, lruCache.get(4));
    }
    
    @Test
    void testLRUCacheSingleCapacity() {
        LRUCacheII lruCache = new LRUCacheII(1);
        
        lruCache.put(1, 1);
        assertEquals(1, lruCache.get(1));
        
        lruCache.put(2, 2);
        assertEquals(-1, lruCache.get(1));
        assertEquals(2, lruCache.get(2));
    }
    
    @Test
    void testLRUCacheUpdateExisting() {
        LRUCacheII lruCache = new LRUCacheII(2);
        
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertEquals(1, lruCache.get(1));
        
        lruCache.put(1, 10); // Update value of key 1
        assertEquals(10, lruCache.get(1));
        assertEquals(2, lruCache.get(2));
    }
    
    @Test
    void testLRUCacheRecentlyUsedEviction() {
        LRUCacheII lruCache = new LRUCacheII(2);
        
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertEquals(1, lruCache.get(1)); // Key 1 is now most recently used
        
        lruCache.put(3, 3); // Key 2 should be evicted as it's least recently used
        assertEquals(1, lruCache.get(1));
        assertEquals(-1, lruCache.get(2));
        assertEquals(3, lruCache.get(3));
    }
    
    @Test
    void testLRUCacheMultipleUpdates() {
        LRUCacheII lruCache = new LRUCacheII(3);
        
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);
        
        assertEquals(10, lruCache.get(1));
        assertEquals(20, lruCache.get(2));
        assertEquals(30, lruCache.get(3));
    }
    
    @Test
    void testLRUCacheComplexSequence() {
        LRUCacheII lruCache = new LRUCacheII(3);
        
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        assertEquals(3, lruCache.get(3));
        assertEquals(2, lruCache.get(2));
        assertEquals(1, lruCache.get(1));
        
        lruCache.put(4, 4); // Evict 3 as 1 and 2 were more recently used
        assertEquals(-1, lruCache.get(3));
        assertEquals(4, lruCache.get(4));
        assertEquals(2, lruCache.get(2));
        assertEquals(1, lruCache.get(1));
        
        lruCache.put(5, 5); // Evict 4 as 1 and 2 were more recently used
        assertEquals(-1, lruCache.get(4));
        assertEquals(5, lruCache.get(5));
    }
}