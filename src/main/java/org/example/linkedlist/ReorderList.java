package org.example.linkedlist;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode current = head;
        ListNode temp = current;
        ListNode prev = reverseList(findPrevMiddle(head));
        while (current.next != null && prev != null) {
            temp.val = current.val;
            current.val = prev.val;
            prev.val = temp.val;
            current = current.next;
            prev = prev.next;
        }

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
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }


}
