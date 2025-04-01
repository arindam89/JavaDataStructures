package com.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the Minimum Path Sum problem.
 */
public class MinimumPathSumTest {
    
    @Test
    public void testMinPathSumExample1() {
        MinimumPathSum solution = new MinimumPathSum();
        
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        
        assertEquals(7, solution.minPathSum(grid));
    }
    
    @Test
    public void testMinPathSumExample2() {
        MinimumPathSum solution = new MinimumPathSum();
        
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        assertEquals(12, solution.minPathSum(grid));
    }
    
    @Test
    public void testMinPathSumEmptyGrid() {
        MinimumPathSum solution = new MinimumPathSum();
        
        int[][] emptyGrid = {};
        
        assertEquals(0, solution.minPathSum(emptyGrid));
    }
    
    @Test
    public void testMinPathSumSingleCell() {
        MinimumPathSum solution = new MinimumPathSum();
        
        int[][] grid = {{5}};
        
        assertEquals(5, solution.minPathSum(grid));
    }
    
    @Test
    public void testMinPathSumSingleRow() {
        MinimumPathSum solution = new MinimumPathSum();
        
        int[][] grid = {{1, 2, 3, 4, 5}};
        
        assertEquals(15, solution.minPathSum(grid));
    }
    
    @Test
    public void testMinPathSumSingleColumn() {
        MinimumPathSum solution = new MinimumPathSum();
        
        int[][] grid = {
            {1},
            {2},
            {3},
            {4},
            {5}
        };
        
        assertEquals(15, solution.minPathSum(grid));
    }
    
    @Test
    public void testMinPathSumLargeGrid() {
        MinimumPathSum solution = new MinimumPathSum();
        
        int[][] grid = new int[100][100];
        // Fill the grid with 1s
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                grid[i][j] = 1;
            }
        }
        
        // The minimum path sum should be 1 * (100 + 100 - 1) = 199
        assertEquals(199, solution.minPathSum(grid));
    }
    
    @Test
    public void testMinPathSumOptimized() {
        MinimumPathSum solution = new MinimumPathSum();
        
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        
        assertEquals(7, solution.minPathSumOptimized(grid));
    }
    
    @Test
    public void testMinPathSumAndOptimizedGiveSameResults() {
        MinimumPathSum solution = new MinimumPathSum();
        
        int[][][] grids = {
            {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}},
            {{1, 2, 3}, {4, 5, 6}},
            {{5}},
            {{1, 2, 3, 4, 5}},
            {{1}, {2}, {3}, {4}, {5}}
        };
        
        for (int[][] grid : grids) {
            assertEquals(
                solution.minPathSum(grid),
                solution.minPathSumOptimized(grid),
                "Both methods should return the same result"
            );
        }
    }
    
    @Test
    public void testMinPathWithPath() {
        MinimumPathSum solution = new MinimumPathSum();
        
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        
        String result = solution.minPathWithPath(grid);
        
        assertNotNull(result);
        assertTrue(result.contains("Minimum Path Sum: 7"));
        assertTrue(result.contains("Path:"));
    }
    
    @Test
    public void testVisualizeMinPath() {
        MinimumPathSum solution = new MinimumPathSum();
        
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        
        String result = solution.visualizeMinPath(grid);
        
        assertNotNull(result);
        assertTrue(result.contains("Grid with minimum path"));
        assertTrue(result.contains("Minimum Path Sum: 7"));
    }
}