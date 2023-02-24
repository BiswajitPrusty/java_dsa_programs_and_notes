package questions.stack;

import java.util.ArrayList;
import java.util.List;

public class MyStackArrayList {
    List<Integer> stack = new ArrayList<>();
    int top = -1;

    public void push(int num) {
        stack.add(num);
        top++;
    }

    public int peek() {
        if (top == -1) return -1;
        return stack.get(top);
    }

    public int pop() {
        if (top == -1) return -1;
        return stack.remove(top--);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
