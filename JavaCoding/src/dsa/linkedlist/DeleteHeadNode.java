package dsa.linkedlist;

import questions.Node;

public class DeleteHeadNode {

    public static Node deleteHead(Node head) {
        if(head == null) return null;
        if(head.next == null) return null;
        else {
            head = head.next;
            head.prev = null;
            return head;
        }
    }
}
