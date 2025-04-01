package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;

import com.leetcode.SlidingWindowMaximum;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

/**
 * Test class for SlidingWindowMaximum implementation.
 */
public class SlidingWindowMaximumTest {

    @Test
    void testMaxSlidingWindowExample1() {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        int[] expected = {3, 3, 5, 5, 6, 7};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }
    
    @Test
    void testMaxSlidingWindowExample2() {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1};
        int k = 1;
        
        int[] expected = {1};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }
    
    @Test
    void testMaxSlidingWindowDecreasingOrder() {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        int k = 3;
        
        int[] expected = {7, 6, 5, 4, 3};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }
    
    @Test
    void testMaxSlidingWindowIncreasingOrder() {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        
        int[] expected = {3, 4, 5, 6, 7};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }
    
    @Test
    void testMaxSlidingWindowEmptyArray() {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {};
        int k = 3;
        
        int[] expected = {};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }
    
    @Test
    void testMaxSlidingWindowInvalidK() {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 0;
        
        int[] expected = {};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }
    
    @Test
    void testMaxSlidingWindowKEqualsArrayLength() {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 8;
        
        int[] expected = {7};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }
    
    @Test
    void testMaxSlidingWindowWithDuplicates() {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 3, 1, 2, 0, 5, 5, 5};
        int k = 3;
        
        int[] expected = {3, 3, 2, 5, 5, 5};
        assertArrayEquals(expected, solution.maxSlidingWindow(nums, k));
    }
}