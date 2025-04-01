package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Test cases for the Generate Parentheses problem.
 */
public class GenerateParenthesesTest {
    
    @Test
    public void testGenerateParenthesisExample1() {
        GenerateParentheses solution = new GenerateParentheses();
        
        List<String> result = solution.generateParenthesis(3);
        
        // Expected output for n=3: ["((()))","(()())","(())()","()(())","()()()"]
        // Order doesn't matter, so convert to sets for comparison
        Set<String> expectedSet = new HashSet<>(Arrays.asList(
            "((()))", "(()())", "(())()", "()(())", "()()()"
        ));
        Set<String> resultSet = new HashSet<>(result);
        
        assertEquals(expectedSet, resultSet);
        assertEquals(5, result.size());
    }
    
    @Test
    public void testGenerateParenthesisExample2() {
        GenerateParentheses solution = new GenerateParentheses();
        
        List<String> result = solution.generateParenthesis(1);
        
        // Expected output for n=1: ["()"]
        assertEquals(1, result.size());
        assertEquals("()", result.get(0));
    }
    
    @Test
    public void testGenerateParenthesisN2() {
        GenerateParentheses solution = new GenerateParentheses();
        
        List<String> result = solution.generateParenthesis(2);
        
        // Expected output for n=2: ["(())","()()"]
        // Order doesn't matter, so convert to sets for comparison
        Set<String> expectedSet = new HashSet<>(Arrays.asList("(())", "()()"));
        Set<String> resultSet = new HashSet<>(result);
        
        assertEquals(expectedSet, resultSet);
        assertEquals(2, result.size());
    }
    
    @Test
    public void testGenerateParenthesisN4() {
        GenerateParentheses solution = new GenerateParentheses();
        
        List<String> result = solution.generateParenthesis(4);
        
        // Expected output size for n=4 is the Catalan number C(4) = 14
        assertEquals(14, result.size());
        
        // Check all results are unique
        Set<String> uniqueResults = new HashSet<>(result);
        assertEquals(14, uniqueResults.size());
        
        // Check all strings have correct length
        for (String s : result) {
            assertEquals(8, s.length()); // 2 * n = 8
        }
    }
    
    @Test
    public void testGenerateParenthesisN0() {
        GenerateParentheses solution = new GenerateParentheses();
        
        List<String> result = solution.generateParenthesis(0);
        
        // Expected output for n=0: [""] (empty string)
        assertEquals(1, result.size());
        assertEquals("", result.get(0));
    }
    
    @Test
    public void testEfficientImplementation() {
        GenerateParentheses solution = new GenerateParentheses();
        
        for (int n = 0; n <= 5; n++) {
            List<String> result1 = solution.generateParenthesis(n);
            List<String> result2 = solution.generateParenthesisEfficient(n);
            
            // Convert to sets to ignore order
            Set<String> set1 = new HashSet<>(result1);
            Set<String> set2 = new HashSet<>(result2);
            
            assertEquals(set1, set2, "Both methods should produce same results for n = " + n);
            assertEquals(result1.size(), result2.size(), "Both methods should produce same number of results for n = " + n);
        }
    }
    
    @Test
    public void testVisualization() {
        GenerateParentheses solution = new GenerateParentheses();
        
        String visualization = solution.visualizeGeneration(3);
        
        assertNotNull(visualization);
        assertTrue(visualization.contains("Total valid combinations: 5"));
        assertTrue(visualization.contains("How the algorithm works"));
    }
    
    @Test
    public void testValidParentheses() {
        GenerateParentheses solution = new GenerateParentheses();
        
        for (int n = 1; n <= 4; n++) {
            List<String> result = solution.generateParenthesis(n);
            
            // Check that all generated strings have valid parentheses
            for (String s : result) {
                assertTrue(isValidParentheses(s), "String should have valid parentheses: " + s);
            }
        }
    }
    
    /**
     * Helper method to check if a string has valid parentheses.
     */
    private boolean isValidParentheses(String s) {
        int count = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                
                // If at any point we have more closing than opening parentheses, it's invalid
                if (count < 0) {
                    return false;
                }
            }
        }
        
        // A valid string should have balanced parentheses (count == 0)
        return count == 0;
    }
}