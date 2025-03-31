package com.datastructures.visualization;

/**
 * Interface for all data structure visualizers.
 * Any class that provides visualization capability for a data structure
 * should implement this interface.
 */
public interface DataStructureVisualizer {
    
    /**
     * Visualizes the data structure and returns the string representation.
     * 
     * @return a string representation of the data structure visualization
     */
    String visualize();
    
    /**
     * Prints the visualization of the data structure to the console.
     */
    default void printVisualization() {
        System.out.println(visualize());
    }
}