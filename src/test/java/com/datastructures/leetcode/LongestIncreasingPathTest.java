package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;

import com.leetcode.LongestIncreasingPath;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LongestIncreasingPath implementation.
 */
public class LongestIncreasingPathTest {

    @Test
    void testLongestIncreasingPathExample1() {
        LongestIncreasingPath solution = new LongestIncreasingPath();
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        
        assertEquals(4, solution.longestIncreasingPath(matrix));
        // The longest increasing path is [1, 2, 6, 9]
    }
    
    @Test
    void testLongestIncreasingPathExample2() {
        LongestIncreasingPath solution = new LongestIncreasingPath();
        int[][] matrix = {
            {3, 4, 5},
            {3, 2, 6},
            {2, 2, 1}
        };
        
        assertEquals(4, solution.longestIncreasingPath(matrix));
        // The longest increasing path is [3, 4, 5, 6]
    }
    
    @Test
    void testLongestIncreasingPathSingleCell() {
        LongestIncreasingPath solution = new LongestIncreasingPath();
        int[][] matrix = {{1}};
        
        assertEquals(1, solution.longestIncreasingPath(matrix));
    }
    
    @Test
    void testLongestIncreasingPathEmptyMatrix() {
        LongestIncreasingPath solution = new LongestIncreasingPath();
        int[][] matrix = {};
        
        assertEquals(0, solution.longestIncreasingPath(matrix));
    }
    
    @Test
    void testLongestIncreasingPathNullMatrix() {
        LongestIncreasingPath solution = new LongestIncreasingPath();
        
        assertEquals(0, solution.longestIncreasingPath(null));
    }
    
    @Test
    void testLongestIncreasingPathDescending() {
        LongestIncreasingPath solution = new LongestIncreasingPath();
        int[][] matrix = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        
        // Perfectly descending matrix can have a path of length 5 going diagonally from top-left to bottom-right
        // 9 -> 8 -> 7 -> 6 -> 5
        assertEquals(5, solution.longestIncreasingPath(matrix));
    }
    
    @Test
    void testLongestIncreasingPathSameValues() {
        LongestIncreasingPath solution = new LongestIncreasingPath();
        int[][] matrix = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        
        assertEquals(1, solution.longestIncreasingPath(matrix));
        // No increasing path, only single cells
    }
    
    @Test
    void testLongestIncreasingPathSnakePattern() {
        LongestIncreasingPath solution = new LongestIncreasingPath();
        int[][] matrix = {
            {1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
        };
        
        assertEquals(25, solution.longestIncreasingPath(matrix));
        // The longest path traverses all cells in order
    }
}