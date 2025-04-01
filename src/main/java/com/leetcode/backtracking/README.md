# Backtracking Problems

This directory contains solutions to common backtracking problems. Backtracking is an algorithmic technique that considers searching every possible combination in order to solve a computational problem.

## Key Concepts of Backtracking

1. **Choice**: At each step, we make a choice from available options
2. **Constraints**: We only make valid choices that satisfy problem constraints
3. **Goal**: We have a target state we're trying to reach
4. **State Management**: We need to undo our choices (backtrack) when they don't lead to a solution

## Common Patterns

1. **Base Case**: Define when to stop recursion (success/failure)
2. **Choice Making**: Try each possible choice at current state
3. **State Update**: Make the choice and update current state
4. **Recursion**: Move to next state with updated choices
5. **Backtracking**: Undo the choice before trying next option

## Problems and Solutions

### 1. Subsets
- **Problem**: Generate all possible subsets of an array of distinct integers
- **Key Points**:
  - Each element has two choices: include or exclude
  - Order doesn't matter (combinations, not permutations)
  - Time Complexity: O(2^n)
  - Space Complexity: O(n) for recursion stack
- **Interview Tips**:
  - Mention that this is a power set problem
  - Discuss both recursive and iterative solutions
  - Consider bit manipulation approach for optimization

### 2. Combination Sum
- **Problem**: Find all combinations of numbers that sum to target
- **Key Points**:
  - Can reuse same number multiple times
  - Need to avoid duplicate combinations
  - Sort input for optimization
  - Time Complexity: O(N^(T/M)) where T is target and M is minimal value
- **Interview Tips**:
  - Discuss how sorting helps avoid duplicates
  - Explain why we pass index to avoid duplicates
  - Consider constraints on input values

### 3. Combination Sum II
- **Problem**: Find combinations that sum to target, each number used once
- **Key Points**:
  - Cannot reuse same element
  - Must handle duplicates in input
  - Time Complexity: O(2^n)
- **Interview Tips**:
  - Explain difference from Combination Sum I
  - Discuss duplicate handling technique
  - Show how sorting helps in skipping duplicates

### 4. Permutations
- **Problem**: Generate all possible permutations of distinct integers
- **Key Points**:
  - Order matters
  - No duplicates in input
  - Time Complexity: O(n!)
  - Space Complexity: O(n)
- **Interview Tips**:
  - Explain swap-based vs visited array approach
  - Discuss trade-offs between different approaches
  - Mention how to handle duplicates if asked

### 5. Subsets II
- **Problem**: Generate all possible subsets with duplicate numbers
- **Key Points**:
  - Must handle duplicates in input
  - Need to avoid duplicate subsets
  - Time Complexity: O(2^n)
- **Interview Tips**:
  - Compare with original Subsets problem
  - Explain duplicate handling strategy
  - Discuss importance of sorting

### 6. Word Search
- **Problem**: Find if a word exists in a 2D board
- **Key Points**:
  - DFS with backtracking
  - Mark visited cells
  - Time Complexity: O(N * M * 4^L) where L is word length
- **Interview Tips**:
  - Discuss optimization techniques
  - Explain visited cell marking strategy
  - Consider edge cases like empty board/word

### 7. Palindrome Partitioning
- **Problem**: Find all possible palindrome decompositions of a string
- **Key Points**:
  - Check palindrome property
  - Generate all possible partitions
  - Time Complexity: O(N * 2^N)
- **Interview Tips**:
  - Discuss palindrome checking optimization
  - Consider DP for palindrome verification
  - Explain time complexity analysis

### 8. Letter Combinations of Phone Number
- **Problem**: Generate all possible letter combinations from phone digits
- **Key Points**:
  - Map digits to letters
  - Generate all combinations
  - Time Complexity: O(4^N) worst case
- **Interview Tips**:
  - Discuss different ways to store digit-to-letter mapping
  - Consider input validation
  - Explain why StringBuilder is better than String

### 9. N Queens
- **Problem**: Place N queens on NxN board without conflicts
- **Key Points**:
  - Check row, column, and diagonals
  - Generate valid board configurations
  - Time Complexity: O(N!)
- **Interview Tips**:
  - Explain optimization techniques
  - Discuss different ways to check validity
  - Consider symmetry optimizations

## General Interview Tips for Backtracking

1. **Problem Analysis**:
   - Identify if problem needs all solutions or just one
   - Determine what makes a valid solution
   - Identify constraints and edge cases

2. **Solution Structure**:
   - Start with base cases
   - Define state clearly
   - Implement choice-making logic
   - Handle backtracking properly

3. **Optimization Techniques**:
   - Early pruning of invalid paths
   - Sorting input when helpful
   - Using appropriate data structures
   - Consider space-time tradeoffs

4. **Common Pitfalls**:
   - Forgetting to backtrack
   - Not handling duplicates properly
   - Missing base cases
   - Incorrect state management

5. **Testing**:
   - Test with empty/null inputs
   - Consider boundary cases
   - Verify all valid solutions are found
   - Check for duplicate solutions

## Time Complexity Analysis
- Most backtracking solutions are exponential
- Common complexities:
  - Subsets: O(2^n)
  - Permutations: O(n!)
  - Combinations: O(2^n)
  - N-Queens: O(N!)

Remember: In interviews, it's important to not just solve the problem but also explain your thought process, discuss trade-offs, and consider optimizations.
