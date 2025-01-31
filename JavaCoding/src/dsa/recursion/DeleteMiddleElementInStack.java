package dsa.recursion;

import java.util.Stack;

public class DeleteMiddleElementInStack {

    public static void deleteMiddleElement2(Stack<Integer> stack, int k) {
        if (k == 1) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        deleteMiddleElement2(stack, k - 1);
        stack.push(temp);
    }

    public static void deleteMiddleElement(Stack<Integer> stack, int size) {
        if(stack.size() == size/2 + 1){
            stack.pop();
            return;
        }
        int temp = stack.pop();
        deleteMiddleElement(stack, size);
        stack.push(temp);
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
        deleteMiddleElement2(stack, stack.size()/2 + 1);
        System.out.println(stack);

    }
}
