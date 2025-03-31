package com.datastructures.graph;

import java.util.*;

/**
 * Implementation of a graph data structure using an adjacency list.
 * This implementation supports both directed and undirected graphs,
 * as well as weighted edges.
 * 
 * Time Complexity:
 * - Add Vertex: O(1)
 * - Add Edge: O(1)
 * - Remove Vertex: O(V + E) where V is the number of vertices and E is the number of edges
 * - Remove Edge: O(E) where E is the number of edges
 * - BFS/DFS: O(V + E) 
 * 
 * Space Complexity: O(V + E) for the adjacency list
 * 
 * @param <T> the type of data stored in the vertices
 */
public class Graph<T> {
    
    // Map to store the adjacency list
    // The key is the vertex, and the value is a map of connected vertices and their edge weights
    private Map<T, Map<T, Integer>> adjacencyList;
    
    // Flag to indicate if the graph is directed
    private boolean directed;
    
    // Flag to indicate if the graph is weighted
    private boolean weighted;
    
    /**
     * Constructs an empty undirected graph.
     */
    public Graph() {
        this(false);
    }
    
    /**
     * Constructs an empty graph.
     * 
     * @param directed true if the graph is directed, false otherwise
     */
    public Graph(boolean directed) {
        this(directed, false);
    }
    
    /**
     * Constructs an empty graph.
     * 
     * @param directed true if the graph is directed, false otherwise
     * @param weighted true if the graph is weighted, false otherwise
     */
    public Graph(boolean directed, boolean weighted) {
        this.adjacencyList = new HashMap<>();
        this.directed = directed;
        this.weighted = weighted;
    }
    
    /**
     * Adds a vertex to the graph.
     * Time Complexity: O(1)
     * 
     * @param vertex the vertex to add
     * @return true if the vertex was added, false if it already exists
     */
    public boolean addVertex(T vertex) {
        if (adjacencyList.containsKey(vertex)) {
            return false;
        }
        
        adjacencyList.put(vertex, new HashMap<>());
        return true;
    }
    
    /**
     * Adds an edge between two vertices with a default weight of 1.
     * 
     * @param source the source vertex
     * @param destination the destination vertex
     * @return true if the edge was added, false otherwise
     */
    public boolean addEdge(T source, T destination) {
        return addEdge(source, destination, 1);
    }
    
    /**
     * Adds a weighted edge between two vertices.
     * Time Complexity: O(1)
     * 
     * @param source the source vertex
     * @param destination the destination vertex
     * @param weight the weight of the edge
     * @return true if the edge was added, false otherwise
     */
    public boolean addEdge(T source, T destination, int weight) {
        // Check if the vertices exist
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            return false;
        }
        
        // Add the edge from source to destination
        adjacencyList.get(source).put(destination, weight);
        
        // If the graph is undirected, add the edge from destination to source as well
        if (!directed) {
            adjacencyList.get(destination).put(source, weight);
        }
        
