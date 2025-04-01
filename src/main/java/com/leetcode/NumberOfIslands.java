package com.leetcode;

/**
 * LeetCode #200: Number of Islands (Medium)
 * 
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * Time Complexity: O(M * N) where M is the number of rows and N is the number of columns
 * Space Complexity: O(M * N) in the worst case for the recursion stack
 */
public class NumberOfIslands {
    
    /**
     * Counts the number of islands in the grid.
     * 
     * @param grid a 2D grid of '1's (land) and '0's (water)
     * @return the number of islands
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        // Scan the grid and perform DFS from each unvisited land cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        
        return count;
    }
    
    /**
     * Performs a depth-first search to mark all connected land cells as visited.
     * 
     * @param grid the 2D grid of land and water
     * @param i the current row index
     * @param j the current column index
     * @param rows the total number of rows
     * @param cols the total number of columns
     */
    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        // Check if the current cell is out of bounds or is water/already visited
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }
        
        // Mark the current cell as visited by changing it to '2'
        grid[i][j] = '2';
        
        // Explore all 4 adjacent cells
        dfs(grid, i + 1, j, rows, cols); // Down
        dfs(grid, i - 1, j, rows, cols); // Up
        dfs(grid, i, j + 1, rows, cols); // Right
        dfs(grid, i, j - 1, rows, cols); // Left
    }
}