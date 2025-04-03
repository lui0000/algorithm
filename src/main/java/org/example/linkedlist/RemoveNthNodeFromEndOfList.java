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
        int len = getLinkedListLenght(dummyNode);

        for (int i = 0; i < (len -n -1); i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return dummyNode.next;

    }

    // для начала находим len
    private int getLinkedListLenght(ListNode dummyNode) {
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

//    public static void add(int val) {
//        ListNode current = new ListNode(val, null);
//        while(current != null) {
//            current = current.next;
//
//        }
//        current.next = new ListNode(val);
//    }

    public void printLinkedList(ListNode dummyNode) {
        List<Integer> linkedList = new ArrayList<>();
        int len = getLinkedListLenght(dummyNode);
        for (int i = 0; i < len; i++) {
            linkedList.add(dummyNode.next.val);
            dummyNode.next = dummyNode.next.next;
        }
        for (Integer integer : linkedList) {
            System.out.print(integer);
        }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode listNode = new ListNode(0, new ListNode(12, new ListNode(8, new ListNode(2, new ListNode(40)))));
        removeNthNodeFromEndOfList.printLinkedList(listNode);
        removeNthNodeFromEndOfList.removeNthFromEnd(listNode, 2);
        removeNthNodeFromEndOfList.printLinkedList(listNode);

    }

}


// спросить про быстрый и медленный указатели у Вани