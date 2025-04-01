package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;

import com.leetcode.TrappingRainWater;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TrappingRainWater implementation.
 */
public class TrappingRainWaterTest {

    @Test
    void testTrapExample1() {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        assertEquals(6, solution.trap(height));
    }
    
    @Test
    void testTrapExample2() {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {4, 2, 0, 3, 2, 5};
        
        assertEquals(9, solution.trap(height));
    }
    
    @Test
    void testTrapNoWater() {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {1, 2, 3, 4, 5};
        
        assertEquals(0, solution.trap(height));
    }
    
    @Test
    void testTrapReverseNoWater() {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {5, 4, 3, 2, 1};
        
        assertEquals(0, solution.trap(height));
    }
    
    @Test
    void testTrapEmptyArray() {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {};
        
        assertEquals(0, solution.trap(height));
    }
    
    @Test
    void testTrapSingleElement() {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {5};
        
        assertEquals(0, solution.trap(height));
    }
    
    @Test
    void testTrapTwoElements() {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {5, 3};
        
        assertEquals(0, solution.trap(height));
    }
    
    @Test
    void testTrapSymmetricWater() {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {3, 1, 3};
        
        assertEquals(2, solution.trap(height));
    }
    
    @Test
    void testTrapComplexCase() {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {5, 2, 1, 2, 1, 5};
        
        assertEquals(14, solution.trap(height));
    }
}