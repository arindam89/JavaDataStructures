package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * 
 * Example:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class SubsetsII {
    
    /**
     * Main method to generate all possible unique subsets.
     * @param nums Array of integers (may contain duplicates)
     * @return List of all unique subsets
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort array to handle duplicates
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    /**
     * Backtracking helper method to generate subsets.
     * This method handles duplicates by skipping elements that would create duplicate subsets.
     * 
     * @param result The final list containing all unique subsets
     * @param current The current subset being built
     * @param nums Sorted array of numbers
     * @param start The starting index to consider
     */
    private void backtrack(List<List<Integer>> result, List<Integer> current, 
                         int[] nums, int start) {
        // Add the current subset to result
        result.add(new ArrayList<>(current));
        
        // Try adding each remaining number to current subset
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same level
            // Only skip if it's not the first element at current level (i > start)
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Include nums[i] in current subset
            current.add(nums[i]);
            
            // Recursively generate subsets starting from next index
            backtrack(result, current, nums, i + 1);
            
            // Backtrack: remove nums[i] to try next number
            current.remove(current.size() - 1);
        }
    }
} 