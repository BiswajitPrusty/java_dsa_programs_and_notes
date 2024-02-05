package dsa.linkedlist;

import questions.Node;

public class InsertAtBeginningDLL {

    public static Node insertBegin(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        if (head != null)
            head.prev = temp;
        return temp;
    }
}
