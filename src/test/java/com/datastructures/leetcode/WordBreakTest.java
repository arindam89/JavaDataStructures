package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Test class for WordBreak implementation.
 */
public class WordBreakTest {

    @Test
    void testWordBreakExample1() {
        WordBreak solution = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        
        assertTrue(solution.wordBreak(s, wordDict));
    }
    
    @Test
    void testWordBreakExample2() {
        WordBreak solution = new WordBreak();
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        
        assertTrue(solution.wordBreak(s, wordDict));
    }
    
    @Test
    void testWordBreakExample3() {
        WordBreak solution = new WordBreak();
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        
        assertFalse(solution.wordBreak(s, wordDict));
    }
    
    @Test
    void testWordBreakEmptyString() {
        WordBreak solution = new WordBreak();
        String s = "";
        List<String> wordDict = Arrays.asList("a", "b");
        
        assertTrue(solution.wordBreak(s, wordDict));
    }
    
    @Test
    void testWordBreakEmptyDict() {
        WordBreak solution = new WordBreak();
        String s = "abc";
        List<String> wordDict = Collections.emptyList();
        
        assertFalse(solution.wordBreak(s, wordDict));
    }
    
    @Test
    void testWordBreakLongString() {
        WordBreak solution = new WordBreak();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa");
        
        assertFalse(solution.wordBreak(s, wordDict));
    }
    
    @Test
    void testWordBreakMemoizationExample1() {
        WordBreak solution = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        
        assertTrue(solution.wordBreakMemoization(s, wordDict));
    }
    
    @Test
    void testWordBreakMemoizationExample2() {
        WordBreak solution = new WordBreak();
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        
        assertTrue(solution.wordBreakMemoization(s, wordDict));
    }
    
    @Test
    void testWordBreakMemoizationExample3() {
        WordBreak solution = new WordBreak();
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        
        assertFalse(solution.wordBreakMemoization(s, wordDict));
    }
    
    @Test
    void testWordBreakOverlappingWords() {
        WordBreak solution = new WordBreak();
        String s = "abcdefg";
        List<String> wordDict = Arrays.asList("abcd", "cdef", "efg");
        
        assertTrue(solution.wordBreak(s, wordDict));
    }
}