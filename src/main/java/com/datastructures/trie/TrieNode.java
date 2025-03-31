package com.datastructures.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Node class for a Trie data structure.
 * Each node contains a map of child nodes and a flag indicating if the node
 * represents the end of a word.
 */
public class TrieNode {
    // Map to store child nodes, where key is a character and value is the child node
    private Map<Character, TrieNode> children;
    
    // Flag to indicate if this node represents the end of a word
    private boolean isEndOfWord;
    
    /**
     * Constructor to create an empty trie node.
     */
    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
    
    /**
     * Get the map of all child nodes.
     * 
     * @return the map of child nodes
     */
    public Map<Character, TrieNode> getChildren() {
        return children;
    }
    
    /**
     * Get a specific child node for a character.
     * 
     * @param ch the character to get the child for
     * @return the child node, or null if no child exists for the character
     */
    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
    
    /**
     * Add a child node for a character.
     * 
     * @param ch the character to add the child for
     * @return the newly created or existing child node
     */
    public TrieNode addChild(char ch) {
        if (!children.containsKey(ch)) {
            children.put(ch, new TrieNode());
        }
        return children.get(ch);
    }
    
    /**
     * Check if a child node exists for a character.
     * 
     * @param ch the character to check for
     * @return true if a child exists for the character, false otherwise
     */
    public boolean hasChild(char ch) {
        return children.containsKey(ch);
    }
    
    /**
     * Remove a child node for a character.
     * 
     * @param ch the character to remove the child for
     * @return true if the child was removed, false if it didn't exist
     */
    public boolean removeChild(char ch) {
        if (children.containsKey(ch)) {
            children.remove(ch);
            return true;
        }
        return false;
    }
    
    /**
     * Check if this node has any children.
     * 
     * @return true if the node has at least one child, false otherwise
     */
    public boolean hasChildren() {
        return !children.isEmpty();
    }
    
    /**
     * Get the number of children.
     * 
     * @return the number of child nodes
     */
    public int getChildCount() {
        return children.size();
    }
    
    /**
     * Check if this node represents the end of a word.
     * 
     * @return true if this node is the end of a word, false otherwise
     */
    public boolean isEndOfWord() {
        return isEndOfWord;
    }
    
    /**
     * Set whether this node represents the end of a word.
     * 
     * @param isEndOfWord true if this node should represent the end of a word, false otherwise
     */
    public void setEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }
}
