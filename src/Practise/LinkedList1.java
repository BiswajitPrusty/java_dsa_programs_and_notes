package Practise;

import DataStructure.Node;

public class LinkedList1 {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList1(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void remove(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("");
        } else if (index == 0) {
            head = this.head.next;
            length--;
        } else {
            Node current = head;
            int i;
            for (i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            length--;
            if (i == length - 1) {
                tail = current;
            }
        }
    }

    public void insert(int value, int index) {

        if (index > length || index < 0)
            throw new IndexOutOfBoundsException(" ");
        else if (index == 0)
            prepend(value);
        else if (index == length)
            append(value);
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
            length++;
        }

    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        length++;
    }


    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }


    public void append(int value) {
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        length++;
    }


}
