package com.leetcode.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class PalindromePartitioningTest {
    
    private PalindromePartitioning solution = new PalindromePartitioning();
    
    @Test
    public void testEmptyString() {
        List<List<String>> result = solution.partition("");
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList()));
    }
    
    @Test
    public void testSingleChar() {
        List<List<String>> result = solution.partition("a");
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList("a")));
    }
    
    @Test
    public void testTwoChars() {
        List<List<String>> result = solution.partition("aa");
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList("a", "a")));
        assertTrue(result.contains(Arrays.asList("aa")));
    }
    
    @Test
    public void testExample() {
        List<List<String>> result = solution.partition("aab");
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList("a", "a", "b")));
        assertTrue(result.contains(Arrays.asList("aa", "b")));
    }
    
    @Test
    public void testAllPalindromes() {
        List<List<String>> result = solution.partition("aba");
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList("a", "b", "a")));
        assertTrue(result.contains(Arrays.asList("aba")));
    }
    
    @Test
    public void testLongerString() {
        List<List<String>> result = solution.partition("aabb");
        // Expected partitions: ["a","a","b","b"], ["a","a","bb"], ["aa","b","b"], ["aa","bb"]
        assertEquals(4, result.size());
        assertTrue(result.contains(Arrays.asList("a", "a", "b", "b")));
        assertTrue(result.contains(Arrays.asList("a", "a", "bb")));
        assertTrue(result.contains(Arrays.asList("aa", "b", "b")));
        assertTrue(result.contains(Arrays.asList("aa", "bb")));
    }
    
    @Test
    public void testNoPalindromes() {
        List<List<String>> result = solution.partition("abc");
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList("a", "b", "c")));
    }
    
    @Test
    public void testMultiplePalindromes() {
        List<List<String>> result = solution.partition("racecar");
        // Should include ["r","a","c","e","c","a","r"], ["racecar"]
        assertTrue(result.contains(Arrays.asList("r", "a", "c", "e", "c", "a", "r")));
        assertTrue(result.contains(Arrays.asList("racecar")));
    }
} 