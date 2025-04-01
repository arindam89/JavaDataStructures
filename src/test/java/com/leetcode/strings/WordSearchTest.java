package com.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for WordSearch implementation.
 */
public class WordSearchTest {

    @Test
    void testExistExample1() {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        
        assertTrue(solution.exist(board, word));
    }
    
    @Test
    void testExistExample2() {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        
        assertTrue(solution.exist(board, word));
    }
    
    @Test
    void testExistExample3() {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";
        
        assertFalse(solution.exist(board, word));
    }
    
    @Test
    void testExistEmptyBoard() {
        WordSearch solution = new WordSearch();
        char[][] board = {};
        String word = "A";
        
        assertFalse(solution.exist(board, word));
    }
    
    @Test
    void testExistEmptyWord() {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "";
        
        assertFalse(solution.exist(board, word));
    }
    
    @Test
    void testExistSingleCharacter() {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A'}
        };
        String word = "A";
        
        assertTrue(solution.exist(board, word));
    }
    
    @Test
    void testExistWordTooLong() {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCFSEDEESA";
        
        assertFalse(solution.exist(board, word));
    }
    
    @Test
    void testExistZigZag() {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ASADB";
        
        assertFalse(solution.exist(board, word));
    }
    
    @Test
    void testExistDuplicateCharactersInWord() {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A', 'A', 'A', 'A'},
            {'A', 'A', 'A', 'A'},
            {'A', 'A', 'A', 'A'}
        };
        // The word is longer than the number of cells in the board, which is 12
        String word = "AAAAAAAAAAAAAA"; 
        
        assertFalse(solution.exist(board, word)); // Can't reuse same cell
    }
}