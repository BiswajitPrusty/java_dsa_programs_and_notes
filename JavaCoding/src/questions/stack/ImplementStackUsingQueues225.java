package questions.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues225 {


    private final Queue<Integer> stack = new LinkedList<>();
    private final Queue<Integer> temp = new LinkedList<>();

    public ImplementStackUsingQueues225() {

    }

    public static void main(String[] args) {
        ImplementStackUsingQueues225 s = new ImplementStackUsingQueues225();
        s.push(1);
        s.push(2);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.empty());
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        int size = stack.size();
        if (size == 0) {
            return -1;
        }
        int count = 1;
        while (count != size) {
            temp.add(stack.poll());
            count++;
        }
        Integer lastElement = stack.poll();
        while (!temp.isEmpty()) {
            stack.add(temp.poll());
        }
        return lastElement;

    }

    public int top() {
        int size = stack.size();
        if (size == 0) {
            return -1;
        }
        int count = 1;
        while (count != size) {
            temp.add(stack.poll());
            count++;
        }
        int lastElement = stack.poll();
        temp.add(lastElement);

        while (!temp.isEmpty()) {
            stack.add(temp.poll());
        }
        return lastElement;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
