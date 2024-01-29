package questions.linkedlist;

import questions.Node;

public class SearchLinkedList {

    Node head;

    public static void main(String[] args) {
        SearchLinkedList s = new SearchLinkedList();
        s.add(1);
        s.add(2);
        s.add(31);
        s.add(4);
        s.add(5);

        System.out.println(s.find(31));
        System.out.println(s.findRecursive(31, s.head));
        TraversingLinkedList.iterateLinkedList(s.head);
    }

    public int findRecursive(int x, Node curr) {
        if (curr == null) {
            return -1;
        }
        if (curr.key == x) {
            return 1;
        }
        return findRecursive(x, curr.next);
    }

    public int find(int x) {
        Node curr = head;
        int index = 1;
        while (curr != null) {
            if (curr.key == x) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public void add(int x) {
        Node temp = new Node(x);
        if (head == null) {
            head = temp;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
    }
}
