package com.datastructures.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #22: Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * Time Complexity: O(4^n / sqrt(n)) - this is the nth Catalan number which represents the number of valid combinations
 * Space Complexity: O(n) for the recursion stack and to store each combination
 */
public class GenerateParentheses {
    
    /**
     * Generates all combinations of well-formed parentheses for n pairs.
     * Uses a backtracking approach to generate valid combinations.
     * 
     * @param n the number of pairs of parentheses
     * @return a list of all combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    /**
     * Backtracking method to generate valid parentheses combinations.
     * 
     * @param result the list to store the valid combinations
     * @param current the current string being built
     * @param open the count of open parentheses
     * @param close the count of close parentheses
     * @param max the maximum number of pairs allowed
     */
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: if the current string has the correct length, add it to the result
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // We can add an open parenthesis if we haven't used all of them
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // We can add a close parenthesis if there are more open than close parentheses
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
    
    /**
     * Alternative implementation using a StringBuilder for better performance.
     * 
     * @param n the number of pairs of parentheses
     * @return a list of all combinations of well-formed parentheses
     */
    public List<String> generateParenthesisEfficient(int n) {
        List<String> result = new ArrayList<>();
        backtrackEfficient(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    /**
     * Efficient backtracking method using StringBuilder.
     * 
     * @param result the list to store the valid combinations
     * @param sb the StringBuilder for building the current combination
     * @param open the count of open parentheses
     * @param close the count of close parentheses
     * @param max the maximum number of pairs allowed
     */
    private void backtrackEfficient(List<String> result, StringBuilder sb, int open, int close, int max) {
        // Base case: if the current string has the correct length, add it to the result
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }
        
        // We can add an open parenthesis if we haven't used all of them
        if (open < max) {
            sb.append('(');
            backtrackEfficient(result, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
        
        // We can add a close parenthesis if there are more open than close parentheses
        if (close < open) {
            sb.append(')');
            backtrackEfficient(result, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
    }
    
    /**
     * Provides a visual representation of how parentheses are generated.
     * 
     * @param n the number of pairs of parentheses
     * @return a string showing the generation process
     */
    public String visualizeGeneration(int n) {
        StringBuilder visualization = new StringBuilder();
        visualization.append("Generating all valid parentheses combinations for n = ").append(n).append("\n\n");
        
        if (n <= 0) {
            visualization.append("Invalid input: n must be positive.");
            return visualization.toString();
        }
        
        if (n > 4) {
            visualization.append("Visualization limited to n <= 4 due to exponential growth.\n\n");
            n = 4;
        }
        
        // Store all states for visualization
        List<ParenthesesState> states = new ArrayList<>();
        visualizeBacktrack(states, "", 0, 0, n, 0);
        
        // Print the decision tree
        int pathCount = 0;
        for (ParenthesesState state : states) {
            if (state.isComplete) {
                pathCount++;
                visualization.append(String.format("Path %d: %s (Valid)\n", pathCount, state.current));
            }
        }
        
        visualization.append("\nTotal valid combinations: ").append(pathCount).append("\n\n");
        
        // Detailed explanation
        visualization.append("How the algorithm works:\n");
        visualization.append("1. We use backtracking, keeping track of counts of open and closed parentheses.\n");
        visualization.append("2. At each step, we have two potential choices:\n");
        visualization.append("   - Add an open parenthesis '(' if we haven't used all (open < n)\n");
        visualization.append("   - Add a close parenthesis ')' if it creates a valid string (close < open)\n");
        visualization.append("3. When the string reaches length 2n, we've used all parentheses, so add it to results.\n\n");
        
        visualization.append("The key insight:\n");
        visualization.append("- To ensure well-formed parentheses, at any point, we can only add a closing\n");
        visualization.append("  parenthesis if there are more open parentheses than closed ones.\n");
        
        return visualization.toString();
    }
    
    /**
     * Helper class for visualization.
     */
    private static class ParenthesesState {
        String current;
        int open;
        int close;
        boolean isComplete;
        
        ParenthesesState(String current, int open, int close, boolean isComplete) {
            this.current = current;
            this.open = open;
            this.close = close;
            this.isComplete = isComplete;
        }
    }
    
    /**
     * Helper method for visualization.
     */
    private void visualizeBacktrack(List<ParenthesesState> states, String current, int open, int close, int max, int depth) {
        // Check if we have a complete combination
        boolean isComplete = current.length() == max * 2;
        
        // Add current state to the list
        states.add(new ParenthesesState(current, open, close, isComplete));
        
        // If complete, return
        if (isComplete) {
            return;
        }
        
        // Try adding an open parenthesis
        if (open < max) {
            visualizeBacktrack(states, current + "(", open + 1, close, max, depth + 1);
        }
        
        // Try adding a close parenthesis
        if (close < open) {
            visualizeBacktrack(states, current + ")", open, close + 1, max, depth + 1);
        }
    }
}