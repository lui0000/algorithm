package org.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    // далее надо проитерироваться до len-n-1
    // далее удаляем node.next = node.next.next
    // return dummy.next

    // есть три варианта:
    // 1. удаление node из начала, для этого нужен Dummy Node
    // 2. удаление из середины len(список) - n -1, чтобы выстроить связь
    // 3. удаление node с конца, просто предпоследний элемент указывает на null

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode current = dummyNode;
        int len = getLinkedListLength(dummyNode);

        for (int i = 0; i < (len -n -1); i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return dummyNode.next;

    }

    // для начала находим len
    private int getLinkedListLength(ListNode dummyNode) {
        int i = 0;
        ListNode current = dummyNode;
        while(current != null) {
            current = current.next;
            i++;
        }
        return i;
    }

//    private ListNode findPrevNodeByIndex(ListNode head,int n) {
//        ListNode dummyNode = new ListNode(0, head);
//        int index = getLinkedListLenght(dummyNode) - n;
//        int i = 0;
//        ListNode current = dummyNode;
//        while (i != index) {
//           i++;
//           current = current.next;
//       }
//       return current;
//
//    }

    public static ListNode add(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            return newNode;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

        return head;
    }

    public void printLinkedList(ListNode dummyNode) {
        if (dummyNode == null || dummyNode.next == null) {
            System.out.println("[]");
            return;
        }

        List<Integer> values = new ArrayList<>();
        ListNode current = dummyNode.next;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        System.out.println(values);
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode listNode = new ListNode(0, null);
        add(listNode, 9);
        add(listNode, 5);
        add(listNode, 8);
        add(listNode, 10);
        add(listNode, 1);
        removeNthNodeFromEndOfList.printLinkedList(listNode);
        removeNthNodeFromEndOfList.removeNthFromEnd(listNode, 1);
        removeNthNodeFromEndOfList.printLinkedList(listNode);

    }

}


// спросить про быстрый и медленный указатели у Вани