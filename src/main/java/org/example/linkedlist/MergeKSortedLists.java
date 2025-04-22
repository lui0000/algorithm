package org.example.linkedlist;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode current = new ListNode();
        ListNode minEl = new ListNode();
        while (true) {
            minEl = findMinInRow(lists);
            minEl = minEl.next;




        }
    }

    private ListNode findMinInRow(ListNode[] lists) {
        ListNode current1;
        ListNode dummyNode = new ListNode();
        ListNode temp = new ListNode(Integer.MAX_VALUE);

        for(int i =0; i<lists.length; i++) {
            current1 = lists[i];
            if(current1.val <= temp.val) {
                temp = current1;
            }
        }
        if(temp.val == Integer.MAX_VALUE) {
            return null;
        } else {
            dummyNode = temp;
            dummyNode = dummyNode.next;

        }

        return temp;
    }
}
