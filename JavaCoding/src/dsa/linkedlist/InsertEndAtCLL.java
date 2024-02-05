package dsa.linkedlist;

import questions.Node;

public class InsertEndAtCLL {

    public Node insertEnd(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        } else {
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
            return head;
        }
    }
}
