package com.datastructures.visualization;

import com.datastructures.bst.BinarySearchTree;
import com.datastructures.tree.TreeNode;

import java.util.*;

/**
 * Visualizer for Binary Search Tree data structure.
 * Provides methods to create a text-based visualization of a BST.
 */
public class BinarySearchTreeVisualizer implements DataStructureVisualizer {
    
    private BinarySearchTree<?> bst;
    private static final int NODE_WIDTH = 5;
    private static final int MAX_HEIGHT = 10; // Limit to avoid excessive output
    
    /**
     * Constructs a BinarySearchTreeVisualizer with the given BST.
     * 
     * @param bst the Binary Search Tree to visualize
     */
    public BinarySearchTreeVisualizer(BinarySearchTree<?> bst) {
        this.bst = bst;
    }
    
    @Override
    public String visualize() {
        if (bst == null || bst.getRoot() == null) {
            return "Empty Binary Search Tree";
        }
        
        return buildBSTVisualization(bst.getRoot());
    }
    
    /**
     * Builds the BST visualization using a level-order traversal approach.
     * 
     * @param root the root node of the BST
     * @return a string representation of the BST
     */
    private String buildBSTVisualization(TreeNode<?> root) {
        if (root == null) {
            return "Empty BST";
        }
        
        StringBuilder visualization = new StringBuilder();
        visualization.append("Binary Search Tree Visualization:\n\n");
        
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
     * @param root the root node of the BST
     * @param height the height of the BST
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
     * Calculates the height of the BST.
     * 
     * @param node the root node of the BST
     * @return the height of the BST
     */
    private int calculateHeight(TreeNode<?> node) {
        if (node == null) return 0;
        return 1 + Math.max(calculateHeight(node.getLeft()), calculateHeight(node.getRight()));
    }
    
    /**
     * Creates a detailed visualization of the BST with search path visualization.
     * 
     * @param key the key to search for
     * @return a detailed string representation of the BST with search path
     */
    public String visualizeSearch(Object key) {
        if (bst == null || bst.getRoot() == null) {
            return "Empty Binary Search Tree";
        }
        
        StringBuilder visualization = new StringBuilder();
        visualization.append("Binary Search Tree Search Visualization:\n\n");
        visualization.append("Searching for key: ").append(key).append("\n\n");
        
        Set<TreeNode<?>> searchPath = new HashSet<>();
        boolean found = collectSearchPath(bst.getRoot(), key, searchPath);
        
        visualization.append("Search result: ").append(found ? "Found" : "Not Found").append("\n\n");
        
        int height = calculateHeight(bst.getRoot());
        
        // Limit height to avoid excessive output
        if (height > MAX_HEIGHT) {
            height = MAX_HEIGHT;
            visualization.append("(Note: Tree is very deep, showing only first ").append(MAX_HEIGHT).append(" levels)\n\n");
        }
        
        // Calculate the width of the visualization
        int width = (int) Math.pow(2, height) * (NODE_WIDTH + 1);
        
        List<List<String>> levelOrderNodes = new ArrayList<>();
        List<List<String>> levelOrderConnectors = new ArrayList<>();
        List<List<Boolean>> nodeInSearchPath = new ArrayList<>();
        
        // Get level order traversal of nodes and build the connector strings
        buildSearchPathVisualization(bst.getRoot(), height, levelOrderNodes, 
                                   levelOrderConnectors, nodeInSearchPath, searchPath);
        
        // Build the visualization
        for (int i = 0; i < levelOrderNodes.size(); i++) {
            List<String> nodes = levelOrderNodes.get(i);
            List<Boolean> pathFlags = nodeInSearchPath.get(i);
            
            // Determine spacing for this level
            int nodeSpacing = width / nodes.size();
            
            // Build the node level
            StringBuilder nodeLevel = new StringBuilder();
            for (int j = 0; j < nodes.size(); j++) {
                String node = nodes.get(j);
                Boolean inPath = pathFlags.get(j);
                
                if (inPath && !node.trim().isEmpty()) {
                    // Highlight nodes in the search path
                    String highlighted = VisualizationUtils.ANSI_GREEN + node + VisualizationUtils.ANSI_RESET;
                    nodeLevel.append(VisualizationUtils.centerText(highlighted, nodeSpacing));
                } else {
                    nodeLevel.append(VisualizationUtils.centerText(node, nodeSpacing));
                }
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
     * Collects the search path for a given key in the BST.
     * 
     * @param node the current node
     * @param key the key to search for
     * @param searchPath set to collect nodes in the search path
     * @return true if the key is found, false otherwise
     */
    private boolean collectSearchPath(TreeNode<?> node, Object key, Set<TreeNode<?>> searchPath) {
        if (node == null) {
            return false;
        }
        
        searchPath.add(node);
        
        if (node.getData().equals(key)) {
            return true;
        }
        
        int comparison = ((Comparable) key).compareTo(node.getData());
        
        if (comparison < 0) {
            return collectSearchPath(node.getLeft(), key, searchPath);
        } else if (comparison > 0) {
            return collectSearchPath(node.getRight(), key, searchPath);
        }
        
        return true;
    }
    
    /**
     * Builds level order lists for search path visualization.
     */
    private void buildSearchPathVisualization(TreeNode<?> root, int height, 
                                           List<List<String>> levelOrderNodes,
                                           List<List<String>> levelOrderConnectors,
                                           List<List<Boolean>> nodeInSearchPath,
                                           Set<TreeNode<?>> searchPath) {
        if (root == null) return;
        
        Queue<TreeNode<?>> queue = new LinkedList<>();
        queue.offer(root);
        
        int level = 0;
        
        while (!queue.isEmpty() && level < height) {
            int levelSize = queue.size();
            List<String> nodeStrings = new ArrayList<>();
            List<String> connectorStrings = new ArrayList<>();
            List<Boolean> pathFlags = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode<?> node = queue.poll();
                
                if (node != null) {
                    // Add node string
                    nodeStrings.add(String.valueOf(node.getData()));
                    
                    // Check if node is in search path
                    pathFlags.add(searchPath.contains(node));
                    
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
                    pathFlags.add(false);
                    connectorStrings.add(" ");
                    
                    // Add null children to maintain the structure
                    queue.offer(null);
                    queue.offer(null);
                }
            }
            
            levelOrderNodes.add(nodeStrings);
            nodeInSearchPath.add(pathFlags);
            
            if (level < height - 1) {
                levelOrderConnectors.add(connectorStrings);
            }
            
            level++;
        }
    }
}