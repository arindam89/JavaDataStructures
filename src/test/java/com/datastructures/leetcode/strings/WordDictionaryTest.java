package com.datastructures.leetcode.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.leetcode.strings.WordDictionary;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the WordDictionary implementation.
 */
public class WordDictionaryTest {
    
    private WordDictionary wordDictionary;
    
    @BeforeEach
    public void setup() {
        wordDictionary = new WordDictionary();
    }
    
    @Test
    public void testAddWord() {
        wordDictionary.addWord("hello");
        assertTrue(wordDictionary.search("hello"));
        assertFalse(wordDictionary.search("hell"));
        assertFalse(wordDictionary.search("helloo"));
    }
    
    @Test
    public void testSearchWithDot() {
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        
        assertTrue(wordDictionary.search("bad"));
        assertTrue(wordDictionary.search(".ad"));
        assertTrue(wordDictionary.search("b.."));
        assertFalse(wordDictionary.search("b..."));
        assertFalse(wordDictionary.search(".."));
    }
    
    @Test
    public void testMultipleDots() {
        wordDictionary.addWord("bat");
        wordDictionary.addWord("cat");
        wordDictionary.addWord("rat");
        
        assertTrue(wordDictionary.search("..."));
        assertTrue(wordDictionary.search("..t"));
        assertTrue(wordDictionary.search("c.."));
        assertFalse(wordDictionary.search("...."));
        assertFalse(wordDictionary.search("c..."));
    }
    
    @Test
    public void testEmptyDictionary() {
        assertFalse(wordDictionary.search("a"));
        assertFalse(wordDictionary.search("."));
    }
    
    @Test
    public void testLongerWords() {
        wordDictionary.addWord("apple");
        wordDictionary.addWord("banana");
        wordDictionary.addWord("cherry");
        
        assertTrue(wordDictionary.search("apple"));
        assertTrue(wordDictionary.search("a...."));
        assertTrue(wordDictionary.search("....."));
        assertTrue(wordDictionary.search("c.e..y"));
        assertFalse(wordDictionary.search("ap"));
        assertFalse(wordDictionary.search("appl"));
    }
    
    @Test
    public void testEdgeCases() {
        // Empty word
        wordDictionary.addWord("");
        assertTrue(wordDictionary.search(""));
        
        // Single character
        wordDictionary.addWord("a");
        assertTrue(wordDictionary.search("a"));
        assertTrue(wordDictionary.search("."));
        
        // Same word multiple times
        wordDictionary.addWord("test");
        wordDictionary.addWord("test");
        assertTrue(wordDictionary.search("test"));
    }
}