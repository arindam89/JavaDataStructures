package com.datastructures.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Test class for Graph implementation.
 */
public class GraphTest {
    
    private Graph<String> undirectedGraph;
    private Graph<String> directedGraph;
    
    @BeforeEach
    void setUp() {
        undirectedGraph = new Graph<>();
        directedGraph = new Graph<>(true);
        
        // Add vertices
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("B");
        undirectedGraph.addVertex("C");
        undirectedGraph.addVertex("D");
        undirectedGraph.addVertex("E");
        
        directedGraph.addVertex("A");
        directedGraph.addVertex("B");
        directedGraph.addVertex("C");
        directedGraph.addVertex("D");
        directedGraph.addVertex("E");
        
        // Add edges
        undirectedGraph.addEdge("A", "B", 2);
        undirectedGraph.addEdge("A", "C", 3);
        undirectedGraph.addEdge("B", "D", 1);
        undirectedGraph.addEdge("C", "D", 5);
        undirectedGraph.addEdge("D", "E", 4);
        
        directedGraph.addEdge("A", "B", 2);
        directedGraph.addEdge("A", "C", 3);
        directedGraph.addEdge("B", "D", 1);
        directedGraph.addEdge("C", "D", 5);
        directedGraph.addEdge("D", "E", 4);
    }
    
    @Test
    void testAddVertex() {
        // Test adding a new vertex
        assertTrue(undirectedGraph.addVertex("F"));
        assertTrue(undirectedGraph.containsVertex("F"));
        
        // Test adding an existing vertex
        assertFalse(undirectedGraph.addVertex("A"));
    }
    
    @Test
    void testAddEdge() {
        // Test adding a new edge
        assertTrue(undirectedGraph.addEdge("A", "E", 6));
        assertTrue(undirectedGraph.containsEdge("A", "E"));
        assertTrue(undirectedGraph.containsEdge("E", "A"));
        assertEquals(6, undirectedGraph.getEdgeWeight("A", "E"));
        
        // Test adding an edge with default weight
        assertTrue(undirectedGraph.addEdge("B", "C"));
        assertTrue(undirectedGraph.containsEdge("B", "C"));
        assertEquals(1, undirectedGraph.getEdgeWeight("B", "C"));
        
        // Test adding an edge with non-existent vertices
        assertFalse(undirectedGraph.addEdge("A", "F"));
        assertFalse(undirectedGraph.addEdge("F", "A"));
        assertFalse(undirectedGraph.addEdge("F", "G"));
    }
    
    @Test
    void testRemoveVertex() {
        // Test removing an existing vertex
        assertTrue(undirectedGraph.removeVertex("C"));
        assertFalse(undirectedGraph.containsVertex("C"));
        assertFalse(undirectedGraph.containsEdge("A", "C"));
        assertFalse(undirectedGraph.containsEdge("C", "D"));
        
        // Test removing a non-existent vertex
        assertFalse(undirectedGraph.removeVertex("F"));
    }
    
    @Test
    void testRemoveEdge() {
        // Test removing an existing edge
        assertTrue(undirectedGraph.removeEdge("A", "B"));
        assertFalse(undirectedGraph.containsEdge("A", "B"));
        assertFalse(undirectedGraph.containsEdge("B", "A"));
        
        // Test removing a non-existent edge
        assertFalse(undirectedGraph.removeEdge("A", "E"));
        
        // Test removing an edge with non-existent vertices
        assertFalse(undirectedGraph.removeEdge("A", "F"));
        assertFalse(undirectedGraph.removeEdge("F", "A"));
    }
    
    @Test
    void testGetVertices() {
        Set<String> vertices = undirectedGraph.getVertices();
        assertEquals(5, vertices.size());
        assertTrue(vertices.contains("A"));
        assertTrue(vertices.contains("B"));
        assertTrue(vertices.contains("C"));
        assertTrue(vertices.contains("D"));
        assertTrue(vertices.contains("E"));
    }
    
    @Test
    void testGetNeighbors() {
        // Test getting neighbors of an existing vertex
        Map<String, Integer> neighborsA = undirectedGraph.getNeighbors("A");
        assertEquals(2, neighborsA.size());
        assertTrue(neighborsA.containsKey("B"));
        assertTrue(neighborsA.containsKey("C"));
        assertEquals(2, neighborsA.get("B"));
        assertEquals(3, neighborsA.get("C"));
        
        // Test getting neighbors of a vertex with no neighbors
        undirectedGraph.addVertex("F");
        Map<String, Integer> neighborsF = undirectedGraph.getNeighbors("F");
        assertEquals(0, neighborsF.size());
        
        // Test getting neighbors of a non-existent vertex
        assertNull(undirectedGraph.getNeighbors("G"));
    }
    
    @Test
    void testContainsVertex() {
        assertTrue(undirectedGraph.containsVertex("A"));
        assertTrue(undirectedGraph.containsVertex("E"));
        assertFalse(undirectedGraph.containsVertex("F"));
    }
    
    @Test
    void testContainsEdge() {
        assertTrue(undirectedGraph.containsEdge("A", "B"));
        assertTrue(undirectedGraph.containsEdge("B", "A"));
        assertFalse(undirectedGraph.containsEdge("A", "E"));
        assertFalse(undirectedGraph.containsEdge("A", "F"));
    }
    
