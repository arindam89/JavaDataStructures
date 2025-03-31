package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TrapRainWater implementation.
 */
public class TrapRainWaterTest {

    @Test
    void testTrapExample1() {
        TrapRainWater solution = new TrapRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        assertEquals(6, solution.trap(height));
    }
    
    @Test
    void testTrapExample2() {
        TrapRainWater solution = new TrapRainWater();
        int[] height = {4, 2, 0, 3, 2, 5};
        
        assertEquals(9, solution.trap(height));
    }
    
    @Test
    void testTrapEmptyArray() {
        TrapRainWater solution = new TrapRainWater();
        int[] height = {};
        
        assertEquals(0, solution.trap(height));
    }
    
    @Test
    void testTrapSingleElement() {
        TrapRainWater solution = new TrapRainWater();
        int[] height = {5};
        
        assertEquals(0, solution.trap(height));
    }
    
    @Test
    void testTrapTwoElements() {
        TrapRainWater solution = new TrapRainWater();
        int[] height = {5, 2};
        
        assertEquals(0, solution.trap(height));
    }
    
    @Test
    void testTrapNoWater() {
        TrapRainWater solution = new TrapRainWater();
        int[] height = {1, 2, 3, 4, 5};
        
        assertEquals(0, solution.trap(height));
    }
    
    @Test
    void testTrapDescendingHeights() {
        TrapRainWater solution = new TrapRainWater();
        int[] height = {5, 4, 3, 2, 1};
        
        assertEquals(0, solution.trap(height));
    }
    
    @Test
    void testTrapUsingDP() {
        TrapRainWater solution = new TrapRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        assertEquals(6, solution.trapUsingDP(height));
    }
    
    @Test
    void testTrapEqualHeights() {
        TrapRainWater solution = new TrapRainWater();
        int[] height = {3, 3, 3, 3, 3};
        
        assertEquals(0, solution.trap(height));
    }
    
    @Test
    void testTrapValleyPattern() {
        TrapRainWater solution = new TrapRainWater();
        int[] height = {5, 4, 1, 2, 3, 4, 5};
        
        assertEquals(11, solution.trap(height));
    }
}