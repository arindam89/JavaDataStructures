package com.datastructures.leetcode;

import java.util.*;

/**
 * LeetCode Problem: Top K Frequent Elements
 * 
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 * - k is in the range [1, the number of unique elements in the array]
 * - It is guaranteed that the answer is unique
 * 
 * Follow up: Your algorithm's time complexity must be better than O(n log n), 
 * where n is the array's size.
 * 
 * This implementation uses a HashMap to count frequencies and a PriorityQueue (heap)
 * to find the top k elements efficiently.
 */
public class TopKFrequentElements {
    
    /**
     * Finds the k most frequent elements in the array.
     * 
     * Time Complexity: O(n log k) where n is the length of the array
     * Space Complexity: O(n + k) for the hashmap and heap
     * 
     * @param nums the input array of integers
     * @param k the number of most frequent elements to return
     * @return an array of the k most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Handle edge cases
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        // Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Use a min heap to keep track of the k most frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue().compareTo(b.getValue())
        );
        
        // Add elements to the heap, maintaining only k elements
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element if we exceed k
            }
        }
        
        // Extract the k most frequent elements from the heap
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        
        return result;
    }
    
    /**
     * Alternative implementation using bucket sort approach.
     * This achieves O(n) time complexity.
     * 
     * @param nums the input array of integers
     * @param k the number of most frequent elements to return
     * @return an array of the k most frequent elements
     */
    public int[] topKFrequentBucketSort(int[] nums, int k) {
        // Handle edge cases
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        // Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Create frequency buckets where bucket[i] contains all numbers that appear i times
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].add(num);
        }
        
        // Extract the k most frequent elements from the buckets
        int[] result = new int[k];
        int index = 0;
        
        // Start from the highest frequency bucket
        for (int i = buckets.length - 1; i > 0 && index < k; i--) {
            List<Integer> currentBucket = buckets[i];
            for (int num : currentBucket) {
                result[index++] = num;
                if (index == k) {
                    break;
                }
            }
        }
        
        return result;
    }
}