package javaeight;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class EvenOddByThreads {

    public static void main(String[] args) {
        Printer print = new Printer();

        Thread even = new Thread(() -> print.printEven(), "Even thread");
        Thread odd = new Thread(() -> print.printOdd(), "Odd thread");

        odd.start();
        even.start();

    }

}

class Printer {

    private int count = 1;
    private int max = 10;
    private boolean isEven = false;

    public synchronized void printEven() {
        while (count <= max) {
            while (!isEven) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Even Thread: " + count);
            count++;
            isEven = false;
            notify();
        }
    }
    public synchronized void printOdd() {
        while (count <= max) {
            while (isEven) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Odd Thread: " + count);
            count++;
            isEven = true;
            notify();
        }
    }
}

