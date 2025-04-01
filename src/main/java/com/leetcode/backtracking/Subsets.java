package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // Add the current subset to result
        result.add(new ArrayList<>(current));
        
        // Try adding each remaining number to current subset
        for (int i = start; i < nums.length; i++) {
            // Include nums[i] in current subset
            current.add(nums[i]);
            // Recursively generate subsets with nums[i]
            backtrack(result, current, nums, i + 1);
            // Backtrack by removing nums[i]
            current.remove(current.size() - 1);
        }
    }
} 