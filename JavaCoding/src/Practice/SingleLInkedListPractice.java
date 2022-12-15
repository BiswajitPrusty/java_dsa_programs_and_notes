package Practice;

import LeetCode.ListNode;

public class SingleLInkedListPractice {

    public ListNode head = null;

    public static void main(String[] args) {
        SingleLInkedListPractice s = new SingleLInkedListPractice();
        s.append(4);
        s.append(2);
        s.append(3);
        s.append(4);
        s.addToFront(1);
        s.addAtIndex(123, 6);

        s.print(s.head);
    }

    public ListNode print(ListNode listNode) {
        if (listNode == null) return listNode;
        System.out.println(listNode.val);
        return print(listNode.next);
    }

    public void append(int val) {
        if (head == null) {
            head = new ListNode(val);
            return;
        }
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new ListNode(val);
    }

    public void addToFront(int val) {
        if (head == null) {
            head = new ListNode(val);
        }
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
    }

    public void addAtIndex(int val, int index) {
        if (head == null) {
            head = new ListNode(val);
            return;
        } else if (index == 0) {
            addToFront(val);
            return;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null && index != 0) {
            prev = temp;
            temp = temp.next;
            index--;
        }
        ListNode newNode = new ListNode(val);

        newNode.next = temp;
        prev.next = newNode;

    }
}
