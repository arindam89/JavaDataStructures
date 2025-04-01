package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the Rotate Image problem.
 */
public class RotateImageTest {
    
    @Test
    public void testRotate3x3Matrix() {
        RotateImage solution = new RotateImage();
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        solution.rotate(matrix);
        
        int[][] expected = {
            {7, 4, 1},
            {8, 5, 2},
            {9, 6, 3}
        };
        
        assertArrayEquals(expected, matrix);
    }
    
    @Test
    public void testRotate4x4Matrix() {
        RotateImage solution = new RotateImage();
        
        int[][] matrix = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        
        solution.rotate(matrix);
        
        int[][] expected = {
            {15, 13, 2, 5},
            {14, 3, 4, 1},
            {12, 6, 8, 9},
            {16, 7, 10, 11}
        };
        
        assertArrayEquals(expected, matrix);
    }
    
    @Test
    public void testRotate1x1Matrix() {
        RotateImage solution = new RotateImage();
        
        int[][] matrix = {{1}};
        
        solution.rotate(matrix);
        
        int[][] expected = {{1}};
        
        assertArrayEquals(expected, matrix);
    }
    
    @Test
    public void testRotate2x2Matrix() {
        RotateImage solution = new RotateImage();
        
        int[][] matrix = {
            {1, 2},
            {3, 4}
        };
        
        solution.rotate(matrix);
        
        int[][] expected = {
            {3, 1},
            {4, 2}
        };
        
        assertArrayEquals(expected, matrix);
    }
    
    @Test
    public void testRotateByLayers() {
        RotateImage solution = new RotateImage();
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        solution.rotateByLayers(matrix);
        
        int[][] expected = {
            {7, 4, 1},
            {8, 5, 2},
            {9, 6, 3}
        };
        
        assertArrayEquals(expected, matrix);
    }
    
    @Test
    public void testRotateNullOrEmptyMatrix() {
        RotateImage solution = new RotateImage();
        
        // Null matrix
        int[][] matrix1 = null;
        solution.rotate(matrix1);
        assertNull(matrix1);
        
        // Empty matrix
        int[][] matrix2 = {};
        solution.rotate(matrix2);
        assertArrayEquals(new int[0][], matrix2);
    }
}