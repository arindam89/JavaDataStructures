package com.leetcode;

/**
 * LeetCode #329: Longest Increasing Path in a Matrix (Hard)
 * 
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 * 
 * From each cell, you can either move in four directions: left, right, up, or down. 
 * You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 * 
 * Time Complexity: O(m * n) where m and n are the dimensions of the matrix
 * Space Complexity: O(m * n) for the memoization array
 */
public class LongestIncreasingPath {
    
    // Four possible directions: up, right, down, left
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    /**
     * Finds the length of the longest increasing path in the matrix.
     * 
     * @param matrix the input matrix
     * @return the length of the longest increasing path
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Memoization array to store the longest path starting from each cell
        int[][] memo = new int[rows][cols];
        
        int longestPath = 0;
        
        // Try starting from each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, i, j, memo));
            }
        }
        
        return longestPath;
    }
    
    /**
     * Depth-first search with memoization to find the longest increasing path starting from a cell.
     * 
     * @param matrix the input matrix
     * @param row the current row
     * @param col the current column
     * @param memo the memoization array
     * @return the length of the longest increasing path starting from the cell
     */
    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        // If we've already calculated the result for this cell, return it
        if (memo[row][col] > 0) {
            return memo[row][col];
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Initialize the path length to 1 (counting the current cell)
        int maxPath = 1;
        
        // Try all four directions
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            // Check if the new position is valid and the next number is greater
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && 
                matrix[newRow][newCol] > matrix[row][col]) {
                // Recursively find the longest path from the new position
                int currentPath = 1 + dfs(matrix, newRow, newCol, memo);
                maxPath = Math.max(maxPath, currentPath);
            }
        }
        
        // Save the result in the memo array before returning
        memo[row][col] = maxPath;
        
        return maxPath;
    }
}