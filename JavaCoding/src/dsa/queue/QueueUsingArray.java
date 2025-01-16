package dsa.queue;

public class QueueUsingArray {

    int size, cap, front = 0;
    int[] arr;

    QueueUsingArray(int cap) {
        this.cap = cap;
        this.size = 0;
        this.arr = new int[cap];
    }

    public void enqueue(int value) {
        if (isFull()) {
            return;
        }
        int rear = getRear();
        rear = (rear + 1) % cap;
        arr[rear] = value;
        size++;
    }

    public void dequeue() {
        if(isEmpty()) return;
        front = (front + 1) % cap;
        size--;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return front;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return (front + size - 1) % cap;
    }

    public boolean isFull() {
        return size == cap;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(4);
        q.enqueue(10);
        q.enqueue(15);
        q.enqueue(16);
        q.enqueue(17);
        q.dequeue();
        q.enqueue(18);
        System.out.println(q.size());
        System.out.println(q.getFront());
        System.out.println(q.getRear());
    }
}
