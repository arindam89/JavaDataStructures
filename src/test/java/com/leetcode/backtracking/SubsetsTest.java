package com.leetcode.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class SubsetsTest {
    
    private Subsets solution = new Subsets();
    
    @Test
    public void testEmptyArray() {
        int[] nums = {};
        List<List<Integer>> result = solution.subsets(nums);
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList()));
    }
    
    @Test
    public void testSingleElement() {
        int[] nums = {1};
        List<List<Integer>> result = solution.subsets(nums);
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList()));
        assertTrue(result.contains(Arrays.asList(1)));
    }
    
    @Test
    public void testThreeElements() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        assertEquals(8, result.size()); // 2^3 subsets
        
        // Check for specific subsets
        assertTrue(result.contains(Arrays.asList()));
        assertTrue(result.contains(Arrays.asList(1)));
        assertTrue(result.contains(Arrays.asList(2)));
        assertTrue(result.contains(Arrays.asList(3)));
        assertTrue(result.contains(Arrays.asList(1, 2)));
        assertTrue(result.contains(Arrays.asList(1, 3)));
        assertTrue(result.contains(Arrays.asList(2, 3)));
        assertTrue(result.contains(Arrays.asList(1, 2, 3)));
    }
    
    @Test
    public void testNoDuplicatesInResult() {
        int[] nums = {4, 5};
        List<List<Integer>> result = solution.subsets(nums);
        assertEquals(4, result.size()); // 2^2 subsets
        
        // Convert to Set to check for duplicates
        Set<List<Integer>> uniqueSubsets = new HashSet<>(result);
        assertEquals(result.size(), uniqueSubsets.size());
    }
} 