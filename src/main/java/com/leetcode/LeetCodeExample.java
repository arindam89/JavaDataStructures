package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.leetcode.design.LRUCache;
import com.leetcode.graphs.WordLadder;
import com.leetcode.graphs.NumberOfIslands;
import com.leetcode.heap.MergeKSortedLists;
import com.leetcode.heap.MergeKSortedLists.ListNode;
import com.leetcode.trees.SerializeDeserializeBinaryTree;
import com.leetcode.trees.SerializeDeserializeBinaryTree.TreeNode;
import com.leetcode.strings.MinimumWindowSubstring;
import com.leetcode.design.MedianFinder;
import com.leetcode.arrays.SlidingWindowMaximum;
import com.leetcode.strings.WordSearch;
import com.leetcode.dynamic_programming.CoinChange;
import com.leetcode.arrays.TrapRainWater;
import com.leetcode.dynamic_programming.LongestIncreasingPath;
/**
 * Example class to demonstrate LeetCode problem solutions.
 */
public class LeetCodeExample {

    /**
     * Runs examples for all LeetCode problems.
     */
    public static void runExample() {
        System.out.println("1. LRU Cache Example:");
        runLRUCacheExample();
        
        System.out.println("\n2. Word Ladder Example:");
        runWordLadderExample();
        
        System.out.println("\n3. Number of Islands Example:");
        runNumberOfIslandsExample();
        
        System.out.println("\n4. Merge K Sorted Lists Example:");
        runMergeKSortedListsExample();
        
        System.out.println("\n5. Serialize and Deserialize Binary Tree Example:");
        runSerializeDeserializeBinaryTreeExample();
        
        System.out.println("\n6. Minimum Window Substring Example:");
        runMinimumWindowSubstringExample();
        
        System.out.println("\n7. Find Median from Data Stream Example:");
        runMedianFinderExample();
        
        System.out.println("\n8. Sliding Window Maximum Example:");
        runSlidingWindowMaximumExample();
        
        System.out.println("\n9. Word Search Example:");
        runWordSearchExample();
        
        System.out.println("\n10. Coin Change Example:");
        runCoinChangeExample();
        
        System.out.println("\n11. Trapping Rain Water Example:");
        runTrapRainWaterExample();
        
        System.out.println("\n12. Longest Increasing Path Example:");
        runLongestIncreasingPathExample();
    }
    
    /**
     * Demonstrates the LRU Cache implementation.
     */
    private static void runLRUCacheExample() {
        LRUCache cache = new LRUCache(2); // capacity = 2
        
        System.out.println("Create LRU Cache with capacity 2");
        System.out.println("Put (1, 1)");
        cache.put(1, 1);
        
        System.out.println("Put (2, 2)");
        cache.put(2, 2);
        
        System.out.println("Get key 1: " + cache.get(1));  // returns 1
        
        System.out.println("Put (3, 3) - This will evict key 2");
        cache.put(3, 3);
        
        System.out.println("Get key 2: " + cache.get(2));  // returns -1 (not found)
        
        System.out.println("Put (4, 4) - This will evict key 1");
        cache.put(4, 4);
        
        System.out.println("Get key 1: " + cache.get(1));  // returns -1 (not found)
        System.out.println("Get key 3: " + cache.get(3));  // returns 3
        System.out.println("Get key 4: " + cache.get(4));  // returns 4
    }
    
    /**
     * Demonstrates the Word Ladder implementation.
     */
    private static void runWordLadderExample() {
        WordLadder solution = new WordLadder();
        
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        
        System.out.println("Finding the shortest transformation from '" + beginWord + "' to '" + endWord + "'");
        System.out.println("Word List: " + wordList);
        
        int result = solution.ladderLength(beginWord, endWord, wordList);
        
        if (result > 0) {
            System.out.println("Length of shortest transformation sequence: " + result);
            System.out.println("Example path could be: hit -> hot -> dot -> dog -> cog");
        } else {
            System.out.println("No valid transformation sequence exists.");
        }
    }
    
    /**
     * Demonstrates the Number of Islands implementation.
     */
    private static void runNumberOfIslandsExample() {
        NumberOfIslands solution = new NumberOfIslands();
        
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        
        System.out.println("Grid:");
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        
        int result = solution.numIslands(grid);
        System.out.println("Number of islands: " + result);
    }
    
    /**
     * Demonstrates the Merge K Sorted Lists implementation.
     */
    private static void runMergeKSortedListsExample() {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        // Create 3 sorted linked lists
        ListNode list1 = createList(new int[]{1, 4, 5});
        ListNode list2 = createList(new int[]{1, 3, 4});
        ListNode list3 = createList(new int[]{2, 6});
        
        ListNode[] lists = new ListNode[]{list1, list2, list3};
        
        System.out.println("Merging the following sorted lists:");
        System.out.println("List 1: " + listToString(list1));
        System.out.println("List 2: " + listToString(list2));
        System.out.println("List 3: " + listToString(list3));
        
        ListNode result = solution.mergeKLists(lists);
        
        System.out.println("Merged result: " + listToString(result));
    }
    
    /**
     * Demonstrates the Serialize and Deserialize Binary Tree implementation.
     */
    private static void runSerializeDeserializeBinaryTreeExample() {
        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();
        
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        System.out.println("Original Binary Tree:");
        printBinaryTree(root, 0);
        
        // Serialize the tree
        String serialized = codec.serialize(root);
        System.out.println("\nSerialized tree: " + serialized);
        
        // Deserialize back to a tree
        TreeNode deserialized = codec.deserialize(serialized);
        
        System.out.println("\nDeserialized Binary Tree:");
        printBinaryTree(deserialized, 0);
    }
    
