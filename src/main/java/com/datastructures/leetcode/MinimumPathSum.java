package com.datastructures.leetcode;

import java.util.Arrays;

/**
 * LeetCode #64: Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative integers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Time Complexity: O(m * n) where m and n are the dimensions of the grid
 * Space Complexity: O(m * n) for the DP solution, can be optimized to O(n)
 */
public class MinimumPathSum {
    
    /**
     * Finds the minimum path sum from top-left to bottom-right in a grid.
     * Uses dynamic programming to store intermediate results.
     * 
     * @param grid the input grid of non-negative integers
     * @return the minimum path sum
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;    // Number of rows
        int n = grid[0].length; // Number of columns
        
        // Create a dp table where dp[i][j] represents the minimum path sum to reach (i, j)
        int[][] dp = new int[m][n];
        
        // Initialize the top-left cell
        dp[0][0] = grid[0][0];
        
        // Initialize the first row (can only move right)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // Initialize the first column (can only move down)
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // At each cell, we can only come from the left or from above
                // Choose the minimum of these two paths
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        // The bottom-right cell contains the minimum path sum
        return dp[m - 1][n - 1];
    }
    
    /**
     * Optimized version that uses O(n) space instead of O(m * n).
     * We only need to keep track of the previous row to compute the current row.
     * 
     * @param grid the input grid of non-negative integers
     * @return the minimum path sum
     */
    public int minPathSumOptimized(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;    // Number of rows
        int n = grid[0].length; // Number of columns
        
        // Create a 1D dp array where dp[j] represents the minimum path sum to reach (current_row, j)
        int[] dp = new int[n];
        
        // Initialize the dp array
        dp[0] = grid[0][0];
        
        // Initialize the first row
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        // Process the rest of the grid
        for (int i = 1; i < m; i++) {
            // Update the dp array for the current row
            dp[0] += grid[i][0]; // First column can only come from above
            
            for (int j = 1; j < n; j++) {
                // For each cell, we can only come from the left or from above
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        
        // The last element contains the minimum path sum
        return dp[n - 1];
    }
    
    /**
     * Finds the actual path that gives the minimum path sum.
     * 
     * @param grid the input grid of non-negative integers
     * @return a string representation of the minimum path and its sum
     */
    public String minPathWithPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return "Empty grid";
        }
        
        int m = grid.length;    // Number of rows
        int n = grid[0].length; // Number of columns
        
        // Create a dp table
        int[][] dp = new int[m][n];
        
        // Initialize the top-left cell
        dp[0][0] = grid[0][0];
        
        // Initialize the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // Initialize the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        // Reconstruct the path
        StringBuilder path = new StringBuilder();
        int i = m - 1;
        int j = n - 1;
        
        while (i > 0 || j > 0) {
            path.insert(0, " -> (" + i + "," + j + ") [" + grid[i][j] + "]");
            
            if (i > 0 && j > 0) {
                // Check whether we came from above or from the left
                if (dp[i - 1][j] <= dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            } else if (i > 0) {
                i--;
            } else {
                j--;
            }
        }
        
        // Add the starting point
        path.insert(0, "(0,0) [" + grid[0][0] + "]");
        
        return "Minimum Path Sum: " + dp[m - 1][n - 1] + "\nPath: " + path.toString();
    }
    
    /**
     * Visualizes the grid and the minimum path.
     * 
     * @param grid the input grid
     * @return a string visualization of the grid with the minimum path marked
     */
    public String visualizeMinPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return "Empty grid";
        }
        
        int m = grid.length;    // Number of rows
        int n = grid[0].length; // Number of columns
        
        // Create a dp table
        int[][] dp = new int[m][n];
        
        // Initialize the top-left cell
        dp[0][0] = grid[0][0];
        
        // Initialize the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // Initialize the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        // Create a 2D boolean array to mark the minimum path
        boolean[][] path = new boolean[m][n];
        
        // Reconstruct the path
        int i = m - 1;
        int j = n - 1;
        path[i][j] = true;
        
        while (i > 0 || j > 0) {
            if (i > 0 && j > 0) {
                // Check whether we came from above or from the left
                if (dp[i - 1][j] <= dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            } else if (i > 0) {
                i--;
            } else {
                j--;
            }
            
            path[i][j] = true;
        }
        
        // Build the visualization
        StringBuilder sb = new StringBuilder();
        
        sb.append("Grid with minimum path (marked with *):\n\n");
        
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (path[i][j]) {
                    sb.append(String.format(" *%2d* ", grid[i][j]));
                } else {
                    sb.append(String.format("  %2d  ", grid[i][j]));
                }
            }
            sb.append("\n\n");
        }
        
        sb.append("Minimum Path Sum: ").append(dp[m - 1][n - 1]);
        
        return sb.toString();
    }
}