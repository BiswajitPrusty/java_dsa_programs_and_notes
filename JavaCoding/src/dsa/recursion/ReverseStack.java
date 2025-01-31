package dsa.recursion;

import java.util.Stack;

public class ReverseStack {

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return;
        }
        int temp = stack.pop();
        reverseStack(stack);
        insert(stack, temp);
    }

    public static void insert(Stack<Integer> stack, int curr) {
        if (stack.isEmpty()) {
            stack.push(curr);
            return;
        }
        int temp = stack.pop();
        insert(stack, curr);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        reverseStack(stack);

        System.out.println(stack);
    }
}


/*

4
3
2
1



 */