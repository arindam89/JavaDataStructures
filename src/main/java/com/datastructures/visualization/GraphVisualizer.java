package com.datastructures.visualization;

import com.datastructures.graph.Graph;

import java.util.*;

/**
 * Visualizer for Graph data structure.
 * Provides methods to create a text-based visualization of a Graph.
 */
public class GraphVisualizer implements DataStructureVisualizer {

    private Graph<?> graph;
    private static final int NODE_WIDTH = 5;
    private static final int NODE_HEIGHT = 3;
    private static final int MAX_NODES_TO_DISPLAY = 15; // Limit to avoid messy output
    
    /**
     * Constructs a GraphVisualizer with the given Graph.
     * 
     * @param graph the Graph to visualize
     */
    public GraphVisualizer(Graph<?> graph) {
        this.graph = graph;
    }
    
    @Override
    public String visualize() {
        if (graph == null || graph.getAdjacencyList().isEmpty()) {
            return "Empty Graph";
        }
        
        StringBuilder visualization = new StringBuilder();
        
        if (graph.isDirected()) {
            visualization.append("Directed Graph Visualization:\n\n");
        } else {
            visualization.append("Undirected Graph Visualization:\n\n");
        }
        
        // Get the list of vertices
        Set<?> vertices = graph.getAdjacencyList().keySet();
        
        if (vertices.size() > MAX_NODES_TO_DISPLAY) {
            visualization.append("(Note: Graph is too large to show complete visualization, showing adjacency list instead)\n\n");
            return visualization.append(visualizeAdjacencyList()).toString();
        }
        
        // Create a circular layout for the graph
        return visualization.append(visualizeCircularLayout()).toString();
    }
    
