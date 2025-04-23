package org.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Integer minEl = findMinInRow(lists);
        ListNode head = new ListNode();
        if(minEl == null) {
            return null;
        }
        ListNode current = lists[minEl];
        head = current;

        while (true) {
            minEl = findMinInRow(lists);
            if(minEl == null) {
                current.next = null;
                break;
            }
            current.next = lists[minEl].next;
            current = current.next;
            lists[minEl] = lists[minEl].next;


        }

        return head;


    }

    private Integer findMinInRow(ListNode[] lists) {
        ListNode current1;
        ListNode dummyNode = new ListNode();
        ListNode temp = new ListNode(Integer.MAX_VALUE);
        int minIndex = temp.val;

        for(int i =0; i<lists.length; i++) {
            current1 = lists[i];
            if(current1.val <= temp.val) {
                temp = current1;
                minIndex = i;
            }

        }
        if (minIndex == Integer.MAX_VALUE)
            return null;

        return minIndex;
    }

    public void printLinkedList(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        System.out.println(values);
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode head1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode head3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = {head1, head2, head3};
       mergeKSortedLists.printLinkedList(mergeKSortedLists.mergeKLists(lists));

    }
}