    /**
     * Helper method to create a linked list from an array of values.
     */
    private static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        
        return dummy.next;
    }
    
    /**
     * Helper method to convert a linked list to a string.
     */
    private static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(", ");
            }
            head = head.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Prints a binary tree with proper indentation.
     */
    private static void printBinaryTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        
        printBinaryTree(node.right, level + 1);
        
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "    ";
        }
        
        System.out.println(indent + node.val);
        
        printBinaryTree(node.left, level + 1);
    }
    
    /**
     * Demonstrates the Minimum Window Substring implementation.
     */
    private static void runMinimumWindowSubstringExample() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        
        String s = "ADOBECODEBANC";
        String t = "ABC";
        
        System.out.println("Source string: " + s);
        System.out.println("Target string: " + t);
        
        String result = solution.minWindow(s, t);
        
        System.out.println("Minimum window substring: " + result);
        System.out.println("Length: " + result.length());
    }
    
    /**
     * Demonstrates the Find Median from Data Stream implementation.
     */
    private static void runMedianFinderExample() {
        MedianFinder medianFinder = new MedianFinder();
        
        System.out.println("Adding numbers to the data stream one by one:");
        
        System.out.println("Add: 1");
        medianFinder.addNum(1);
        System.out.println("Median: " + medianFinder.findMedian());
        
        System.out.println("Add: 2");
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian());
        
        System.out.println("Add: 3");
        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian());
        
        System.out.println("Add: 4");
        medianFinder.addNum(4);
        System.out.println("Median: " + medianFinder.findMedian());
        
        System.out.println("Add: 5");
        medianFinder.addNum(5);
        System.out.println("Median: " + medianFinder.findMedian());
    }
    
    /**
     * Demonstrates the Sliding Window Maximum implementation.
     */
    private static void runSlidingWindowMaximumExample() {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Window size: " + k);
        
        int[] result = solution.maxSlidingWindow(nums, k);
        
        System.out.println("Maximum values in each sliding window: " + Arrays.toString(result));
    }
    
    /**
     * Demonstrates the Word Search implementation.
     */
    private static void runWordSearchExample() {
        WordSearch solution = new WordSearch();
        
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        
        System.out.println("Board:");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        
        System.out.println("\nSearching for words in the board:");
        System.out.println("'" + word1 + "' exists: " + solution.exist(board, word1));
        System.out.println("'" + word2 + "' exists: " + solution.exist(board, word2));
        System.out.println("'" + word3 + "' exists: " + solution.exist(board, word3));
    }
    
    /**
     * Demonstrates the Coin Change implementation.
     */
    private static void runCoinChangeExample() {
        CoinChange solution = new CoinChange();
        
        int[] coins = {1, 2, 5};
        int amount = 11;
        
        System.out.println("Coin denominations: " + Arrays.toString(coins));
        System.out.println("Target amount: " + amount);
        
        int result = solution.coinChange(coins, amount);
        
        if (result != -1) {
            System.out.println("Minimum number of coins needed: " + result);
        } else {
            System.out.println("The amount cannot be made up by any combination of the coins.");
        }
        
        // Another example
        int[] coins2 = {2};
        int amount2 = 3;
        
        System.out.println("\nCoin denominations: " + Arrays.toString(coins2));
        System.out.println("Target amount: " + amount2);
        
        int result2 = solution.coinChange(coins2, amount2);
        
        if (result2 != -1) {
            System.out.println("Minimum number of coins needed: " + result2);
        } else {
            System.out.println("The amount cannot be made up by any combination of the coins.");
        }
    }
    
    /**
     * Demonstrates the Trapping Rain Water implementation.
     */
    private static void runTrapRainWaterExample() {
        TrapRainWater solution = new TrapRainWater();
        
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        System.out.println("Height array: " + Arrays.toString(height1));
        
        int result1 = solution.trap(height1);
        System.out.println("Amount of trapped water: " + result1);
        
        System.out.println("\nUsing alternative DP approach:");
        int result1DP = solution.trapUsingDP(height1);
        System.out.println("Amount of trapped water (DP): " + result1DP);
        
        // Another example
        int[] height2 = {4, 2, 0, 3, 2, 5};
        
        System.out.println("\nHeight array: " + Arrays.toString(height2));
        
        int result2 = solution.trap(height2);
        System.out.println("Amount of trapped water: " + result2);
    }
    
    /**
     * Demonstrates the Longest Increasing Path in a Matrix implementation.
     */
    private static void runLongestIncreasingPathExample() {
        LongestIncreasingPath solution = new LongestIncreasingPath();
        
        int[][] matrix1 = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        
        System.out.println("Matrix 1:");
        for (int[] row : matrix1) {
            System.out.println(Arrays.toString(row));
        }
        
        int result1 = solution.longestIncreasingPath(matrix1);
        System.out.println("Longest increasing path length: " + result1);
        System.out.println("Example path: 1 -> 2 -> 6 -> 9");
        
        // Another example
        int[][] matrix2 = {
            {3, 4, 5},
            {3, 2, 6},
            {2, 2, 1}
        };
        
        System.out.println("\nMatrix 2:");
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }
        
        int result2 = solution.longestIncreasingPath(matrix2);
        System.out.println("Longest increasing path length: " + result2);
        System.out.println("Example path: 3 -> 4 -> 5 -> 6");
    }
}