        return true;
    }
    
    /**
     * Removes a vertex from the graph.
     * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
     * 
     * @param vertex the vertex to remove
     * @return true if the vertex was removed, false if it doesn't exist
     */
    public boolean removeVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return false;
        }
        
        // Remove all edges pointing to this vertex
        for (Map<T, Integer> edges : adjacencyList.values()) {
            edges.remove(vertex);
        }
        
        // Remove the vertex itself
        adjacencyList.remove(vertex);
        
        return true;
    }
    
    /**
     * Removes an edge between two vertices.
     * Time Complexity: O(1)
     * 
     * @param source the source vertex
     * @param destination the destination vertex
     * @return true if the edge was removed, false otherwise
     */
    public boolean removeEdge(T source, T destination) {
        // Check if the vertices exist
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            return false;
        }
        
        // Check if the edge exists
        if (!adjacencyList.get(source).containsKey(destination)) {
            return false;
        }
        
        // Remove the edge from source to destination
        adjacencyList.get(source).remove(destination);
        
        // If the graph is undirected, remove the edge from destination to source as well
        if (!directed) {
            adjacencyList.get(destination).remove(source);
        }
        
        return true;
    }
    
    /**
     * Gets all vertices in the graph.
     * 
     * @return a set of all vertices
     */
    public Set<T> getVertices() {
        return new HashSet<>(adjacencyList.keySet());
    }
    
    /**
     * Gets all neighbors of a vertex.
     * 
     * @param vertex the vertex to get neighbors for
     * @return a map of neighbors and their edge weights, or null if the vertex doesn't exist
     */
    public Map<T, Integer> getNeighbors(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return null;
        }
        
        return new HashMap<>(adjacencyList.get(vertex));
    }
    
    /**
     * Checks if the graph contains a vertex.
     * 
     * @param vertex the vertex to check
     * @return true if the vertex exists, false otherwise
     */
    public boolean containsVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }
    
    /**
     * Checks if the graph contains an edge between two vertices.
     * 
     * @param source the source vertex
     * @param destination the destination vertex
     * @return true if the edge exists, false otherwise
     */
    public boolean containsEdge(T source, T destination) {
        // Check if the vertices exist
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            return false;
        }
        
        // Check if the edge exists
        return adjacencyList.get(source).containsKey(destination);
    }
    
    /**
     * Gets the weight of an edge between two vertices.
     * 
     * @param source the source vertex
     * @param destination the destination vertex
     * @return the weight of the edge, or -1 if the edge doesn't exist
     */
    public int getEdgeWeight(T source, T destination) {
        // Check if the vertices exist
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            return -1;
        }
        
        // Check if the edge exists
        if (!adjacencyList.get(source).containsKey(destination)) {
            return -1;
        }
        
        return adjacencyList.get(source).get(destination);
    }
    
    /**
     * Gets the number of vertices in the graph.
     * 
     * @return the number of vertices
     */
    public int getVertexCount() {
        return adjacencyList.size();
    }
    
    /**
     * Gets the number of edges in the graph.
     * 
     * @return the number of edges
     */
    public int getEdgeCount() {
        int count = 0;
        
        // Count the number of edges in the adjacency list
        for (Map<T, Integer> edges : adjacencyList.values()) {
            count += edges.size();
        }
        
        // If the graph is undirected, each edge is counted twice
        if (!directed) {
            count /= 2;
        }
        
        return count;
    }
    
    /**
     * Checks if the graph is directed.
     * 
     * @return true if the graph is directed, false otherwise
     */
    public boolean isDirected() {
        return directed;
    }
    
    /**
     * Checks if the graph is weighted.
     * 
     * @return true if the graph is weighted, false otherwise
     */
    public boolean isWeighted() {
        return weighted;
    }
    
    /**
     * Gets the adjacency list representation of the graph.
     * 
     * @return the adjacency list
     */
    public Map<T, Map<T, Integer>> getAdjacencyList() {
        return adjacencyList;
    }
    
    /**
     * Checks if there is an edge between two vertices.
     * 
     * @param source the source vertex
     * @param destination the destination vertex
     * @return true if there is an edge, false otherwise
     */
    public boolean hasEdge(T source, T destination) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            return false;
        }
        return adjacencyList.get(source).containsKey(destination);
    }
    
    /**
     * Gets the weight of an edge between two vertices.
     * 
     * @param source the source vertex
     * @param destination the destination vertex
     * @return the weight of the edge, or -1 if there is no edge
     */
    public int getWeight(T source, T destination) {
        if (!hasEdge(source, destination)) {
            return -1;
        }
        return adjacencyList.get(source).get(destination);
    }
    
    /**
     * Performs a breadth-first search starting from a given vertex.
     * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
     * 
     * @param start the vertex to start from
     * @return a list of vertices in BFS order, or an empty list if the start vertex doesn't exist
     */
    public List<T> bfs(T start) {
        if (!adjacencyList.containsKey(start)) {
            return new ArrayList<>();
        }
        
        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        
        // Add the start vertex to the queue and mark it as visited
        queue.offer(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            // Remove the next vertex from the queue
            T current = queue.poll();
            
            // Add the vertex to the result
            result.add(current);
            
            // Visit all neighbors
            for (T neighbor : adjacencyList.get(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    // Mark the neighbor as visited and add it to the queue
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        
        return result;
    }
    
    /**
     * Performs a depth-first search starting from a given vertex.
     * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
     * 
     * @param start the vertex to start from
     * @return a list of vertices in DFS order, or an empty list if the start vertex doesn't exist
     */
    public List<T> dfs(T start) {
        if (!adjacencyList.containsKey(start)) {
            return new ArrayList<>();
        }
        
        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        
        // Call the recursive DFS helper method
        dfsHelper(start, visited, result);
        
        return result;
    }
    
    /**
     * Helper method for DFS traversal.
     * 
     * @param current the current vertex
     * @param visited the set of visited vertices
     * @param result the list to store the result
     */
    private void dfsHelper(T current, Set<T> visited, List<T> result) {
        // Mark the current vertex as visited
        visited.add(current);
        
        // Add the vertex to the result
        result.add(current);
        
        // Visit all neighbors
        for (T neighbor : adjacencyList.get(current).keySet()) {
            if (!visited.contains(neighbor)) {
                // Recursively visit the neighbor
                dfsHelper(neighbor, visited, result);
            }
        }
    }
    
    /**
     * Checks if the graph has a cycle.
     * 
     * @return true if the graph has a cycle, false otherwise
     */
    public boolean hasCycle() {
        Set<T> visited = new HashSet<>();
        Set<T> recStack = new HashSet<>();
        
        // Check for cycles starting from each unvisited vertex
        for (T vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                if (hasCycleHelper(vertex, visited, recStack)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Helper method to check for cycles.
     * 
     * @param current the current vertex
     * @param visited the set of visited vertices
     * @param recStack the set of vertices in the current recursion stack
     * @return true if a cycle is found, false otherwise
     */
    private boolean hasCycleHelper(T current, Set<T> visited, Set<T> recStack) {
        // Mark the current vertex as visited
        visited.add(current);
        
        // Add to recursion stack
        recStack.add(current);
        
        // Visit all neighbors
        for (T neighbor : adjacencyList.get(current).keySet()) {
            // If the neighbor is not visited, recursively check for cycles
            if (!visited.contains(neighbor)) {
                if (hasCycleHelper(neighbor, visited, recStack)) {
                    return true;
                }
            } 
            // If the neighbor is in the recursion stack, there's a cycle
            else if (recStack.contains(neighbor)) {
                return true;
            }
        }
        
        // Remove from recursion stack
        recStack.remove(current);
        
        return false;
    }
    
    /**
     * Computes the shortest path from a source vertex to all other vertices using Dijkstra's algorithm.
     * Time Complexity: O((V + E) log V) where V is the number of vertices and E is the number of edges
     * 
     * @param source the source vertex
     * @return a map containing the shortest distance to each vertex, or null if the source vertex doesn't exist
     */
    public Map<T, Integer> dijkstra(T source) {
        if (!adjacencyList.containsKey(source)) {
            return null;
        }
        
        // Initialize distances
        Map<T, Integer> distances = new HashMap<>();
        for (T vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        
        // Priority queue to store vertices based on their distance
        PriorityQueue<VertexDistance<T>> pq = new PriorityQueue<>(
            Comparator.comparingInt(vd -> vd.distance)
        );
        pq.offer(new VertexDistance<>(source, 0));
        
        // Set to keep track of processed vertices
        Set<T> processed = new HashSet<>();
        
        while (!pq.isEmpty()) {
            // Get the vertex with the smallest distance
            VertexDistance<T> current = pq.poll();
            T currentVertex = current.vertex;
            
            // If the vertex has already been processed, skip it
            if (processed.contains(currentVertex)) {
                continue;
            }
            
            // Mark the vertex as processed
            processed.add(currentVertex);
            
            // Update distances to neighbors
            for (Map.Entry<T, Integer> neighbor : adjacencyList.get(currentVertex).entrySet()) {
                T neighborVertex = neighbor.getKey();
                int weight = neighbor.getValue();
                
                // Skip processed neighbors
                if (processed.contains(neighborVertex)) {
                    continue;
                }
                
                // Calculate the new distance
                int newDistance = distances.get(currentVertex) + weight;
                
                // If the new distance is smaller, update it
                if (newDistance < distances.get(neighborVertex)) {
                    distances.put(neighborVertex, newDistance);
                    pq.offer(new VertexDistance<>(neighborVertex, newDistance));
                }
            }
        }
        
        return distances;
    }
    
    /**
     * Helper class for Dijkstra's algorithm.
     */
    private static class VertexDistance<T> {
        T vertex;
        int distance;
        
        VertexDistance(T vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
    
    /**
     * Computes a minimum spanning tree of the graph using Prim's algorithm.
     * Time Complexity: O((V + E) log V) where V is the number of vertices and E is the number of edges
     * 
     * @return a new graph representing the minimum spanning tree, or null if the graph is empty
     */
    public Graph<T> minimumSpanningTree() {
        if (adjacencyList.isEmpty()) {
            return null;
        }
        
        // Create a new graph for the MST
        Graph<T> mst = new Graph<>(false);
        
        // Add all vertices to the MST
        for (T vertex : adjacencyList.keySet()) {
            mst.addVertex(vertex);
        }
        
        // Set to keep track of vertices in the MST
        Set<T> inMST = new HashSet<>();
        
        // Priority queue to store edges based on their weight
        PriorityQueue<Edge<T>> pq = new PriorityQueue<>(
            Comparator.comparingInt(e -> e.weight)
        );
        
        // Start with an arbitrary vertex
        T start = adjacencyList.keySet().iterator().next();
        inMST.add(start);
        
        // Add all edges from the start vertex to the priority queue
        for (Map.Entry<T, Integer> neighbor : adjacencyList.get(start).entrySet()) {
            pq.offer(new Edge<>(start, neighbor.getKey(), neighbor.getValue()));
        }
        
        // Continue until all vertices are in the MST or the priority queue is empty
        while (!pq.isEmpty() && inMST.size() < adjacencyList.size()) {
            // Get the edge with the smallest weight
            Edge<T> edge = pq.poll();
            
            // If the destination vertex is already in the MST, skip it
            if (inMST.contains(edge.destination)) {
                continue;
            }
            
            // Add the edge to the MST
            mst.addEdge(edge.source, edge.destination, edge.weight);
            
            // Add the destination vertex to the MST
            inMST.add(edge.destination);
            
            // Add all edges from the destination vertex to the priority queue
            for (Map.Entry<T, Integer> neighbor : adjacencyList.get(edge.destination).entrySet()) {
                // Skip vertices already in the MST
                if (!inMST.contains(neighbor.getKey())) {
                    pq.offer(new Edge<>(edge.destination, neighbor.getKey(), neighbor.getValue()));
                }
            }
        }
        
        return mst;
    }
    
    /**
     * Helper class for minimum spanning tree algorithm.
     */
    private static class Edge<T> {
        T source;
        T destination;
        int weight;
        
        Edge(T source, T destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    /**
     * Performs a topological sort of the graph.
     * Only applicable to directed acyclic graphs (DAGs).
     * 
     * @return a list of vertices in topological order, or null if the graph has a cycle
     */
    public List<T> topologicalSort() {
        // Check if the graph is directed
        if (!directed) {
            return null;
        }
        
        // Check if the graph has a cycle
        if (hasCycle()) {
            return null;
        }
        
        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        
        // Visit each unvisited vertex
        for (T vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                topologicalSortHelper(vertex, visited, result);
            }
        }
        
        // Reverse the result to get the topological order
        Collections.reverse(result);
        
        return result;
    }
    
    /**
     * Helper method for topological sort.
     * 
     * @param current the current vertex
     * @param visited the set of visited vertices
     * @param result the list to store the result
     */
    private void topologicalSortHelper(T current, Set<T> visited, List<T> result) {
        // Mark the current vertex as visited
        visited.add(current);
        
        // Visit all neighbors
        for (T neighbor : adjacencyList.get(current).keySet()) {
            if (!visited.contains(neighbor)) {
                topologicalSortHelper(neighbor, visited, result);
            }
        }
        
        // Add the current vertex to the result
        result.add(current);
    }
    
    /**
     * String representation of the graph.
     * 
     * @return a string representation of the graph
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph: ").append(directed ? "directed" : "undirected").append("\n");
        
        for (Map.Entry<T, Map<T, Integer>> entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey()).append(" -> ");
            
            for (Map.Entry<T, Integer> neighbor : entry.getValue().entrySet()) {
                sb.append(neighbor.getKey()).append("(").append(neighbor.getValue()).append(") ");
            }
            
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
