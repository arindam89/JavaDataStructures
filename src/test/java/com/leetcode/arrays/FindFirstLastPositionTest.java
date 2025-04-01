package com.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the Find First and Last Position problem.
 */
public class FindFirstLastPositionTest {
    
    @Test
    public void testSearchRangeExample1() {
        FindFirstLastPosition solution = new FindFirstLastPosition();
        
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        
        int[] expected = {3, 4};
        int[] result = solution.searchRange(nums, target);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSearchRangeExample2() {
        FindFirstLastPosition solution = new FindFirstLastPosition();
        
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        
        int[] expected = {-1, -1};
        int[] result = solution.searchRange(nums, target);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSearchRangeEmptyArray() {
        FindFirstLastPosition solution = new FindFirstLastPosition();
        
        int[] nums = {};
        int target = 0;
        
        int[] expected = {-1, -1};
        int[] result = solution.searchRange(nums, target);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSearchRangeSingleElement() {
        FindFirstLastPosition solution = new FindFirstLastPosition();
        
        int[] nums = {1};
        int target = 1;
        
        int[] expected = {0, 0};
        int[] result = solution.searchRange(nums, target);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSearchRangeAllSame() {
        FindFirstLastPosition solution = new FindFirstLastPosition();
        
        int[] nums = {5, 5, 5, 5, 5};
        int target = 5;
        
        int[] expected = {0, 4};
        int[] result = solution.searchRange(nums, target);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSearchRangeTargetAtBoundaries() {
        FindFirstLastPosition solution = new FindFirstLastPosition();
        
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 1; // Target at the beginning
        
        int[] expected = {0, 0};
        int[] result = solution.searchRange(nums, target);
        
        assertArrayEquals(expected, result);
        
        target = 8; // Target at the end
        expected = new int[]{7, 7};
        result = solution.searchRange(nums, target);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSearchRangeAlternative() {
        FindFirstLastPosition solution = new FindFirstLastPosition();
        
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        
        int[] expected = {3, 4};
        int[] result = solution.searchRangeAlternative(nums, target);
        
        assertArrayEquals(expected, result);
        
        // Test for target not found
        target = 6;
        expected = new int[]{-1, -1};
        result = solution.searchRangeAlternative(nums, target);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testBothMethodsGiveSameResults() {
        FindFirstLastPosition solution = new FindFirstLastPosition();
        
        int[] nums = {1, 2, 2, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 8, 9};
        
        for (int target = 0; target <= 10; target++) {
            int[] result1 = solution.searchRange(nums, target);
            int[] result2 = solution.searchRangeAlternative(nums, target);
            
            assertArrayEquals(result1, result2, 
                    "Both methods should give same results for target: " + target);
        }
    }
}