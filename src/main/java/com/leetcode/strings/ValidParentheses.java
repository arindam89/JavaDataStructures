package com.leetcode.strings;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem: Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * 
 * Constraints:
 * - 1 <= s.length <= 10^4
 * - s consists of parentheses only '()[]{}'
 * 
 * This problem demonstrates using a stack data structure to match opening and closing brackets.
 */
public class ValidParentheses {
    
    /**
     * Determines if the input string has valid parentheses.
     * Uses a stack to match opening and closing brackets.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) in the worst case if all chars are opening brackets
     * 
     * @param s the input string containing only parentheses
     * @return true if the parentheses are valid, false otherwise
     */
    public boolean isValid(String s) {
        // Handle edge cases
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        // Use a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Map to store the mapping of closing to opening brackets
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        
        for (char c : s.toCharArray()) {
            // If it's a closing bracket
            if (bracketMap.containsKey(c)) {
                // Get the top element if stack is not empty, or use a dummy value
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                
                // If the top element doesn't match the corresponding opening bracket
                if (topElement != bracketMap.get(c)) {
                    return false;
                }
            } else {
                // It's an opening bracket, push onto the stack
                stack.push(c);
            }
        }
        
        // If the stack is empty, all brackets were properly matched
        return stack.isEmpty();
    }
    
    /**
     * Alternative implementation without using a HashMap.
     * 
     * @param s the input string containing only parentheses
     * @return true if the parentheses are valid, false otherwise
     */
    public boolean isValidSimple(String s) {
        // Handle edge cases
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        // Use a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // Push opening brackets onto the stack
                stack.push(c);
            } else {
                // For closing brackets, check if the stack is empty
                if (stack.isEmpty()) {
                    return false;
                }
                
                // Check if the closing bracket matches the top opening bracket
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets were properly matched
        return stack.isEmpty();
    }
}