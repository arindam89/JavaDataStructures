package com.leetcode.arrays;

/**
 * LeetCode #42: Trapping Rain Water (Hard)
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * 
 * Time Complexity: O(n) where n is the length of the height array
 * Space Complexity: O(1) using two pointers approach
 */
public class TrapRainWater {
    
    /**
     * Computes the amount of water that can be trapped using the two pointers approach.
     * 
     * @param height array of heights
     * @return the amount of water that can be trapped
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        
        while (left < right) {
            // Compare heights at left and right pointers
            if (height[left] < height[right]) {
                // If current left height is greater than or equal to leftMax,
                // update leftMax, otherwise add trapped water
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                // If current right height is greater than or equal to rightMax,
                // update rightMax, otherwise add trapped water
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        
        return water;
    }
    
    /**
     * Alternative solution using dynamic programming.
     * This approach is clearer but uses O(n) space.
     * 
     * @param height array of heights
     * @return the amount of water that can be trapped
     */
    public int trapUsingDP(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        
        int n = height.length;
        int water = 0;
        
        // Arrays to store the maximum height to the left and right at each position
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        // Fill leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        // Fill rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        // Calculate trapped water at each position
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return water;
    }
}