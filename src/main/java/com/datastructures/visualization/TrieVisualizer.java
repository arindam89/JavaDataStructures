package com.datastructures.visualization;

import com.datastructures.trie.Trie;
import com.datastructures.trie.TrieNode;

import java.util.*;

/**
 * Visualizer for Trie data structure.
 * Provides methods to create a text-based visualization of a Trie.
 */
public class TrieVisualizer implements DataStructureVisualizer {
    
    private Trie trie;
    private static final int NODE_WIDTH = 3;
    private static final int MAX_DEPTH = 10; // Limit to avoid excessive output
    
    /**
     * Constructs a TrieVisualizer with the given Trie.
     * 
     * @param trie the Trie to visualize
     */
    public TrieVisualizer(Trie trie) {
        this.trie = trie;
    }
    
    @Override
    public String visualize() {
        if (trie == null || trie.getRoot() == null) {
            return "Empty Trie";
        }
        
        StringBuilder visualization = new StringBuilder();
        visualization.append("Trie Visualization:\n\n");
        
        // Recursively visualize the trie
        visualizeNode(trie.getRoot(), "", "", visualization, 0, true);
        
        return visualization.toString();
    }
    
    /**
     * Recursively visualize a node in the trie.
     * 
     * @param node the node to visualize
     * @param prefix the string prefix to the current node
     * @param branch the characters representing the branch structure
     * @param visualization the StringBuilder to append the visualization
     * @param depth the current depth in the trie
     * @param lastChild whether this is the last child of its parent
     */
    private void visualizeNode(TrieNode node, String prefix, String branch, StringBuilder visualization, int depth, boolean lastChild) {
        if (depth > MAX_DEPTH) {
            if (branch.length() > 0) {
                visualization.append(branch).append("...(depth limit reached)\n");
            }
            return;
        }
        
        // Find all children of the current node
        Map<Character, TrieNode> children = new TreeMap<>(); // TreeMap for sorted keys
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.getChildren().containsKey(c)) {
                children.put(c, node.getChildren().get(c));
            }
        }
        
        // Current node representation
        String nodeType = node.isEndOfWord() ? "◉" : "○";
        String nodeLabel = (depth == 0) ? "ROOT" : nodeType;
        
        visualization.append(branch).append(nodeLabel);
        
        // Display word completion if it's end of word
        if (node.isEndOfWord() && depth > 0) {
            visualization.append(" (").append(prefix).append(")");
        }
        
        visualization.append("\n");
        
        // Check if there are children to display
        if (!children.isEmpty()) {
            // For each child
            List<Character> keys = new ArrayList<>(children.keySet());
            for (int i = 0; i < keys.size(); i++) {
                char c = keys.get(i);
                boolean isLastChild = (i == keys.size() - 1);
                
                // Create new branch string based on whether this is the last child
                String newBranch;
                if (isLastChild) {
                    newBranch = branch.replaceAll("├─", "│ ").replaceAll("└─", "  ") + "└─" + c + "─";
                } else {
                    newBranch = branch.replaceAll("├─", "│ ").replaceAll("└─", "  ") + "├─" + c + "─";
                }
                
                // Recursively visualize the child
                visualizeNode(children.get(c), prefix + c, newBranch, visualization, depth + 1, isLastChild);
            }
        }
    }
    
    /**
     * Creates a detailed visualization of the Trie with search demonstration.
     * 
     * @return a detailed string representation of the Trie
     */
    public String visualizeDetailed() {
        StringBuilder visualization = new StringBuilder();
        
        // Basic visualization
        visualization.append(visualize()).append("\n");
        
        // Add trie statistics
        Set<String> words = trie.getAllWords();
        int wordCount = words.size();
        
        visualization.append("Trie Statistics:\n");
        visualization.append("Number of words: ").append(wordCount).append("\n");
        
        // Calculate trie height
        int height = 0;
        for (String word : words) {
            height = Math.max(height, word.length());
        }
        visualization.append("Maximum depth: ").append(height).append("\n\n");
        
        // Display all words in the trie (if not too many)
        if (wordCount <= 50) {
            visualization.append("Words in trie: ").append(words).append("\n\n");
        } else {
            visualization.append("Words in trie: ").append(wordCount).append(" words (too many to display)\n\n");
        }
        
        return visualization.toString();
    }
    
    /**
     * Visualizes a search operation in the trie.
     * 
     * @param prefix the prefix to search
     * @return a visualization of the search operation
     */
    public String visualizeSearch(String prefix) {
        StringBuilder visualization = new StringBuilder();
        
        visualization.append("Trie Search Visualization:\n\n");
        visualization.append("Searching for prefix: \"").append(prefix).append("\"\n\n");
        
        // Search for the prefix and get matching words
        List<String> matchingWords = trie.autocomplete(prefix);
        
        visualization.append("Search path:\n");
        
        // Highlight the path taken to find the prefix
        TrieNode current = trie.getRoot();
        StringBuilder path = new StringBuilder();
        boolean prefixFound = true;
        
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            path.append(c);
            
            if (current.getChildren().containsKey(c)) {
                current = current.getChildren().get(c);
                visualization.append("  ").append(path).append(" ✓\n");
            } else {
                visualization.append("  ").append(path).append(" ✗ (not found)\n");
                prefixFound = false;
                break;
            }
        }
        
        visualization.append("\n");
        
        if (prefixFound) {
            if (matchingWords.isEmpty()) {
                visualization.append("No words found with prefix \"").append(prefix).append("\"\n");
            } else {
                visualization.append("Words with prefix \"").append(prefix).append("\":");
                for (String word : matchingWords) {
                    visualization.append(" ").append(word);
                }
                visualization.append("\n");
            }
        } else {
            visualization.append("Prefix \"").append(prefix).append("\" not found in trie\n");
        }
        
        return visualization.toString();
    }
}