    @Test
    void testGetEdgeWeight() {
        assertEquals(2, undirectedGraph.getEdgeWeight("A", "B"));
        assertEquals(2, undirectedGraph.getEdgeWeight("B", "A"));
        assertEquals(-1, undirectedGraph.getEdgeWeight("A", "E"));
        assertEquals(-1, undirectedGraph.getEdgeWeight("A", "F"));
    }
    
    @Test
    void testGetVertexCount() {
        assertEquals(5, undirectedGraph.getVertexCount());
        
        undirectedGraph.addVertex("F");
        assertEquals(6, undirectedGraph.getVertexCount());
        
        undirectedGraph.removeVertex("F");
        assertEquals(5, undirectedGraph.getVertexCount());
    }
    
    @Test
    void testGetEdgeCount() {
        assertEquals(5, undirectedGraph.getEdgeCount());
        
        undirectedGraph.addEdge("A", "E", 6);
        assertEquals(6, undirectedGraph.getEdgeCount());
        
        undirectedGraph.removeEdge("A", "B");
        assertEquals(5, undirectedGraph.getEdgeCount());
    }
    
    @Test
    void testIsDirected() {
        assertFalse(undirectedGraph.isDirected());
        assertTrue(directedGraph.isDirected());
    }
    
    @Test
    void testBfs() {
        List<String> bfsResult = undirectedGraph.bfs("A");
        assertEquals(5, bfsResult.size());
        assertEquals("A", bfsResult.get(0));
        
        // Test BFS from a non-existent vertex
        List<String> emptyResult = undirectedGraph.bfs("F");
        assertTrue(emptyResult.isEmpty());
    }
    
    @Test
    void testDfs() {
        List<String> dfsResult = undirectedGraph.dfs("A");
        assertEquals(5, dfsResult.size());
        assertEquals("A", dfsResult.get(0));
        
        // Test DFS from a non-existent vertex
        List<String> emptyResult = undirectedGraph.dfs("F");
        assertTrue(emptyResult.isEmpty());
    }
    
    @Test
    void testHasCycle() {
        assertTrue(undirectedGraph.hasCycle());
        
        // Create a graph without cycles
        Graph<String> acyclicGraph = new Graph<>();
        acyclicGraph.addVertex("A");
        acyclicGraph.addVertex("B");
        acyclicGraph.addVertex("C");
        
        acyclicGraph.addEdge("A", "B");
        acyclicGraph.addEdge("B", "C");
        
        assertFalse(acyclicGraph.hasCycle());
    }
    
    @Test
    void testDijkstra() {
        Map<String, Integer> shortestPaths = undirectedGraph.dijkstra("A");
        assertEquals(5, shortestPaths.size());
        assertEquals(0, shortestPaths.get("A"));
        assertEquals(2, shortestPaths.get("B"));
        assertEquals(3, shortestPaths.get("C"));
        assertEquals(3, shortestPaths.get("D"));
        assertEquals(7, shortestPaths.get("E"));
        
        // Test Dijkstra from a non-existent vertex
        assertNull(undirectedGraph.dijkstra("F"));
    }
    
    @Test
    void testMinimumSpanningTree() {
        Graph<String> mst = undirectedGraph.minimumSpanningTree();
        assertEquals(5, mst.getVertexCount());
        assertEquals(4, mst.getEdgeCount());
        
        // Check that the MST is connected
        List<String> bfsResult = mst.bfs("A");
        assertEquals(5, bfsResult.size());
        
        // Create an empty graph
        Graph<String> emptyGraph = new Graph<>();
        assertNull(emptyGraph.minimumSpanningTree());
    }
    
    @Test
    void testTopologicalSort() {
        // Create a directed acyclic graph
        Graph<String> dag = new Graph<>(true);
        dag.addVertex("A");
        dag.addVertex("B");
        dag.addVertex("C");
        dag.addVertex("D");
        dag.addVertex("E");
        
        dag.addEdge("A", "B");
        dag.addEdge("A", "C");
        dag.addEdge("B", "D");
        dag.addEdge("C", "D");
        dag.addEdge("D", "E");
        
        List<String> topoSort = dag.topologicalSort();
        assertEquals(5, topoSort.size());
        assertEquals("A", topoSort.get(0));
        assertEquals("E", topoSort.get(4));
        
        // Test topological sort on an undirected graph
        assertNull(undirectedGraph.topologicalSort());
        
        // Test topological sort on a graph with a cycle
        Graph<String> cyclicGraph = new Graph<>(true);
        cyclicGraph.addVertex("A");
        cyclicGraph.addVertex("B");
        cyclicGraph.addVertex("C");
        
        cyclicGraph.addEdge("A", "B");
        cyclicGraph.addEdge("B", "C");
        cyclicGraph.addEdge("C", "A");
        
        assertNull(cyclicGraph.topologicalSort());
    }
    
    @Test
    void testToString() {
        String result = undirectedGraph.toString();
        assertNotNull(result);
        assertTrue(result.contains("undirected"));
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
        assertTrue(result.contains("D"));
        assertTrue(result.contains("E"));
    }
}
