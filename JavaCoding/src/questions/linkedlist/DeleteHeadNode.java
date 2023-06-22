package questions.linkedlist;

import questions.Node;

public class DeleteHeadNode {


    public static void main(String[] args) {
        InsertAtFrontAndBack.insertAtBack(1);
        InsertAtFrontAndBack.insertAtBack(2);
        InsertAtFrontAndBack.insertAtBack(3);
        InsertAtFrontAndBack.insertAtBack(4);
//        InsertAtFrontAndBack.printValues(deleteFirstNode(InsertAtFrontAndBack.head));
        InsertAtFrontAndBack.printValues(deleteLastNode(InsertAtFrontAndBack.head));


    }

    public static Node deleteFirstNode(Node node) {
        if (node == null) {
            return null;
        } else {
            node = node.next;
        }
        return node;
    }

    public static Node deleteLastNode(Node head) {
        Node temp = head;
        if (temp == null || temp.next == null) {
            return null;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }
}
