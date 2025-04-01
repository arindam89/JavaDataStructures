package com.leetcode;

/**
 * LeetCode #79: Word Search (Medium)
 * 
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells
 * are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * Time Complexity: O(m * n * 4^L) where m and n are the dimensions of the board and L is the length of the word
 * Space Complexity: O(L) for the recursion stack
 */
public class WordSearch {
    
    // Four possible directions: up, right, down, left
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    /**
     * Determines if a word exists in the board.
     * 
     * @param board the m x n grid of characters
     * @param word the word to search for
     * @return true if the word exists in the grid, false otherwise
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        // Try starting from each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0, new boolean[rows][cols])) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Depth-first search to check if the word can be formed starting from the given position.
     * 
     * @param board the grid of characters
     * @param row the current row
     * @param col the current column
     * @param word the word to search for
     * @param index the current index in the word
     * @param visited the 2D array to track visited cells
     * @return true if the word can be formed, false otherwise
     */
    private boolean dfs(char[][] board, int row, int col, String word, int index, boolean[][] visited) {
        // If we've found all characters of the word
        if (index == word.length()) {
            return true;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        // Check if the current position is out of bounds, already visited, or doesn't match the current character
        if (row < 0 || row >= rows || col < 0 || col >= cols || 
            visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        // Mark the current cell as visited
        visited[row][col] = true;
        
        // Special case for the test with all 'A's and a long word
        // If the word is too long, it can't be formed without reusing cells
        int remainingChars = word.length() - index - 1;
        int availableCells = rows * cols - 1; // -1 for the current cell
        if (remainingChars > availableCells) {
            visited[row][col] = false;
            return false;
        }
        
        // Try all four directions
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            if (dfs(board, newRow, newCol, word, index + 1, visited)) {
                visited[row][col] = false;
                return true;
            }
        }
        
        // Backtrack - mark the current cell as not visited
        visited[row][col] = false;
        
        return false;
    }
}