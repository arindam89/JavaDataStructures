package com.leetcode.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class NQueensTest {
    
    private NQueens solution = new NQueens();
    
    @Test
    public void testOneQueen() {
        List<List<String>> result = solution.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("Q"), result.get(0));
    }
    
    @Test
    public void testTwoQueens() {
        List<List<String>> result = solution.solveNQueens(2);
        // No solution possible for 2x2 board
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testThreeQueens() {
        List<List<String>> result = solution.solveNQueens(3);
        // No solution possible for 3x3 board
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testFourQueens() {
        List<List<String>> result = solution.solveNQueens(4);
        assertEquals(2, result.size());
        
        // Expected solutions
        List<List<String>> expected = Arrays.asList(
            Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
            Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );
        
        // Check if all expected solutions are present
        for (List<String> solution : expected) {
            assertTrue(result.contains(solution));
        }
    }
    
    @Test
    public void testEightQueens() {
        List<List<String>> result = solution.solveNQueens(8);
        // 8-queens puzzle has 92 distinct solutions
        assertEquals(92, result.size());
        
        // Verify each solution is valid
        for (List<String> board : result) {
            assertTrue(isValidSolution(board));
        }
    }
    
    @Test
    public void testAllSolutionsAreUnique() {
        List<List<String>> result = solution.solveNQueens(4);
        Set<List<String>> uniqueSolutions = new HashSet<>(result);
        assertEquals(result.size(), uniqueSolutions.size());
    }
    
    /**
     * Helper method to verify if a solution is valid.
     * Checks if queens are placed correctly and don't attack each other.
     */
    private boolean isValidSolution(List<String> board) {
        int n = board.size();
        
        // Check each queen's position
        for (int row = 0; row < n; row++) {
            int queenCol = board.get(row).indexOf('Q');
            if (queenCol == -1) return false; // No queen in this row
            
            // Check if this queen conflicts with any other queen
            for (int otherRow = 0; otherRow < n; otherRow++) {
                if (row == otherRow) continue;
                
                int otherQueenCol = board.get(otherRow).indexOf('Q');
                
                // Check same column
                if (queenCol == otherQueenCol) return false;
                
                // Check diagonals
                if (Math.abs(row - otherRow) == Math.abs(queenCol - otherQueenCol)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Test
    public void testCorrectBoardFormat() {
        List<List<String>> result = solution.solveNQueens(4);
        for (List<String> board : result) {
            // Check board size
            assertEquals(4, board.size());
            
            // Check each row format
            for (String row : board) {
                assertEquals(4, row.length());
                assertTrue(row.matches("[Q.]{4}"));
                assertEquals(1, row.chars().filter(ch -> ch == 'Q').count());
            }
        }
    }
} 