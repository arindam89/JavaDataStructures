package com.leetcode.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for NumberOfIslands implementation.
 */
public class NumberOfIslandsTest {

    @Test
    void testNumberOfIslandsExample1() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        
        assertEquals(1, solution.numIslands(grid));
    }
    
    @Test
    void testNumberOfIslandsExample2() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        
        assertEquals(3, solution.numIslands(grid));
    }
    
    @Test
    void testNumberOfIslandsNoIslands() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        
        assertEquals(0, solution.numIslands(grid));
    }
    
    @Test
    void testNumberOfIslandsAllLand() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        
        assertEquals(1, solution.numIslands(grid));
    }
    
    @Test
    void testNumberOfIslandsIrregularShapes() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '0', '0', '0', '1'},
            {'0', '0', '0', '1', '1'},
            {'0', '0', '0', '1', '0'}
        };
        
        // Looking at the grid, we have 2 islands: one in top-left, and one on right side
        assertEquals(2, solution.numIslands(grid));
    }
    
    @Test
    void testNumberOfIslandsEmptyGrid() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {};
        
        assertEquals(0, solution.numIslands(grid));
    }
    
    @Test
    void testNumberOfIslandsNullGrid() {
        NumberOfIslands solution = new NumberOfIslands();
        
        assertEquals(0, solution.numIslands(null));
    }
}