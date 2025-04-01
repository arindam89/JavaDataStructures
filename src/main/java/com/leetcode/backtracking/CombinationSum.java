package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * 
 * Example:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 + 2 + 3 = 7
 * 7 = 7
 */
public class CombinationSum {
    
    /**
     * Main method to find all combinations that sum to target.
     * @param candidates Array of distinct integers to choose from
     * @param target The target sum to achieve
     * @return List of all possible combinations that sum to target
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    /**
     * Backtracking helper method to find combinations.
     * 
     * @param result The final list containing all valid combinations
     * @param current The current combination being built
     * @param candidates Array of available numbers
     * @param remaining The remaining sum needed to reach target
     * @param start The starting index to consider (prevents duplicate combinations)
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
        // We use start to avoid duplicate combinations (e.g., [2,2,3] and [2,3,2])
        for (int i = start; i < candidates.length; i++) {
            // Add current candidate to the combination
            current.add(candidates[i]);
            
            // Recursively try to find combinations with the current number
            // We pass i instead of i+1 because we can reuse the same number
            backtrack(result, current, candidates, remaining - candidates[i], i);
            
            // Backtrack: remove the last added number to try a different path
            current.remove(current.size() - 1);
        }
    }
} 