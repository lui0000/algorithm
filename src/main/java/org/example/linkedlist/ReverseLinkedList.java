package org.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }

    public static void add(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            head = newNode;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

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

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseLinkedList.printLinkedList(listNode);
        listNode = reverseLinkedList.reverseList(listNode);
        reverseLinkedList.printLinkedList(listNode);



    }
}
