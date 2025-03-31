package com.datastructures.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Test class for BinarySearchTree implementation.
 */
public class BinarySearchTreeTest {
    
    private BinarySearchTree<Integer> bst;
    
    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }
    
    @Test
    void testEmptyBST() {
        assertTrue(bst.isEmpty());
        assertNull(bst.getRoot());
        assertNull(bst.findMin());
        assertNull(bst.findMax());
        assertEquals(-1, bst.height());
        assertEquals(0, bst.size());
        assertTrue(bst.isValidBST());
    }
    
    @Test
    void testInsert() {
        bst.insert(50);
        assertFalse(bst.isEmpty());
        assertEquals(50, bst.getRoot().getData());
        assertEquals(50, bst.findMin());
        assertEquals(50, bst.findMax());
        
        bst.insert(30);
        bst.insert(70);
        assertEquals(30, bst.findMin());
        assertEquals(70, bst.findMax());
        
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        assertEquals(20, bst.findMin());
        assertEquals(80, bst.findMax());
        assertEquals(2, bst.height());
        assertEquals(7, bst.size());
        assertTrue(bst.isValidBST());
    }
    
    @Test
    void testSearch() {
        assertFalse(bst.search(50));
        
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        assertTrue(bst.search(50));
        assertTrue(bst.search(30));
        assertTrue(bst.search(70));
        assertTrue(bst.search(20));
        assertTrue(bst.search(40));
        assertTrue(bst.search(60));
        assertTrue(bst.search(80));
        
        assertFalse(bst.search(10));
        assertFalse(bst.search(90));
    }
    
    @Test
    void testDelete() {
        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        // Delete a leaf node
        bst.delete(20);
        assertFalse(bst.search(20));
        assertEquals(6, bst.size());
        assertTrue(bst.isValidBST());
        
        // Delete a node with one child
        bst.delete(60);
        assertFalse(bst.search(60));
        assertEquals(5, bst.size());
        assertTrue(bst.isValidBST());
        
        // Delete a node with two children
        bst.delete(30);
        assertFalse(bst.search(30));
        assertEquals(4, bst.size());
        assertTrue(bst.isValidBST());
        
        // Delete the root
        bst.delete(50);
        assertFalse(bst.search(50));
        assertEquals(3, bst.size());
        assertTrue(bst.isValidBST());
        
        // Delete a non-existent node
        bst.delete(100);
        assertEquals(3, bst.size());
        assertTrue(bst.isValidBST());
    }
    
    @Test
    void testInOrderTraversal() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        List<Integer> result = bst.inOrderTraversal();
        assertEquals(7, result.size());
        
        Integer[] expected = {20, 30, 40, 50, 60, 70, 80};
        assertArrayEquals(expected, result.toArray(new Integer[0]));
    }
    
    @Test
    void testPreOrderTraversal() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        List<Integer> result = bst.preOrderTraversal();
        assertEquals(7, result.size());
        
        Integer[] expected = {50, 30, 20, 40, 70, 60, 80};
        assertArrayEquals(expected, result.toArray(new Integer[0]));
    }
    
    @Test
    void testPostOrderTraversal() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        List<Integer> result = bst.postOrderTraversal();
        assertEquals(7, result.size());
        
        Integer[] expected = {20, 40, 30, 60, 80, 70, 50};
        assertArrayEquals(expected, result.toArray(new Integer[0]));
    }
    
    @Test
    void testLevelOrderTraversal() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        List<Integer> result = bst.levelOrderTraversal();
        assertEquals(7, result.size());
        
        Integer[] expected = {50, 30, 70, 20, 40, 60, 80};
        assertArrayEquals(expected, result.toArray(new Integer[0]));
    }
    
    @Test
    void testSuccessor() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        assertEquals(Integer.valueOf(30), bst.successor(20));
        assertEquals(Integer.valueOf(40), bst.successor(30));
        assertEquals(Integer.valueOf(50), bst.successor(40));
        assertEquals(Integer.valueOf(60), bst.successor(50));
        assertEquals(Integer.valueOf(70), bst.successor(60));
        assertEquals(Integer.valueOf(80), bst.successor(70));
        assertNull(bst.successor(80));
        assertNull(bst.successor(100));
    }
    
    @Test
    void testPredecessor() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        assertNull(bst.predecessor(20));
        assertEquals(Integer.valueOf(20), bst.predecessor(30));
        assertEquals(Integer.valueOf(30), bst.predecessor(40));
        assertEquals(Integer.valueOf(40), bst.predecessor(50));
        assertEquals(Integer.valueOf(50), bst.predecessor(60));
        assertEquals(Integer.valueOf(60), bst.predecessor(70));
        assertEquals(Integer.valueOf(70), bst.predecessor(80));
        assertNull(bst.predecessor(10));
    }
    
    @Test
    void testIsValidBST() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        assertTrue(bst.isValidBST());
    }
    
    @Test
    void testToString() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        
        String result = bst.toString();
        assertNotNull(result);
        assertTrue(result.contains("50"));
        assertTrue(result.contains("30"));
        assertTrue(result.contains("70"));
    }
}
