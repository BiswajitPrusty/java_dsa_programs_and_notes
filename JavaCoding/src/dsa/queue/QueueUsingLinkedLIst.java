package dsa.queue;

import questions.Node;

import java.util.LinkedList;

public class QueueUsingLinkedLIst {

    Node front, rear;

    QueueUsingLinkedLIst() {
        front = rear = null;
    }

    void enqueue(int x) {
        Node temp = new Node(x);
        if (front == null) {
            front = rear = temp;
        }
        rear.next = temp;
        rear = temp;
    }

    void dequeue() {
        if (front == null) {
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }
}
