package com.datastructures.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Problem: Design Add and Search Words Data Structure (Medium)
 * 
 * Design a data structure that supports adding new words and finding if a 
 * string matches any previously added string.
 * 
 * Implement the WordDictionary class:
 * - WordDictionary() Initializes the object.
 * - void addWord(word) Adds word to the data structure, it can be matched later.
 * - boolean search(word) Returns true if there is any string in the data structure 
 *   that matches word, or false otherwise. word may contain dots '.' where dots 
 *   can be matched with any letter.
 * 
 * Example:
 * Input:
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output:
 * [null,null,null,null,false,true,true,true]
 */
public class WordDictionary {
    private TrieNode root;

    /**
     * Inner class to represent TrieNode
     */
    private class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEndOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    /**
     * Initializes the WordDictionary.
     */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /**
     * Adds a word into the data structure.
     * 
     * @param word the word to add
     */
    public void addWord(String word) {
        TrieNode current = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            
            current = node;
        }
        
        current.isEndOfWord = true;
    }
    
    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     * 
     * @param word the word to search for
     * @return true if the word is found, false otherwise
     */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    /**
     * Helper method for search to handle the dot character.
     * 
     * @param word the word to search for
     * @param index the current index in the word
     * @param node the current node in the trie
     * @return true if the word is found, false otherwise
     */
    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }
        
        char ch = word.charAt(index);
        
        if (ch == '.') {
            // Wildcard character, need to check all children
            for (TrieNode child : node.children.values()) {
                if (searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            
            return false;
        } else {
            // Regular character, check specific child
            TrieNode child = node.children.get(ch);
            
            if (child == null) {
                return false;
            }
            
            return searchHelper(word, index + 1, child);
        }
    }
    
    /**
     * Returns a string representation of the WordDictionary.
     * 
     * @return a string with the number of entries in the dictionary
     */
    @Override
    public String toString() {
        return "WordDictionary [size=" + countWords(root) + "]";
    }
    
    /**
     * Counts the number of words in the trie.
     * 
     * @param node the current node
     * @return the number of words in the trie
     */
    private int countWords(TrieNode node) {
        int count = 0;
        
        if (node.isEndOfWord) {
            count++;
        }
        
        for (TrieNode child : node.children.values()) {
            count += countWords(child);
        }
        
        return count;
    }
}