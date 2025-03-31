package com.datastructures.visualization;

import com.datastructures.linkedlist.LinkedList;
import com.datastructures.linkedlist.Node;

/**
 * Visualizer for LinkedList data structure.
 * Provides methods to create a text-based visualization of a LinkedList.
 */
public class LinkedListVisualizer implements DataStructureVisualizer {
    
    private LinkedList<?> linkedList;
    private static final int NODE_WIDTH = 10;
    private static final int NODE_HEIGHT = 3;
    
    /**
     * Constructs a LinkedListVisualizer with the given LinkedList.
     * 
     * @param linkedList the LinkedList to visualize
     */
    public LinkedListVisualizer(LinkedList<?> linkedList) {
        this.linkedList = linkedList;
    }
    
    @Override
    public String visualize() {
        if (linkedList == null || linkedList.isEmpty()) {
            return "Empty LinkedList";
        }
        
        StringBuilder visualization = new StringBuilder();
        visualization.append("LinkedList Visualization:\n\n");
        
        Node<?> current = linkedList.getHead();
        
        while (current != null) {
            // Create a node box
            String nodeValue = String.valueOf(current.getData());
            if (nodeValue.length() > NODE_WIDTH - 4) {
                nodeValue = nodeValue.substring(0, NODE_WIDTH - 7) + "...";
            }
            
            visualization.append(VisualizationUtils.createFixedBox(nodeValue, NODE_WIDTH, NODE_HEIGHT));
            
            // Add an arrow if there is a next node
            if (current.getNext() != null) {
                visualization.append(" ").append(VisualizationUtils.ARROW_RIGHT).append(" ");
            }
            
            current = current.getNext();
        }
        
        return visualization.toString();
    }
    
    /**
     * Creates a more detailed visualization of the LinkedList with node indices.
     * 
     * @return a detailed string representation of the LinkedList
     */
    public String visualizeDetailed() {
        if (linkedList == null || linkedList.isEmpty()) {
            return "Empty LinkedList";
        }
        
        StringBuilder visualization = new StringBuilder();
        visualization.append("LinkedList Detailed Visualization:\n\n");
        
        Node<?> current = linkedList.getHead();
        int index = 0;
        
        while (current != null) {
            // Create a node box with index
            String nodeValue = String.valueOf(current.getData());
            if (nodeValue.length() > NODE_WIDTH - 4) {
                nodeValue = nodeValue.substring(0, NODE_WIDTH - 7) + "...";
            }
            
            visualization.append(VisualizationUtils.createFixedBox(nodeValue, NODE_WIDTH, NODE_HEIGHT));
            visualization.append("\n").append(VisualizationUtils.centerText("Index: " + index, NODE_WIDTH));
            
            // Add an arrow if there is a next node
            if (current.getNext() != null) {
                visualization.append("\n\n").append(VisualizationUtils.centerText(VisualizationUtils.ARROW_DOWN, NODE_WIDTH));
            }
            
            visualization.append("\n\n");
            
            current = current.getNext();
            index++;
        }
        
        return visualization.toString();
    }
    
    /**
     * Creates a horizontal view of the LinkedList.
     * 
     * @return a horizontal string representation of the LinkedList
     */
    public String visualizeHorizontal() {
        return visualize();
    }
    
    /**
     * Creates a vertical view of the LinkedList.
     * 
     * @return a vertical string representation of the LinkedList
     */
    public String visualizeVertical() {
        if (linkedList == null || linkedList.isEmpty()) {
            return "Empty LinkedList";
        }
        
        StringBuilder visualization = new StringBuilder();
        visualization.append("LinkedList Vertical Visualization:\n\n");
        
        Node<?> current = linkedList.getHead();
        
        while (current != null) {
            // Create a node box
            String nodeValue = String.valueOf(current.getData());
            if (nodeValue.length() > NODE_WIDTH - 4) {
                nodeValue = nodeValue.substring(0, NODE_WIDTH - 7) + "...";
            }
            
            visualization.append(VisualizationUtils.createFixedBox(nodeValue, NODE_WIDTH, NODE_HEIGHT));
            
            // Add an arrow if there is a next node
            if (current.getNext() != null) {
                visualization.append("\n").append(VisualizationUtils.centerText(VisualizationUtils.ARROW_DOWN, NODE_WIDTH)).append("\n");
            }
            
            current = current.getNext();
        }
        
        return visualization.toString();
    }
}