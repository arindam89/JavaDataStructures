package com.datastructures.visualization;

import com.datastructures.linkedlist.LinkedList;
import com.datastructures.tree.BinaryTree;
import com.datastructures.tree.TreeNode;
import com.datastructures.bst.BinarySearchTree;
import com.datastructures.heap.MaxHeap;
import com.datastructures.graph.Graph;
import com.datastructures.trie.Trie;

/**
 * Example class to demonstrate the visualization of different data structures.
 */
public class VisualizationExample {
    
    /**
     * Run examples for all data structure visualizations.
     */
    public static void runExample() {
        System.out.println("=== Data Structure Visualizations ===\n");
        
        // Linked List Visualization
        demonstrateLinkedListVisualization();
        
        // Binary Tree Visualization
        demonstrateBinaryTreeVisualization();
        
        // Binary Search Tree Visualization
        demonstrateBSTVisualization();
        
        // Heap Visualization
        demonstrateHeapVisualization();
        
        // Graph Visualization
        demonstrateGraphVisualization();
        
        // Trie Visualization
        demonstrateTrieVisualization();
    }
    
    /**
     * Demonstrates LinkedList visualization.
     */
    private static void demonstrateLinkedListVisualization() {
        System.out.println("\n=== Linked List Visualization ===\n");
        
        // Create a linked list
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        
        // Create a visualizer
        LinkedListVisualizer visualizer = new LinkedListVisualizer(list);
        
        // Display horizontal visualization
        System.out.println("Horizontal visualization:");
        System.out.println(visualizer.visualizeHorizontal());
        
        // Display vertical visualization
        System.out.println("Vertical visualization:");
        System.out.println(visualizer.visualizeVertical());
        
        System.out.println("---------------------------------------");
    }
    
    /**
     * Demonstrates BinaryTree visualization.
     */
    private static void demonstrateBinaryTreeVisualization() {
        System.out.println("\n=== Binary Tree Visualization ===\n");
        
        // Create a binary tree
        BinaryTree<Integer> tree = new BinaryTree<>();
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(3));
        root.getLeft().setLeft(new TreeNode<>(4));
        root.getLeft().setRight(new TreeNode<>(5));
        root.getRight().setLeft(new TreeNode<>(6));
        tree.setRoot(root);
        
        // Create a visualizer
        BinaryTreeVisualizer visualizer = new BinaryTreeVisualizer(tree);
        
        // Display basic visualization
        System.out.println("Basic Binary Tree visualization:");
        System.out.println(visualizer.visualize());
        
        // Display detailed visualization
        System.out.println("Detailed Binary Tree visualization:");
        System.out.println(visualizer.visualizeDetailed());
        
        System.out.println("---------------------------------------");
    }
    
    /**
     * Demonstrates BinarySearchTree visualization.
     */
    private static void demonstrateBSTVisualization() {
        System.out.println("\n=== Binary Search Tree Visualization ===\n");
        
        // Create a BST
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        
        // Create a visualizer
        BinarySearchTreeVisualizer visualizer = new BinarySearchTreeVisualizer(bst);
        
        // Display basic visualization
        System.out.println("Basic BST visualization:");
        System.out.println(visualizer.visualize());
        
        // Display search visualization
        System.out.println("BST search visualization (searching for 6):");
        System.out.println(visualizer.visualizeSearch(6));
        
        System.out.println("---------------------------------------");
    }
    
    /**
     * Demonstrates Heap visualization.
     */
    private static void demonstrateHeapVisualization() {
        System.out.println("\n=== Heap Visualization ===\n");
        
        // Create a MaxHeap
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(17);
        maxHeap.insert(4);
        maxHeap.insert(22);
        
        // Create a visualizer
        HeapVisualizer visualizer = new HeapVisualizer(maxHeap);
        
        // Display basic visualization
        System.out.println("Basic Heap visualization:");
        System.out.println(visualizer.visualize());
        
        // Display detailed visualization
        System.out.println("Detailed Heap visualization:");
        System.out.println(visualizer.visualizeDetailed());
        
        System.out.println("---------------------------------------");
    }
    
    /**
     * Demonstrates Graph visualization.
     */
    private static void demonstrateGraphVisualization() {
        System.out.println("\n=== Graph Visualization ===\n");
        
        // Create an undirected graph
        Graph<String> graph = new Graph<>(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        
        // Create a visualizer
        GraphVisualizer<String> visualizer = new GraphVisualizer<>(graph);
        
        // Display circular layout visualization
        System.out.println("Graph visualization (circular layout):");
        System.out.println(visualizer.visualize());
        
        // Display adjacency list
        System.out.println("Graph visualization (adjacency list):");
        System.out.println(visualizer.visualizeAdjacencyList());
        
        // Display matrix representation
        System.out.println("Graph visualization (adjacency matrix):");
        System.out.println(visualizer.visualizeMatrix());
        
        System.out.println("---------------------------------------");
    }
    
    /**
     * Demonstrates Trie visualization.
     */
    private static void demonstrateTrieVisualization() {
        System.out.println("\n=== Trie Visualization ===\n");
        
        // Create a Trie
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("application");
        trie.insert("apply");
        trie.insert("apparatus");
        trie.insert("banana");
        trie.insert("band");
        
        // Create a visualizer
        TrieVisualizer visualizer = new TrieVisualizer(trie);
        
        // Display basic visualization
        System.out.println("Basic Trie visualization:");
        System.out.println(visualizer.visualize());
        
        // Display detailed visualization
        System.out.println("Detailed Trie visualization:");
        System.out.println(visualizer.visualizeDetailed());
        
        // Display search visualization
        System.out.println("Trie search visualization (searching for prefix 'app'):");
        System.out.println(visualizer.visualizeSearch("app"));
        
        System.out.println("---------------------------------------");
    }
}