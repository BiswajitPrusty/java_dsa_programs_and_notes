package dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumberWithGivenDigit {

    public static void main(String[] args) {
        printFirstN(10);
    }

    public static void printFirstN(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("5");
        queue.add("6");
        for (int i = 0; i < n; i++) {
            String poll = queue.poll();
            System.out.print(poll+", ");
            queue.add(poll + "5");
            queue.add(poll + "6");
        }


    }
}
