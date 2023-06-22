package questions.linkedlist;

import questions.Node;

public class TraversingLinkedList {

    public static void main(String[] args) {

        InsertAtFrontAndBack.insertAtFront(1);
        InsertAtFrontAndBack.insertAtFront(2);
        InsertAtFrontAndBack.insertAtFront(3);
        InsertAtFrontAndBack.insertAtFront(4);
        traverseViaRecursion(InsertAtFrontAndBack.head);
        iterateLinkedList(InsertAtFrontAndBack.head);
    }

    public static void traverseViaRecursion(Node node) {
        if (node == null) return;
        System.out.println(node.data);
        traverseViaRecursion(node.next);
    }

    public static void iterateLinkedList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
