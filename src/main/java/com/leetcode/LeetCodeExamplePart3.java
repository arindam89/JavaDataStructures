package com.leetcode;

import java.util.*;

/**
 * This class demonstrates the solutions for LeetCode problems (Part 3).
 * It provides a way to visualize and understand the implementation of
 * various algorithmic problems from LeetCode.
 */
public class LeetCodeExamplePart3 {
    
    /**
     * Runs examples of all LeetCode problems from Part 3.
     */
    public static void runExample() {
        System.out.println("\nLeetCode Problems (Part 3) Examples\n");
        
        // Examples of each LeetCode problem
        minimumPathSumExample();
        
        // Add other examples here as they are implemented
        // searchInRotatedSortedArrayExample();
        // generateParenthesesExample();
        // binaryTreeMaxPathSumExample();
        // cloneGraphExample();
        // etc.
    }
    
    /**
     * Demonstrates the Minimum Path Sum problem.
     */
    private static void minimumPathSumExample() {
        System.out.println("=== Minimum Path Sum (LeetCode #64) ===");
        
        // Create a sample grid
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        
        System.out.println("Input Grid:");
        printGrid(grid);
        
        // Create an instance of MinimumPathSum
        MinimumPathSum solution = new MinimumPathSum();
        
        // Find the minimum path sum
        int result = solution.minPathSum(grid);
        System.out.println("\nMinimum Path Sum: " + result);
        
        // Find the minimum path sum with optimized space
        int resultOptimized = solution.minPathSumOptimized(grid);
        System.out.println("Minimum Path Sum (Optimized): " + resultOptimized);
        
        // Show the path that gives the minimum sum
        System.out.println("\n" + solution.minPathWithPath(grid));
        
        // Visualize the grid with the minimum path
        System.out.println("\n" + solution.visualizeMinPath(grid));
        
        System.out.println("\nTime Complexity: O(m*n)");
        System.out.println("Space Complexity: O(m*n) for the DP solution, O(n) for the optimized version");
        System.out.println("Where m and n are the dimensions of the grid");
    }
    
    /**
     * Helper method to print a 2D grid.
     * 
     * @param grid the grid to print
     */
    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}