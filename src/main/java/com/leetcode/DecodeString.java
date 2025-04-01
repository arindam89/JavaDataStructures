package com.leetcode;

import java.util.Stack;

/**
 * LeetCode Problem: Decode String
 * 
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed to be
 * a positive integer.
 * 
 * You may assume that the input string is always valid; there are no extra white spaces,
 * square brackets are well-formed, etc. Furthermore, you may assume that the original
 * data does not contain any digits and that digits are only for those repeat numbers, k.
 * 
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * 
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * 
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * 
 * Constraints:
 * - 1 <= s.length <= 30
 * - s consists of lowercase English letters, digits, and square brackets '[]'.
 * - s is guaranteed to be a valid input.
 * - All the integers in s are in the range [1, 300].
 * 
 * This problem demonstrates using a stack data structure to handle nested operations.
 */
public class DecodeString {
    
    /**
     * Decodes the input string according to the encoding rule.
     * Uses a stack-based approach to handle nested encodings.
     * 
     * Time Complexity: O(n) where n is the length of the decoded string
     * Space Complexity: O(m) where m is the maximum nesting level
     * 
     * @param s the encoded string
     * @return the decoded string
     */
    public String decodeString(String s) {
        // Handle edge cases
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        Stack<Integer> countStack = new Stack<>(); // Stack to store repeat counts
        Stack<StringBuilder> stringStack = new Stack<>(); // Stack to store partially built strings
        StringBuilder currentString = new StringBuilder(); // Current string being built
        int currentCount = 0; // Current repeat count
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Accumulate multiple digits into a number
                currentCount = currentCount * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current count and string onto the stacks
                countStack.push(currentCount);
                stringStack.push(currentString);
                
                // Reset for the next level
                currentCount = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                // Pop the most recent count and string
                int repeatCount = countStack.pop();
                StringBuilder previousString = stringStack.pop();
                
                // Repeat the current string 'repeatCount' times and append to previous string
                for (int i = 0; i < repeatCount; i++) {
                    previousString.append(currentString);
                }
                
                // Update the current string to the result
                currentString = previousString;
            } else {
                // Regular character, append to the current string
                currentString.append(c);
            }
        }
        
        return currentString.toString();
    }
    
    /**
     * Alternative recursive implementation for decoding the string.
     * 
     * @param s the encoded string
     * @return the decoded string
     */
    public String decodeStringRecursive(String s) {
        // Use a wrapper for the index to be passed by reference
        int[] index = new int[1];
        return decodeStringHelper(s, index);
    }
    
    /**
     * Helper method for recursive decoding.
     * 
     * @param s the encoded string
     * @param index current position in the string (wrapper to pass by reference)
     * @return partially decoded string for the current level
     */
    private String decodeStringHelper(String s, int[] index) {
        StringBuilder result = new StringBuilder();
        
        while (index[0] < s.length() && s.charAt(index[0]) != ']') {
            if (!Character.isDigit(s.charAt(index[0]))) {
                // Regular character
                result.append(s.charAt(index[0]++));
            } else {
                // Parse the number
                int count = 0;
                while (index[0] < s.length() && Character.isDigit(s.charAt(index[0]))) {
                    count = count * 10 + (s.charAt(index[0]++) - '0');
                }
                
                // Skip the opening bracket
                index[0]++; // '['
                
                // Recursively decode the substring
                String decodedString = decodeStringHelper(s, index);
                
                // Skip the closing bracket
                index[0]++; // ']'
                
                // Repeat the decoded string 'count' times
                for (int i = 0; i < count; i++) {
                    result.append(decodedString);
                }
            }
        }
        
        return result.toString();
    }
}