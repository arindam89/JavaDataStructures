package com.leetcode.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode #297: Serialize and Deserialize Binary Tree (Hard)
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits 
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection 
 * link to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how 
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary 
 * tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * 
 * Time Complexity:
 * - Serialize: O(n) where n is the number of nodes in the tree
 * - Deserialize: O(n) where n is the number of nodes in the tree
 * 
 * Space Complexity: O(n) for both serialize and deserialize
 */
public class SerializeDeserializeBinaryTree {
    
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int x) { 
            val = x; 
        }
    }
    
    // Delimiter used in the serialized string
    private static final String DELIMITER = ",";
    // Null marker used in the serialized string
    private static final String NULL_MARKER = "X";
    
    /**
     * Encodes a tree to a single string using preorder traversal.
     * 
     * @param root the root of the binary tree
     * @return a serialized string representation of the tree
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    /**
     * Helper method for serialization using preorder traversal.
     * 
     * @param node the current node
     * @param sb the string builder to append to
     */
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_MARKER).append(DELIMITER);
            return;
        }
        
        // Preorder traversal: node, left, right
        sb.append(node.val).append(DELIMITER);
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }
    
    /**
     * Decodes your encoded data to tree.
     * 
     * @param data the serialized string representation of the tree
     * @return the root of the reconstructed binary tree
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        
        String[] values = data.split(DELIMITER);
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        
        return deserializeHelper(queue);
    }
    
    /**
     * Helper method for deserialization using preorder traversal.
     * 
     * @param queue the queue of values from the serialized string
     * @return the root of the reconstructed subtree
     */
    private TreeNode deserializeHelper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        
        String value = queue.poll();
        
        if (value.equals(NULL_MARKER)) {
            return null;
        }
        
        // Create node with the current value
        TreeNode node = new TreeNode(Integer.parseInt(value));
        
        // Recursively reconstruct left and right subtrees
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        
        return node;
    }
}