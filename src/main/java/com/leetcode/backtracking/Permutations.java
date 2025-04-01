package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Given an array nums of distinct integers, return all possible permutations.
 * You can return the answer in any order.
 * 
 * Example:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations {
    
    /**
     * Main method to generate all possible permutations.
     * @param nums Array of distinct integers
     * @return List of all possible permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Convert array to list for easier manipulation
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        backtrack(result, numsList, 0);
        return result;
    }
    
    /**
     * Backtracking helper method to generate permutations.
     * This method uses the concept of "fixing" elements at each position.
     * 
     * @param result The final list containing all permutations
     * @param nums List of numbers to permute
     * @param start The starting index for current permutation
     */
    private void backtrack(List<List<Integer>> result, List<Integer> nums, int start) {
        // Base case: if we've fixed all positions, add the permutation to result
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }
        
        // Try each number as the next element in the permutation
        for (int i = start; i < nums.size(); i++) {
            // Swap elements to fix the current position
            swap(nums, start, i);
            
            // Recursively generate permutations for remaining elements
            backtrack(result, nums, start + 1);
            
            // Backtrack: restore the array to its original state
            swap(nums, start, i);
        }
    }
    
    /**
     * Helper method to swap elements in a list.
     * @param nums List where elements need to be swapped
     * @param i First index
     * @param j Second index
     */
    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
} 