package com.datastructures.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for DecodeString implementation.
 */
public class DecodeStringTest {

    @Test
    void testDecodeStringExample1() {
        DecodeString solution = new DecodeString();
        String s = "3[a]2[bc]";
        
        assertEquals("aaabcbc", solution.decodeString(s));
    }
    
    @Test
    void testDecodeStringExample2() {
        DecodeString solution = new DecodeString();
        String s = "3[a2[c]]";
        
        assertEquals("accaccacc", solution.decodeString(s));
    }
    
    @Test
    void testDecodeStringExample3() {
        DecodeString solution = new DecodeString();
        String s = "2[abc]3[cd]ef";
        
        assertEquals("abcabccdcdcdef", solution.decodeString(s));
    }
    
    @Test
    void testDecodeStringNestedBrackets() {
        DecodeString solution = new DecodeString();
        String s = "2[3[a]b]";
        
        assertEquals("aaabaaab", solution.decodeString(s));
    }
    
    @Test
    void testDecodeStringEmptyString() {
        DecodeString solution = new DecodeString();
        String s = "";
        
        assertEquals("", solution.decodeString(s));
    }
    
    @Test
    void testDecodeStringNoEncoding() {
        DecodeString solution = new DecodeString();
        String s = "abcdef";
        
        assertEquals("abcdef", solution.decodeString(s));
    }
    
    @Test
    void testDecodeStringRecursiveExample1() {
        DecodeString solution = new DecodeString();
        String s = "3[a]2[bc]";
        
        assertEquals("aaabcbc", solution.decodeStringRecursive(s));
    }
    
    @Test
    void testDecodeStringRecursiveExample2() {
        DecodeString solution = new DecodeString();
        String s = "3[a2[c]]";
        
        assertEquals("accaccacc", solution.decodeStringRecursive(s));
    }
    
    @Test
    void testDecodeStringRecursiveExample3() {
        DecodeString solution = new DecodeString();
        String s = "2[abc]3[cd]ef";
        
        assertEquals("abcabccdcdcdef", solution.decodeStringRecursive(s));
    }
    
    @Test
    void testDecodeStringComplexNesting() {
        DecodeString solution = new DecodeString();
        String s = "10[a]";
        
        assertEquals("aaaaaaaaaa", solution.decodeString(s));
    }
}