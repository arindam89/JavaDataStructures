package com.datastructures.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a Max Heap data structure.
 * A Max Heap is a complete binary tree where the value of each node is greater than
 * or equal to the values of its children. This ensures that the maximum element
 * is always at the root.
 * 
 * Time Complexity:
 * - Insert: O(log n) - May need to heapify up to maintain the heap property
 * - Extract Max: O(log n) - Need to heapify down after removing the root
 * - Peek (Get Max): O(1) - Always at the root
 * - Heapify: O(n) - Building a heap from an array
 * 
 * Space Complexity: O(n) where n is the number of elements
 * 
 * @param <T> the type of elements in this heap, must be comparable
 */
public class MaxHeap<T extends Comparable<T>> {
    
    // List to store the heap elements
    private List<T> heap;
    
    /**
     * Constructs an empty max heap.
     */
    public MaxHeap() {
        heap = new ArrayList<>();
    }
    
    /**
     * Constructs a max heap from an initial collection of elements.
     * 
     * @param elements the initial elements to add to the heap
     */
    public MaxHeap(List<T> elements) {
        // Initialize the heap with the elements
        heap = new ArrayList<>(elements);
        
        // Heapify the elements to satisfy the max heap property
        heapify();
    }
    
    /**
     * Returns the parent index of a given index.
     * 
     * @param index the index to find the parent of
     * @return the parent index
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }
    
    /**
     * Returns the left child index of a given index.
     * 
     * @param index the index to find the left child of
     * @return the left child index
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    
    /**
     * Returns the right child index of a given index.
     * 
     * @param index the index to find the right child of
     * @return the right child index
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    
    /**
     * Swaps the elements at the given indices in the heap.
     * 
     * @param i the first index
     * @param j the second index
     */
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    /**
     * Moves an element up the heap to its correct position.
     * This is used after inserting a new element at the bottom.
     * 
     * @param index the index of the element to sift up
     */
    private void siftUp(int index) {
        // Continue sifting up as long as we're not at the root and
        // the parent is smaller than the current element
        while (index > 0 && heap.get(parent(index)).compareTo(heap.get(index)) < 0) {
            // Swap with the parent
            swap(index, parent(index));
            
            // Move up to the parent index
            index = parent(index);
        }
    }
    
    /**
     * Moves an element down the heap to its correct position.
     * This is used after removing the maximum element from the root.
     * 
     * @param index the index of the element to sift down
     */
    private void siftDown(int index) {
        int maxIndex = index;
        int leftIndex = leftChild(index);
        
        // Compare with left child
        if (leftIndex < heap.size() && heap.get(leftIndex).compareTo(heap.get(maxIndex)) > 0) {
            maxIndex = leftIndex;
        }
        
        int rightIndex = rightChild(index);
        
        // Compare with right child
        if (rightIndex < heap.size() && heap.get(rightIndex).compareTo(heap.get(maxIndex)) > 0) {
            maxIndex = rightIndex;
        }
        
        // If the max is not the current index, swap and continue sifting down
        if (index != maxIndex) {
            swap(index, maxIndex);
            siftDown(maxIndex);
        }
    }
    
    /**
     * Builds a heap from the current list of elements.
     * This is done by sifting down each non-leaf node starting
     * from the lowest one.
     * Time Complexity: O(n)
     */
    private void heapify() {
        // Start from the last non-leaf node and sift down each node
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }
    
    /**
     * Inserts an element into the heap.
     * Time Complexity: O(log n)
     * 
     * @param element the element to insert
     */
    public void insert(T element) {
        // Add the element to the end of the heap
        heap.add(element);
        
        // Sift it up to its correct position
        siftUp(heap.size() - 1);
    }
    
    /**
     * Returns the maximum element in the heap without removing it.
     * Time Complexity: O(1)
     * 
     * @return the maximum element
     * @throws IllegalStateException if the heap is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        
        // The maximum element is always at the root (index 0)
        return heap.get(0);
    }
    
    /**
     * Removes and returns the maximum element from the heap.
     * Time Complexity: O(log n)
     * 
     * @return the maximum element
     * @throws IllegalStateException if the heap is empty
     */
    public T extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        
        // Get the maximum element (at the root)
        T max = heap.get(0);
        
        // Replace the root with the last element
        heap.set(0, heap.get(heap.size() - 1));
        
        // Remove the last element (which is now a duplicate)
        heap.remove(heap.size() - 1);
        
        // If the heap is not empty, sift down the root to maintain the heap property
        if (!heap.isEmpty()) {
            siftDown(0);
        }
        
        return max;
    }
    
    /**
     * Returns the size of the heap.
     * Time Complexity: O(1)
     * 
     * @return the number of elements in the heap
     */
    public int size() {
        return heap.size();
    }
    
    /**
     * Checks if the heap is empty.
     * Time Complexity: O(1)
     * 
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    /**
     * Clears the heap by removing all elements.
     * Time Complexity: O(1)
     */
    public void clear() {
        heap.clear();
    }
    
    /**
     * Returns a list representation of the heap.
     * Note: This does not return the elements in sorted order,
     * it returns them in the order they are stored in the heap.
     * 
     * @return a list containing all elements in the heap
     */
    public List<T> toList() {
        return new ArrayList<>(heap);
    }
    
    /**
     * String representation of the heap.
     * 
     * @return a string representation of the heap
     */
    @Override
    public String toString() {
        return heap.toString();
    }
}
