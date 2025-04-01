package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;

import com.leetcode.MinimumWindowSubstring;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MinimumWindowSubstring implementation.
 */
public class MinimumWindowSubstringTest {

    @Test
    void testMinWindowExample1() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        
        assertEquals("BANC", solution.minWindow(s, t));
    }
    
    @Test
    void testMinWindowExample2() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "a";
        String t = "a";
        
        assertEquals("a", solution.minWindow(s, t));
    }
    
    @Test
    void testMinWindowExample3() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "a";
        String t = "aa";
        
        assertEquals("", solution.minWindow(s, t));
    }
    
    @Test
    void testMinWindowEmptyStrings() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "";
        String t = "";
        
        assertEquals("", solution.minWindow(s, t));
    }
    
    @Test
    void testMinWindowTargetEmpty() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "";
        
        assertEquals("", solution.minWindow(s, t));
    }
    
    @Test
    void testMinWindowSourceEmpty() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "";
        String t = "ABC";
        
        assertEquals("", solution.minWindow(s, t));
    }
    
    @Test
    void testMinWindowExactMatch() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ABC";
        String t = "ABC";
        
        assertEquals("ABC", solution.minWindow(s, t));
    }
    
    @Test
    void testMinWindowWithDuplicates() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "AABC";
        
        assertEquals("ADOBECODEBA", solution.minWindow(s, t));
    }
    
    @Test
    void testMinWindowMultipleOptions() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ABCABDEBAC";
        String t = "ABC";
        
        assertEquals("ABC", solution.minWindow(s, t));
    }
}