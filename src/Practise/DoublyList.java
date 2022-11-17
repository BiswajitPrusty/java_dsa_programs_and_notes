package Practise;

import DataStructure.Node;

public class DoublyList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void insert(int value, int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("length ke andar insert kar");
        } else if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node newNode = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            newNode.previous = current;
            newNode.next.previous = newNode;
            length++;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("thoda padle bhai");
        } else if (index == 0) {
            head = this.head.next;
            this.head.previous = null;
            length--;
        } else {
            Node current = head;
            int i = 0;
            for (i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            length--;
            if (i == length - 1) {
                tail = current;
            } else {
                current.next.previous = current;
            }
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        head.previous = newNode;
        newNode.next = head;
        head = newNode;
        length++;
    }
}
