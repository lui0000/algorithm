package org.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MiddleOfTheLinkedList {

    // более топортное решение
//    public ListNode middleNode(ListNode head) {
//        ListNode curr = head;
//
//        int length = 0;
//        while (curr != null) {
//            curr = curr.next;
//            length++;
//        }
//        curr = head;
//        for (int i = 0; i < length/2; i++) {
//                curr = curr.next;
//        }
//        return  curr;
//    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;


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
        MiddleOfTheLinkedList middleOfTheLinkedList = new MiddleOfTheLinkedList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        middleOfTheLinkedList.printLinkedList(head);
        ListNode result = middleOfTheLinkedList.middleNode(head);
        middleOfTheLinkedList.printLinkedList(result);


    }
}
