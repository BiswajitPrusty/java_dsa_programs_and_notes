package codingWithFolks;

import java.util.Stack;

public class Day11 {
    public static void main(String[] args) {
        System.out.println(new Day11().isValid("()["));
    }

    public boolean isValid(String s) {
        Stack st = new Stack();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                count++;
                st.push(s.charAt(i));
            }
            if ((s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')')) {
                if (st.size() < 1) {
                    return false;
                }
                if ((char) st.peek() == '[' && s.charAt(i) == ']')
                    st.pop();
                else if ((char) st.peek() == '{' && s.charAt(i) == '}')
                    st.pop();
                else if ((char) st.peek() == '(' && s.charAt(i) == ')')
                    st.pop();
                else
                    return false;

            }

        }
        return st.size() == 0 ? count >= 1 ? true : false : false;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;

            }
        }

        if (list1 == null) {
            current.next = list2;
        }

        if (list2 == null) {
            current.next = list1;
        }

        return dummy.next;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
