package org.example.linkedlist;

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
        ListNode prev = findPrevNodeByIndex(head, n);
        prev.next = prev.next.next;
        return
    }

    public void add(int val) {
        ListNode head = new ListNode(val, null);
       if(head == null) {
            head = new ListNode(val);
        } else{
            ListNode current = head;
            while(current != null) {
                current = current.next;

            }
            current.next = new ListNode(val);
        }
    }
    // для начала находим len
    private int getLinkedListLenght(ListNode head) {
        int i = 0;
        ListNode current = head;
        while(current != null) {
            current = current.next;
            i++;
        }
        return i;
    }

    private ListNode findPrevNodeByIndex(ListNode head,int n) {
        ListNode dummyNode = new ListNode(0, head);
       int index = getLinkedListLenght(dummyNode) - n;
       int i = 0;
       ListNode current = dummyNode;
       while (i != index) {
           i++;
           current = current.next;
       }
       return current;

    }

}


// спросить про быстрый и медленный указатели у Вани