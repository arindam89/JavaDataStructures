package com.datastructures.visualization;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the VisualizationUtils class.
 */
public class VisualizationUtilsTest {
    
    @Test
    public void testCreateBox() {
        String expected = 
            "┌──────┐\n" +
            "│ Test │\n" +
            "└──────┘";
        
        String actual = VisualizationUtils.createBox("Test", 8);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateBoxWithEmptyText() {
        String expected = 
            "┌────┐\n" +
            "└────┘";
        
        String actual = VisualizationUtils.createBox("", 6);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateBoxWithNullText() {
        String expected = 
            "┌────┐\n" +
            "└────┘";
        
        String actual = VisualizationUtils.createBox(null, 6);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateHorizontalLine() {
        String expected = "────";
        String actual = VisualizationUtils.createHorizontalLine(4);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateVerticalLine() {
        String expected = 
            "│\n" +
            "│\n" +
            "│\n";
        
        String actual = VisualizationUtils.createVerticalLine(3);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateConnectorHorizontal() {
        String expected = "────→";
        String actual = VisualizationUtils.createConnector("horizontal", 5, true);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateConnectorVertical() {
        String expected = 
            "│\n" +
            "│\n" +
            "↓";
        
        String actual = VisualizationUtils.createConnector("vertical", 3, true);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCenterText() {
        String expected = "  Test  ";
        String actual = VisualizationUtils.centerText("Test", 8);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCenterTextWithEmptyString() {
        String expected = "      ";
        String actual = VisualizationUtils.centerText("", 6);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCenterTextWithNullString() {
        String expected = "      ";
        String actual = VisualizationUtils.centerText(null, 6);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateFixedBox() {
        String expected = 
            "┌──────┐\n" +
            "│      │\n" +
            "│ Test │\n" +
            "│      │\n" +
            "└──────┘";
        
        String actual = VisualizationUtils.createFixedBox("Test", 8, 5);
        assertEquals(expected, actual);
    }
}