package com.leetcode.arrays;

/**
 * LeetCode #11: Container With Most Water
 * 
 * You are given an integer array height of length n. There are n vertical lines drawn such that the
 * two endpoints of the ith line are (i, 0) and (i, height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the container contains
 * the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * Time Complexity: O(n) where n is the length of the height array
 * Space Complexity: O(1) as we only use constant extra space
 */
public class ContainerWithMostWater {
    
    /**
     * Finds the maximum area of water that can be contained.
     * Uses a two-pointer approach to efficiently find the maximum area.
     * 
     * @param height array of heights representing the vertical lines
     * @return the maximum water area that can be contained
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            // Calculate the width between the two lines
            int width = right - left;
            
            // Calculate the height (limited by the shorter line)
            int h = Math.min(height[left], height[right]);
            
            // Calculate the area and update maxWater if necessary
            int area = width * h;
            maxWater = Math.max(maxWater, area);
            
            // Move the pointer pointing to the shorter line
            // This is the key insight: we always move the shorter line inward
            // because moving the taller line would only decrease the area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
    
    /**
     * Brute force approach to find the maximum area.
     * Check all possible pairs of lines.
     * 
     * Time Complexity: O(n²) where n is the length of the height array
     * Space Complexity: O(1)
     * 
     * @param height array of heights representing the vertical lines
     * @return the maximum water area that can be contained
     */
    public int maxAreaBruteForce(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        
        int maxWater = 0;
        
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // Calculate width between the two lines
                int width = j - i;
                
                // Calculate height (limited by the shorter line)
                int h = Math.min(height[i], height[j]);
                
                // Calculate area and update maxWater if necessary
                int area = width * h;
                maxWater = Math.max(maxWater, area);
            }
        }
        
        return maxWater;
    }
    
    /**
     * Illustrates why the two-pointer approach works with a detailed explanation.
     * 
     * @param height array of heights representing the vertical lines
     * @return the maximum water area and explanation
     */
    public String explainMaxAreaApproach(int[] height) {
        if (height == null || height.length < 2) {
            return "Invalid input: array must have at least 2 elements.";
        }
        
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        StringBuilder explanation = new StringBuilder();
        explanation.append("Container With Most Water Solution Explanation:\n\n");
        explanation.append("We use a two-pointer approach, starting with the widest possible container.\n");
        explanation.append("Initial pointers: left=0, right=").append(height.length - 1).append("\n\n");
        
        int step = 1;
        
        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;
            
            explanation.append("Step ").append(step++).append(":\n");
            explanation.append("  Left=").append(left).append(" (height=").append(height[left]).append("), ");
            explanation.append("Right=").append(right).append(" (height=").append(height[right]).append(")\n");
            explanation.append("  Width=").append(width).append(", Height=").append(h).append("\n");
            explanation.append("  Area=").append(width).append("*").append(h).append("=").append(area).append("\n");
            
            if (area > maxWater) {
                maxWater = area;
                explanation.append("  New maximum area found: ").append(maxWater).append("\n");
            }
            
            explanation.append("  Moving ");
            
            if (height[left] < height[right]) {
                explanation.append("left pointer inward (since left height is smaller)\n\n");
                left++;
            } else {
                explanation.append("right pointer inward (since right height is smaller or equal)\n\n");
                right--;
            }
        }
        
        explanation.append("Final maximum area: ").append(maxWater);
        explanation.append("\n\nWhy this approach works:\n");
        explanation.append("1. We start with the maximum possible width.\n");
        explanation.append("2. The area is limited by the shorter of the two lines.\n");
        explanation.append("3. When we move a pointer, we're decreasing the width, so the only way to possibly get a larger area is to find a taller height.\n");
        explanation.append("4. By always moving the pointer pointing to the shorter line, we have a chance to find a better solution.\n");
        explanation.append("5. Moving the taller line would only decrease the area (because the height was already limited by the shorter line, and the width is decreasing).\n");
        
        return explanation.toString();
    }
}