package LeetCode;

public class DsDay8 {

    ListNode newHead = null;

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {

        //three pointers to hold next, previous and current node from linked list;
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        while (current != null) {
            //here as the current node is the head node we are moving one step to the next node.
            next = current.next;

            //remove the current nodes next element to prevous node
            current.next = prev;

            // assign the current node to previous one.
            prev = current;

            //move the current node to next element.
            current = next;
        }

        head = prev;
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        /**
         * Algorithm: Traverse the list from the head (or start) node.
         * While traversing, compare each node with its next node.
         * If the data of the next node is the same as the current node then delete the next node.
         * Before we delete a node, we need to store the next pointer of the node
          */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val)
                current.next = current.next.next;
             else
                current = current.next;
        }
        return head;
    }
}
