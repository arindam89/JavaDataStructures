package com.leetcode;

import java.util.*;

/**
 * LeetCode Problem: Course Schedule
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you
 * must take course bi first if you want to take course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * 
 * Return true if you can finish all courses. Otherwise, return false.
 * 
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should also have finished course 1. So it is impossible.
 * 
 * Constraints:
 * - 1 <= numCourses <= 2000
 * - 0 <= prerequisites.length <= 5000
 * - prerequisites[i].length == 2
 * - 0 <= ai, bi < numCourses
 * - All the pairs prerequisites[i] are unique
 * 
 * This problem demonstrates cycle detection in a directed graph using depth-first search.
 */
public class CourseSchedule {
    
    /**
     * Determines if it's possible to finish all courses using DFS for cycle detection.
     * 
     * Time Complexity: O(V + E) where V is the number of courses and E is the number of prerequisites
     * Space Complexity: O(V + E) for the adjacency list and visited arrays
     * 
     * @param numCourses the number of courses
     * @param prerequisites the prerequisite pairs
     * @return true if all courses can be finished, false otherwise
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Handle edge cases
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites == null || prerequisites.length == 0) {
            return true; // No prerequisites means all courses can be taken
        }
        
        // Build the adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Add the directed edges based on prerequisites
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        // Prepare arrays for DFS
        boolean[] visited = new boolean[numCourses]; // To track visited nodes
        boolean[] inStack = new boolean[numCourses]; // To track nodes in current DFS path
        
        // Check for cycles starting from each unvisited course
        for (int course = 0; course < numCourses; course++) {
            if (!visited[course] && hasCycle(graph, course, visited, inStack)) {
                return false; // If a cycle is found, courses cannot be completed
            }
        }
        
        return true; // No cycles found, all courses can be completed
    }
    
    /**
     * Helper method for DFS-based cycle detection.
     * 
     * @param graph the adjacency list representation of the graph
     * @param current the current node/course
     * @param visited array to track visited nodes
     * @param inStack array to track nodes in the current DFS path
     * @return true if a cycle is detected, false otherwise
     */
    private boolean hasCycle(List<List<Integer>> graph, int current, boolean[] visited, boolean[] inStack) {
        // Mark the current node as visited and add to the current path
        visited[current] = true;
        inStack[current] = true;
        
        // Visit all neighbors
        for (int neighbor : graph.get(current)) {
            // If the neighbor is not visited, recursively check for a cycle
            if (!visited[neighbor]) {
                if (hasCycle(graph, neighbor, visited, inStack)) {
                    return true;
                }
            } 
            // If the neighbor is in the current path, a cycle is found
            else if (inStack[neighbor]) {
                return true;
            }
        }
        
        // Remove the current node from the current path
        inStack[current] = false;
        
        return false; // No cycle found in this path
    }
    
    /**
     * Alternative implementation using BFS (Kahn's algorithm).
     * 
     * @param numCourses the number of courses
     * @param prerequisites the prerequisite pairs
     * @return true if all courses can be finished, false otherwise
     */
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        // Handle edge cases
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites == null || prerequisites.length == 0) {
            return true; // No prerequisites means all courses can be taken
        }
        
        // Build the adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Add edges and count in-degrees
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        
        // Queue for BFS, start with all nodes that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Count of courses that can be taken
        int count = 0;
        
        // Process queue
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            
            // Reduce in-degree of all dependent courses
            for (int dependent : graph.get(course)) {
                inDegree[dependent]--;
                if (inDegree[dependent] == 0) {
                    queue.offer(dependent);
                }
            }
        }
        
        // If all courses can be taken, count will equal numCourses
        return count == numCourses;
    }
}