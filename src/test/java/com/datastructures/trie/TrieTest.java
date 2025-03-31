package com.datastructures.trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Test class for Trie implementation.
 */
public class TrieTest {
    
    private Trie trie;
    
    @BeforeEach
    void setUp() {
        trie = new Trie();
    }
    
    @Test
    void testEmptyTrie() {
        assertTrue(trie.isEmpty());
        assertEquals(0, trie.countWords());
        assertEquals("", trie.longestCommonPrefix());
        assertFalse(trie.search("a"));
        assertFalse(trie.startsWith("a"));
        assertTrue(trie.autocomplete("a").isEmpty());
    }
    
    @Test
    void testInsert() {
        trie.insert("apple");
        assertFalse(trie.isEmpty());
        assertEquals(1, trie.countWords());
        assertTrue(trie.search("apple"));
        assertTrue(trie.startsWith("app"));
        assertFalse(trie.search("app"));
        
        trie.insert("app");
        assertEquals(2, trie.countWords());
        assertTrue(trie.search("app"));
        
        // Test inserting null or empty string
        trie.insert(null);
        trie.insert("");
        assertEquals(2, trie.countWords());
    }
    
    @Test
    void testSearch() {
        assertFalse(trie.search("apple"));
        
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        
        assertTrue(trie.search("apple"));
        assertTrue(trie.search("app"));
        assertTrue(trie.search("application"));
        assertFalse(trie.search("appl"));
        assertFalse(trie.search("applica"));
        assertFalse(trie.search("banana"));
        
        // Test searching for null or empty string
        assertFalse(trie.search(null));
        assertFalse(trie.search(""));
    }
    
    @Test
    void testStartsWith() {
        assertFalse(trie.startsWith("a"));
        
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        
        assertTrue(trie.startsWith("a"));
        assertTrue(trie.startsWith("ap"));
        assertTrue(trie.startsWith("app"));
        assertTrue(trie.startsWith("appl"));
        assertTrue(trie.startsWith("apple"));
        assertTrue(trie.startsWith("appli"));
        assertFalse(trie.startsWith("b"));
        assertFalse(trie.startsWith("ba"));
        
        // Test checking null or empty string
        assertFalse(trie.startsWith(null));
        assertFalse(trie.startsWith(""));
    }
    
    @Test
    void testDelete() {
        // Delete from empty trie
        assertFalse(trie.delete("apple"));
        
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        
        // Delete a word that is a prefix of another word
        assertTrue(trie.delete("app"));
        assertFalse(trie.search("app"));
        assertTrue(trie.search("apple"));
        assertTrue(trie.search("application"));
        assertTrue(trie.startsWith("app"));
        
        // Delete a word that has a prefix that is also a word
        assertTrue(trie.delete("apple"));
        assertFalse(trie.search("apple"));
        assertTrue(trie.search("application"));
        assertTrue(trie.startsWith("app"));
        
        // Delete the last word
        assertTrue(trie.delete("application"));
        assertFalse(trie.search("application"));
        assertFalse(trie.startsWith("app"));
        assertTrue(trie.isEmpty());
        
        // Delete a word that doesn't exist
        assertFalse(trie.delete("banana"));
        
        // Delete null or empty string
        assertFalse(trie.delete(null));
        assertFalse(trie.delete(""));
    }
    
    @Test
    void testAutocomplete() {
        // Autocomplete on empty trie
        assertTrue(trie.autocomplete("a").isEmpty());
        
        String[] words = {"apple", "app", "application", "banana", "band", "bean"};
        for (String word : words) {
            trie.insert(word);
        }
        
        // Autocomplete with prefix that matches multiple words
        List<String> appResults = trie.autocomplete("app");
        assertEquals(3, appResults.size());
        assertTrue(appResults.contains("apple"));
        assertTrue(appResults.contains("app"));
        assertTrue(appResults.contains("application"));
        
        // Autocomplete with prefix that matches one word
        List<String> bananaResults = trie.autocomplete("banana");
        assertEquals(1, bananaResults.size());
        assertTrue(bananaResults.contains("banana"));
        
        // Autocomplete with prefix that doesn't match any word
        List<String> noResults = trie.autocomplete("z");
        assertTrue(noResults.isEmpty());
        
        // Autocomplete with null
        assertTrue(trie.autocomplete(null).isEmpty());
    }
    
    @Test
    void testCountWords() {
        assertEquals(0, trie.countWords());
        
        trie.insert("apple");
        assertEquals(1, trie.countWords());
        
        trie.insert("app");
        assertEquals(2, trie.countWords());
        
        trie.insert("application");
        assertEquals(3, trie.countWords());
        
        trie.insert("banana");
        assertEquals(4, trie.countWords());
        
        // Delete a word
        trie.delete("app");
        assertEquals(3, trie.countWords());
        
        // Clear the trie
        trie.clear();
        assertEquals(0, trie.countWords());
    }
    
    @Test
    void testLongestCommonPrefix() {
        assertEquals("", trie.longestCommonPrefix());
        
        trie.insert("flower");
        assertEquals("flower", trie.longestCommonPrefix());
        
        trie.insert("flow");
        assertEquals("flow", trie.longestCommonPrefix());
        
        trie.insert("flight");
        assertEquals("fl", trie.longestCommonPrefix());
        
        trie.insert("cat");
        assertEquals("", trie.longestCommonPrefix());
        
        // Clear and insert words with the same prefix
        trie.clear();
        trie.insert("tree");
        trie.insert("trees");
        trie.insert("tread");
        assertEquals("tre", trie.longestCommonPrefix());
    }
    
    @Test
    void testClear() {
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        
        assertFalse(trie.isEmpty());
        assertEquals(3, trie.countWords());
        
        trie.clear();
        
        assertTrue(trie.isEmpty());
        assertEquals(0, trie.countWords());
        assertFalse(trie.search("apple"));
        assertFalse(trie.startsWith("app"));
    }
    
    @Test
    void testIsEmpty() {
        assertTrue(trie.isEmpty());
        
        trie.insert("apple");
        assertFalse(trie.isEmpty());
        
        trie.delete("apple");
        assertTrue(trie.isEmpty());
        
        // Insert and delete different words
        trie.insert("apple");
        trie.insert("banana");
        trie.delete("apple");
        assertFalse(trie.isEmpty());
        
        trie.delete("banana");
        assertTrue(trie.isEmpty());
    }
}
