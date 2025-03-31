package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the Search in Rotated Sorted Array problem.
 */
public class SearchInRotatedSortedArrayTest {
    
    @Test
    public void testSearchExample1() {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        
        assertEquals(4, solution.search(nums, target));
    }
    
    @Test
    public void testSearchExample2() {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        
        assertEquals(-1, solution.search(nums, target));
    }
    
    @Test
    public void testSearchExample3() {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        int[] nums = {1};
        int target = 0;
        
        assertEquals(-1, solution.search(nums, target));
    }
    
    @Test
    public void testSearchNoRotation() {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        
        assertEquals(2, solution.search(nums, target));
    }
    
    @Test
    public void testSearchFullRotation() {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        // Full rotation (rotated such that it's back to original order)
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        
        assertEquals(2, solution.search(nums, target));
    }
    
    @Test
    public void testSearchLargeArray() {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = (i + 500) % 1000; // Rotated at index 500
        }
        
        assertEquals(623, solution.search(nums, 123)); // Before rotation point
        assertEquals(123, solution.search(nums, 623)); // After rotation point
        assertEquals(-1, solution.search(nums, 1001)); // Not found
    }
    
    @Test
    public void testSearchEmptyAndNullArrays() {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        int[] empty = {};
        int[] nullArray = null;
        
        assertEquals(-1, solution.search(empty, 5));
        assertEquals(-1, solution.search(nullArray, 5));
    }
    
    @Test
    public void testSearchWithPivotFinding() {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        
        // Test various targets
        assertEquals(4, solution.searchWithPivotFinding(nums, 0));
        assertEquals(0, solution.searchWithPivotFinding(nums, 4));
        assertEquals(2, solution.searchWithPivotFinding(nums, 6));
        assertEquals(6, solution.searchWithPivotFinding(nums, 2));
        assertEquals(-1, solution.searchWithPivotFinding(nums, 3));
    }
    
    @Test
    public void testBothMethodsGiveSameResults() {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        int[][] testArrays = {
            {4, 5, 6, 7, 0, 1, 2},
            {1, 3, 5},
            {5, 1, 3},
            {3, 5, 1},
            {1, 2, 3, 4, 5},
            {3, 4, 5, 1, 2}
        };
        
        for (int[] nums : testArrays) {
            for (int target = -1; target <= 10; target++) {
                assertEquals(
                    solution.search(nums, target),
                    solution.searchWithPivotFinding(nums, target),
                    "Both methods should return the same result for array [" + 
                        java.util.Arrays.toString(nums) + "] and target " + target
                );
            }
        }
    }
    
    @Test
    public void testExplainSearch() {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        
        String explanation = solution.explainSearch(nums, target);
        
        assertNotNull(explanation);
        assertTrue(explanation.contains("Target found at index 4"));
        assertTrue(explanation.contains("Final result: 4"));
    }
}