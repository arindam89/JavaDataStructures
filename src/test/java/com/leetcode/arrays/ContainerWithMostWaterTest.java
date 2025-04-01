package com.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the Container With Most Water problem.
 */
public class ContainerWithMostWaterTest {
    
    @Test
    public void testMaxAreaExample1() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        
        assertEquals(49, solution.maxArea(height));
    }
    
    @Test
    public void testMaxAreaExample2() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        int[] height = {1, 1};
        
        assertEquals(1, solution.maxArea(height));
    }
    
    @Test
    public void testMaxAreaEmptyArray() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        int[] height = {};
        
        assertEquals(0, solution.maxArea(height));
    }
    
    @Test
    public void testMaxAreaSingleElement() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        int[] height = {5};
        
        assertEquals(0, solution.maxArea(height));
    }
    
    @Test
    public void testMaxAreaIncreasingHeights() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        int[] height = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        assertEquals(20, solution.maxArea(height));
    }
    
    @Test
    public void testMaxAreaDecreasingHeights() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        int[] height = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        
        assertEquals(20, solution.maxArea(height));
    }
    
    @Test
    public void testMaxAreaWithZeroes() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        int[] height = {0, 0, 0, 0, 0};
        
        assertEquals(0, solution.maxArea(height));
    }
    
    @Test
    public void testMaxAreaBruteForce() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        
        assertEquals(49, solution.maxAreaBruteForce(height));
    }
    
    @Test
    public void testBothMethodsGiveSameResults() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        int[][] testCases = {
            {1, 8, 6, 2, 5, 4, 8, 3, 7},
            {1, 1},
            {1, 2, 1},
            {4, 3, 2, 1, 4},
            {1, 2, 3, 4, 5, 6, 7, 8, 9}
        };
        
        for (int[] testCase : testCases) {
            assertEquals(
                solution.maxArea(testCase),
                solution.maxAreaBruteForce(testCase),
                "Both methods should return the same result for the given input"
            );
        }
    }
    
    @Test
    public void testExplainMaxAreaApproach() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        
        String explanation = solution.explainMaxAreaApproach(height);
        
        assertNotNull(explanation);
        assertTrue(explanation.contains("Final maximum area: 49"));
        assertTrue(explanation.contains("Why this approach works"));
    }
}