package com.datastructures;

import com.datastructures.linkedlist.LinkedListExample;
import com.datastructures.heap.HeapExample;
import com.datastructures.tree.BinaryTreeExample;
import com.datastructures.bst.BSTExample;
import com.datastructures.graph.GraphExample;
import com.datastructures.trie.TrieExample;
import com.datastructures.leetcode.LeetCodeExample;

/**
 * Main class to demonstrate all the data structures implementations.
 * This class serves as an entry point to the application and runs
 * examples for each data structure.
 * 
 * @author DataStructures Team
 * @version 1.0
 */
public class Main {
    
    /**
     * Main method to run examples of all data structures.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Data Structures Examples\n");
        
        System.out.println("=== Linked List Examples ===");
        LinkedListExample.runExample();
        
        System.out.println("\n=== Heap Examples ===");
        HeapExample.runExample();
        
        System.out.println("\n=== Binary Tree Examples ===");
        BinaryTreeExample.runExample();
        
        System.out.println("\n=== Binary Search Tree Examples ===");
        BSTExample.runExample();
        
        System.out.println("\n=== Graph Examples ===");
        GraphExample.runExample();
        
        System.out.println("\n=== Trie Examples ===");
        TrieExample.runExample();
        
        System.out.println("\n=== LeetCode Problem Examples ===");
        LeetCodeExample.runExample();
    }
}
