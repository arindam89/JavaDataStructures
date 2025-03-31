package com.datastructures.leetcode;

/**
 * LeetCode #42: Trapping Rain Water (Hard)
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * 
 * Time Complexity: O(n) where n is the length of the height array
 * Space Complexity: O(1)
 */
public class TrappingRainWater {
    
    /**
     * Computes how much water can be trapped after raining.
     * Uses the two-pointer approach.
     * 
     * @param height array of heights representing the elevation map
     * @return the amount of water that can be trapped
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        
        while (left < right) {
            // Update left max height
            if (height[left] > leftMax) {
                leftMax = height[left];
            }
            
            // Update right max height
            if (height[right] > rightMax) {
                rightMax = height[right];
            }
            
            // Calculate trapped water
            if (leftMax < rightMax) {
                // If left wall is lower, calculate water based on left max
                water += Math.max(0, leftMax - height[left]);
                left++;
            } else {
                // If right wall is lower or equal, calculate water based on right max
                water += Math.max(0, rightMax - height[right]);
                right--;
            }
        }
        
        return water;
    }
}