package com.datastructures.leetcode.arrays;

import org.junit.jupiter.api.Test;

import com.leetcode.arrays.TopKFrequentElements;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Test class for TopKFrequentElements implementation.
 */
public class TopKFrequentElementsTest {

    @Test
    void testTopKFrequentExample1() {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        
        int[] result = solution.topKFrequent(nums, k);
        // Sort for consistent comparison
        Arrays.sort(result);
        
        assertArrayEquals(new int[]{1, 2}, result);
    }
    
    @Test
    void testTopKFrequentExample2() {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1};
        int k = 1;
        
        int[] result = solution.topKFrequent(nums, k);
        
        assertArrayEquals(new int[]{1}, result);
    }
    
    @Test
    void testTopKFrequentAllSameElements() {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {5, 5, 5, 5, 5};
        int k = 1;
        
        int[] result = solution.topKFrequent(nums, k);
        
        assertArrayEquals(new int[]{5}, result);
    }
    
    @Test
    void testTopKFrequentLargerExample() {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {5, 1, 1, 5, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6};
        int k = 3;
        
        int[] result = solution.topKFrequent(nums, k);
        // Convert to set for comparison as the order doesn't matter
        Set<Integer> resultSet = new HashSet<>();
        for (int num : result) {
            resultSet.add(num);
        }
        
        Set<Integer> expectedSet = new HashSet<>(Arrays.asList(5, 2, 4));
        assertEquals(expectedSet, resultSet);
    }
    
    @Test
    void testTopKFrequentWithTies() {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 1, 2, 2, 3, 3, 4};
        int k = 2;
        
        int[] result = solution.topKFrequent(nums, k);
        // Since we have a tie, we need to check if any two of the tied elements are returned
        Set<Integer> possibleResults = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> resultSet = new HashSet<>();
        for (int num : result) {
            resultSet.add(num);
        }
        
        assertEquals(k, result.length);
        for (int num : result) {
            assertTrue(possibleResults.contains(num));
        }
    }
    
    @Test
    void testTopKFrequentEmptyArray() {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {};
        int k = 0;
        
        int[] result = solution.topKFrequent(nums, k);
        
        assertArrayEquals(new int[]{}, result);
    }
    
    @Test
    void testTopKFrequentNullArray() {
        TopKFrequentElements solution = new TopKFrequentElements();
        
        int[] result = solution.topKFrequent(null, 1);
        
        assertArrayEquals(new int[]{}, result);
    }
    
    @Test
    void testTopKFrequentBucketSortImplementation() {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        
        int[] result = solution.topKFrequentBucketSort(nums, k);
        // Sort for consistent comparison
        Arrays.sort(result);
        
        assertArrayEquals(new int[]{1, 2}, result);
    }
}