package com.leetcode;

/**
 * LeetCode #124: Binary Tree Maximum Path Sum
 * 
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence
 * has an edge connecting them. A node can only appear in the sequence at most once. Note that the
 * path does not need to pass through the root.
 * 
 * The path sum of a path is the sum of the node's values in the path.
 * 
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * 
 * Time Complexity: O(n) where n is the number of nodes in the tree
 * Space Complexity: O(h) where h is the height of the tree, due to recursion stack
 */
public class BinaryTreeMaxPathSum {
    
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    /**
     * Global variable to store the maximum path sum.
     * We use this because in recursion we need to keep track of the max value across all paths.
     */
    private int maxSum;
    
    /**
     * Finds the maximum path sum in a binary tree.
     * 
     * @param root the root of the binary tree
     * @return the maximum path sum
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        maxSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return maxSum;
    }
    
    /**
     * Recursive helper method to find the maximum path sum.
     * For each node, it calculates:
     * 1. The max path sum that passes through the node and extends to one of its children
     * 2. The max path sum that passes through the node and connects its two children
     * 
     * @param node the current node being processed
     * @return the maximum path sum starting from this node and going down one path
     */
    private int findMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // Calculate the maximum path sum from left child
        // If it's negative, we're better off not including it (take 0 instead)
        int leftMax = Math.max(0, findMaxPathSum(node.left));
        
        // Calculate the maximum path sum from right child
        // If it's negative, we're better off not including it (take 0 instead)
        int rightMax = Math.max(0, findMaxPathSum(node.right));
        
        // Update the global maximum
        // This considers the path through the current node that connects the left and right subtrees
        maxSum = Math.max(maxSum, node.val + leftMax + rightMax);
        
        // Return the maximum path sum starting from this node and going down one path
        // (we can't include both left and right paths when returning up the recursion,
        // as that would create a non-valid path for the parent)
        return node.val + Math.max(leftMax, rightMax);
    }
    
    /**
     * Finds the actual path that gives the maximum sum.
     * This version not only returns the max sum but also the path that produces it.
     * 
     * @param root the root of the binary tree
     * @return a string representation of the maximum path sum and the path itself
     */
    public String maxPathSumWithPath(TreeNode root) {
        if (root == null) {
            return "Empty tree";
        }
        
        maxSum = Integer.MIN_VALUE;
        StringBuilder maxPath = new StringBuilder();
        StringBuilder currentPath = new StringBuilder();
        
        findMaxPathSumWithPath(root, currentPath, maxPath);
        
        return "Maximum Path Sum: " + maxSum + "\nPath: " + maxPath.toString();
    }
    
    /**
     * Helper class to store path information during recursion.
     */
    private static class PathInfo {
        int sum;
        String path;
        
        PathInfo(int sum, String path) {
            this.sum = sum;
            this.path = path;
        }
    }
    
    /**
     * Helper method to find the maximum path sum with the path.
     * 
     * @param node the current node
     * @param currentPath tracks the current path being explored
     * @param maxPath will be updated with the path that gives the maximum sum
     * @return the PathInfo containing the maximum sum and path from this node
     */
    private PathInfo findMaxPathSumWithPath(TreeNode node, StringBuilder currentPath, StringBuilder maxPath) {
        if (node == null) {
            return new PathInfo(0, "");
        }
        
        // Record the current node
        String nodePath = node.val + "";
        
        // Get the maximum paths from left and right children
        PathInfo leftInfo = findMaxPathSumWithPath(node.left, currentPath, maxPath);
        PathInfo rightInfo = findMaxPathSumWithPath(node.right, currentPath, maxPath);
        
        // If including the child paths would decrease the sum, don't include them
        int leftMax = Math.max(0, leftInfo.sum);
        int rightMax = Math.max(0, rightInfo.sum);
        
        // Calculate the max path through this node (connecting left and right subtrees)
        int totalSum = node.val + leftMax + rightMax;
        
        // Update the global max if necessary
        if (totalSum > maxSum) {
            maxSum = totalSum;
            
            // Construct the path
            StringBuilder pathBuilder = new StringBuilder();
            
            if (leftMax > 0) {
                pathBuilder.append(leftInfo.path).append(" -> ");
            }
            
            pathBuilder.append(node.val);
            
            if (rightMax > 0) {
                pathBuilder.append(" -> ").append(rightInfo.path);
            }
            
            maxPath.setLength(0);
            maxPath.append(pathBuilder.toString());
        }
        
        // For the return value, we can only include one child path
        // (Either the left or right, whichever gives a larger sum)
        String returnPath;
        if (leftMax > rightMax) {
            returnPath = leftInfo.path.isEmpty() ? nodePath : leftInfo.path + " -> " + nodePath;
        } else {
            returnPath = rightInfo.path.isEmpty() ? nodePath : nodePath + " -> " + rightInfo.path;
        }
        
        return new PathInfo(node.val + Math.max(leftMax, rightMax), returnPath);
    }
    
    /**
     * Creates a binary tree from an array representation.
     * Similar to the way LeetCode represents binary trees.
     * 
     * @param values the array representation of the tree
     * @return the root of the created binary tree
     */
    public TreeNode createBinaryTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }
        
        return createBinaryTreeHelper(values, 0);
    }
    
    /**
     * Helper method for creating a binary tree.
     * 
     * @param values the array representation of the tree
     * @param index the current index being processed
     * @return the node at the current index
     */
    private TreeNode createBinaryTreeHelper(Integer[] values, int index) {
        if (index >= values.length || values[index] == null) {
            return null;
        }
        
        TreeNode node = new TreeNode(values[index]);
        node.left = createBinaryTreeHelper(values, 2 * index + 1);
        node.right = createBinaryTreeHelper(values, 2 * index + 2);
        
        return node;
    }
}