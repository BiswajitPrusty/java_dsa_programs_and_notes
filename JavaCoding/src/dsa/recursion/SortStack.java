package dsa.recursion;

import java.util.Stack;

public class SortStack {

    public static void sort(Stack<Integer> stack) {
        if (stack.size() == 1) return;

        int temp = stack.pop();
        sort(stack);
        insert(stack, temp);

    }

    public static void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }
        int curr = stack.pop();
        insert(stack, temp);
        stack.push(curr);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(9);
        stack.add(0);
        stack.add(1);
        stack.add(4);
        stack.add(90);
        stack.add(67);
        stack.add(2);
        stack.add(120);
        System.out.println(stack);
        sort(stack);
        System.out.println(stack);

    }
}
