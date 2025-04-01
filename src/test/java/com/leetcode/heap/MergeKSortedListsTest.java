package com.leetcode.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.leetcode.heap.MergeKSortedLists.ListNode;

/**
 * Test class for MergeKSortedLists implementation.
 */
public class MergeKSortedListsTest {

    /**
     * Helper method to create a linked list from an array of values.
     */
    private ListNode createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        
        return dummy.next;
    }
    
    /**
     * Helper method to check if two linked lists are equal.
     */
    private boolean areListsEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return l1 == null && l2 == null;
    }
    
    @Test
    void testMergeKListsExample1() {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        ListNode[] lists = new ListNode[3];
        lists[0] = createList(new int[]{1, 4, 5});
        lists[1] = createList(new int[]{1, 3, 4});
        lists[2] = createList(new int[]{2, 6});
        
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = createList(new int[]{1, 1, 2, 3, 4, 4, 5, 6});
        
        assertTrue(areListsEqual(expected, result));
    }
    
    @Test
    void testMergeKListsEmptyLists() {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        ListNode[] lists = new ListNode[0];
        ListNode result = solution.mergeKLists(lists);
        
        assertNull(result);
    }
    
    @Test
    void testMergeKListsNullLists() {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        ListNode result = solution.mergeKLists(null);
        
        assertNull(result);
    }
    
    @Test
    void testMergeKListsWithEmptyList() {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        ListNode[] lists = new ListNode[3];
        lists[0] = createList(new int[]{1, 4, 5});
        lists[1] = null;
        lists[2] = createList(new int[]{2, 6});
        
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = createList(new int[]{1, 2, 4, 5, 6});
        
        assertTrue(areListsEqual(expected, result));
    }
    
    @Test
    void testMergeKListsSingleList() {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        ListNode[] lists = new ListNode[1];
        lists[0] = createList(new int[]{1, 2, 3, 4, 5});
        
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = createList(new int[]{1, 2, 3, 4, 5});
        
        assertTrue(areListsEqual(expected, result));
    }
    
    @Test
    void testMergeKListsWithDuplicates() {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        ListNode[] lists = new ListNode[2];
        lists[0] = createList(new int[]{1, 1, 1});
        lists[1] = createList(new int[]{1, 1, 1});
        
        ListNode result = solution.mergeKLists(lists);
        ListNode expected = createList(new int[]{1, 1, 1, 1, 1, 1});
        
        assertTrue(areListsEqual(expected, result));
    }
}