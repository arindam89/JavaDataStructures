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

## LeetCode Problems

This project includes solutions to several medium to hard LeetCode problems that demonstrate practical applications of the implemented data structures:

1. **LRU Cache** (LeetCode #146) - Medium
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
│               ├── leetcode/             # LeetCode problem solutions
│               ├── linkedlist/           # Linked List implementation
│               ├── tree/                 # Binary Tree implementation
│               ├── trie/                 # Trie implementation
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
                └── trie/                 # Trie tests
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
6. Finally, check out the LeetCode problems to see practical applications of these data structures

## Contributing

Contributions to improve the implementations, add new data structures, or include more LeetCode problems are welcome. Please follow these steps:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
