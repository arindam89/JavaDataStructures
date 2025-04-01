package com.leetcode.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for WordLadder implementation.
 */
public class WordLadderTest {

    @Test
    void testWordLadderExample1() {
        WordLadder solution = new WordLadder();
        
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        
        int result = solution.ladderLength(beginWord, endWord, wordList);
        
        assertEquals(5, result);
        // The transformation sequence is: hit -> hot -> dot -> dog -> cog
    }
    
    @Test
    void testWordLadderExample2() {
        WordLadder solution = new WordLadder();
        
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        
        int result = solution.ladderLength(beginWord, endWord, wordList);
        
        assertEquals(0, result);
        // The endWord "cog" is not in wordList, so no valid transformation
    }
    
    @Test
    void testWordLadderSingleLetterDifference() {
        WordLadder solution = new WordLadder();
        
        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = Arrays.asList("a", "b", "c");
        
        int result = solution.ladderLength(beginWord, endWord, wordList);
        
        assertEquals(2, result);
        // The transformation sequence is: a -> c
    }
    
    @Test
    void testWordLadderNoTransformation() {
        WordLadder solution = new WordLadder();
        
        String beginWord = "talk";
        String endWord = "play";
        List<String> wordList = Arrays.asList("tall", "tale", "roll", "poll", "pall", "pale", "sale", "sage", "page", "play");
        
        int result = solution.ladderLength(beginWord, endWord, wordList);
        
        assertEquals(0, result);
        // No valid transformation from "talk" to "play"
    }
    
    @Test
    void testWordLadderMultiplePaths() {
        WordLadder solution = new WordLadder();
        
        String beginWord = "red";
        String endWord = "tax";
        List<String> wordList = Arrays.asList("ted", "tex", "rex", "tax");
        
        int result = solution.ladderLength(beginWord, endWord, wordList);
        
        assertEquals(4, result);
        // The shortest transformation sequence is: red -> ted -> tex -> tax
    }
    
    @Test
    void testWordLadderSameStartAndEnd() {
        WordLadder solution = new WordLadder();
        
        String beginWord = "dog";
        String endWord = "dog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        
        int result = solution.ladderLength(beginWord, endWord, wordList);
        
        assertEquals(1, result);
        // Start and end words are the same
    }
    
    @Test
    void testWordLadderEmptyWordList() {
        WordLadder solution = new WordLadder();
        
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList();
        
        int result = solution.ladderLength(beginWord, endWord, wordList);
        
        assertEquals(0, result);
        // Empty word list, no valid transformation
    }
}