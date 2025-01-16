package questions;


import java.util.ArrayDeque;
import java.util.Queue;

public class Practice {
    public static void main(String[] args) {

        Queue<Integer> q = new ArrayDeque<>(2);
        q.offer(10);
        q.offer(10);
        q.offer(10);
        System.out.println(q.peek());

    }


}