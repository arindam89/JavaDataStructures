package com.leetcode.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class LetterCombinationsTest {
    
    private LetterCombinations solution = new LetterCombinations();
    
    @Test
    public void testEmptyString() {
        List<String> result = solution.letterCombinations("");
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testNullInput() {
        List<String> result = solution.letterCombinations(null);
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testSingleDigit() {
        List<String> result = solution.letterCombinations("2");
        assertEquals(3, result.size());
        assertTrue(result.containsAll(Arrays.asList("a", "b", "c")));
    }
    
    @Test
    public void testTwoDigits() {
        List<String> result = solution.letterCombinations("23");
        assertEquals(9, result.size());
        List<String> expected = Arrays.asList(
            "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
        );
        assertTrue(result.containsAll(expected));
        assertEquals(expected.size(), result.size());
    }
    
    @Test
    public void testThreeDigits() {
        List<String> result = solution.letterCombinations("234");
        assertEquals(27, result.size()); // 3 * 3 * 3 combinations
        
        // Check a few expected combinations
        assertTrue(result.contains("adg"));
        assertTrue(result.contains("adi"));
        assertTrue(result.contains("beh"));
        assertTrue(result.contains("cfi"));
    }
    
    @Test
    public void testWithFourLetterDigit() {
        List<String> result = solution.letterCombinations("7");
        assertEquals(4, result.size());
        assertTrue(result.containsAll(Arrays.asList("p", "q", "r", "s")));
    }
    
    @Test
    public void testLongNumber() {
        List<String> result = solution.letterCombinations("234567");
        // 3 * 3 * 3 * 3 * 3 * 4 = 972 combinations
        assertEquals(972, result.size());
    }
    
    @Test
    public void testSameDigitRepeated() {
        List<String> result = solution.letterCombinations("22");
        assertEquals(9, result.size());
        List<String> expected = Arrays.asList(
            "aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb", "cc"
        );
        assertTrue(result.containsAll(expected));
        assertEquals(expected.size(), result.size());
    }
    
    @Test
    public void testAllUniqueResults() {
        List<String> result = solution.letterCombinations("23");
        Set<String> uniqueResults = new HashSet<>(result);
        assertEquals(result.size(), uniqueResults.size());
    }
} 