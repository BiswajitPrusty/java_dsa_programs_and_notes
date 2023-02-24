package questions.stack;

import questions.searching.ListNode;

public class StackUsingLinkedLIst {
    private ListNode head;
    private int size = 0;

    public static void main(String[] args) {
        StackUsingLinkedLIst s = new StackUsingLinkedLIst();
        System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
        System.out.println(s.size());
    }

    public void push(int num) {
        ListNode temp = new ListNode(num);
        temp.next = head;
        head = temp;
        size++;
    }

    public int peek() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Stack is empty");
        } else return head.val;
    }

    public int pop() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        int res = head.val;
        head = head.next;
        size--;
        return res;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
