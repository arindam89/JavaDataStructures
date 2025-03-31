package com.datastructures.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for MinHeap implementation.
 */
public class MinHeapTest {
    
    private MinHeap<Integer> heap;
    
    @BeforeEach
    void setUp() {
        heap = new MinHeap<>();
    }
    
    @Test
    void testEmptyHeap() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        assertThrows(IllegalStateException.class, () -> heap.peek());
        assertThrows(IllegalStateException.class, () -> heap.extractMin());
    }
    
    @Test
    void testInsert() {
        heap.insert(10);
        assertEquals(1, heap.size());
        assertEquals(10, heap.peek());
        
        heap.insert(20);
        assertEquals(2, heap.size());
        assertEquals(10, heap.peek());
        
        heap.insert(5);
        assertEquals(3, heap.size());
        assertEquals(5, heap.peek());
    }
    
    @Test
    void testExtractMin() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        
        assertEquals(5, heap.extractMin());
        assertEquals(2, heap.size());
        assertEquals(10, heap.peek());
        
        assertEquals(10, heap.extractMin());
        assertEquals(1, heap.size());
        assertEquals(20, heap.peek());
        
        assertEquals(20, heap.extractMin());
        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
    }
    
    @Test
    void testHeapifyFromList() {
        List<Integer> elements = Arrays.asList(10, 20, 15, 30, 5);
        heap = new MinHeap<>(elements);
        
        assertEquals(5, heap.size());
        assertEquals(5, heap.peek());
        
        assertEquals(5, heap.extractMin());
        assertEquals(10, heap.extractMin());
        assertEquals(15, heap.extractMin());
        assertEquals(20, heap.extractMin());
        assertEquals(30, heap.extractMin());
        assertTrue(heap.isEmpty());
    }
    
    @Test
    void testClear() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        
        assertFalse(heap.isEmpty());
        
        heap.clear();
        
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }
    
    @Test
    void testToList() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        
        List<Integer> list = heap.toList();
        assertEquals(3, list.size());
        
        // The list is in heap order, not sorted order
        assertEquals(5, list.get(0));
    }
    
    @Test
    void testHeapSort() {
        List<Integer> unsorted = Arrays.asList(3, 8, 2, 1, 7, 4, 6, 5);
        heap = new MinHeap<>(unsorted);
        
        Integer[] sorted = new Integer[unsorted.size()];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = heap.extractMin();
        }
        
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, sorted);
    }
    
    @Test
    void testToString() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        
        assertNotNull(heap.toString());
        assertTrue(heap.toString().contains("5"));
        assertTrue(heap.toString().contains("10"));
        assertTrue(heap.toString().contains("20"));
    }
}
