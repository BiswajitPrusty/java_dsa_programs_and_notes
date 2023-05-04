package questions.linkedlist;

import questions.Node;

public class InsertAtIndex {

    int index = 1;

    public static void main(String[] args) {
        InsertAtIndex list = new InsertAtIndex();

        Node head = list.insertIndex(1, 1, null);
        list.insertIndex(2, 2, head);
        list.insertIndex(3, 3, head);
        list.insertIndex(3, 4, head);
        TraversingLinkedList.iterateLinkedList(head);
    }

    public Node insertIndex(int pos, int data, Node head) {
        Node temp = new Node(data);
        if (pos == 1) {
            temp.next = head;
            head = temp;
            return head;
        }
        Node curr = head;
        int counter = 1;
        while (curr != null && counter != pos - 1) {
            curr = curr.next;
            counter++;
        }
        if (curr == null) {
            return head;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }
}
