package com.datastructures.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of a Trie (prefix tree) data structure.
 * A Trie is an efficient information retrieval data structure that is
 * commonly used for searching for words in a dictionary, auto-complete
 * suggestions, spell-checking, and more.
 * 
 * Time Complexity:
 * - Insert: O(m) where m is the length of the key
 * - Search: O(m) where m is the length of the key
 * - Delete: O(m) where m is the length of the key
 * - Prefix Search: O(m + k) where m is the length of the prefix and k is the number of matches
 * 
 * Space Complexity: O(n*m) where n is the number of keys and m is the average key length
 */
public class Trie {
    
    // Root node of the trie
    private TrieNode root;
    
    /**
     * Constructs an empty trie.
     */
    public Trie() {
        root = new TrieNode();
    }
    
    /**
     * Gets the root node of the trie.
     * 
     * @return the root node
     */
    public TrieNode getRoot() {
        return root;
    }
    
    /**
     * Inserts a word into the trie.
     * Time Complexity: O(m) where m is the length of the word
     * 
     * @param word the word to insert
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        
        TrieNode current = root;
        
        // Traverse the trie for each character in the word
        for (char ch : word.toCharArray()) {
            // Add the character to the trie if it doesn't exist
            current = current.addChild(ch);
        }
        
        // Mark the end of the word
        current.setEndOfWord(true);
    }
    
    /**
     * Searches for a word in the trie.
     * Time Complexity: O(m) where m is the length of the word
     * 
     * @param word the word to search for
     * @return true if the word is found, false otherwise
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        
        TrieNode node = searchPrefix(word);
        
        // Return true if the node exists and it's the end of a word
        return node != null && node.isEndOfWord();
    }
    
    /**
     * Searches for a prefix in the trie.
     * Time Complexity: O(m) where m is the length of the prefix
     * 
     * @param prefix the prefix to search for
     * @return true if the prefix is found, false otherwise
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        
        // Return true if the prefix node exists
        return searchPrefix(prefix) != null;
    }
    
    /**
     * Helper method to find the node that represents a prefix.
     * 
     * @param prefix the prefix to search for
     * @return the node representing the last character of the prefix, or null if not found
     */
    private TrieNode searchPrefix(String prefix) {
        TrieNode current = root;
        
        // Traverse the trie for each character in the prefix
        for (char ch : prefix.toCharArray()) {
            // If the character doesn't exist, the prefix is not in the trie
            if (!current.hasChild(ch)) {
                return null;
            }
            
            // Move to the next node
            current = current.getChild(ch);
        }
        
        return current;
    }
    
    /**
     * Deletes a word from the trie.
     * Time Complexity: O(m) where m is the length of the word
     * 
     * @param word the word to delete
     * @return true if the word was deleted, false if it wasn't found
     */
    public boolean delete(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        
        return delete(root, word, 0);
    }
    
    /**
     * Helper method for recursively deleting a word from the trie.
     * 
     * @param current the current node
     * @param word the word to delete
     * @param index the current index in the word
     * @return true if the word was deleted, false otherwise
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            // If the word doesn't end here, it doesn't exist in the trie
            if (!current.isEndOfWord()) {
                return false;
            }
            
            // Mark this node as not the end of a word
            current.setEndOfWord(false);
            
            // Return true if this node has no children, indicating it can be deleted
            return !current.hasChildren();
        }
        
        char ch = word.charAt(index);
        TrieNode child = current.getChild(ch);
        
        // If the character doesn't exist, the word is not in the trie
        if (child == null) {
            return false;
        }
        
        // Recursively delete the rest of the word
        boolean shouldDeleteChild = delete(child, word, index + 1);
        
        // If the child should be deleted and it's not the end of another word
        if (shouldDeleteChild && !child.isEndOfWord()) {
            current.removeChild(ch);
            
            // Return true if this node has no children, indicating it can be deleted
            return !current.hasChildren();
        }
        
        return false;
    }
    
    /**
     * Finds all words in the trie that start with a given prefix.
     * Time Complexity: O(m + k) where m is the length of the prefix and k is the total length of all matching words
     * 
     * @param prefix the prefix to search for
     * @return a list of words that start with the prefix
     */
    public List<String> autocomplete(String prefix) {
        List<String> result = new ArrayList<>();
        
        if (prefix == null) {
            return result;
        }
        
        TrieNode prefixNode = searchPrefix(prefix);
        
        // If the prefix is not found, return an empty list
        if (prefixNode == null) {
            return result;
        }
        
        // Collect all words starting with the prefix
        collectWords(prefixNode, new StringBuilder(prefix), result);
        
        return result;
    }
    
