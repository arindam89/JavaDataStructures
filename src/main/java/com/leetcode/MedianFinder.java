package com.leetcode;

import java.util.PriorityQueue;

/**
 * LeetCode #295: Find Median from Data Stream (Hard)
 * 
 * The MedianFinder class finds the median of a data stream.
 * 
 * Implement the MedianFinder class:
 * - MedianFinder() initializes the MedianFinder object.
 * - void addNum(int num) adds the integer num from the data stream to the data structure.
 * - double findMedian() returns the median of all elements so far.
 *   Answers within 10^-5 of the actual answer will be accepted.
 * 
 * Time Complexity:
 * - addNum: O(log n)
 * - findMedian: O(1)
 * 
 * Space Complexity: O(n)
 */
public class MedianFinder {
    
    // Max heap for the first half (smaller elements)
    private PriorityQueue<Integer> maxHeap;
    
    // Min heap for the second half (larger elements)
    private PriorityQueue<Integer> minHeap;
    
    /**
     * Initializes the MedianFinder.
     */
    public MedianFinder() {
        // Max heap stores the smaller half of numbers
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Min heap stores the larger half of numbers
        minHeap = new PriorityQueue<>();
    }
    
    /**
     * Adds a number into the data structure.
     * 
     * @param num the number to add
     */
    public void addNum(int num) {
        // First element goes to maxHeap
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        
        // If num is smaller than the largest element in maxHeap, add to maxHeap
        // Otherwise, add to minHeap
        if (num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        
        // Balance the heaps to ensure their sizes differ by at most 1
        // If maxHeap has more than one more element than minHeap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } 
        // If minHeap has more elements than maxHeap
        else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    /**
     * Returns the median of all elements so far.
     * 
     * @return the median value
     */
    public double findMedian() {
        // If maxHeap and minHeap have the same size, median is the average of their tops
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } 
        // Otherwise, maxHeap has one more element, so its top is the median
        else {
            return maxHeap.peek();
        }
    }
}