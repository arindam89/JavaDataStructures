package com.datastructures.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for MaxHeap implementation.
 */
public class MaxHeapTest {
    
    private MaxHeap<Integer> heap;
    
    @BeforeEach
    void setUp() {
        heap = new MaxHeap<>();
    }
    
    @Test
    void testEmptyHeap() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        assertThrows(IllegalStateException.class, () -> heap.peek());
        assertThrows(IllegalStateException.class, () -> heap.extractMax());
    }
    
    @Test
    void testInsert() {
        heap.insert(10);
        assertEquals(1, heap.size());
        assertEquals(10, heap.peek());
        
        heap.insert(20);
        assertEquals(2, heap.size());
        assertEquals(20, heap.peek());
        
        heap.insert(15);
        assertEquals(3, heap.size());
        assertEquals(20, heap.peek());
    }
    
    @Test
    void testExtractMax() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        
        assertEquals(20, heap.extractMax());
        assertEquals(2, heap.size());
        assertEquals(15, heap.peek());
        
        assertEquals(15, heap.extractMax());
        assertEquals(1, heap.size());
        assertEquals(10, heap.peek());
        
        assertEquals(10, heap.extractMax());
        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
    }
    
    @Test
    void testHeapifyFromList() {
        List<Integer> elements = Arrays.asList(10, 20, 15, 30, 5);
        heap = new MaxHeap<>(elements);
        
        assertEquals(5, heap.size());
        assertEquals(30, heap.peek());
        
        assertEquals(30, heap.extractMax());
        assertEquals(20, heap.extractMax());
        assertEquals(15, heap.extractMax());
        assertEquals(10, heap.extractMax());
        assertEquals(5, heap.extractMax());
        assertTrue(heap.isEmpty());
    }
    
    @Test
    void testClear() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        
        assertFalse(heap.isEmpty());
        
        heap.clear();
        
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }
    
    @Test
    void testToList() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        
        List<Integer> list = heap.toList();
        assertEquals(3, list.size());
        
        // The list is in heap order, not sorted order
        assertEquals(20, list.get(0));
    }
    
    @Test
    void testHeapSort() {
        List<Integer> unsorted = Arrays.asList(3, 8, 2, 1, 7, 4, 6, 5);
        heap = new MaxHeap<>(unsorted);
        
        Integer[] sorted = new Integer[unsorted.size()];
        for (int i = sorted.length - 1; i >= 0; i--) {
            sorted[i] = heap.extractMax();
        }
        
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, sorted);
    }
    
    @Test
    void testToString() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        
        assertNotNull(heap.toString());
        assertTrue(heap.toString().contains("20"));
        assertTrue(heap.toString().contains("15"));
        assertTrue(heap.toString().contains("10"));
    }
}
