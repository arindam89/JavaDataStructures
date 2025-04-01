package com.datastructures.graph;

import java.util.List;
import java.util.Map;

/**
 * Example class to demonstrate the usage of Graph implementation.
 * This class contains a method that shows different operations
 * that can be performed on a graph.
 */
public class GraphExample {
    
    /**
     * Runs examples demonstrating graph operations.
     */
    public static void runExample() {
        // Example 1: Undirected Graph
        System.out.println("Undirected Graph Example:");
        
        // Create an undirected graph
        Graph<String> undirectedGraph = new Graph<>();
        
        // Add vertices
        System.out.println("Adding vertices: A, B, C, D, E");
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("B");
        undirectedGraph.addVertex("C");
        undirectedGraph.addVertex("D");
        undirectedGraph.addVertex("E");
        
        // Add edges
        System.out.println("Adding edges: A-B, A-C, B-D, C-D, D-E, E-A");
        undirectedGraph.addEdge("A", "B", 2);
        undirectedGraph.addEdge("A", "C", 3);
        undirectedGraph.addEdge("B", "D", 1);
        undirectedGraph.addEdge("C", "D", 5);
        undirectedGraph.addEdge("D", "E", 4);
        undirectedGraph.addEdge("E", "A", 6);
        
        // Print the graph
        System.out.println(undirectedGraph);
        
        // Example 2: Graph traversals
        System.out.println("\nGraph Traversals:");
        
        // BFS traversal
        List<String> bfsResult = undirectedGraph.bfs("A");
        System.out.println("BFS starting from A: " + bfsResult);
        
        // DFS traversal
        List<String> dfsResult = undirectedGraph.dfs("A");
        System.out.println("DFS starting from A: " + dfsResult);
        
        // Example 3: Graph operations
        System.out.println("\nGraph Operations:");
        
        // Check if the graph contains vertices and edges
        System.out.println("Contains vertex A? " + undirectedGraph.containsVertex("A"));
        System.out.println("Contains vertex F? " + undirectedGraph.containsVertex("F"));
        System.out.println("Contains edge A-B? " + undirectedGraph.containsEdge("A", "B"));
        System.out.println("Contains edge A-D? " + undirectedGraph.containsEdge("A", "D"));
        
        // Get neighbors
        System.out.println("Neighbors of A: " + undirectedGraph.getNeighbors("A"));
        
        // Get edge weight
        System.out.println("Weight of edge A-B: " + undirectedGraph.getEdgeWeight("A", "B"));
        
        // Check if the undirected graph has a cycle
        System.out.println("Undirected graph has cycle? " + undirectedGraph.hasCycle());
        
        // Create a tree-like undirected graph (no cycles)
        System.out.println("\nCreating a tree-like undirected graph (no cycles):");
        Graph<String> treeGraph = new Graph<>();
        treeGraph.addVertex("A");
        treeGraph.addVertex("B");
        treeGraph.addVertex("C");
        treeGraph.addVertex("D");
        treeGraph.addVertex("E");
        
        treeGraph.addEdge("A", "B", 1);
        treeGraph.addEdge("A", "C", 1);
        treeGraph.addEdge("B", "D", 1);
        treeGraph.addEdge("C", "E", 1);
        
        System.out.println(treeGraph);
        System.out.println("Tree-like undirected graph has cycle? " + treeGraph.hasCycle());
        
        // Minimum Spanning Tree
        System.out.println("\nMinimum Spanning Tree:");
        Graph<String> mst = undirectedGraph.minimumSpanningTree();
        System.out.println(mst);
        
        // Shortest paths (Dijkstra's algorithm)
        System.out.println("\nShortest paths from A (Dijkstra's algorithm):");
        Map<String, Integer> shortestPaths = undirectedGraph.dijkstra("A");
        for (Map.Entry<String, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("Shortest path to " + entry.getKey() + ": " + entry.getValue());
        }
        
        // Remove an edge
        System.out.println("\nRemoving edge B-D...");
        undirectedGraph.removeEdge("B", "D");
        System.out.println("Contains edge B-D? " + undirectedGraph.containsEdge("B", "D"));
        System.out.println(undirectedGraph);
        
        // Remove a vertex
        System.out.println("\nRemoving vertex C...");
        undirectedGraph.removeVertex("C");
        System.out.println("Contains vertex C? " + undirectedGraph.containsVertex("C"));
        System.out.println(undirectedGraph);
        
        // Example 4: Directed Graph
        System.out.println("\nDirected Graph Example:");
        
        // Create a directed graph
        Graph<String> directedGraph = new Graph<>(true);
        
        // Add vertices
        System.out.println("Adding vertices: A, B, C, D");
        directedGraph.addVertex("A");
        directedGraph.addVertex("B");
        directedGraph.addVertex("C");
        directedGraph.addVertex("D");
        
        // Add edges
        System.out.println("Adding edges: A->B, A->C, B->C, C->D, D->A");
        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("A", "C");
        directedGraph.addEdge("B", "C");
        directedGraph.addEdge("C", "D");
        directedGraph.addEdge("D", "A");
        
        // Print the graph
        System.out.println(directedGraph);
        
        // Check if the graph has a cycle
        System.out.println("Has cycle? " + directedGraph.hasCycle());
        
        // Example 5: Directed Acyclic Graph (DAG)
        System.out.println("\nDirected Acyclic Graph (DAG) Example:");
        
        // Create a DAG
        Graph<String> dag = new Graph<>(true);
        
        // Add vertices
        System.out.println("Adding vertices: A, B, C, D, E");
        dag.addVertex("A");
        dag.addVertex("B");
        dag.addVertex("C");
        dag.addVertex("D");
        dag.addVertex("E");
        
        // Add edges for a DAG
        System.out.println("Adding edges: A->B, A->C, B->D, C->D, D->E");
        dag.addEdge("A", "B");
        dag.addEdge("A", "C");
        dag.addEdge("B", "D");
        dag.addEdge("C", "D");
        dag.addEdge("D", "E");
        
        // Print the graph
        System.out.println(dag);
        
        // Check if the graph has a cycle
        System.out.println("Has cycle? " + dag.hasCycle());
        
        // Topological sort
        System.out.println("Topological sort: " + dag.topologicalSort());
    }
}
