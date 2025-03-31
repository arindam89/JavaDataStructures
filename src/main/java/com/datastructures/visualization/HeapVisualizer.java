package com.datastructures.visualization;

import com.datastructures.heap.MaxHeap;
import com.datastructures.heap.MinHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * Visualizer for Heap data structure (works for both MaxHeap and MinHeap).
 * Provides methods to create a text-based visualization of a Heap.
 */
public class HeapVisualizer implements DataStructureVisualizer {
    
    private Object heap;
    private static final int NODE_WIDTH = 5;
    private static final int MAX_DEPTH = 6; // Limit to avoid excessive output
    
    /**
     * Constructs a HeapVisualizer with the given Heap.
     * 
     * @param heap the Heap to visualize (can be MinHeap or MaxHeap)
     */
    public HeapVisualizer(Object heap) {
        if (!(heap instanceof MaxHeap) && !(heap instanceof MinHeap)) {
            throw new IllegalArgumentException("Heap must be an instance of MaxHeap or MinHeap");
        }
        this.heap = heap;
    }
    
    @Override
    public String visualize() {
        try {
            StringBuilder visualization = new StringBuilder();
            String heapType = (heap instanceof MaxHeap) ? "Max Heap" : "Min Heap";
            visualization.append(heapType).append(" Visualization:\n\n");
            
            // Get the array representation of the heap
            Object[] heapArray;
            int size;
            
            if (heap instanceof MaxHeap) {
                heapArray = ((MaxHeap<?>) heap).toArray();
                size = ((MaxHeap<?>) heap).size();
            } else { // MinHeap
                heapArray = ((MinHeap<?>) heap).toArray();
                size = ((MinHeap<?>) heap).size();
            }
            
            if (size == 0) {
                return heapType + " is empty";
            }
            
            // For very large heaps, limit the display
            if (size > Math.pow(2, MAX_DEPTH) - 1) {
                visualization.append("(Note: Heap is very large, showing only first ").append(MAX_DEPTH).append(" levels)\n\n");
                size = (int) Math.pow(2, MAX_DEPTH) - 1;
            }
            
            int height = (int) Math.floor(Math.log(size) / Math.log(2)) + 1;
            
            // Calculate max width based on the full binary tree
            int maxWidth = (int) Math.pow(2, height - 1) * (NODE_WIDTH + 1);
            
            // For each level of the heap
            for (int level = 0; level < height; level++) {
                int startIdx = (int) Math.pow(2, level) - 1;
                int endIdx = Math.min((int) Math.pow(2, level + 1) - 1, size);
                int nodesInLevel = endIdx - startIdx;
                
                // Calculate spacing for this level
                int spacing = maxWidth / nodesInLevel;
                
                // Add the nodes for this level
                for (int i = startIdx; i < endIdx; i++) {
                    String nodeValue = String.valueOf(heapArray[i]);
                    if (nodeValue.length() > NODE_WIDTH - 2) {
                        nodeValue = nodeValue.substring(0, NODE_WIDTH - 3) + "..";
                    }
                    visualization.append(VisualizationUtils.centerText(nodeValue, spacing));
                }
                visualization.append("\n");
                
                // Add connectors if not the last level
                if (level < height - 1) {
                    for (int i = startIdx; i < endIdx; i++) {
                        int leftChildIdx = 2 * i + 1;
                        int rightChildIdx = 2 * i + 2;
                        
                        StringBuilder connectorStr = new StringBuilder();
                        
                        if (leftChildIdx < size && rightChildIdx < size) {
                            connectorStr.append("/\\");
                        } else if (leftChildIdx < size) {
                            connectorStr.append("/");
                        } else if (rightChildIdx < size) {
                            connectorStr.append("\\");
                        } else {
                            connectorStr.append(" ");
                        }
                        
                        visualization.append(VisualizationUtils.centerText(connectorStr.toString(), spacing));
                    }
                    visualization.append("\n");
                }
            }
            
            // Add array representation
            visualization.append("\nHeap Array: [");
            for (int i = 0; i < size; i++) {
                visualization.append(heapArray[i]);
                if (i < size - 1) {
                    visualization.append(", ");
                }
            }
            visualization.append("]\n");
            
            return visualization.toString();
        } catch (Exception e) {
            return "Error visualizing heap: " + e.getMessage();
        }
    }
    
