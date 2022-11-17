package DataStructure;

import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top;//index of array

    public ArrayStack(int capacity) {

        stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        if (top == stack.length) {
            // need to resize the array as the above condition states that the stack is full

            Employee[] newArray = new Employee[2 * stack.length];
//                here we are copying the array the
            //arrayName,copyStartIndex,newArray,copyingToIndex, No of elements to be inserted.
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            //now we are assigning the new array resized array to the stack
            stack = newArray;
        }
        stack[top++] = employee;
    }

    public int size() {
        return top;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        //here we are removing employee from the stack top so here array length is one less to access elements
        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    public boolean isEmpty() {
        return top == 0;
    }

}
