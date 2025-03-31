package com.datastructures.heap;

import java.util.Arrays;
import java.util.List;

/**
 * Example class to demonstrate the usage of MaxHeap and MinHeap implementations.
 * This class contains a method that shows different operations
 * that can be performed on heaps.
 */
public class HeapExample {
    
    /**
     * Runs examples demonstrating heap operations.
     */
    public static void runExample() {
        // Example 1: MaxHeap with integers
        System.out.println("MaxHeap Example with integers:");
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        
        // Insert elements
        System.out.println("Inserting elements: 10, 5, 15, 7, 20, 30, 25");
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(15);
        maxHeap.insert(7);
        maxHeap.insert(20);
        maxHeap.insert(30);
        maxHeap.insert(25);
        
        // Print the heap
        System.out.println("MaxHeap: " + maxHeap);
        
        // Peek at the maximum element
        System.out.println("Max element: " + maxHeap.peek());
        
        // Extract the maximum element
        System.out.println("Extracting max elements one by one:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.extractMax() + " ");
        }
        System.out.println("\nMaxHeap after extraction: " + maxHeap);
        
        // Example 2: MaxHeap initialization with a list
        System.out.println("\nMaxHeap initialized with a list:");
        List<Integer> numbers = Arrays.asList(4, 8, 2, 9, 5, 7, 1, 6, 3);
        MaxHeap<Integer> maxHeapFromList = new MaxHeap<>(numbers);
        System.out.println("Initial list: " + numbers);
        System.out.println("MaxHeap: " + maxHeapFromList);
        
        // Extracting in sorted order (descending)
        System.out.println("Extracting max elements (sorted in descending order):");
        while (!maxHeapFromList.isEmpty()) {
            System.out.print(maxHeapFromList.extractMax() + " ");
        }
        System.out.println();
        
        // Example 3: MinHeap with integers
        System.out.println("\nMinHeap Example with integers:");
        MinHeap<Integer> minHeap = new MinHeap<>();
        
        // Insert elements
        System.out.println("Inserting elements: 10, 5, 15, 7, 20, 30, 25");
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(7);
        minHeap.insert(20);
        minHeap.insert(30);
        minHeap.insert(25);
        
        // Print the heap
        System.out.println("MinHeap: " + minHeap);
        
        // Peek at the minimum element
        System.out.println("Min element: " + minHeap.peek());
        
        // Extract the minimum element
        System.out.println("Extracting min elements one by one:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.extractMin() + " ");
        }
        System.out.println("\nMinHeap after extraction: " + minHeap);
        
        // Example 4: MinHeap initialization with a list
        System.out.println("\nMinHeap initialized with a list:");
        List<Integer> numbers2 = Arrays.asList(4, 8, 2, 9, 5, 7, 1, 6, 3);
        MinHeap<Integer> minHeapFromList = new MinHeap<>(numbers2);
        System.out.println("Initial list: " + numbers2);
        System.out.println("MinHeap: " + minHeapFromList);
        
        // Extracting in sorted order (ascending)
        System.out.println("Extracting min elements (sorted in ascending order):");
        while (!minHeapFromList.isEmpty()) {
            System.out.print(minHeapFromList.extractMin() + " ");
        }
        System.out.println();
        
        // Example 5: Priority Queue using MinHeap for strings
        System.out.println("\nPriority Queue using MinHeap for strings:");
        MinHeap<String> priorityQueue = new MinHeap<>();
        
        // Insert tasks with priorities (lexicographical order for simplicity)
        priorityQueue.insert("A-High Priority Task");
        priorityQueue.insert("C-Low Priority Task");
        priorityQueue.insert("B-Medium Priority Task");
        
        System.out.println("Tasks in priority order:");
        while (!priorityQueue.isEmpty()) {
            System.out.println("Processing: " + priorityQueue.extractMin());
        }
    }
}
