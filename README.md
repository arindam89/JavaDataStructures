# Java Data Structures Learning Project

A comprehensive Java project for learning and exploring fundamental data structures with extensive documentation and examples, including practical applications through LeetCode problems.

## Overview

This project provides implementations of core data structures in Java with a focus on clear, well-documented code to facilitate learning. Each data structure is implemented in its own module with detailed comments explaining the concepts, operations, and time/space complexity. The project also includes a LeetCode problems module that demonstrates how these data structures are applied to solve complex algorithmic challenges.

## Data Structures Included

1. **Linked List**
   - Singly linked list implementation with comprehensive operations
   - Time and space complexity analysis for each operation
   - Insertion, deletion, search, and traversal operations

2. **Heaps**
   - Max Heap implementation
   - Min Heap implementation
   - Heap operations like insertion, extraction, and heapify
   - Priority queue functionality

3. **Binary Trees**
   - General binary tree implementation
   - Tree traversals (in-order, pre-order, post-order, level-order)
   - Tree properties and operations (height, size, mirror, etc.)

4. **Binary Search Trees (BST)**
   - Complete BST implementation with search, insert, and delete operations
   - Tree balancing concepts
   - In-order traversal for sorted output
   - Successor and predecessor functionality

5. **Graphs**
   - Adjacency list representation for both directed and undirected graphs
   - Graph traversals (BFS, DFS)
   - Shortest path algorithms (Dijkstra's)
   - Minimum spanning tree (Prim's algorithm)
   - Topological sorting for directed acyclic graphs

6. **Trie**
   - Prefix tree implementation for efficient string operations
   - Insert, search, and delete operations
   - Autocomplete functionality
   - Common prefix finding

## Visualization Components

The project includes comprehensive visualization tools for each data structure to enhance understanding and learning:

1. **Linked List Visualization**
   - Horizontal and vertical view modes
   - Node connections and pointer visualization
   - Step-by-step operation visualization

2. **Binary Tree Visualization**
   - Tree structure with node values
   - Multiple view modes (basic and detailed)
   - Traversal path highlighting

3. **Binary Search Tree Visualization**
   - BST structure with search path highlighting
   - Insertion and deletion animation
   - Property verification views

4. **Heap Visualization**
   - Array and tree representations
   - Heapify operation visualization
   - Property maintenance demonstration

5. **Graph Visualization**
   - Multiple view modes (circular, adjacency list, matrix)
   - Edge and vertex highlighting
   - Path finding visualization

6. **Trie Visualization**
   - Tree structure with prefix highlighting
   - Search path visualization
   - Statistical information display
   - Word completion demonstration

## LeetCode Problems

This project includes solutions to 20 medium to hard LeetCode problems that demonstrate practical applications of the implemented data structures:

### Part 1: Core Algorithm Problems

1. **LRU Cache** (LeetCode #146) - Hard
   - Implementation using HashMap and Doubly Linked List
   - O(1) time complexity for both get and put operations

2. **Word Ladder** (LeetCode #127) - Hard
   - Implementation using BFS and Graph concepts
   - Finding the shortest transformation sequence between words

3. **Number of Islands** (LeetCode #200) - Medium
   - Implementation using DFS and Graph traversal
   - Connected components in a 2D grid

4. **Merge K Sorted Lists** (LeetCode #23) - Hard
   - Implementation using Priority Queue (Min Heap)
   - Efficient merging of multiple sorted linked lists

5. **Serialize and Deserialize Binary Tree** (LeetCode #297) - Hard
   - Binary Tree operations for encoding and decoding tree structures
   - Preorder traversal for serialization and deserialization

6. **Trapping Rain Water** (LeetCode #42) - Hard
   - Two-pointer technique and dynamic programming
   - Calculating trapped water between bars

7. **Longest Increasing Path in a Matrix** (LeetCode #329) - Hard
   - DFS with memoization
   - Finding the longest increasing path in a grid

8. **Minimum Window Substring** (LeetCode #76) - Hard
   - Sliding window technique
   - Finding minimum substring containing all characters of a pattern

9. **Find Median from Data Stream** (LeetCode #295) - Hard
   - Using two heaps (max and min)
   - Maintaining a median with efficient insertions

10. **Sliding Window Maximum** (LeetCode #239) - Hard
    - Deque implementation
    - Finding maximum in each sliding window

11. **Word Search II** (LeetCode #212) - Hard
    - Trie and backtracking
    - Finding words in a board

12. **Coin Change** (LeetCode #322) - Medium
    - Dynamic programming
    - Finding minimum number of coins to make up a given amount

### Part 2: Advanced Problems

13. **Top K Frequent Elements** (LeetCode #347) - Medium
    - Bucket sort and heap implementation
    - Finding the k most frequent elements

14. **Word Break** (LeetCode #139) - Medium
    - Dynamic programming
    - Determining if a string can be segmented into dictionary words

15. **Course Schedule** (LeetCode #207) - Medium
    - Directed graph and cycle detection
    - Determining if a course schedule is possible

16. **Longest Substring Without Repeating Characters** (LeetCode #3) - Medium
    - Sliding window technique
    - Finding longest substring with unique characters

17. **Decode String** (LeetCode #394) - Medium
    - Stack implementation
    - Decoding a string with repeated patterns

18. **Valid Parentheses** (LeetCode #20) - Easy
    - Stack implementation
    - Validating properly closed brackets

19. **LRU Cache II** (Advanced version of LeetCode #146) - Hard
    - Enhanced implementation with additional features
    - Improved caching mechanism

20. **Design Add and Search Words Data Structure** (LeetCode #211) - Medium
    - Trie implementation with wildcard search
    - Supporting '.' wildcard that can match any character

## Project Structure

The project follows the standard Maven directory structure:

```
src/
├── main/
│   └── java/
│       └── com/
│           └── datastructures/
│               ├── bst/                  # Binary Search Tree implementation
│               ├── graph/                # Graph implementation
│               ├── heap/                 # Heap implementations (Min and Max)
│               ├── leetcode/             # LeetCode problem solutions (20 Problems)
│               ├── linkedlist/           # Linked List implementation
│               ├── tree/                 # Binary Tree implementation
│               ├── trie/                 # Trie implementation
│               ├── visualization/        # Visualization components for all data structures
│               └── Main.java             # Main class to run all examples
└── test/
    └── java/
        └── com/
            └── datastructures/
                ├── bst/                  # BST tests
                ├── graph/                # Graph tests
                ├── heap/                 # Heap tests
                ├── leetcode/             # LeetCode solution tests
                ├── linkedlist/           # Linked List tests
                ├── tree/                 # Binary Tree tests
                ├── trie/                 # Trie tests
                └── visualization/        # Tests for visualization components
```

## Running the Project

This project uses Maven for dependency management and build automation. To run the project:

1. Ensure you have Java 11 or later and Maven installed on your system
2. Clone the repository to your local machine
3. Navigate to the project directory
4. Run the following command to compile and run the project:

```bash
mvn compile exec:java -Dexec.mainClass="com.datastructures.Main"
```

## Testing

To run the unit tests, execute:

```bash
mvn test
```

## Learning Path

This project is designed to be educational. Here's a suggested order to explore the code:

1. Start with the LinkedList implementation as it forms the foundation for many other data structures
2. Move on to the Tree and BST implementations to understand hierarchical data structures
3. Explore the Heap implementations to learn about priority-based data structures
4. Study the Trie implementation for string-related operations
5. Dive into the Graph implementation for network-related problems
6. Explore the visualization components for each data structure to get a visual understanding
7. Finally, check out the LeetCode problems to see practical applications of these data structures, starting with the simpler problems (Easy/Medium) and moving to more complex ones (Hard)

## Contributing

Contributions to improve the implementations, add new data structures, or include more LeetCode problems are welcome. Please follow these steps:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
