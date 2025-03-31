package com.datastructures.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Test class for BinaryTree implementation.
 */
public class BinaryTreeTest {
    
    private BinaryTree<Integer> tree;
    private TreeNode<Integer> root;
    
    @BeforeEach
    void setUp() {
        tree = new BinaryTree<>();
        
        // Create a binary tree:
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        root = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);
    }
    
    @Test
    void testEmptyTree() {
        BinaryTree<Integer> emptyTree = new BinaryTree<>();
        assertTrue(emptyTree.isEmpty());
        assertNull(emptyTree.getRoot());
        assertEquals(-1, emptyTree.height());
        assertEquals(0, emptyTree.size());
        assertEquals(0, emptyTree.countLeaves());
        assertTrue(emptyTree.isFullBinaryTree());
        assertTrue(emptyTree.isPerfectBinaryTree());
        assertTrue(emptyTree.isCompleteBinaryTree());
        assertTrue(emptyTree.isBalanced());
    }
    
    @Test
    void testTreeWithRoot() {
        tree.setRoot(root);
        
        assertFalse(tree.isEmpty());
        assertEquals(root, tree.getRoot());
        assertEquals(2, tree.height());
        assertEquals(6, tree.size());
        assertEquals(3, tree.countLeaves());
        assertFalse(tree.isFullBinaryTree());
        assertFalse(tree.isPerfectBinaryTree());
        assertFalse(tree.isCompleteBinaryTree());
        assertFalse(tree.isBalanced());
    }
    
    @Test
    void testInOrderTraversal() {
        tree.setRoot(root);
        
        List<Integer> result = tree.inOrderTraversal();
        assertEquals(6, result.size());
        
        Integer[] expected = {4, 2, 5, 1, 3, 6};
        assertArrayEquals(expected, result.toArray(new Integer[0]));
    }
    
    @Test
    void testPreOrderTraversal() {
        tree.setRoot(root);
        
        List<Integer> result = tree.preOrderTraversal();
        assertEquals(6, result.size());
        
        Integer[] expected = {1, 2, 4, 5, 3, 6};
        assertArrayEquals(expected, result.toArray(new Integer[0]));
    }
    
    @Test
    void testPostOrderTraversal() {
        tree.setRoot(root);
        
        List<Integer> result = tree.postOrderTraversal();
        assertEquals(6, result.size());
        
        Integer[] expected = {4, 5, 2, 6, 3, 1};
        assertArrayEquals(expected, result.toArray(new Integer[0]));
    }
    
    @Test
    void testLevelOrderTraversal() {
        tree.setRoot(root);
        
        List<Integer> result = tree.levelOrderTraversal();
        assertEquals(6, result.size());
        
        Integer[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, result.toArray(new Integer[0]));
    }
    
    @Test
    void testHeight() {
        tree.setRoot(root);
        assertEquals(2, tree.height());
        
        // Add another level
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node4 = root.getLeft().getLeft();
        node4.setLeft(node7);
        
        assertEquals(3, tree.height());
    }
    
    @Test
    void testSize() {
        tree.setRoot(root);
        assertEquals(6, tree.size());
        
        // Add another node
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node4 = root.getLeft().getLeft();
        node4.setLeft(node7);
        
        assertEquals(7, tree.size());
    }
    
    @Test
    void testCountLeaves() {
        tree.setRoot(root);
        assertEquals(3, tree.countLeaves());
        
        // Add another node
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node4 = root.getLeft().getLeft();
        node4.setLeft(node7);
        
        assertEquals(3, tree.countLeaves());
    }
    
    @Test
    void testIsFullBinaryTree() {
        // Create a full binary tree:
        //       1
        //      / \
        //     2   3
        TreeNode<Integer> fullRoot = new TreeNode<>(1);
        fullRoot.setLeft(new TreeNode<>(2));
        fullRoot.setRight(new TreeNode<>(3));
        
        BinaryTree<Integer> fullTree = new BinaryTree<>(fullRoot);
        assertTrue(fullTree.isFullBinaryTree());
        
        // Not a full binary tree
        tree.setRoot(root);
        assertFalse(tree.isFullBinaryTree());
    }
    
    @Test
    void testIsPerfectBinaryTree() {
        // Create a perfect binary tree:
        //       1
        //      / \
        //     2   3
        //    / \ / \
        //   4  5 6  7
        TreeNode<Integer> perfectRoot = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        
        perfectRoot.setLeft(node2);
        perfectRoot.setRight(node3);
        
        node2.setLeft(new TreeNode<>(4));
        node2.setRight(new TreeNode<>(5));
        node3.setLeft(new TreeNode<>(6));
        node3.setRight(new TreeNode<>(7));
        
        BinaryTree<Integer> perfectTree = new BinaryTree<>(perfectRoot);
        assertTrue(perfectTree.isPerfectBinaryTree());
        
        // Not a perfect binary tree
        tree.setRoot(root);
        assertFalse(tree.isPerfectBinaryTree());
    }
    
    @Test
    void testIsCompleteBinaryTree() {
        // Create a complete binary tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode<Integer> completeRoot = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        
        completeRoot.setLeft(node2);
        completeRoot.setRight(node3);
        
        node2.setLeft(new TreeNode<>(4));
        node2.setRight(new TreeNode<>(5));
        
        BinaryTree<Integer> completeTree = new BinaryTree<>(completeRoot);
        assertTrue(completeTree.isCompleteBinaryTree());
        
        // Not a complete binary tree
        tree.setRoot(root);
        assertFalse(tree.isCompleteBinaryTree());
    }
    
    @Test
    void testIsBalanced() {
        // Create a balanced binary tree:
        //       1
        //      / \
        //     2   3
        //    /
        //   4
        TreeNode<Integer> balancedRoot = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        
        balancedRoot.setLeft(node2);
        balancedRoot.setRight(node3);
        
        node2.setLeft(new TreeNode<>(4));
        
        BinaryTree<Integer> balancedTree = new BinaryTree<>(balancedRoot);
        assertTrue(balancedTree.isBalanced());
        
        // Not balanced
        tree.setRoot(root);
        assertFalse(tree.isBalanced());
    }
    
    @Test
    void testMirror() {
        tree.setRoot(root);
        
        List<Integer> before = tree.inOrderTraversal();
        Integer[] expectedBefore = {4, 2, 5, 1, 3, 6};
        assertArrayEquals(expectedBefore, before.toArray(new Integer[0]));
        
        // Mirror the tree
        tree.mirror();
        
        List<Integer> after = tree.inOrderTraversal();
        Integer[] expectedAfter = {6, 3, 1, 5, 2, 4};
        assertArrayEquals(expectedAfter, after.toArray(new Integer[0]));
    }
    
    @Test
    void testToString() {
        tree.setRoot(root);
        
        String result = tree.toString();
        assertNotNull(result);
        assertTrue(result.contains("1"));
        assertTrue(result.contains("2"));
        assertTrue(result.contains("3"));
        assertTrue(result.contains("4"));
        assertTrue(result.contains("5"));
        assertTrue(result.contains("6"));
    }
}
