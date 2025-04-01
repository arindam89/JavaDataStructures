package com.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Test cases for the Permutations problem.
 */
public class PermutationsTest {
    
    @Test
    public void testPermuteExample1() {
        Permutations solution = new Permutations();
        
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        
        // Check the size of the result (3! = 6 permutations)
        assertEquals(6, result.size());
        
        // Check that all permutations are unique
        Set<List<Integer>> uniquePermutations = new HashSet<>(result);
        assertEquals(6, uniquePermutations.size());
        
        // Check that expected permutations are included
        assertTrue(result.contains(Arrays.asList(1, 2, 3)));
        assertTrue(result.contains(Arrays.asList(1, 3, 2)));
        assertTrue(result.contains(Arrays.asList(2, 1, 3)));
        assertTrue(result.contains(Arrays.asList(2, 3, 1)));
        assertTrue(result.contains(Arrays.asList(3, 1, 2)));
        assertTrue(result.contains(Arrays.asList(3, 2, 1)));
    }
    
    @Test
    public void testPermuteExample2() {
        Permutations solution = new Permutations();
        
        int[] nums = {0, 1};
        List<List<Integer>> result = solution.permute(nums);
        
        // Check the size of the result (2! = 2 permutations)
        assertEquals(2, result.size());
        
        // Check that all permutations are unique
        Set<List<Integer>> uniquePermutations = new HashSet<>(result);
        assertEquals(2, uniquePermutations.size());
        
        // Check that expected permutations are included
        assertTrue(result.contains(Arrays.asList(0, 1)));
        assertTrue(result.contains(Arrays.asList(1, 0)));
    }
    
    @Test
    public void testPermuteSingleElement() {
        Permutations solution = new Permutations();
        
        int[] nums = {42};
        List<List<Integer>> result = solution.permute(nums);
        
        // Check the size of the result (1! = 1 permutation)
        assertEquals(1, result.size());
        
        // Check the only permutation
        assertEquals(Arrays.asList(42), result.get(0));
    }
    
    @Test
    public void testPermuteEmptyArray() {
        Permutations solution = new Permutations();
        
        int[] nums = {};
        List<List<Integer>> result = solution.permute(nums);
        
        // Empty input should return empty result
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testPermuteBySwappingExample1() {
        Permutations solution = new Permutations();
        
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permuteBySwapping(nums);
        
        // Check the size of the result (3! = 6 permutations)
        assertEquals(6, result.size());
        
        // Check that all permutations are unique
        Set<List<Integer>> uniquePermutations = new HashSet<>(result);
        assertEquals(6, uniquePermutations.size());
        
        // Check that expected permutations are included
        assertTrue(result.contains(Arrays.asList(1, 2, 3)));
        assertTrue(result.contains(Arrays.asList(1, 3, 2)));
        assertTrue(result.contains(Arrays.asList(2, 1, 3)));
        assertTrue(result.contains(Arrays.asList(2, 3, 1)));
        assertTrue(result.contains(Arrays.asList(3, 1, 2)));
        assertTrue(result.contains(Arrays.asList(3, 2, 1)));
    }
    
    @Test
    public void testBothMethodsSameResults() {
        Permutations solution = new Permutations();
        
        int[] nums = {1, 2, 3, 4};
        
        List<List<Integer>> result1 = solution.permute(nums);
        List<List<Integer>> result2 = solution.permuteBySwapping(nums);
        
        // Both methods should generate the same number of permutations (4! = 24)
        assertEquals(result1.size(), result2.size());
        assertEquals(24, result1.size());
        
        // Both sets should contain the same permutations
        Set<List<Integer>> set1 = new HashSet<>(result1);
        Set<List<Integer>> set2 = new HashSet<>(result2);
        
        assertEquals(set1, set2);
    }
}