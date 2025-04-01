package org.example.linkedlist;

public class RemoveNthNodeFromEndOfList {

    // далее надо проитерироваться до len-n-1
    // далее удаляем node.next = node.next.next
    // return dummy.next

    private ListNode head;
    private ListNode dummyNode = new ListNode(0, head);



    // есть три варианта:
    // 1. удаление node из начала, для этого нужен Dummy Node
    // 2. удаление из середины len(список) - n -1, чтобы выстроить связь
    // 3. удаление node с конца, просто предпоследний элемент указывает на null

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        if (head.next == null) {
            dummyNode.next = null;
        } else if (findPrevNodeByIndex(n).next.next == null) {
            findPrevNodeByIndex(n).next = null;
        } else {
            findPrevNodeByIndex(n)
        }

    }

    public void add(int val) {
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

    private ListNode findPrevNodeByIndex(int n) {
       int index = getLinkedListLenght(head) - n;
       int i = 0;
        ListNode current = head;
       while (i != index) {
           i++;
           current = current.next;
       }
       return current;

    }


}


// спросить про быстрый и медленный указатели у Вани