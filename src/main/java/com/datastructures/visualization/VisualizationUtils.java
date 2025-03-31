package com.datastructures.visualization;

/**
 * Utility methods for data structure visualization.
 * Contains helper methods for drawing boxes, lines, arrows, etc.
 */
public class VisualizationUtils {

    // Unicode box drawing characters
    public static final char BOX_HORIZONTAL = '─';
    public static final char BOX_VERTICAL = '│';
    public static final char BOX_TOP_LEFT = '┌';
    public static final char BOX_TOP_RIGHT = '┐';
    public static final char BOX_BOTTOM_LEFT = '└';
    public static final char BOX_BOTTOM_RIGHT = '┘';
    public static final char BOX_JUNCTION_TOP = '┬';
    public static final char BOX_JUNCTION_BOTTOM = '┴';
    public static final char BOX_JUNCTION_LEFT = '├';
    public static final char BOX_JUNCTION_RIGHT = '┤';
    public static final char BOX_JUNCTION_MIDDLE = '┼';
    
    // Arrow characters
    public static final String ARROW_RIGHT = "→";
    public static final String ARROW_LEFT = "←";
    public static final String ARROW_UP = "↑";
    public static final String ARROW_DOWN = "↓";
    public static final String ARROW_BIDIRECTIONAL = "↔";
    
    // ANSI color codes (for optional colorful visualization)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    /**
     * Creates a box around text with the given width.
     * 
     * @param text the text to put in the box
     * @param width the width of the box
     * @return a string containing the text in a box
     */
    public static String createBox(String text, int width) {
        StringBuilder box = new StringBuilder();
        
        // Top border
        box.append(BOX_TOP_LEFT);
        for (int i = 0; i < width - 2; i++) {
            box.append(BOX_HORIZONTAL);
        }
        box.append(BOX_TOP_RIGHT).append("\n");
        
        // Content (centered)
        if (text != null && !text.isEmpty()) {
            int padding = (width - 2 - text.length()) / 2;
            box.append(BOX_VERTICAL);
            for (int i = 0; i < padding; i++) {
                box.append(' ');
            }
            box.append(text);
            for (int i = 0; i < width - 2 - text.length() - padding; i++) {
                box.append(' ');
            }
            box.append(BOX_VERTICAL).append("\n");
        }
        
        // Bottom border
        box.append(BOX_BOTTOM_LEFT);
        for (int i = 0; i < width - 2; i++) {
            box.append(BOX_HORIZONTAL);
        }
        box.append(BOX_BOTTOM_RIGHT);
        
        return box.toString();
    }
    
    /**
     * Creates a horizontal line with the given width.
     * 
     * @param width the width of the horizontal line
     * @return a string with a horizontal line of the specified width
     */
    public static String createHorizontalLine(int width) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < width; i++) {
            line.append(BOX_HORIZONTAL);
        }
        return line.toString();
    }
    
    /**
     * Creates a vertical line with the given height.
     * 
     * @param height the height of the vertical line
     * @return a string with a vertical line of the specified height
     */
    public static String createVerticalLine(int height) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < height; i++) {
            line.append(BOX_VERTICAL).append("\n");
        }
        return line.toString();
    }
    
    /**
     * Creates a connecting line between two points.
     * 
     * @param direction the direction of the connector (horizontal or vertical)
     * @param length the length of the connector
     * @param withArrow whether to add an arrow at the end
     * @return a string with a connector line
     */
    public static String createConnector(String direction, int length, boolean withArrow) {
        StringBuilder connector = new StringBuilder();
        
        if ("horizontal".equals(direction)) {
            for (int i = 0; i < length - (withArrow ? 1 : 0); i++) {
                connector.append(BOX_HORIZONTAL);
            }
            if (withArrow) {
                connector.append(ARROW_RIGHT);
            }
        } else if ("vertical".equals(direction)) {
            for (int i = 0; i < length - (withArrow ? 1 : 0); i++) {
                connector.append(BOX_VERTICAL).append("\n");
            }
            if (withArrow) {
                connector.append(ARROW_DOWN);
            }
        }
        
        return connector.toString();
    }
    
    /**
     * Centers a text in a field of given width.
     * 
     * @param text the text to center
     * @param width the width of the field
     * @return the centered text
     */
    public static String centerText(String text, int width) {
        if (text == null) {
            text = "";
        }
        
        if (text.length() >= width) {
            return text;
        }
        
        int padding = (width - text.length()) / 2;
        StringBuilder centered = new StringBuilder();
        
        for (int i = 0; i < padding; i++) {
            centered.append(' ');
        }
        
        centered.append(text);
        
        for (int i = 0; i < width - text.length() - padding; i++) {
            centered.append(' ');
        }
        
        return centered.toString();
    }
    
    /**
     * Creates a box with a fixed width and height.
     * 
     * @param text the text to put in the box
     * @param width the width of the box
     * @param height the height of the box
     * @return a string containing the text in a box
     */
    public static String createFixedBox(String text, int width, int height) {
        StringBuilder box = new StringBuilder();
        
        // Top border
        box.append(BOX_TOP_LEFT);
        for (int i = 0; i < width - 2; i++) {
            box.append(BOX_HORIZONTAL);
        }
        box.append(BOX_TOP_RIGHT).append("\n");
        
        // Calculate vertical padding
        int contentLines = 1; // Assuming text fits on one line
        int vPadding = (height - 2 - contentLines) / 2;
        
        // Top padding
        for (int i = 0; i < vPadding; i++) {
            box.append(BOX_VERTICAL);
            for (int j = 0; j < width - 2; j++) {
                box.append(' ');
            }
            box.append(BOX_VERTICAL).append("\n");
        }
        
        // Content (centered)
        if (text != null && !text.isEmpty()) {
            int hPadding = (width - 2 - text.length()) / 2;
            box.append(BOX_VERTICAL);
            for (int i = 0; i < hPadding; i++) {
                box.append(' ');
            }
            box.append(text);
            for (int i = 0; i < width - 2 - text.length() - hPadding; i++) {
                box.append(' ');
            }
            box.append(BOX_VERTICAL).append("\n");
        } else {
            box.append(BOX_VERTICAL);
            for (int j = 0; j < width - 2; j++) {
                box.append(' ');
            }
            box.append(BOX_VERTICAL).append("\n");
        }
        
        // Bottom padding
        for (int i = 0; i < height - 2 - contentLines - vPadding; i++) {
            box.append(BOX_VERTICAL);
            for (int j = 0; j < width - 2; j++) {
                box.append(' ');
            }
            box.append(BOX_VERTICAL).append("\n");
        }
        
        // Bottom border
        box.append(BOX_BOTTOM_LEFT);
        for (int i = 0; i < width - 2; i++) {
            box.append(BOX_HORIZONTAL);
        }
        box.append(BOX_BOTTOM_RIGHT);
        
        return box.toString();
    }
}