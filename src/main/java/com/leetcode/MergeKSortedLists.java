package com.leetcode;

import java.util.PriorityQueue;

/**
 * LeetCode #23: Merge k Sorted Lists (Hard)
 * 
 * You are given an array of k linked-list lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * Time Complexity: O(N log k) where N is the total number of nodes and k is the number of linked lists
 * Space Complexity: O(k) for the priority queue
 */
public class MergeKSortedLists {
    
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) { 
            this.val = val; 
        }
        
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }
    
    /**
     * Merges k sorted linked lists into one sorted linked list.
     * 
     * @param lists an array of k linked-list heads
     * @return the head of the merged linked list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Create a priority queue (min heap) of list nodes, sorted by their values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the first node from each list to the heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }
        
        // Create a dummy head for the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Process nodes in the heap
        while (!minHeap.isEmpty()) {
            // Get the minimum node
            ListNode node = minHeap.poll();
            
            // Add it to the result list
            current.next = node;
            current = current.next;
            
            // Add the next node from the same list to the heap, if it exists
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}