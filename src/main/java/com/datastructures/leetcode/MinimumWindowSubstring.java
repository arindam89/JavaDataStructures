package com.datastructures.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #76: Minimum Window Substring (Hard)
 * 
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring
 * of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * Time Complexity: O(m + n) where m is the length of s and n is the length of t
 * Space Complexity: O(m + n)
 */
public class MinimumWindowSubstring {
    
    /**
     * Finds the minimum window substring of s that contains all characters of t.
     * 
     * @param s the source string
     * @param t the target string
     * @return the minimum window substring or empty string if not found
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        // Character frequency map for string t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        
        int required = targetMap.size(); // Number of unique characters in t
        int formed = 0; // Number of unique characters in t found in the current window
        
        // Window character frequency map
        Map<Character, Integer> windowMap = new HashMap<>();
        
        // Sliding window pointers
        int left = 0;
        int right = 0;
        
        // Result tracking
        int[] result = {-1, 0, 0}; // [window length, left, right]
        
        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            
            // Check if we have all occurrences of the current character
            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }
            
            // Try to minimize the window by moving the left pointer
            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                // Update result if this window is smaller
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }
                
                // Remove the leftmost character from the window
                windowMap.put(c, windowMap.get(c) - 1);
                
                // If this character was part of t and removing it makes us fall below the required frequency
                if (targetMap.containsKey(c) && windowMap.get(c).intValue() < targetMap.get(c).intValue()) {
                    formed--;
                }
                
                // Move left pointer
                left++;
            }
            
            // Move right pointer
            right++;
        }
        
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}