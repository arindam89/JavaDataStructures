package com.leetcode.arrays;

/**
 * LeetCode #34: Find First and Last Position of Element in Sorted Array
 * 
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
 * position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Time Complexity: O(log n) because we're using binary search twice
 * Space Complexity: O(1) as we only use a constant amount of extra space
 */
public class FindFirstLastPosition {
    
    /**
     * Finds the starting and ending position of the target in nums.
     * 
     * @param nums the sorted array of integers
     * @param target the target value to search for
     * @return an array of size 2, where the first element is the starting position and the
     *         second element is the ending position, or [-1, -1] if the target is not found
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // Find the first position of target
        result[0] = findFirstPosition(nums, target);
        
        // If target is not found, return [-1, -1]
        if (result[0] == -1) {
            return result;
        }
        
        // Find the last position of target
        result[1] = findLastPosition(nums, target);
        
        return result;
    }
    
    /**
     * Finds the first position of the target in the array using binary search.
     * 
     * @param nums the sorted array
     * @param target the target value to search for
     * @return the first position of the target, or -1 if not found
     */
    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstPos = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                // Found a match, but need to check if it's the first occurrence
                firstPos = mid;
                // Continue searching in the left half
                right = mid - 1;
            } else if (nums[mid] < target) {
                // Target is in the right half
                left = mid + 1;
            } else {
                // Target is in the left half
                right = mid - 1;
            }
        }
        
        return firstPos;
    }
    
    /**
     * Finds the last position of the target in the array using binary search.
     * 
     * @param nums the sorted array
     * @param target the target value to search for
     * @return the last position of the target, or -1 if not found
     */
    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastPos = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                // Found a match, but need to check if it's the last occurrence
                lastPos = mid;
                // Continue searching in the right half
                left = mid + 1;
            } else if (nums[mid] < target) {
                // Target is in the right half
                left = mid + 1;
            } else {
                // Target is in the left half
                right = mid - 1;
            }
        }
        
        return lastPos;
    }
    
    /**
     * Alternative implementation that uses a single binary search to find both first and last positions.
     * 
     * @param nums the sorted array
     * @param target the target value to search for
     * @return an array of size 2 with the first and last positions of the target, or [-1, -1] if not found
     */
    public int[] searchRangeAlternative(int[] nums, int target) {
        int[] result = {-1, -1};
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // First, find any occurrence of the target
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // If target is not found, return [-1, -1]
        if (index == -1) {
            return result;
        }
        
        // Expand from the found index to find the range
        int start = index;
        int end = index;
        
        // Find the first position
        while (start > 0 && nums[start - 1] == target) {
            start--;
        }
        
        // Find the last position
        while (end < nums.length - 1 && nums[end + 1] == target) {
            end++;
        }
        
        result[0] = start;
        result[1] = end;
        
        return result;
    }
}