package com.leetcode.strings;

import java.util.*;

/**
 * LeetCode Problem: Word Break
 * 
 * Given a string s and a dictionary of strings wordDict, return true if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * 
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 * 
 * Constraints:
 * - 1 <= s.length <= 300
 * - 1 <= wordDict.length <= 1000
 * - 1 <= wordDict[i].length <= 20
 * - s and wordDict[i] consist of only lowercase English letters
 * - All the strings of wordDict are unique
 * 
 * This problem demonstrates using dynamic programming and efficient word lookups with a hash set.
 */
public class WordBreak {
    
    /**
     * Determines if a string can be segmented into words from the dictionary.
     * Uses dynamic programming approach.
     * 
     * Time Complexity: O(n^2) where n is the length of the string
     * Space Complexity: O(n + m) where m is the size of the dictionary
     * 
     * @param s the input string to segment
     * @param wordDict the dictionary containing valid words
     * @return true if the string can be segmented, false otherwise
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // Handle edge cases
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        
        // Convert wordDict to a set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // Create a DP array where dp[i] represents whether s[0...i-1] can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string can always be segmented
        
        // Fill the DP array
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If s[0...j-1] can be segmented and s[j...i-1] is a word in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
    /**
     * Alternative solution using memoization (top-down DP).
     * 
     * @param s the input string to segment
     * @param wordDict the dictionary containing valid words
     * @return true if the string can be segmented, false otherwise
     */
    public boolean wordBreakMemoization(String s, List<String> wordDict) {
        // Handle edge cases
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        
        // Convert wordDict to a set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // Memo to avoid recomputing subproblems
        // memo[i] = true if s[i...end] can be segmented
        Boolean[] memo = new Boolean[s.length()];
        
        return canSegment(s, wordSet, 0, memo);
    }
    
    /**
     * Helper method for memoization approach.
     */
    private boolean canSegment(String s, Set<String> wordSet, int start, Boolean[] memo) {
        // Base case: we've reached the end of the string
        if (start == s.length()) {
            return true;
        }
        
        // If we've already computed this subproblem
        if (memo[start] != null) {
            return memo[start];
        }
        
        // Try all possible words starting at 'start'
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordSet.contains(prefix) && canSegment(s, wordSet, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        
        // If no valid segmentation found
        memo[start] = false;
        return false;
    }
}