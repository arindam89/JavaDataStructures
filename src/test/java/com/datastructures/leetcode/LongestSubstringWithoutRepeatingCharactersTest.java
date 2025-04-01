package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;

import com.leetcode.LongestSubstringWithoutRepeatingCharacters;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LongestSubstringWithoutRepeatingCharacters implementation.
 */
public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    void testLengthOfLongestSubstringExample1() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        
        assertEquals(3, solution.lengthOfLongestSubstring(s));
    }
    
    @Test
    void testLengthOfLongestSubstringExample2() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "bbbbb";
        
        assertEquals(1, solution.lengthOfLongestSubstring(s));
    }
    
    @Test
    void testLengthOfLongestSubstringExample3() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "pwwkew";
        
        assertEquals(3, solution.lengthOfLongestSubstring(s));
    }
    
    @Test
    void testLengthOfLongestSubstringEmptyString() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "";
        
        assertEquals(0, solution.lengthOfLongestSubstring(s));
    }
    
    @Test
    void testLengthOfLongestSubstringNullString() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        
        assertEquals(0, solution.lengthOfLongestSubstring(null));
    }
    
    @Test
    void testLengthOfLongestSubstringSingleCharacter() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "a";
        
        assertEquals(1, solution.lengthOfLongestSubstring(s));
    }
    
    @Test
    void testLengthOfLongestSubstringWithSpaces() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "hello world";
        
        assertEquals(6, solution.lengthOfLongestSubstring(s)); // "world " or " world"
    }
    
    @Test
    void testLengthOfLongestSubstringOptimizedExample1() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        
        assertEquals(3, solution.lengthOfLongestSubstringOptimized(s));
    }
    
    @Test
    void testLengthOfLongestSubstringOptimizedExample2() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "bbbbb";
        
        assertEquals(1, solution.lengthOfLongestSubstringOptimized(s));
    }
    
    @Test
    void testLengthOfLongestSubstringOptimizedExample3() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "pwwkew";
        
        assertEquals(3, solution.lengthOfLongestSubstringOptimized(s));
    }
}