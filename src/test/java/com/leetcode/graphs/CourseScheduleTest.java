package com.leetcode.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for CourseSchedule implementation.
 */
public class CourseScheduleTest {

    @Test
    void testCanFinishExample1() {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        
        assertTrue(solution.canFinish(numCourses, prerequisites));
    }
    
    @Test
    void testCanFinishExample2() {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        
        assertFalse(solution.canFinish(numCourses, prerequisites));
    }
    
    @Test
    void testCanFinishNoPrerequisites() {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 5;
        int[][] prerequisites = {};
        
        assertTrue(solution.canFinish(numCourses, prerequisites));
    }
    
    @Test
    void testCanFinishComplexCycleDetection() {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}, {1, 3}};
        
        assertFalse(solution.canFinish(numCourses, prerequisites));
    }
    
    @Test
    void testCanFinishComplexAcyclicGraph() {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 5;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}, {4, 3}};
        
        assertTrue(solution.canFinish(numCourses, prerequisites));
    }
    
    @Test
    void testCanFinishInvalidCourseNumber() {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 0;
        int[][] prerequisites = {{1, 0}};
        
        assertFalse(solution.canFinish(numCourses, prerequisites));
    }
    
    @Test
    void testCanFinishSelfLoop() {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 3;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 2}};
        
        assertFalse(solution.canFinish(numCourses, prerequisites));
    }
    
    @Test
    void testCanFinishBFSExample1() {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        
        assertTrue(solution.canFinishBFS(numCourses, prerequisites));
    }
    
    @Test
    void testCanFinishBFSExample2() {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        
        assertFalse(solution.canFinishBFS(numCourses, prerequisites));
    }
}