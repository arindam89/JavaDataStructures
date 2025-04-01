package com.leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #46: Permutations
 * 
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 * 
 * Time Complexity: O(n! * n) where n is the length of the input array
 * - We generate n! permutations and each permutation takes O(n) time to construct
 * 
 * Space Complexity: O(n! * n) to store all permutations
 * - The recursion stack also takes O(n) space
 */
public class Permutations {
    
    /**
     * Generates all possible permutations of the given array.
     * 
     * @param nums array of distinct integers
     * @return list of all possible permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // Start backtracking to generate permutations
        backtrack(nums, result, new ArrayList<>(), new boolean[nums.length]);
        
        return result;
    }
    
    /**
     * Backtracking method to generate permutations.
     * 
     * @param nums original array
     * @param result list to store all permutations
     * @param current current permutation being built
     * @param used boolean array to keep track of used elements
     */
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] used) {
        // If the current permutation is complete, add it to the result
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try all possible numbers at the current position
        for (int i = 0; i < nums.length; i++) {
            // Skip used numbers
            if (used[i]) {
                continue;
            }
            
            // Choose the current number
            used[i] = true;
            current.add(nums[i]);
            
            // Recurse to fill the next position
            backtrack(nums, result, current, used);
            
            // Unchoose (backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
    
    /**
     * Alternative implementation using swap-based backtracking.
     * This approach directly modifies the original array instead of using a separate list.
     * 
     * @param nums array of distinct integers
     * @return list of all possible permutations
     */
    public List<List<Integer>> permuteBySwapping(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        
        backtrackBySwapping(numsList, 0, result);
        
        return result;
    }
    
    /**
     * Backtracking method that generates permutations by swapping elements.
     * 
     * @param nums list of numbers to permute
     * @param start index to start permuting from
     * @param result list to store all permutations
     */
    private void backtrackBySwapping(List<Integer> nums, int start, List<List<Integer>> result) {
        // If we've reached the end, add the permutation to our result
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }
        
        // Try all possible elements at the current position
        for (int i = start; i < nums.size(); i++) {
            // Swap the current position with position i
            swap(nums, start, i);
            
            // Recurse with the next position
            backtrackBySwapping(nums, start + 1, result);
            
            // Restore the array (backtrack)
            swap(nums, start, i);
        }
    }
    
    /**
     * Helper method to swap two elements in a list.
     * 
     * @param nums the list
     * @param i first index
     * @param j second index
     */
    private void swap(List<Integer> nums, int i, int j) {
        if (i != j) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
}