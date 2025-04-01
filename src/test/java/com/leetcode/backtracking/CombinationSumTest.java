package com.leetcode.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class CombinationSumTest {
    
    private CombinationSum solution = new CombinationSum();
    
    @Test
    public void testEmptyArray() {
        int[] candidates = {};
        List<List<Integer>> result = solution.combinationSum(candidates, 8);
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testNoValidCombination() {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> result = solution.combinationSum(candidates, 1);
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testSingleNumberCombination() {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> result = solution.combinationSum(candidates, 7);
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList(7)));
        assertTrue(result.contains(Arrays.asList(2, 2, 3)));
    }
    
    @Test
    public void testMultipleValidCombinations() {
        int[] candidates = {2, 3, 5};
        List<List<Integer>> result = solution.combinationSum(candidates, 8);
        
        // Expected combinations: [2,2,2,2], [2,3,3], [3,5]
        assertEquals(3, result.size());
        assertTrue(result.contains(Arrays.asList(2, 2, 2, 2)));
        assertTrue(result.contains(Arrays.asList(2, 3, 3)));
        assertTrue(result.contains(Arrays.asList(3, 5)));
    }
    
    @Test
    public void testRepeatedNumbersAllowed() {
        int[] candidates = {3, 5};
        List<List<Integer>> result = solution.combinationSum(candidates, 9);
        
        // Should contain [3,3,3]
        assertTrue(result.contains(Arrays.asList(3, 3, 3)));
    }
    
    @Test
    public void testZeroTarget() {
        int[] candidates = {2, 3, 5};
        List<List<Integer>> result = solution.combinationSum(candidates, 0);
        
        // Should contain only empty list
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList()));
    }
} 