    /**
     * Helper method to recursively collect all words starting from a node.
     * 
     * @param node the current node
     * @param prefix the current prefix
     * @param result the list to store the words
     */
    private void collectWords(TrieNode node, StringBuilder prefix, List<String> result) {
        // If this node is the end of a word, add it to the result
        if (node.isEndOfWord()) {
            result.add(prefix.toString());
        }
        
        // Recursively visit all child nodes
        for (Map.Entry<Character, TrieNode> entry : node.getChildren().entrySet()) {
            // Add the character to the prefix
            prefix.append(entry.getKey());
            
            // Recursively collect words
            collectWords(entry.getValue(), prefix, result);
            
            // Remove the character from the prefix (backtracking)
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
    
    /**
     * Counts the number of words in the trie.
     * Time Complexity: O(n) where n is the number of nodes in the trie
     * 
     * @return the number of words in the trie
     */
    public int countWords() {
        return countWords(root);
    }
    
    /**
     * Helper method to recursively count the number of words starting from a node.
     * 
     * @param node the current node
     * @return the number of words in the subtrie rooted at the node
     */
    private int countWords(TrieNode node) {
        int count = 0;
        
        // If this node is the end of a word, count it
        if (node.isEndOfWord()) {
            count++;
        }
        
        // Recursively count words in all child nodes
        for (TrieNode child : node.getChildren().values()) {
            count += countWords(child);
        }
        
        return count;
    }
    
    /**
     * Returns the longest common prefix of all words in the trie.
     * Time Complexity: O(n) where n is the number of nodes in the trie
     * 
     * @return the longest common prefix
     */
    public String longestCommonPrefix() {
        if (root == null || !root.hasChildren()) {
            return "";
        }
        
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;
        
        // Follow the path as long as there's only one child
        while (current.getChildCount() == 1 && !current.isEndOfWord()) {
            // Get the only character
            char ch = current.getChildren().keySet().iterator().next();
            prefix.append(ch);
            
            // Move to the next node
            current = current.getChild(ch);
        }
        
        return prefix.toString();
    }
    
    /**
     * Clears the trie by removing all words.
     */
    public void clear() {
        root = new TrieNode();
    }
    
    /**
     * Checks if the trie is empty.
     * 
     * @return true if the trie is empty, false otherwise
     */
    public boolean isEmpty() {
        return !root.hasChildren() && !root.isEndOfWord();
    }
    
    /**
     * Gets all words stored in the trie.
     * 
     * @return a set of all words in the trie
     */
    public Set<String> getAllWords() {
        Set<String> words = new HashSet<>();
        StringBuilder prefix = new StringBuilder();
        collectAllWords(root, prefix, words);
        return words;
    }
    
    /**
     * Helper method to recursively collect all words in the trie.
     * 
     * @param node the current node
     * @param prefix the current prefix
     * @param words the set to store the words
     */
    private void collectAllWords(TrieNode node, StringBuilder prefix, Set<String> words) {
        if (node.isEndOfWord()) {
            words.add(prefix.toString());
        }
        
        for (Map.Entry<Character, TrieNode> entry : node.getChildren().entrySet()) {
            char c = entry.getKey();
            prefix.append(c);
            collectAllWords(entry.getValue(), prefix, words);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
