package com.leetcode;

/**
 * LeetCode #48: Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
 * DO NOT allocate another 2D matrix and do the rotation.
 * 
 * Time Complexity: O(n²) where n is the length of the matrix
 * Space Complexity: O(1) because we are rotating the matrix in-place
 */
public class RotateImage {
    
    /**
     * Rotates the image by 90 degrees (clockwise) in-place.
     * The approach:
     * 1. Transpose the matrix (swap rows with columns)
     * 2. Reverse each row
     * 
     * @param matrix the input matrix to be rotated
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        
        int n = matrix.length;
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
    
    /**
     * Alternative approach using 4-way swapping by rotating elements in groups of 4.
     * Rotates one layer at a time, starting from the outermost layer and moving inward.
     * 
     * @param matrix the input matrix to be rotated
     */
    public void rotateByLayers(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        
        int n = matrix.length;
        
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            
            for (int i = first; i < last; i++) {
                int offset = i - first;
                
                // Save top
                int top = matrix[first][i];
                
                // Left -> Top
                matrix[first][i] = matrix[last - offset][first];
                
                // Bottom -> Left
                matrix[last - offset][first] = matrix[last][last - offset];
                
                // Right -> Bottom
                matrix[last][last - offset] = matrix[i][last];
                
                // Top -> Right
                matrix[i][last] = top;
            }
        }
    }
}