package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;

import com.leetcode.BinaryTreeMaxPathSum;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the Binary Tree Maximum Path Sum problem.
 */
public class BinaryTreeMaxPathSumTest {
    
    @Test
    public void testMaxPathSumExample1() {
        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();
        
        // Example 1: [1,2,3]
        BinaryTreeMaxPathSum.TreeNode root = new BinaryTreeMaxPathSum.TreeNode(1);
        root.left = new BinaryTreeMaxPathSum.TreeNode(2);
        root.right = new BinaryTreeMaxPathSum.TreeNode(3);
        
        assertEquals(6, solution.maxPathSum(root));
    }
    
    @Test
    public void testMaxPathSumExample2() {
        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();
        
        // Example 2: [-10,9,20,null,null,15,7]
        BinaryTreeMaxPathSum.TreeNode root = new BinaryTreeMaxPathSum.TreeNode(-10);
        root.left = new BinaryTreeMaxPathSum.TreeNode(9);
        root.right = new BinaryTreeMaxPathSum.TreeNode(20);
        root.right.left = new BinaryTreeMaxPathSum.TreeNode(15);
        root.right.right = new BinaryTreeMaxPathSum.TreeNode(7);
        
        assertEquals(42, solution.maxPathSum(root));
    }
    
    @Test
    public void testMaxPathSumSingleNode() {
        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();
        
        // Single node with positive value
        BinaryTreeMaxPathSum.TreeNode positiveRoot = new BinaryTreeMaxPathSum.TreeNode(5);
        assertEquals(5, solution.maxPathSum(positiveRoot));
        
        // Single node with negative value
        BinaryTreeMaxPathSum.TreeNode negativeRoot = new BinaryTreeMaxPathSum.TreeNode(-5);
        assertEquals(-5, solution.maxPathSum(negativeRoot));
    }
    
    @Test
    public void testMaxPathSumAllNegative() {
        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();
        
        // Tree with all negative values
        BinaryTreeMaxPathSum.TreeNode root = new BinaryTreeMaxPathSum.TreeNode(-1);
        root.left = new BinaryTreeMaxPathSum.TreeNode(-2);
        root.right = new BinaryTreeMaxPathSum.TreeNode(-3);
        
        assertEquals(-1, solution.maxPathSum(root));
    }
    
    @Test
    public void testMaxPathSumPathNotThroughRoot() {
        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();
        
        // Tree where the max path does not go through the root
        BinaryTreeMaxPathSum.TreeNode root = new BinaryTreeMaxPathSum.TreeNode(5);
        root.left = new BinaryTreeMaxPathSum.TreeNode(4);
        root.left.left = new BinaryTreeMaxPathSum.TreeNode(11);
        root.left.left.left = new BinaryTreeMaxPathSum.TreeNode(7);
        root.left.left.right = new BinaryTreeMaxPathSum.TreeNode(2);
        root.right = new BinaryTreeMaxPathSum.TreeNode(8);
        root.right.left = new BinaryTreeMaxPathSum.TreeNode(13);
        root.right.right = new BinaryTreeMaxPathSum.TreeNode(4);
        root.right.right.right = new BinaryTreeMaxPathSum.TreeNode(1);
        
        // Max path is 5 -> 4 -> 11 -> 7 + 8 -> 13 = 48
        assertEquals(48, solution.maxPathSum(root));
    }
    
    @Test
    public void testMaxPathSumEmptyTree() {
        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();
        
        // Empty tree
        assertEquals(0, solution.maxPathSum(null));
    }
    
    @Test
    public void testMaxPathSumWithPath() {
        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();
        
        // Example: [-10,9,20,null,null,15,7]
        BinaryTreeMaxPathSum.TreeNode root = new BinaryTreeMaxPathSum.TreeNode(-10);
        root.left = new BinaryTreeMaxPathSum.TreeNode(9);
        root.right = new BinaryTreeMaxPathSum.TreeNode(20);
        root.right.left = new BinaryTreeMaxPathSum.TreeNode(15);
        root.right.right = new BinaryTreeMaxPathSum.TreeNode(7);
        
        String result = solution.maxPathSumWithPath(root);
        
        assertTrue(result.contains("Maximum Path Sum: 42"));
    }
    
    @Test
    public void testCreateBinaryTree() {
        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();
        
        // Create a tree using the array representation
        Integer[] values = {-10, 9, 20, null, null, 15, 7};
        BinaryTreeMaxPathSum.TreeNode root = solution.createBinaryTree(values);
        
        assertNotNull(root);
        assertEquals(-10, root.val);
        assertEquals(9, root.left.val);
        assertEquals(20, root.right.val);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);
        
        // Check the path sum matches our expected value
        assertEquals(42, solution.maxPathSum(root));
    }
}