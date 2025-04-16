package org.example.linkedlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedLists {
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode dummyNode = null;
//        ListNode current1 = list1;
//        ListNode current2= list2;
//        while(list1 != null || list2 != null) {
//            if (list1.val <= list2.val) {
//                dummyNode = current1;
//            } else {
//                dummyNode = current2;
//            }
//            if (current1.next != null) {
//                current1 = current1.next;
//            } else if (current2.next != null){
//                current2 = current2.next;
//            }
//
//            current2 = current2.next;
//
//
//        }
//    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> intermediateResult = new ArrayList<>();
        ListNode current1 = list1;
        ListNode current2= list2;
        while (current1 != null) {
            intermediateResult.add(current1.val);
            current1 = current1.next;
        }
        while (current2 != null) {
            intermediateResult.add(current2.val);
            current2 = current2.next;
        }

        Collections.sort(intermediateResult);
        ListNode head;
        for (Integer integer : intermediateResult) {
            head = new ListNode(integer);

            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = current;
        }
        return head;


//        Если head ещё null:
//        Создаём новый ListNode с integer
//                head = этот узел
//                tail = этот узел
//        Иначе:
//        Создаём новый ListNode с integer
//        tail.next = новый узел
//                tail = новый узел
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
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(4))));
        ListNode list2 = new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(10))));
        mergeTwoSortedLists.printLinkedList(list1);
        mergeTwoSortedLists.printLinkedList(list2);
        ListNode list3 = mergeTwoSortedLists.mergeTwoLists(list1, list2);
        mergeTwoSortedLists.printLinkedList(list3);
    }



}
