package org.example.linkedlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedLists {

    private int getVal(ListNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        return node.val;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = new ListNode();
        ListNode dummyNode = current;
        while(list1 != null || list2 != null) {
            if(getVal(list1) < getVal(list2)) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;

        }
        return dummyNode.next;
    }

//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        List<Integer> intermediateResult = new ArrayList<>();
//        ListNode current1 = list1;
//        ListNode current2= list2;
//        while (current1 != null) {
//            intermediateResult.add(current1.val);
//            current1 = current1.next;
//        }
//        while (current2 != null) {
//            intermediateResult.add(current2.val);
//            current2 = current2.next;
//        }
//        if (intermediateResult.isEmpty()) {
//            return list1;
//        }
//
//        Collections.sort(intermediateResult);
//        ListNode head = new ListNode();
//        ListNode current = head;
//        for (int i = 0; i< intermediateResult.size(); i++) {
//            current.val = intermediateResult.get(i);
//            if (i < intermediateResult.size() - 1) {
//                current.next = new ListNode();
//                current = current.next;
//            }
//
//        }
//        return head;
//    }


//        Если head ещё null:
//        Создаём новый ListNode с integer
//                head = этот узел
//                tail = этот узел
//        Иначе:
//        Создаём новый ListNode с integer
//        tail.next = новый узел
//                tail = новый узел

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
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        mergeTwoSortedLists.printLinkedList(list1);
        mergeTwoSortedLists.printLinkedList(list2);
        ListNode list3 = mergeTwoSortedLists.mergeTwoLists(list1, list2);
        mergeTwoSortedLists.printLinkedList(list3);
    }

}
