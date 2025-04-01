package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * 
 * Each number in candidates may only be used ONCE in the combination.
 * Note: The solution set must not contain duplicate combinations.
 * 
 * Example:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output: [[1,1,6], [1,2,5], [1,7], [2,6]]
 */
public class CombinationSumII {
    
    /**
     * Main method to find all unique combinations that sum to target.
     * @param candidates Array of integers (may contain duplicates)
     * @param target The target sum to achieve
     * @return List of all unique combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort array to handle duplicates and for optimization
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    /**
     * Backtracking helper method to find combinations.
     * 
     * @param result The final list containing all valid combinations
     * @param current The current combination being built
     * @param candidates Sorted array of available numbers
     * @param remaining The remaining sum needed to reach target
     * @param start The starting index to consider
     */
    private void backtrack(List<List<Integer>> result, List<Integer> current, 
                         int[] candidates, int remaining, int start) {
        // Base case: if remaining sum becomes 0, we found a valid combination
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Base case: if remaining sum becomes negative, this path is invalid
        if (remaining < 0) {
            return;
        }
        
        // Try each candidate from the start index
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            // Only skip if it's not the first element at current level (i > start)
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // Add current candidate to the combination
            current.add(candidates[i]);
            
            // Recursively try to find combinations
            // Use i + 1 since we can't reuse the same element
            backtrack(result, current, candidates, remaining - candidates[i], i + 1);
            
            // Backtrack: remove the last added number to try a different path
            current.remove(current.size() - 1);
        }
    }
} 