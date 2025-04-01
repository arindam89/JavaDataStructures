package com.leetcode;

/**
 * LeetCode #33: Search in Rotated Sorted Array
 * 
 * There is an integer array nums sorted in ascending order (with distinct values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k 
 * (1 <= k < nums.length) such that the resulting array is 
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * 
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target, return the index of 
 * target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Time Complexity: O(log n) because we're using binary search
 * Space Complexity: O(1) because we only use a constant amount of extra space
 */
public class SearchInRotatedSortedArray {
    
    /**
     * Searches for the target in a rotated sorted array.
     * Uses a modified binary search algorithm.
     * 
     * @param nums the rotated sorted array
     * @param target the target value to search for
     * @return the index of the target if found, -1 otherwise
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Case 1: Found target
            if (nums[mid] == target) {
                return mid;
            }
            
            // Case 2: Right half is sorted
            if (nums[mid] < nums[right]) {
                // Check if target is in the right sorted half
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Search right half
                } else {
                    right = mid - 1; // Search left half
                }
            } 
            // Case 3: Left half is sorted
            else {
                // Check if target is in the left sorted half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Search left half
                } else {
                    left = mid + 1; // Search right half
                }
            }
        }
        
        return -1; // Target not found
    }
    
    /**
     * Alternative implementation that first finds the pivot point, then performs standard binary search.
     * 
     * @param nums the rotated sorted array
     * @param target the target value to search for
     * @return the index of the target if found, -1 otherwise
     */
    public int searchWithPivotFinding(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        // Find the pivot index (the smallest element)
        int pivotIndex = findPivot(nums);
        
        // If the array is not rotated
        if (pivotIndex == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        
        // If target is the pivot element
        if (nums[pivotIndex] == target) {
            return pivotIndex;
        }
        
        // If target is greater than or equal to the first element,
        // search in the first half (before the pivot)
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivotIndex - 1, target);
        }
        
        // Otherwise, search in the second half (from pivot onwards)
        return binarySearch(nums, pivotIndex, nums.length - 1, target);
    }
    
    /**
     * Finds the pivot index (the smallest element) in a rotated sorted array.
     * 
     * @param nums the rotated sorted array
     * @return the index of the smallest element
     */
    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // If the array is not rotated
        if (nums[left] < nums[right]) {
            return 0;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If mid element is greater than the right element,
            // the pivot must be in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // If mid element is less than or equal to the right element,
            // the pivot must be in the left half or at mid
            else {
                right = mid;
            }
        }
        
        return left; // At this point, left == right and points to the pivot
    }
    
    /**
     * Standard binary search algorithm.
     * 
     * @param nums the array to search in
     * @param left the left index
     * @param right the right index
     * @param target the target value to search for
     * @return the index of the target if found, -1 otherwise
     */
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Target not found
    }
    
    /**
     * Provides a detailed explanation of how the search algorithm works
     * with a specific example.
     * 
     * @param nums the rotated sorted array
     * @param target the target value to search for
     * @return a string explaining the search process
     */
    public String explainSearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return "Array is empty or null.";
        }
        
        StringBuilder explanation = new StringBuilder();
        explanation.append("Searching for ").append(target).append(" in rotated array: ");
        
        for (int i = 0; i < nums.length; i++) {
            explanation.append(nums[i]);
            if (i < nums.length - 1) {
                explanation.append(", ");
            }
        }
        explanation.append("\n\n");
        
        int left = 0;
        int right = nums.length - 1;
        int step = 1;
        
        explanation.append("Using modified binary search to handle rotation:\n");
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            explanation.append("\nStep ").append(step++).append(":\n");
            explanation.append("  Current search range: [").append(left).append(", ").append(right).append("]\n");
            explanation.append("  Mid index: ").append(mid).append(", value: ").append(nums[mid]).append("\n");
            
            // Case 1: Found target
            if (nums[mid] == target) {
                explanation.append("  Target found at index ").append(mid).append("!\n");
                explanation.append("\nFinal result: ").append(mid);
                return explanation.toString();
            }
            
            // Check if right half is sorted
            if (nums[mid] < nums[right]) {
                explanation.append("  Right half [").append(mid).append(", ").append(right)
                          .append("] is sorted (").append(nums[mid]).append(" < ").append(nums[right]).append(")\n");
                
                // Check if target is in the right sorted half
                if (target > nums[mid] && target <= nums[right]) {
                    explanation.append("  Target ").append(target).append(" is in this sorted right half\n");
                    explanation.append("  Searching right half: changing left from ").append(left)
                              .append(" to ").append(mid + 1).append("\n");
                    left = mid + 1; // Search right half
                } else {
                    explanation.append("  Target ").append(target).append(" is NOT in this sorted right half\n");
                    explanation.append("  Searching left half: changing right from ").append(right)
                              .append(" to ").append(mid - 1).append("\n");
                    right = mid - 1; // Search left half
                }
            } 
            // Left half is sorted
            else {
                explanation.append("  Left half [").append(left).append(", ").append(mid)
                          .append("] is sorted (").append(nums[mid]).append(" >= ").append(nums[right]).append(")\n");
                
                // Check if target is in the left sorted half
                if (target >= nums[left] && target < nums[mid]) {
                    explanation.append("  Target ").append(target).append(" is in this sorted left half\n");
                    explanation.append("  Searching left half: changing right from ").append(right)
                              .append(" to ").append(mid - 1).append("\n");
                    right = mid - 1; // Search left half
                } else {
                    explanation.append("  Target ").append(target).append(" is NOT in this sorted left half\n");
                    explanation.append("  Searching right half: changing left from ").append(left)
                              .append(" to ").append(mid + 1).append("\n");
                    left = mid + 1; // Search right half
                }
            }
        }
        
        explanation.append("\nTarget ").append(target).append(" not found in the array.");
        explanation.append("\nFinal result: -1");
        
        return explanation.toString();
    }
}