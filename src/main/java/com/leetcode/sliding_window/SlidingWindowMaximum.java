package com.leetcode.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode #239: Sliding Window Maximum (Hard)
 * 
 * You are given an array of integers nums, there is a sliding window of size k which is moving 
 * from the very left of the array to the very right. You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position.
 * 
 * Return the max sliding window.
 * 
 * Time Complexity: O(n) where n is the length of the array
 * Space Complexity: O(k) where k is the window size
 */
public class SlidingWindowMaximum {
    
    /**
     * Returns an array containing the maximum value in each sliding window.
     * 
     * @param nums the input array of integers
     * @param k the size of the sliding window
     * @return array of maximum values in each window
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1]; // Total number of windows
        
        // Deque to store indices of potential maximum values
        // Elements are stored in decreasing order of their values
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove indices whose values are less than the current value
            // These values can never be the maximum in future windows
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add current index to deque
            deque.offerLast(i);
            
            // Calculate the maximum for the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}