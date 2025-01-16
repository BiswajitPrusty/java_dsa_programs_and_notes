package dsa.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.offer(10);
        q.offer(5);
        q.offer(15);
        q.offer(20);
        reverseUsingRecursion(q);
        System.out.println(q);
    }

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }

    }

    public static void reverseUsingRecursion(Queue<Integer> queue) {
        if(queue.isEmpty())
            return;
        int data = queue.poll();
        reverseUsingRecursion(queue);
        queue.offer(data);
    }
}
