package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MedianFinder implementation.
 */
public class MedianFinderTest {

    @Test
    void testMedianFinderExample1() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian());
    }
    
    @Test
    void testMedianFinderWithDuplicates() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(1);
        assertEquals(1.0, medianFinder.findMedian());
        medianFinder.addNum(2);
        assertEquals(1.0, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(1.5, medianFinder.findMedian());
    }
    
    @Test
    void testMedianFinderEmptyAndSingle() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(5);
        assertEquals(5.0, medianFinder.findMedian());
    }
    
    @Test
    void testMedianFinderUnsortedStream() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(41);
        assertEquals(41.0, medianFinder.findMedian());
        medianFinder.addNum(35);
        assertEquals(38.0, medianFinder.findMedian());
        medianFinder.addNum(62);
        assertEquals(41.0, medianFinder.findMedian());
        medianFinder.addNum(4);
        assertEquals(38.0, medianFinder.findMedian());
        medianFinder.addNum(97);
        assertEquals(41.0, medianFinder.findMedian());
        medianFinder.addNum(108);
        assertEquals(51.5, medianFinder.findMedian());
    }
    
    @Test
    void testMedianFinderDescendingOrder() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(10);
        assertEquals(10.0, medianFinder.findMedian());
        medianFinder.addNum(9);
        assertEquals(9.5, medianFinder.findMedian());
        medianFinder.addNum(8);
        assertEquals(9.0, medianFinder.findMedian());
        medianFinder.addNum(7);
        assertEquals(8.5, medianFinder.findMedian());
        medianFinder.addNum(6);
        assertEquals(8.0, medianFinder.findMedian());
    }
    
    @Test
    void testMedianFinderAscendingOrder() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        assertEquals(1.0, medianFinder.findMedian());
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian());
        medianFinder.addNum(4);
        assertEquals(2.5, medianFinder.findMedian());
        medianFinder.addNum(5);
        assertEquals(3.0, medianFinder.findMedian());
    }
    
    @Test
    void testMedianFinderNegativeNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        assertEquals(-1.0, medianFinder.findMedian());
        medianFinder.addNum(-2);
        assertEquals(-1.5, medianFinder.findMedian());
        medianFinder.addNum(-3);
        assertEquals(-2.0, medianFinder.findMedian());
        medianFinder.addNum(0);
        assertEquals(-1.5, medianFinder.findMedian());
        medianFinder.addNum(4);
        assertEquals(-1.0, medianFinder.findMedian());
    }
}