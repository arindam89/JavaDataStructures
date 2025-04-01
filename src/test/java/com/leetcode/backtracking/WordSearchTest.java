package com.leetcode.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordSearchTest {
    
    private WordSearch solution = new WordSearch();
    
    @Test
    public void testEmptyBoard() {
        char[][] board = {};
        assertFalse(solution.exist(board, "ABCCED"));
    }
    
    @Test
    public void testEmptyWord() {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        assertFalse(solution.exist(board, ""));
    }
    
    @Test
    public void testWordExists() {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        assertTrue(solution.exist(board, "ABCCED"));
    }
    
    @Test
    public void testWordDoesNotExist() {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        assertFalse(solution.exist(board, "ABCB"));
    }
    
    @Test
    public void testSingleCharBoard() {
        char[][] board = {{'A'}};
        assertTrue(solution.exist(board, "A"));
        assertFalse(solution.exist(board, "B"));
    }
    
    @Test
    public void testWordLongerThanBoard() {
        char[][] board = {
            {'A', 'B'},
            {'C', 'D'}
        };
        assertFalse(solution.exist(board, "ABCDABCD"));
    }
    
    @Test
    public void testZigZagPath() {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        assertTrue(solution.exist(board, "SEE"));
    }
    
    @Test
    public void testCannotReuseCell() {
        char[][] board = {
            {'A', 'A'},
            {'A', 'A'}
        };
        assertTrue(solution.exist(board, "AAA")); // A path like (0,0)->(0,1)->(1,1) exists without reuse
    }
    
    @Test
    public void testNonExistentCharacter() {
        char[][] board = {
            {'A', 'B', 'C'},
            {'D', 'E', 'F'},
            {'G', 'H', 'I'}
        };
        assertFalse(solution.exist(board, "XYZ")); // Contains characters not in board
    }
} 