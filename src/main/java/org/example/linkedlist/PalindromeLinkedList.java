package org.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    //найти середину
    // развернуть вторую часть списка (добавятся указалети prev)
    // сравнить половины
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode curr = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = prev;
            prev = temp;
        }

        while (curr != null && prev != null) {
            if (curr.val != prev.val) {
                return false;
            }
            curr = curr.next;
            prev = prev.next;
        }

        return true;
    }


    public static void main(String[] args) {
        PalindromeLinkedList middleOfTheLinkedList = new PalindromeLinkedList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(middleOfTheLinkedList.isPalindrome(head));


    }

}
