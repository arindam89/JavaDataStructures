package com.leetcode.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class PermutationsTest {
    
    private Permutations solution = new Permutations();
    
    @Test
    public void testEmptyArray() {
        int[] nums = {};
        List<List<Integer>> result = solution.permute(nums);
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList()));
    }
    
    @Test
    public void testSingleElement() {
        int[] nums = {1};
        List<List<Integer>> result = solution.permute(nums);
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList(1)));
    }
    
    @Test
    public void testTwoElements() {
        int[] nums = {1, 2};
        List<List<Integer>> result = solution.permute(nums);
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList(1, 2)));
        assertTrue(result.contains(Arrays.asList(2, 1)));
    }
    
    @Test
    public void testThreeElements() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        
        // Should contain all 6 permutations
        assertEquals(6, result.size());
        assertTrue(result.contains(Arrays.asList(1, 2, 3)));
        assertTrue(result.contains(Arrays.asList(1, 3, 2)));
        assertTrue(result.contains(Arrays.asList(2, 1, 3)));
        assertTrue(result.contains(Arrays.asList(2, 3, 1)));
        assertTrue(result.contains(Arrays.asList(3, 1, 2)));
        assertTrue(result.contains(Arrays.asList(3, 2, 1)));
    }
    
    @Test
    public void testNegativeNumbers() {
        int[] nums = {-1, 0, 1};
        List<List<Integer>> result = solution.permute(nums);
        
        assertEquals(6, result.size());
        assertTrue(result.contains(Arrays.asList(-1, 0, 1)));
        assertTrue(result.contains(Arrays.asList(-1, 1, 0)));
        assertTrue(result.contains(Arrays.asList(0, -1, 1)));
        assertTrue(result.contains(Arrays.asList(0, 1, -1)));
        assertTrue(result.contains(Arrays.asList(1, -1, 0)));
        assertTrue(result.contains(Arrays.asList(1, 0, -1)));
    }
    
    @Test
    public void testUniquePermutations() {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result = solution.permute(nums);
        
        // Should have 4! = 24 permutations
        assertEquals(24, result.size());
        
        // Convert to set to check for duplicates
        Set<List<Integer>> uniquePerms = new HashSet<>(result);
        assertEquals(result.size(), uniquePerms.size());
    }
} 