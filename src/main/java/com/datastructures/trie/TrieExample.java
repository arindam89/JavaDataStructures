package com.datastructures.trie;

import java.util.List;

/**
 * Example class to demonstrate the usage of Trie implementation.
 * This class contains a method that shows different operations
 * that can be performed on a trie.
 */
public class TrieExample {
    
    /**
     * Runs examples demonstrating trie operations.
     */
    public static void runExample() {
        // Create a new trie
        Trie trie = new Trie();
        
        // Example 1: Inserting words
        System.out.println("Inserting words into the trie:");
        String[] words = {"apple", "app", "application", "banana", "band", "bean", "car", "card", "care", "careful"};
        for (String word : words) {
            trie.insert(word);
            System.out.println("Inserted: " + word);
        }
        
        // Example 2: Searching for words
        System.out.println("\nSearching for words:");
        String[] searchWords = {"apple", "app", "application", "ban", "car", "care", "carefully"};
        for (String word : searchWords) {
            boolean found = trie.search(word);
            System.out.println("Search for '" + word + "': " + (found ? "Found" : "Not found"));
        }
        
        // Example 3: Prefix search
        System.out.println("\nPrefix search:");
        String[] prefixes = {"ap", "ba", "be", "ca", "z"};
        for (String prefix : prefixes) {
            boolean hasPrefix = trie.startsWith(prefix);
            System.out.println("Words starting with '" + prefix + "': " + (hasPrefix ? "Yes" : "No"));
        }
        
        // Example 4: Autocomplete
        System.out.println("\nAutocomplete:");
        String[] autocompletePrefixes = {"a", "b", "c", "ca", "z"};
        for (String prefix : autocompletePrefixes) {
            List<String> suggestions = trie.autocomplete(prefix);
            System.out.println("Autocomplete for '" + prefix + "': " + suggestions);
        }
        
        // Example 5: Counting words
        System.out.println("\nCounting words:");
        int wordCount = trie.countWords();
        System.out.println("Number of words in the trie: " + wordCount);
        
        // Example 6: Longest common prefix
        System.out.println("\nLongest common prefix:");
        String lcp = trie.longestCommonPrefix();
        System.out.println("Longest common prefix: " + (lcp.isEmpty() ? "None" : "'" + lcp + "'"));
        
        // Example 7: Deleting words
        System.out.println("\nDeleting words:");
        String[] deleteWords = {"app", "care", "banana", "nonexistent"};
        for (String word : deleteWords) {
            boolean deleted = trie.delete(word);
            System.out.println("Delete '" + word + "': " + (deleted ? "Deleted" : "Not deleted"));
        }
        
        // Verify deletion
        System.out.println("\nVerifying deletion:");
        for (String word : deleteWords) {
            boolean found = trie.search(word);
            System.out.println("Search for '" + word + "' after deletion: " + (found ? "Found" : "Not found"));
        }
        
        // Example 8: Autocomplete after deletion
        System.out.println("\nAutocomplete after deletion:");
        for (String prefix : autocompletePrefixes) {
            List<String> suggestions = trie.autocomplete(prefix);
            System.out.println("Autocomplete for '" + prefix + "': " + suggestions);
        }
        
        // Example 9: Working with a new trie for special cases
        System.out.println("\nSpecial cases:");
        Trie specialTrie = new Trie();
        
        // Empty trie
        System.out.println("Empty trie:");
        System.out.println("Is empty? " + specialTrie.isEmpty());
        System.out.println("Word count: " + specialTrie.countWords());
        System.out.println("Longest common prefix: '" + specialTrie.longestCommonPrefix() + "'");
        
        // Insert an empty string
        System.out.println("\nInserting an empty string:");
        specialTrie.insert("");
        System.out.println("Is empty after inserting empty string? " + specialTrie.isEmpty());
        
        // Search for null
        System.out.println("\nSearching for null:");
        boolean foundNull = specialTrie.search(null);
        System.out.println("Found null? " + foundNull);
        
        // Insert words with common prefix
        System.out.println("\nInserting words with common prefix:");
        specialTrie.clear();
        String[] commonWords = {"tree", "trees", "tread", "treat", "treasury"};
        for (String word : commonWords) {
            specialTrie.insert(word);
            System.out.println("Inserted: " + word);
        }
        
        System.out.println("Longest common prefix: '" + specialTrie.longestCommonPrefix() + "'");
        System.out.println("Autocomplete for 'tre': " + specialTrie.autocomplete("tre"));
    }
}
