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

    // Big O 1 approach
    public Node insertEnd2(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        } else {
            temp.next = head.next;
            head.next = temp;
            int t = temp.key;
            temp.key = head.key;
            head.key = t;
            return temp;
        }
    }
}
