package org.example.linkedlist;
// есть три варианта:
// 1. удаление node из начала, для этого нужен Dummy Node
// 2. удаление из середины len(список) - n -1, чтобы выстроить связь
// 3. удаление node с конца, просто предпоследний элемент указывает на null

public class RemoveNthNodeFromEndOfList {
    // для начала находим len
    // далее надо проитерироваться до len-n-1
    // далее удаляем node.next = node.next.next
    // return dummy.next

    ListNode dummyNode = ListNode(0, head);


}


// спросить про быстрый и медленный указатели у Вани