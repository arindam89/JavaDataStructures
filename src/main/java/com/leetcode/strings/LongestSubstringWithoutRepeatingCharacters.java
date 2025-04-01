package com.leetcode.strings;

import java.util.*;

/**
 * LeetCode Problem: Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces.
 * 
 * This problem demonstrates using the sliding window technique with efficient character lookups.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    
    /**
     * Finds the length of the longest substring without repeating characters.
     * Uses a sliding window approach with a HashMap.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(min(m, n)) where m is the size of the character set and n is the length of the string
     * 
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        // Handle edge cases
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        // Map to store the most recent index of each character
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        
        // Sliding window approach
        for (int i = 0, j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);
            
            // If the character is already in the current window, move the left pointer
            if (charMap.containsKey(currentChar)) {
                // Move i to the position after the last occurrence of currentChar
                // Math.max ensures i doesn't move backward
                i = Math.max(i, charMap.get(currentChar) + 1);
            }
            
            // Update the maximum length
            maxLength = Math.max(maxLength, j - i + 1);
            
            // Update the character's most recent position
            charMap.put(currentChar, j);
        }
        
        return maxLength;
    }
    
    /**
     * Alternative implementation using a sliding window with an array for character lookup.
     * This is more efficient for ASCII characters.
     * 
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstringOptimized(String s) {
        // Handle edge cases
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        // Array to store the index of each character (assuming ASCII)
        int[] lastIndex = new int[128]; // For ASCII characters
        Arrays.fill(lastIndex, -1); // Initialize with -1
        
        int maxLength = 0;
        int startIndex = 0; // Start of current window
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // If the character was seen before in the current window, update the start
            if (lastIndex[currentChar] >= startIndex) {
                startIndex = lastIndex[currentChar] + 1;
            }
            
            // Update the maximum length
            maxLength = Math.max(maxLength, i - startIndex + 1);
            
            // Update the last index of the current character
            lastIndex[currentChar] = i;
        }
        
        return maxLength;
    }
}