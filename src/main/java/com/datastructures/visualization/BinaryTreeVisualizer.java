package com.datastructures.visualization;

import com.datastructures.tree.BinaryTree;
import com.datastructures.tree.TreeNode;

import java.util.*;

/**
 * Visualizer for Binary Tree data structure.
 * Provides methods to create a text-based visualization of a Binary Tree.
 */
public class BinaryTreeVisualizer implements DataStructureVisualizer {
    
    private BinaryTree<?> tree;
    private static final int NODE_WIDTH = 5;
    private static final int MAX_HEIGHT = 10; // Limit to avoid excessive output
    
    /**
     * Constructs a BinaryTreeVisualizer with the given Binary Tree.
     * 
     * @param tree the Binary Tree to visualize
     */
    public BinaryTreeVisualizer(BinaryTree<?> tree) {
        this.tree = tree;
    }
    
    @Override
    public String visualize() {
        if (tree == null || tree.getRoot() == null) {
            return "Empty Binary Tree";
        }
        
        return buildTreeVisualization(tree.getRoot());
    }
    
    /**
     * Builds the tree visualization using a level-order traversal approach.
     * 
     * @param root the root node of the tree
     * @return a string representation of the tree
     */
    private String buildTreeVisualization(TreeNode<?> root) {
        if (root == null) {
            return "Empty Tree";
        }
        
        StringBuilder visualization = new StringBuilder();
        visualization.append("Binary Tree Visualization:\n\n");
        
        int height = calculateHeight(root);
        
        // Limit height to avoid excessive output
        if (height > MAX_HEIGHT) {
            height = MAX_HEIGHT;
            visualization.append("(Note: Tree is very deep, showing only first ").append(MAX_HEIGHT).append(" levels)\n\n");
        }
        
        // Calculate the width of the visualization
        int width = (int) Math.pow(2, height) * (NODE_WIDTH + 1);
        
        List<List<String>> levelOrderNodes = new ArrayList<>();
        List<List<String>> levelOrderConnectors = new ArrayList<>();
        
        // Get level order traversal of nodes and build the connector strings
        buildLevelOrderStrings(root, height, levelOrderNodes, levelOrderConnectors);
        
        // Build the visualization
        for (int i = 0; i < levelOrderNodes.size(); i++) {
            List<String> nodes = levelOrderNodes.get(i);
            
            // Determine spacing for this level
            int nodeSpacing = width / nodes.size();
            
            // Build the node level
            StringBuilder nodeLevel = new StringBuilder();
            for (String node : nodes) {
                nodeLevel.append(VisualizationUtils.centerText(node, nodeSpacing));
            }
            visualization.append(nodeLevel).append("\n");
            
            // Add connectors if not the last level
            if (i < levelOrderConnectors.size()) {
                List<String> connectors = levelOrderConnectors.get(i);
                StringBuilder connectorLevel = new StringBuilder();
                for (String connector : connectors) {
                    connectorLevel.append(VisualizationUtils.centerText(connector, nodeSpacing));
                }
                visualization.append(connectorLevel).append("\n");
            }
        }
        
        return visualization.toString();
    }
    
    /**
     * Builds level order lists of nodes and connectors for visualization.
     * 
     * @param root the root node of the tree
     * @param height the height of the tree
     * @param levelOrderNodes list to store nodes at each level
     * @param levelOrderConnectors list to store connectors at each level
     */
    private void buildLevelOrderStrings(TreeNode<?> root, int height, 
                                      List<List<String>> levelOrderNodes,
                                      List<List<String>> levelOrderConnectors) {
        if (root == null) return;
        
        Queue<TreeNode<?>> queue = new LinkedList<>();
        queue.offer(root);
        
        int level = 0;
        
        while (!queue.isEmpty() && level < height) {
            int levelSize = queue.size();
            List<String> nodeStrings = new ArrayList<>();
            List<String> connectorStrings = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode<?> node = queue.poll();
                
                if (node != null) {
                    // Add node string
                    nodeStrings.add(String.valueOf(node.getData()));
                    
                    // Add children to the queue
                    queue.offer(node.getLeft());
                    queue.offer(node.getRight());
                    
                    // Create connector string
                    if (node.getLeft() != null || node.getRight() != null) {
                        StringBuilder connector = new StringBuilder();
                        
                        if (node.getLeft() != null && node.getRight() != null) {
                            connector.append("/\\");
                        } else if (node.getLeft() != null) {
                            connector.append("/");
                        } else if (node.getRight() != null) {
                            connector.append("\\");
                        }
                        
                        connectorStrings.add(connector.toString());
                    } else {
                        connectorStrings.add(" ");
                    }
                } else {
                    // Add placeholders for null nodes
                    nodeStrings.add(" ");
                    connectorStrings.add(" ");
                    
                    // Add null children to maintain the structure
                    queue.offer(null);
                    queue.offer(null);
                }
            }
            
            levelOrderNodes.add(nodeStrings);
            if (level < height - 1) {
                levelOrderConnectors.add(connectorStrings);
            }
            
            level++;
        }
    }
    
    /**
     * Calculates the height of the binary tree.
     * 
     * @param node the root node of the tree
     * @return the height of the tree
     */
    private int calculateHeight(TreeNode<?> node) {
        if (node == null) return 0;
        return 1 + Math.max(calculateHeight(node.getLeft()), calculateHeight(node.getRight()));
    }

    /**
     * Creates a detailed visualization of the Binary Tree.
     * 
     * @return a detailed string representation of the Binary Tree
     */
    public String visualizeDetailed() {
        if (tree == null || tree.getRoot() == null) {
            return "Empty Binary Tree";
        }
        
        StringBuilder visualization = new StringBuilder();
        visualization.append("Binary Tree Detailed Visualization:\n\n");
        
        // Create a list for each traversal type
        List<?> inOrderList = tree.inOrderTraversal();
        List<?> preOrderList = tree.preOrderTraversal();
        List<?> postOrderList = tree.postOrderTraversal();
        List<?> levelOrderList = tree.levelOrderTraversal();
        
        visualization.append("Tree Height: ").append(calculateHeight(tree.getRoot())).append("\n");
        visualization.append("Node Count: ").append(countNodes(tree.getRoot())).append("\n\n");
        
        visualization.append("Traversals:\n");
        visualization.append("In-Order: ").append(inOrderList).append("\n");
        visualization.append("Pre-Order: ").append(preOrderList).append("\n");
        visualization.append("Post-Order: ").append(postOrderList).append("\n");
        visualization.append("Level-Order: ").append(levelOrderList).append("\n\n");
        
        visualization.append(buildTreeVisualization(tree.getRoot()));
        
        return visualization.toString();
    }
    
    /**
     * Counts the number of nodes in the tree.
     * 
     * @param node the root node
     * @return the number of nodes
     */
    private int countNodes(TreeNode<?> node) {
        if (node == null) return 0;
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }
}