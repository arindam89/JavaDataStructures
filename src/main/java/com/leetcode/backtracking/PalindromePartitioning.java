package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 */
public class PalindromePartitioning {
    
    /**
     * Main method to find all possible palindrome partitions.
     * @param s Input string to be partitioned
     * @return List of all possible palindrome partitions
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }
    
    /**
     * Backtracking helper method to find palindrome partitions.
     * 
     * @param result The final list containing all valid partitions
     * @param current The current partition being built
     * @param s The input string
     * @param start The starting index for current partition
     */
    private void backtrack(List<List<String>> result, List<String> current, String s, int start) {
        // Base case: if we've processed the entire string
        if (start >= s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try all possible substrings starting from current position
        for (int end = start; end < s.length(); end++) {
            // If current substring is palindrome, add it to current partition
            if (isPalindrome(s, start, end)) {
                // Add current palindrome substring to partition
                current.add(s.substring(start, end + 1));
                
                // Recursively partition remaining string
                backtrack(result, current, s, end + 1);
                
                // Backtrack: remove current substring to try different partition
                current.remove(current.size() - 1);
            }
        }
    }
    
    /**
     * Helper method to check if a substring is palindrome.
     * 
     * @param s The input string
     * @param start Starting index of substring
     * @param end Ending index of substring
     * @return true if substring is palindrome, false otherwise
     */
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
} 