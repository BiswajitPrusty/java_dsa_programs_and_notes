package dsa.linkedlist;

import questions.Node;

public class InsertAtBeginningCLL {

    //time complexity O(n)
    public Node insertBegin(Node head, int x) {
        Node temp = new Node(x);

        if (head == null) {
            temp.next = temp;
        } else {
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
        }
        return temp;
    }

    //time complexity O(1)
    public Node insertBegin2(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        } else {
            temp.next = head.next;
            head.next = temp;
            int headData = head.key;
            head.key = temp.key;
            temp.key = headData;
            return head;
        }
    }
}
