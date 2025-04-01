package com.leetcode.backtracking;

/**
 * Problem: Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * Example:
 * board = [["A","B","C","E"],
 *          ["S","F","C","S"],
 *          ["A","D","E","E"]], 
 * word = "ABCCED"
 * Output: true
 */
public class WordSearch {
    
    // Directions array for moving in the grid (up, right, down, left)
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    /**
     * Main method to find if word exists in the board.
     * @param board The 2D character grid
     * @param word The word to search for
     * @return true if word exists in the grid, false otherwise
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        // Try starting the search from each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && !visited[i][j]) {
                    visited[i][j] = true;
                    if (dfs(board, word, i, j, 1, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    /**
     * DFS helper method to search for the word.
     * 
     * @param board The 2D character grid
     * @param word The word to search for
     * @param row Current row in the grid
     * @param col Current column in the grid
     * @param index Current index in the word
     * @param visited Boolean array to track visited cells
     * @return true if remaining word is found starting at current position
     */
    private boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        // Base case: if we've matched all characters, word is found
        if (index == word.length()) {
            return true;
        }
        
        // Try all four directions
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            // Check if next position is valid and matches current character
            if (newRow >= 0 && newRow < board.length && 
                newCol >= 0 && newCol < board[0].length && 
                !visited[newRow][newCol] &&
                board[newRow][newCol] == word.charAt(index)) {
                
                // Mark current cell as visited
                visited[newRow][newCol] = true;
                
                // Recursively search next character
                if (dfs(board, word, newRow, newCol, index + 1, visited)) {
                    return true;
                }
                
                // Backtrack: mark cell as unvisited
                visited[newRow][newCol] = false;
            }
        }
        
        return false;
    }
} 