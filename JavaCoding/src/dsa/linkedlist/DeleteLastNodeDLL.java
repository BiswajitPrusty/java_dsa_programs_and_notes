package dsa.linkedlist;

import questions.Node;

public class DeleteLastNodeDLL {

    public static Node deleteLastNode(Node head) {
        if (head == null) return null;
        if (head.next == null) return null;

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        return head;
    }
}
