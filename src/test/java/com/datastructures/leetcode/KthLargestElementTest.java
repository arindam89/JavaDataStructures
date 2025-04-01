package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;

import com.leetcode.KthLargestElement;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the Kth Largest Element in an Array problem.
 */
public class KthLargestElementTest {
    
    @Test
    public void testFindKthLargestExample1() {
        KthLargestElement solution = new KthLargestElement();
        
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        
        assertEquals(5, solution.findKthLargest(nums, k));
    }
    
    @Test
    public void testFindKthLargestExample2() {
        KthLargestElement solution = new KthLargestElement();
        
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        
        assertEquals(4, solution.findKthLargest(nums, k));
    }
    
    @Test
    public void testFindKthLargestWithDuplicates() {
        KthLargestElement solution = new KthLargestElement();
        
        int[] nums = {3, 3, 3, 3, 3, 3, 3};
        int k = 1;
        
        assertEquals(3, solution.findKthLargest(nums, k));
    }
    
    @Test
    public void testFindKthLargestSingleElement() {
        KthLargestElement solution = new KthLargestElement();
        
        int[] nums = {1};
        int k = 1;
        
        assertEquals(1, solution.findKthLargest(nums, k));
    }
    
    @Test
    public void testFindKthLargestNegativeNumbers() {
        KthLargestElement solution = new KthLargestElement();
        
        int[] nums = {-1, -2, -3, -4, -5};
        int k = 2;
        
        assertEquals(-2, solution.findKthLargest(nums, k));
    }
    
    @Test
    public void testFindKthLargestQuickSelectExample1() {
        KthLargestElement solution = new KthLargestElement();
        
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        
        assertEquals(5, solution.findKthLargestQuickSelect(nums, k));
    }
    
    @Test
    public void testFindKthLargestQuickSelectExample2() {
        KthLargestElement solution = new KthLargestElement();
        
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        
        assertEquals(4, solution.findKthLargestQuickSelect(nums, k));
    }
    
    @Test
    public void testBothMethodsReturnSameResult() {
        KthLargestElement solution = new KthLargestElement();
        
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        
        for (int k = 1; k <= nums.length; k++) {
            int[] numsCopy = nums.clone(); // Create a copy as quickSelect modifies array
            int heapResult = solution.findKthLargest(nums, k);
            int quickSelectResult = solution.findKthLargestQuickSelect(numsCopy, k);
            
            assertEquals(heapResult, quickSelectResult, 
                    "Both methods should return the same result for k = " + k);
        }
    }
}