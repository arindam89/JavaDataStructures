package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Problem: Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent. Return the answer in any order.
 * 
 * A mapping of digits to letters (just like on telephone buttons) is given below:
 * 2 -> abc
 * 3 -> def
 * 4 -> ghi
 * 5 -> jkl
 * 6 -> mno
 * 7 -> pqrs
 * 8 -> tuv
 * 9 -> wxyz
 * 
 * Example:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinations {
    
    // Map each digit to its corresponding letters
    private static final Map<Character, String> DIGIT_MAP = new HashMap<>();
    static {
        DIGIT_MAP.put('2', "abc");
        DIGIT_MAP.put('3', "def");
        DIGIT_MAP.put('4', "ghi");
        DIGIT_MAP.put('5', "jkl");
        DIGIT_MAP.put('6', "mno");
        DIGIT_MAP.put('7', "pqrs");
        DIGIT_MAP.put('8', "tuv");
        DIGIT_MAP.put('9', "wxyz");
    }
    
    /**
     * Main method to find all possible letter combinations.
     * @param digits String containing digits from 2-9
     * @return List of all possible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Handle empty input
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }
    
    /**
     * Backtracking helper method to generate letter combinations.
     * 
     * @param result The final list containing all combinations
     * @param current The current combination being built
     * @param digits The input string of digits
     * @param index Current index in digits string
     */
    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Base case: if we've processed all digits
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get the letters corresponding to current digit
        String letters = DIGIT_MAP.get(digits.charAt(index));
        
        // Try each letter for current digit
        for (char letter : letters.toCharArray()) {
            // Add current letter to combination
            current.append(letter);
            
            // Recursively process next digit
            backtrack(result, current, digits, index + 1);
            
            // Backtrack: remove current letter to try next one
            current.setLength(current.length() - 1);
        }
    }
} 