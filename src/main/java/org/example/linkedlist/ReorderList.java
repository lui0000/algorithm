package org.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode current = head;
        ListNode temp = current;
        ListNode prev = reverseList(findPrevMiddle(head));
        while (current.next != null && prev != null) {
            temp.val = current.next.val;
            current.next.val = prev.val;
            current = current.next;
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
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

        }
        return slow;

    }
    public void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }

        List<Integer> values = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        System.out.println(values);
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList.printLinkedList(head);
        reorderList.reorderList(head);

    }


}
