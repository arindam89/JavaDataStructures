package com.leetcode;

import java.util.*;

/**
 * LeetCode #127: Word Ladder (Hard)
 * 
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList 
 * is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * 
 * - Every adjacent pair of words differs by a single letter.
 * - Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * - sk == endWord
 * 
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words 
 * in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * 
 * Time Complexity: O(N * M^2) where N is the length of wordList and M is the length of each word
 * Space Complexity: O(N * M^2) for the queue and visited set
 */
public class WordLadder {
    
    /**
     * Returns the length of the shortest transformation sequence from beginWord to endWord.
     * 
     * @param beginWord the starting word
     * @param endWord the target word
     * @param wordList the dictionary of words that can be used in the transformation
     * @return the number of words in the shortest transformation sequence, or 0 if none exists
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // If begin and end words are the same, return 1 (only one word in the sequence)
        if (beginWord.equals(endWord)) {
            return 1;
        }
        
        // Convert wordList to a HashSet for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordList);
        
        // Check if endWord is in the dictionary
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        
        // Queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        // Set to keep track of visited words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        // Number of words in the transformation chain
        int level = 1;
        
        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process all words at the current level
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                
                // Try all possible one-letter transformations
                char[] wordChars = currentWord.toCharArray();
                
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    
                    // Try replacing the current character with every letter from a-z
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) {
                            continue;  // Skip the same character
                        }
                        
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        
                        // If we've found the end word, return the level + 1
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        
                        // If the new word is in the dictionary and hasn't been visited
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    
                    // Restore the original character for the next iteration
                    wordChars[j] = originalChar;
                }
            }
            
            // Move to the next level
            level++;
        }
        
        // If we reach here, there's no transformation sequence
        return 0;
    }
}