    /**
     * Creates a circular layout visualization of the graph.
     * 
     * @return a string representation of the graph in circular layout
     */
    private String visualizeCircularLayout() {
        StringBuilder visualization = new StringBuilder();
        
        // Get the list of vertices
        List<?> vertices = new ArrayList<>(graph.getAdjacencyList().keySet());
        int vertexCount = vertices.size();
        
        // Calculate positions for each vertex
        int radius = 10 + vertexCount * 2;
        Map<Object, int[]> vertexPositions = new HashMap<>();
        
        for (int i = 0; i < vertexCount; i++) {
            double angle = 2 * Math.PI * i / vertexCount;
            int x = (int) (radius * Math.cos(angle));
            int y = (int) (radius * Math.sin(angle));
            vertexPositions.put(vertices.get(i), new int[]{x, y});
        }
        
        // Create a 2D grid for the visualization
        int gridSize = radius * 2 + 5;
        char[][] grid = new char[gridSize][gridSize];
        
        // Initialize grid with spaces
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = ' ';
            }
        }
        
        // Place vertices on the grid
        for (Object vertex : vertices) {
            int[] pos = vertexPositions.get(vertex);
            int x = pos[0] + radius;
            int y = pos[1] + radius;
            
            // Draw a simple box for the vertex
            String vertexStr = String.valueOf(vertex);
            if (vertexStr.length() > 3) {
                vertexStr = vertexStr.substring(0, 3);
            }
            
            grid[y][x] = 'O'; // Use 'O' for vertices
            for (int i = 0; i < vertexStr.length() && x + i + 1 < gridSize; i++) {
                grid[y][x + i + 1] = vertexStr.charAt(i);
            }
        }
        
        // Draw edges between vertices
        for (Object source : vertices) {
            for (Object target : graph.getAdjacencyList().get(source).keySet()) {
                int[] sourcePos = vertexPositions.get(source);
                int[] targetPos = vertexPositions.get(target);
                
                // For simplicity, draw a simple line connecting the two vertices
                int sourceX = sourcePos[0] + radius;
                int sourceY = sourcePos[1] + radius;
                int targetX = targetPos[0] + radius;
                int targetY = targetPos[1] + radius;
                
                // Calculate line
                if (Math.abs(sourceX - targetX) > Math.abs(sourceY - targetY)) {
                    int startX = Math.min(sourceX, targetX) + 1;
                    int endX = Math.max(sourceX, targetX) - 1;
                    for (int x = startX; x <= endX; x++) {
                        int y = sourceY + (x - sourceX) * (targetY - sourceY) / (targetX - sourceX);
                        if (x >= 0 && x < gridSize && y >= 0 && y < gridSize && grid[y][x] == ' ') {
                            grid[y][x] = (sourceX < targetX) ? '-' : (graph.isDirected() ? '<' : '-');
                        }
                    }
                } else {
                    int startY = Math.min(sourceY, targetY) + 1;
                    int endY = Math.max(sourceY, targetY) - 1;
                    for (int y = startY; y <= endY; y++) {
                        int x = sourceX + (y - sourceY) * (targetX - sourceX) / (targetY - sourceY);
                        if (x >= 0 && x < gridSize && y >= 0 && y < gridSize && grid[y][x] == ' ') {
                            grid[y][x] = (sourceY < targetY) ? '|' : (graph.isDirected() ? '^' : '|');
                        }
                    }
                }
                
                // Add arrow for directed graphs
                if (graph.isDirected()) {
                    if (Math.abs(sourceX - targetX) > Math.abs(sourceY - targetY)) {
                        int x = (sourceX < targetX) ? targetX - 1 : targetX + 1;
                        int y = targetY;
                        if (x >= 0 && x < gridSize && y >= 0 && y < gridSize) {
                            grid[y][x] = (sourceX < targetX) ? '>' : '<';
                        }
                    } else {
                        int x = targetX;
                        int y = (sourceY < targetY) ? targetY - 1 : targetY + 1;
                        if (x >= 0 && x < gridSize && y >= 0 && y < gridSize) {
                            grid[y][x] = (sourceY < targetY) ? 'v' : '^';
                        }
                    }
                }
            }
        }
        
        // Convert grid to string
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                visualization.append(grid[i][j]);
            }
            visualization.append("\n");
        }
        
        return visualization.toString();
    }
    
    /**
     * Creates an adjacency list visualization of the graph.
     * 
     * @return a string representation of the graph as an adjacency list
     */
    public String visualizeAdjacencyList() {
        StringBuilder visualization = new StringBuilder();
        
        // Get the adjacency list
        Map<?, ?> adjacencyList = graph.getAdjacencyList();
        
        visualization.append("Graph Adjacency List:\n");
        
        if (graph.isWeighted()) {
            // Weighted graph needs a different format for edge display
            for (Object vertex : adjacencyList.keySet()) {
                visualization.append(vertex).append(" -> ");
                
                Map<?, ?> neighbors = (Map<?, ?>) adjacencyList.get(vertex);
                if (neighbors.isEmpty()) {
                    visualization.append("[ ]");
                } else {
                    visualization.append("[ ");
                    for (Object neighbor : neighbors.keySet()) {
                        visualization.append(neighbor).append("(").append(neighbors.get(neighbor)).append(") ");
                    }
                    visualization.append("]");
                }
                
                visualization.append("\n");
            }
        } else {
            // Unweighted graph
            for (Object vertex : adjacencyList.keySet()) {
                visualization.append(vertex).append(" -> ");
                
                Map<?, ?> neighbors = (Map<?, ?>) adjacencyList.get(vertex);
                if (neighbors.isEmpty()) {
                    visualization.append("[ ]");
                } else {
                    visualization.append("[ ");
                    for (Object neighbor : neighbors.keySet()) {
                        visualization.append(neighbor).append(" ");
                    }
                    visualization.append("]");
                }
                
                visualization.append("\n");
            }
        }
        
        return visualization.toString();
    }
    
    /**
     * Visualizes a graph traversal (DFS or BFS).
     * 
     * @param traversalType the type of traversal ("DFS" or "BFS")
     * @param startVertex the starting vertex
     * @param traversalOrder the order of vertices visited during traversal
     * @return a visualization of the graph traversal
     */
    public String visualizeTraversal(String traversalType, Object startVertex, List<?> traversalOrder) {
        StringBuilder visualization = new StringBuilder();
        
        visualization.append("Graph ").append(traversalType).append(" Traversal:\n\n");
        visualization.append("Starting Vertex: ").append(startVertex).append("\n\n");
        
        visualization.append("Traversal Order: [ ");
        for (Object vertex : traversalOrder) {
            visualization.append(vertex).append(" ");
        }
        visualization.append("]\n\n");
        
        // Simple visualization - show discovery time for each vertex
        visualization.append("Discovery Times:\n");
        for (int i = 0; i < traversalOrder.size(); i++) {
            visualization.append(traversalOrder.get(i)).append(": ").append(i + 1).append("\n");
        }
        
        // Add the main graph visualization
        visualization.append("\n").append(visualize());
        
        return visualization.toString();
    }
    
    /**
     * Visualize the graph as a matrix.
     * 
     * @return a string representation of the graph as an adjacency matrix
     */
    public String visualizeMatrix() {
        StringBuilder visualization = new StringBuilder();
        
        // Get the list of vertices
        List<?> vertices = new ArrayList<>(graph.getAdjacencyList().keySet());
        int vertexCount = vertices.size();
        
        visualization.append("Graph Adjacency Matrix:\n\n");
        
        // Create header row for the matrix
        visualization.append("    "); // Space for row headers
        for (Object vertex : vertices) {
            visualization.append(String.format("%-4s", vertex));
        }
        visualization.append("\n");
        
        // Create matrix rows
        for (Object source : vertices) {
            visualization.append(String.format("%-4s", source));
            
            for (Object target : vertices) {
                if (graph.hasEdge(source, target)) {
                    if (graph.isWeighted()) {
                        int weight = graph.getWeight(source, target);
                        visualization.append(String.format("%-4s", weight));
                    } else {
                        visualization.append("1   ");
                    }
                } else {
                    visualization.append("0   ");
                }
            }
            
            visualization.append("\n");
        }
        
        return visualization.toString();
    }
}