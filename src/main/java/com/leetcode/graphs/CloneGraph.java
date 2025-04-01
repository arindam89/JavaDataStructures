package com.leetcode.graphs;

import java.util.*;

/**
 * LeetCode #133: Clone Graph
 * 
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * 
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * 
 * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
 * Space Complexity: O(V) for the HashMap and recursion stack
 */
public class CloneGraph {
    
    /**
     * Definition for a Node in the graph.
     */
    public static class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    
    /**
     * HashMap to keep track of nodes that have already been cloned.
     * Key: Original node, Value: Cloned node
     */
    private Map<Node, Node> visited = new HashMap<>();
    
    /**
     * Clones a graph using depth-first search (DFS).
     * 
     * @param node the reference to a node in the original graph
     * @return the cloned graph (reference to the same node in the cloned graph)
     */
    public Node cloneGraph(Node node) {
        // Reset the visited map for multiple calls
        visited.clear();
        
        // Handle the case of empty graph
        if (node == null) {
            return null;
        }
        
        return cloneGraphDFS(node);
    }
    
    /**
     * Helper method that implements the recursive DFS approach.
     * 
     * @param node the current node being cloned
     * @return the cloned node
     */
    private Node cloneGraphDFS(Node node) {
        // If the node has already been visited and cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        // Create a new node with the same value
        Node cloneNode = new Node(node.val);
        
        // Add the mapping to visited map before exploring neighbors to handle cycles
        visited.put(node, cloneNode);
        
        // Clone all neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraphDFS(neighbor));
        }
        
        return cloneNode;
    }
    
    /**
     * Alternative implementation that clones a graph using breadth-first search (BFS).
     * 
     * @param node the reference to a node in the original graph
     * @return the cloned graph (reference to the same node in the cloned graph)
     */
    public Node cloneGraphBFS(Node node) {
        // Reset the visited map for multiple calls
        visited.clear();
        
        // Handle the case of empty graph
        if (node == null) {
            return null;
        }
        
        // Create a queue for BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        // Create the first node (the reference node)
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);
        
        // BFS to clone all nodes and edges
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            // Process all neighbors of the current node
            for (Node neighbor : current.neighbors) {
                // If the neighbor hasn't been visited yet, create a clone and add to queue
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                
                // Add the cloned neighbor to the cloned current node's neighbors list
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }
        
        return cloneNode;
    }
    
    /**
     * Generates a string representation of the graph.
     * 
     * @param node the reference node of the graph
     * @return a string representation of the graph
     */
    public String graphToString(Node node) {
        if (node == null) {
            return "Empty graph";
        }
        
        StringBuilder sb = new StringBuilder();
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(node);
        visited.add(node.val);
        
        sb.append("Graph structure:\n");
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            sb.append("Node ").append(current.val).append(" -> Neighbors: [");
            
            for (int i = 0; i < current.neighbors.size(); i++) {
                Node neighbor = current.neighbors.get(i);
                sb.append(neighbor.val);
                
                if (i < current.neighbors.size() - 1) {
                    sb.append(", ");
                }
                
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.add(neighbor);
                }
            }
            
            sb.append("]\n");
        }
        
        return sb.toString();
    }
    
    /**
     * Creates a simple graph for testing purposes.
     * 
     * @param n number of nodes (1 to n)
     * @param edges list of edges, each edge is a pair of nodes
     * @return the reference node (node 1) of the created graph
     */
    public Node createGraph(int n, int[][] edges) {
        if (n <= 0) {
            return null;
        }
        
        // Create all nodes
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nodes.put(i, new Node(i));
        }
        
        // Add edges
        if (edges != null) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                
                // Add bidirectional edges (undirected graph)
                nodes.get(u).neighbors.add(nodes.get(v));
                nodes.get(v).neighbors.add(nodes.get(u));
            }
        }
        
        // Return the reference node (node 1)
        return nodes.get(1);
    }
}