package questions.stack;

import java.util.Arrays;

public class MyStack {

    int[] nums;
    int indexOfLastElement = -1;

    public MyStack(int capacity) {
        this.nums = new int[capacity];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.toString());
    }

    @Override
    public String toString() {

        return "MyStack: " + Arrays.toString(nums);
    }

    public void push(int num) {
        indexOfLastElement++;
        nums[indexOfLastElement] = num;
    }

    public int peek() {
        return nums[indexOfLastElement];
    }

    public int pop() {
        int lastElement = nums[indexOfLastElement];
        nums[indexOfLastElement] = 0;
        indexOfLastElement--;
        return lastElement;
    }

    public int size() {
        return indexOfLastElement + 1;
    }

    public boolean isEmpty() {
        return indexOfLastElement == -1;
    }
}
