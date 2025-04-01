package com.datastructures.leetcode.strings;

import org.junit.jupiter.api.Test;

import com.leetcode.strings.ValidParentheses;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ValidParentheses implementation.
 */
public class ValidParenthesesTest {

    @Test
    void testIsValidExample1() {
        ValidParentheses solution = new ValidParentheses();
        String s = "()";
        
        assertTrue(solution.isValid(s));
    }
    
    @Test
    void testIsValidExample2() {
        ValidParentheses solution = new ValidParentheses();
        String s = "()[]{}";
        
        assertTrue(solution.isValid(s));
    }
    
    @Test
    void testIsValidExample3() {
        ValidParentheses solution = new ValidParentheses();
        String s = "(]";
        
        assertFalse(solution.isValid(s));
    }
    
    @Test
    void testIsValidNestedBrackets() {
        ValidParentheses solution = new ValidParentheses();
        String s = "([{}])";
        
        assertTrue(solution.isValid(s));
    }
    
    @Test
    void testIsValidUnbalanced() {
        ValidParentheses solution = new ValidParentheses();
        String s = "((";
        
        assertFalse(solution.isValid(s));
    }
    
    @Test
    void testIsValidWrongOrder() {
        ValidParentheses solution = new ValidParentheses();
        String s = "([)]";
        
        assertFalse(solution.isValid(s));
    }
    
    @Test
    void testIsValidEmptyString() {
        ValidParentheses solution = new ValidParentheses();
        String s = "";
        
        assertTrue(solution.isValid(s));
    }
    
    @Test
    void testIsValidSimpleExample1() {
        ValidParentheses solution = new ValidParentheses();
        String s = "()";
        
        assertTrue(solution.isValidSimple(s));
    }
    
    @Test
    void testIsValidSimpleExample2() {
        ValidParentheses solution = new ValidParentheses();
        String s = "()[]{}";
        
        assertTrue(solution.isValidSimple(s));
    }
    
    @Test
    void testIsValidSimpleExample3() {
        ValidParentheses solution = new ValidParentheses();
        String s = "(]";
        
        assertFalse(solution.isValidSimple(s));
    }
}