    /**
     * Visualizes the heap with additional details about heap properties.
     * 
     * @return a detailed string representation of the heap
     */
    public String visualizeDetailed() {
        StringBuilder visualization = new StringBuilder();
        visualization.append(visualize()).append("\n");
        
        try {
            String heapType = (heap instanceof MaxHeap) ? "Max Heap" : "Min Heap";
            visualization.append(heapType).append(" Properties:\n");
            
            int size;
            
            if (heap instanceof MaxHeap) {
                size = ((MaxHeap<?>) heap).size();
            } else { // MinHeap
                size = ((MinHeap<?>) heap).size();
            }
            
            int height = (int) Math.floor(Math.log(size) / Math.log(2)) + 1;
            
            visualization.append("Size: ").append(size).append("\n");
            visualization.append("Height: ").append(height).append("\n");
            visualization.append("Heap Property: ");
            
            if (heap instanceof MaxHeap) {
                visualization.append("For any node i, the value of i is greater than or equal to the values of its children\n");
            } else { // MinHeap
                visualization.append("For any node i, the value of i is less than or equal to the values of its children\n");
            }
            
            // Add navigation information
            visualization.append("\nHeap Navigation:\n");
            visualization.append("- Root is at index 0\n");
            visualization.append("- For any node at index i:\n");
            visualization.append("  - Left child is at index 2i + 1\n");
            visualization.append("  - Right child is at index 2i + 2\n");
            visualization.append("  - Parent is at index floor((i-1)/2)\n");
            
        } catch (Exception e) {
            visualization.append("Error generating detailed information: ").append(e.getMessage());
        }
        
        return visualization.toString();
    }
    
    /**
     * Visualizes a heap operation such as insertion or deletion.
     * 
     * @param operation the operation being performed ("insert" or "delete")
     * @param value the value being inserted or deleted
     * @param steps list of heap states during the operation
     * @return a visualization of the heap operation
     */
    public String visualizeOperation(String operation, Object value, List<Object[]> steps) {
        StringBuilder visualization = new StringBuilder();
        String heapType = (heap instanceof MaxHeap) ? "Max Heap" : "Min Heap";
        
        visualization.append(heapType).append(" ").append(operation).append(" Operation:\n\n");
        visualization.append("Operation: ").append(operation).append(" ").append(value).append("\n\n");
        
        for (int stepIdx = 0; stepIdx < steps.size(); stepIdx++) {
            Object[] heapArray = steps.get(stepIdx);
            int size = heapArray.length;
            
            visualization.append("Step ").append(stepIdx + 1).append(":\n");
            
            if (size == 0) {
                visualization.append("Empty heap\n\n");
                continue;
            }
            
            int height = (int) Math.floor(Math.log(size) / Math.log(2)) + 1;
            
            // Calculate max width based on the full binary tree
            int maxWidth = (int) Math.pow(2, height - 1) * (NODE_WIDTH + 1);
            
            // For each level of the heap
            for (int level = 0; level < height; level++) {
                int startIdx = (int) Math.pow(2, level) - 1;
                int endIdx = Math.min((int) Math.pow(2, level + 1) - 1, size);
                int nodesInLevel = endIdx - startIdx;
                
                // Calculate spacing for this level
                int spacing = maxWidth / nodesInLevel;
                
                // Add the nodes for this level
                for (int i = startIdx; i < endIdx; i++) {
                    String nodeValue = String.valueOf(heapArray[i]);
                    if (nodeValue.length() > NODE_WIDTH - 2) {
                        nodeValue = nodeValue.substring(0, NODE_WIDTH - 3) + "..";
                    }
                    visualization.append(VisualizationUtils.centerText(nodeValue, spacing));
                }
                visualization.append("\n");
                
                // Add connectors if not the last level
                if (level < height - 1) {
                    for (int i = startIdx; i < endIdx; i++) {
                        int leftChildIdx = 2 * i + 1;
                        int rightChildIdx = 2 * i + 2;
                        
                        StringBuilder connectorStr = new StringBuilder();
                        
                        if (leftChildIdx < size && rightChildIdx < size) {
                            connectorStr.append("/\\");
                        } else if (leftChildIdx < size) {
                            connectorStr.append("/");
                        } else if (rightChildIdx < size) {
                            connectorStr.append("\\");
                        } else {
                            connectorStr.append(" ");
                        }
                        
                        visualization.append(VisualizationUtils.centerText(connectorStr.toString(), spacing));
                    }
                    visualization.append("\n");
                }
            }
            
            // Add array representation
            visualization.append("\nHeap Array: [");
            for (int i = 0; i < size; i++) {
                visualization.append(heapArray[i]);
                if (i < size - 1) {
                    visualization.append(", ");
                }
            }
            visualization.append("]\n\n");
        }
        
        return visualization.toString();
    }
}