package com.datastructures.linkedlist;

/**
 * Example class to demonstrate the usage of LinkedList implementation.
 * This class contains a method that shows different operations
 * that can be performed on a linked list.
 */
public class LinkedListExample {
    
    /**
     * Runs examples demonstrating linked list operations.
     */
    public static void runExample() {
        // Create a new linked list of integers
        LinkedList<Integer> list = new LinkedList<>();
        
        // Example 1: Adding elements
        System.out.println("Adding elements to the linked list:");
        list.addFirst(10);
        System.out.println("After adding 10 at first: " + list);
        
        list.addLast(20);
        System.out.println("After adding 20 at last: " + list);
        
        list.addAtPosition(15, 1);
        System.out.println("After adding 15 at position 1: " + list);
        
        list.addFirst(5);
        System.out.println("After adding 5 at first: " + list);
        
        list.addLast(25);
        System.out.println("After adding 25 at last: " + list);
        
        // Example 2: Accessing elements
        System.out.println("\nAccessing elements:");
        System.out.println("Element at position 0: " + list.get(0));
        System.out.println("Element at position 2: " + list.get(2));
        System.out.println("Element at position 4: " + list.get(4));
        
        // Example 3: Checking if the list contains an element
        System.out.println("\nChecking if the list contains elements:");
        System.out.println("Contains 15? " + list.contains(15));
        System.out.println("Contains 100? " + list.contains(100));
        
        // Example 4: Finding the position of an element
        System.out.println("\nFinding positions:");
        System.out.println("Position of 5: " + list.indexOf(5));
        System.out.println("Position of 15: " + list.indexOf(15));
        System.out.println("Position of 100: " + list.indexOf(100));
        
        // Example 5: Updating elements
        System.out.println("\nUpdating elements:");
        list.set(50, 2);
        System.out.println("After updating position 2 to 50: " + list);
        
        // Example 6: Removing elements
        System.out.println("\nRemoving elements:");
        int removed = list.removeFirst();
        System.out.println("Removed first element: " + removed);
        System.out.println("After removing first: " + list);
        
        removed = list.removeLast();
        System.out.println("Removed last element: " + removed);
        System.out.println("After removing last: " + list);
        
        removed = list.removeAtPosition(1);
        System.out.println("Removed element at position 1: " + removed);
        System.out.println("After removing at position 1: " + list);
        
        // Example 7: Size and empty operations
        System.out.println("\nSize and empty operations:");
        System.out.println("Size of the list: " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty());
        
        // Example 8: Reversing the list
        System.out.println("\nReversing the list:");
        list.reverse();
        System.out.println("After reversing: " + list);
        
        // Example 9: Clearing the list
        System.out.println("\nClearing the list:");
        list.clear();
        System.out.println("After clearing: " + list);
        System.out.println("Is the list empty? " + list.isEmpty());
        
        // Example 10: Working with a different data type
        System.out.println("\nWorking with strings:");
        LinkedList<String> stringList = new LinkedList<>();
        stringList.addLast("Hello");
        stringList.addLast("World");
        stringList.addLast("Java");
        System.out.println("String list: " + stringList);
        
        System.out.println("Contains 'Java'? " + stringList.contains("Java"));
        System.out.println("Position of 'World': " + stringList.indexOf("World"));
    }
}
