package Practise;

public class DoublyList2 {
    private Node head;
    private Node tail;
    private int length;

    public DoublyList2(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > length)
            throw new IndexOutOfBoundsException();
        else if (index == 0)
            prepend(value);
        else if (index == length)
            append(value);
        else {
            Node current = head;
            for (int i = 0; i < length - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
            newNode.previous = current;
            newNode.next.previous = newNode;
            length++;

        }
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        head.previous = newNode;
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
        length++;
    }
}
