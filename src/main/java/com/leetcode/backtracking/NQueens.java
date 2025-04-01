package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * 
 * Example:
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 */
public class NQueens {
    
    /**
     * Main method to find all valid N Queens solutions.
     * @param n Size of the board (n x n)
     * @return List of all valid board configurations
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        // Initialize the board with empty spaces
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        backtrack(result, board, 0, n);
        return result;
    }
    
    /**
     * Backtracking helper method to find valid queen placements.
     * 
     * @param result List to store all valid solutions
     * @param board Current board configuration
     * @param row Current row being processed
     * @param n Size of the board
     */
    private void backtrack(List<List<String>> result, char[][] board, int row, int n) {
        // Base case: if we've placed queens in all rows, we found a valid solution
        if (row == n) {
            result.add(constructSolution(board));
            return;
        }
        
        // Try placing queen in each column of current row
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                // Place queen
                board[row][col] = 'Q';
                
                // Recursively try to place queens in next rows
                backtrack(result, board, row + 1, n);
                
                // Backtrack: remove queen to try next position
                board[row][col] = '.';
            }
        }
    }
    
    /**
     * Helper method to check if placing a queen at given position is valid.
     * 
     * @param board Current board configuration
     * @param row Row to check
     * @param col Column to check
     * @param n Size of the board
     * @return true if position is valid for queen placement
     */
    private boolean isValid(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        
        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Helper method to convert board configuration to list of strings.
     * 
     * @param board Current board configuration
     * @return List of strings representing the board
     */
    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
} 