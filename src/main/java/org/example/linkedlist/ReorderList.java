package org.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode current = head;
        ListNode temp = findPrevMiddle(head);
        ListNode prev = reverseList(temp.next);
        temp.next = null;

        while (prev != null) {
            temp = current.next;
            current.next = prev;
            current = prev;
            prev = temp;
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
