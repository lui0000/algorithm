package org.example.linkedlist;

public class ReorderList {
    public void reorderList(ListNode head) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode temp = current;

        while (current != null) {
            current = current.next;
            temp.next = prev;
            prev = temp;
            temp = current;
        }
        return prev;
    }

    public ListNode findPrevMiddle(ListNode head) {

    }
}
