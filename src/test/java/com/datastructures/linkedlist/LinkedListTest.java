package com.datastructures.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

/**
 * Test class for LinkedList implementation.
 */
public class LinkedListTest {
    
    private LinkedList<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }
    
    @Test
    void testEmptyList() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }
    
    @Test
    void testAddFirst() {
        list.addFirst(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
        
        list.addFirst(20);
        assertEquals(2, list.size());
        assertEquals(20, list.get(0));
        assertEquals(10, list.get(1));
    }
    
    @Test
    void testAddLast() {
        list.addLast(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
        
        list.addLast(20);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }
    
    @Test
    void testAddAtPosition() {
        list.addAtPosition(10, 0);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
        
        list.addAtPosition(20, 1);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        
        list.addAtPosition(15, 1);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(15, list.get(1));
        assertEquals(20, list.get(2));
        
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAtPosition(30, 4));
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAtPosition(30, -1));
    }
    
    @Test
    void testRemoveFirst() {
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
        
        list.addFirst(10);
        list.addFirst(20);
        
        assertEquals(20, list.removeFirst());
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
        
        assertEquals(10, list.removeFirst());
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
    
    @Test
    void testRemoveLast() {
        assertThrows(NoSuchElementException.class, () -> list.removeLast());
        
        list.addLast(10);
        list.addLast(20);
        
        assertEquals(20, list.removeLast());
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
        
        assertEquals(10, list.removeLast());
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
    
    @Test
    void testRemoveAtPosition() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAtPosition(0));
        
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        
        assertEquals(20, list.removeAtPosition(1));
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
        
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAtPosition(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAtPosition(-1));
    }
    
    @Test
    void testGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        
        list.addLast(10);
        list.addLast(20);
        
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }
    
    @Test
    void testSet() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(10, 0));
        
        list.addLast(10);
        list.addLast(20);
        
        list.set(15, 0);
        assertEquals(15, list.get(0));
        
        list.set(25, 1);
        assertEquals(25, list.get(1));
        
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(30, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(30, -1));
    }
    
    @Test
    void testContains() {
        assertFalse(list.contains(10));
        
        list.addLast(10);
        list.addLast(20);
        
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertFalse(list.contains(30));
    }
    
    @Test
    void testIndexOf() {
        assertEquals(-1, list.indexOf(10));
        
        list.addLast(10);
        list.addLast(20);
        list.addLast(10);
        
        assertEquals(0, list.indexOf(10));
        assertEquals(1, list.indexOf(20));
        assertEquals(-1, list.indexOf(30));
    }
    
    @Test
    void testClear() {
        list.addLast(10);
        list.addLast(20);
        
        assertFalse(list.isEmpty());
        
        list.clear();
        
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
    
    @Test
    void testReverse() {
        // Empty list
        list.reverse();
        assertTrue(list.isEmpty());
        
        // Single element
        list.addLast(10);
        list.reverse();
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
        
        // Multiple elements
        list.addLast(20);
        list.addLast(30);
        
        list.reverse();
        
        assertEquals(3, list.size());
        assertEquals(30, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(10, list.get(2));
    }
    
    @Test
    void testToString() {
        assertEquals("[]", list.toString());
        
        list.addLast(10);
        assertEquals("[10]", list.toString());
        
        list.addLast(20);
        assertEquals("[10, 20]", list.toString());
        
        list.addLast(30);
        assertEquals("[10, 20, 30]", list.toString());
    }
}
