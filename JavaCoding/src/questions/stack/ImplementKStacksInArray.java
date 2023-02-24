package questions.stack;

import java.util.Arrays;

public class ImplementKStacksInArray {

    private int arr[], top[], next[];
    private int freeTop = 0;

    public ImplementKStacksInArray(int capacity, int noOfStacks) {
        this.arr = new int[capacity];
        this.top = new int[noOfStacks];
        this.next = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            next[i] = i + 1;
        }
        Arrays.fill(top, -1);
        next[capacity - 1] = -1;
    }

    public void push(int num, int stackNo) {

    }

    public void pop(int num, int stackNo) {

    }

    public void peek(int num, int stackNo) {

    }
}
