package dsa.linkedlist;

import questions.Node;

public class CircularLinkedListTraversal {

    public void method1(Node head) {
        if (head == null) {
            return;
        }

        System.out.print(head.key + ", ");

        for (Node r = head.next; r != head; r = r.next) {
            System.out.print(r.key + ", ");
        }
    }

    public void method2(Node head) {
        if (head == null) {
            return;
        }
        Node r = head;
        do {
            System.out.print(r.key + ", ");
            r = r.next;
        } while (r != head);
    }
}
