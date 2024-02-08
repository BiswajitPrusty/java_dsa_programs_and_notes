package dsa.linkedlist;

import questions.Node;

public class DeleteHeadCLL {

    //naive approach
    public Node delete(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) {
            return null;
        }
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = head.next;
        return curr.next;
    }

    //efficient approach
    public Node delHead(Node head) {
        if(head == null || head.next == head) return null;

        head.key = head.next.key;
        head.next = head.next.next;
        return head;
    }
}
