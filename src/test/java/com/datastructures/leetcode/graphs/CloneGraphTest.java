package com.datastructures.leetcode.graphs;

import org.junit.jupiter.api.Test;

import com.leetcode.graphs.CloneGraph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Test cases for the Clone Graph problem.
 */
public class CloneGraphTest {
    
    @Test
    public void testCloneGraphExample1() {
        CloneGraph solution = new CloneGraph();
        
        // Create a graph with 4 nodes: [[2,4],[1,3],[2,4],[1,3]]
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        
        CloneGraph.Node clonedNode = solution.cloneGraph(node1);
        
        // Verify the cloned graph structure
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.size());
        
        // Verify that the cloned node is not the same object as the original
        assertNotSame(node1, clonedNode);
        
        // Get neighbor values
        Set<Integer> neighborValues = new HashSet<>();
        for (CloneGraph.Node neighbor : clonedNode.neighbors) {
            neighborValues.add(neighbor.val);
        }
        
        // Verify neighbor values
        assertEquals(new HashSet<>(Arrays.asList(2, 4)), neighborValues);
    }
    
    @Test
    public void testCloneGraphBFS() {
        CloneGraph solution = new CloneGraph();
        
        // Create a graph with 4 nodes
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        
        CloneGraph.Node clonedNode = solution.cloneGraphBFS(node1);
        
        // Verify the cloned graph structure
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.size());
        
        // Verify that the cloned node is not the same object as the original
        assertNotSame(node1, clonedNode);
    }
    
    @Test
    public void testCloneGraphNullAndSingleNode() {
        CloneGraph solution = new CloneGraph();
        
        // Test with null node
        assertNull(solution.cloneGraph(null));
        
        // Test with a single node with no neighbors
        CloneGraph.Node singleNode = new CloneGraph.Node(1);
        CloneGraph.Node clonedSingleNode = solution.cloneGraph(singleNode);
        
        assertNotNull(clonedSingleNode);
        assertEquals(1, clonedSingleNode.val);
        assertEquals(0, clonedSingleNode.neighbors.size());
        assertNotSame(singleNode, clonedSingleNode);
    }
    
    @Test
    public void testCloneGraphCyclic() {
        CloneGraph solution = new CloneGraph();
        
        // Create a cyclic graph with 3 nodes in a circle
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);
        
        CloneGraph.Node clonedNode = solution.cloneGraph(node1);
        
        // Verify the structure
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(1, clonedNode.neighbors.size());
        
        CloneGraph.Node clonedNode2 = clonedNode.neighbors.get(0);
        assertEquals(2, clonedNode2.val);
        assertEquals(1, clonedNode2.neighbors.size());
        
        CloneGraph.Node clonedNode3 = clonedNode2.neighbors.get(0);
        assertEquals(3, clonedNode3.val);
        assertEquals(1, clonedNode3.neighbors.size());
        
        // The cycle should be complete - node3 should point back to node1
        assertSame(clonedNode, clonedNode3.neighbors.get(0));
    }
    
    @Test
    public void testCreateGraph() {
        CloneGraph solution = new CloneGraph();
        
        // Create a simple graph with 4 nodes
        int[][] edges = {{1, 2}, {1, 4}, {2, 3}, {3, 4}};
        CloneGraph.Node graph = solution.createGraph(4, edges);
        
        assertNotNull(graph);
        assertEquals(1, graph.val);
        assertEquals(2, graph.neighbors.size());
        
        // Clone the graph
        CloneGraph.Node clonedGraph = solution.cloneGraph(graph);
        
        // Verify the cloned graph is a deep copy
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(2, clonedGraph.neighbors.size());
        assertNotSame(graph, clonedGraph);
        
        // Ensure the structures are identical
        String originalGraphString = solution.graphToString(graph);
        String clonedGraphString = solution.graphToString(clonedGraph);
        
        assertEquals(originalGraphString, clonedGraphString);
    }
    
    @Test
    public void testGraphToString() {
        CloneGraph solution = new CloneGraph();
        
        // Create a simple graph
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        
        String graphString = solution.graphToString(node1);
        
        assertNotNull(graphString);
        assertTrue(graphString.contains("Node 1 -> Neighbors: [2]"));
        assertTrue(graphString.contains("Node 2 -> Neighbors: [1]"));
    }
    
    @Test
    public void testBothCloneMethodsGiveSameResult() {
        CloneGraph solution = new CloneGraph();
        
        // Create a graph for testing
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 4}};
        CloneGraph.Node graph = solution.createGraph(4, edges);
        
        // Clone the graph using both methods
        CloneGraph.Node dfsClone = solution.cloneGraph(graph);
        CloneGraph.Node bfsClone = solution.cloneGraphBFS(graph);
        
        // Compare the string representations
        String dfsString = solution.graphToString(dfsClone);
        String bfsString = solution.graphToString(bfsClone);
        
        assertEquals(dfsString, bfsString);
    }
}