package com.leetcode.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class SubsetsIITest {
    
    private SubsetsII solution = new SubsetsII();
    
    @Test
    public void testEmptyArray() {
        int[] nums = {};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList()));
    }
    
    @Test
    public void testSingleElement() {
        int[] nums = {1};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList()));
        assertTrue(result.contains(Arrays.asList(1)));
    }
    
    @Test
    public void testWithDuplicates() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        
        // Expected: [[],[1],[1,2],[1,2,2],[2],[2,2]]
        assertEquals(6, result.size());
        assertTrue(result.contains(Arrays.asList()));
        assertTrue(result.contains(Arrays.asList(1)));
        assertTrue(result.contains(Arrays.asList(2)));
        assertTrue(result.contains(Arrays.asList(1, 2)));
        assertTrue(result.contains(Arrays.asList(2, 2)));
        assertTrue(result.contains(Arrays.asList(1, 2, 2)));
    }
    
    @Test
    public void testAllDuplicates() {
        int[] nums = {2, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        
        // Expected: [[],[2],[2,2],[2,2,2]]
        assertEquals(4, result.size());
        assertTrue(result.contains(Arrays.asList()));
        assertTrue(result.contains(Arrays.asList(2)));
        assertTrue(result.contains(Arrays.asList(2, 2)));
        assertTrue(result.contains(Arrays.asList(2, 2, 2)));
    }
    
    @Test
    public void testMultipleDuplicates() {
        int[] nums = {1, 1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        
        // Expected: [[],[1],[1,1],[1,1,2],[1,1,2,2],[1,2],[1,2,2],[2],[2,2]]
        assertEquals(9, result.size());
        assertTrue(result.contains(Arrays.asList()));
        assertTrue(result.contains(Arrays.asList(1)));
        assertTrue(result.contains(Arrays.asList(2)));
        assertTrue(result.contains(Arrays.asList(1, 1)));
        assertTrue(result.contains(Arrays.asList(1, 2)));
        assertTrue(result.contains(Arrays.asList(2, 2)));
        assertTrue(result.contains(Arrays.asList(1, 1, 2)));
        assertTrue(result.contains(Arrays.asList(1, 2, 2)));
        assertTrue(result.contains(Arrays.asList(1, 1, 2, 2)));
    }
    
    @Test
    public void testNoDuplicates() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        
        // Should behave same as regular subsets
        assertEquals(8, result.size());
        assertTrue(result.contains(Arrays.asList()));
        assertTrue(result.contains(Arrays.asList(1)));
        assertTrue(result.contains(Arrays.asList(2)));
        assertTrue(result.contains(Arrays.asList(3)));
        assertTrue(result.contains(Arrays.asList(1, 2)));
        assertTrue(result.contains(Arrays.asList(1, 3)));
        assertTrue(result.contains(Arrays.asList(2, 3)));
        assertTrue(result.contains(Arrays.asList(1, 2, 3)));
    }
} 