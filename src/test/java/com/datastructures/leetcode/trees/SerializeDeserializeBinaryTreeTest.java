package com.datastructures.leetcode.trees;

import org.junit.jupiter.api.Test;

import com.leetcode.trees.SerializeDeserializeBinaryTree;
import com.leetcode.trees.SerializeDeserializeBinaryTree.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for SerializeDeserializeBinaryTree implementation.
 */
public class SerializeDeserializeBinaryTreeTest {

    /**
     * Helper method to verify if two binary trees are structurally identical and have the same node values.
     */
    private boolean areTreesEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        
        if (t1 == null || t2 == null) {
            return false;
        }
        
        return t1.val == t2.val && 
               areTreesEqual(t1.left, t2.left) && 
               areTreesEqual(t1.right, t2.right);
    }
    
    @Test
    void testSerializeDeserializeExample1() {
        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();
        
        // Create tree: [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        // Serialize and then deserialize
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        
        // Verify trees are equal
        assertTrue(areTreesEqual(root, deserialized));
    }
    
    @Test
    void testSerializeDeserializeEmptyTree() {
        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();
        
        TreeNode root = null;
        
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        
        assertNull(deserialized);
    }
    
    @Test
    void testSerializeDeserializeSingleNode() {
        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();
        
        TreeNode root = new TreeNode(5);
        
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        
        assertNotNull(deserialized);
        assertEquals(5, deserialized.val);
        assertNull(deserialized.left);
        assertNull(deserialized.right);
    }
    
    @Test
    void testSerializeDeserializeLeftSkewedTree() {
        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();
        
        // Create left-skewed tree [1,2,null,3,null,4,null]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        
        assertTrue(areTreesEqual(root, deserialized));
    }
    
    @Test
    void testSerializeDeserializeRightSkewedTree() {
        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();
        
        // Create right-skewed tree [1,null,2,null,3,null,4]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        
        assertTrue(areTreesEqual(root, deserialized));
    }
    
    @Test
    void testSerializeDeserializeComplexTree() {
        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();
        
        // Create a more complex tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        
        assertTrue(areTreesEqual(root, deserialized));
    }
}