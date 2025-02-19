package dsa.linkedlist;

import questions.searching.ListNode;

public class ReverseLinkedList206 {

    public ListNode reverseList(ListNode head) {
        ListNode curr = head,
                 next = null,
                 prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
