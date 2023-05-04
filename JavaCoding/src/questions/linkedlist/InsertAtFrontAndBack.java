package questions.linkedlist;

import questions.Node;

public class InsertAtFrontAndBack {

    static Node head = null;

    public static void insertAtIndex(int num, int index) {
        int i = 1;
        Node curr = head;
        while (curr != null && i != index) {
            i++;
            curr = curr.next;
        }
        Node temp = curr.next;
        curr.next = new Node(num);
        curr.next.next = temp;
    }

    public static void insertAtFront(int num) {
        Node temp = new Node(num);
        temp.next = head;
        head = temp;
    }

    public static void main(String[] args) {
        insertAtBack(1);
        insertAtBack(2);
        insertAtBack(3);
        insertAtIndex(10,3);
        printValues(head);
    }

    public static void printValues(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void insertAtBack(int num) {
        if (head == null) {
            head = new Node(num);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(num);
    }
}
