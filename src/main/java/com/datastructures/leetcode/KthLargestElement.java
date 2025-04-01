package com.datastructures.leetcode;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Random;

/**
 * LeetCode #215: Kth Largest Element in an Array
 * 
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Time Complexity:
 * - Using Heap: O(n log k) time
 * - Using QuickSelect: O(n) average case, O(n²) worst case
 * 
 * Space Complexity: 
 * - Using Heap: O(k) space
 * - Using QuickSelect: O(1) space
 */
public class KthLargestElement {
    
    /**
     * Finds the kth largest element using a min heap.
     * We maintain a min heap of size k, so the minimum element in the heap
     * will be the kth largest element overall.
     * 
     * @param nums the input array
     * @param k the position from the largest
     * @return the kth largest element
     */
    public int findKthLargest(int[] nums, int k) {
        // Create a min heap of size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        
        // Add elements to the min heap
        for (int num : nums) {
            minHeap.offer(num);
            
            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The top of the heap is the kth largest element
        return minHeap.peek();
    }
    
    private Random random = new Random();
    
    /**
     * Finds the kth largest element using the QuickSelect algorithm.
     * QuickSelect is a selection algorithm to find the kth smallest element in an unordered list.
     * It is similar to QuickSort but only recurses into one partition.
     * 
     * @param nums the input array
     * @param k the position from the largest
     * @return the kth largest element
     */
    public int findKthLargestQuickSelect(int[] nums, int k) {
        // Convert kth largest to (n - k)th smallest
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    /**
     * Helper method for the QuickSelect algorithm.
     * 
     * @param nums the input array
     * @param start start index
     * @param end end index
     * @param k the position (0-indexed)
     * @return the kth element
     */
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        
        // Select a random pivot index between start and end
        int pivotIndex = start + random.nextInt(end - start + 1);
        
        // Partition the array around the pivot
        pivotIndex = partition(nums, start, end, pivotIndex);
        
        // If pivotIndex is the kth element, return it
        if (pivotIndex == k) {
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            // If pivotIndex is less than k, search in the right side
            return quickSelect(nums, pivotIndex + 1, end, k);
        } else {
            // If pivotIndex is greater than k, search in the left side
            return quickSelect(nums, start, pivotIndex - 1, k);
        }
    }
    
    /**
     * Partitions the array around a pivot element.
     * 
     * @param nums the input array
     * @param start start index
     * @param end end index
     * @param pivotIndex the index of the pivot element
     * @return the final position of the pivot element
     */
    private int partition(int[] nums, int start, int end, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        
        // Move pivot to end
        swap(nums, pivotIndex, end);
        
        // Move all elements smaller than the pivot to the left
        int storeIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }
        
        // Move pivot to its final place
        swap(nums, storeIndex, end);
        
        return storeIndex;
    }
    
    /**
     * Swaps two elements in an array.
     * 
     * @param nums the input array
     * @param i index of first element
     * @param j index of second element
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}