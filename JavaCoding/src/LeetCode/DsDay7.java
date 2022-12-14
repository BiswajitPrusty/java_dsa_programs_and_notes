package LeetCode;

public class DsDay7 {

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(8);
        ListNode l4 = new ListNode(4);

        l.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        DsDay7 d = new DsDay7();
        System.out.println((d.removeElements(l, 4)));


    }

    /**
     * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
     * <p>
     * Input: head = [1,2,6,3,4,5,6], val = 6
     * Output: [1,2,3,4,5]
     */

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (head != null) {
            if (head.val != val) {
                System.out.println(head.val);
                current.next = head;
                current = current.next;
            }
                head = head.next;
        }
        if (current.next != null && current.next.val == val) {
            current.next = null;
        }
        return dummy.next;
    }

    public ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementsRecursive(head.next, val);
        return head.val == val ? head.next : head;
    }
    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * Return the head of the merged linked list.
     * <p>
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy head node for the merged list
        ListNode dummyHead = new ListNode(-1);

        // Create a pointer to the dummy head node
        ListNode current = dummyHead;

        // Loop until one of the lists is empty
        while (list1 != null && list2 != null) {
            // Compare the values of the two list nodes
            if (list1.val < list2.val) {
                // If list1 has the smaller value, add it to the merged list
                current.next = list1;
                list1 = list1.next;
            } else {
                // If list2 has the smaller value, add it to the merged list
                current.next = list2;
                list2 = list2.next;
            }

            // Move the pointer to the next node in the merged list
            current = current.next;
        }

        // If list1 is not empty, add the remaining nodes to the merged list
        if (list1 != null) {
            current.next = list1;
        }

        // If list2 is not empty, add the remaining nodes to the merged list
        if (list2 != null) {
            current.next = list2;
        }

        // Return the head of the merged list
        return dummyHead.next;
    }

    /**
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * <p>
     * There is a cycle in a linked list if there is some node in the list that can be reached again by
     * continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
     * Note that pos is not passed as a parameter.
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     */
    public boolean hasCycle(ListNode head) {

        //this problem can be solved using tortoise and hare algorithm.
        // where tortoise(slow) will move one node at a time and hare(fast) will move 2 nodes at a time.
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            //move one step for slow node
            slow = slow.next;

            //move two steps for fast node
            fast = fast.next.next;

            //if the 2 points meet at a node it's an cycle.
            if (slow == fast) {
                return true;
            }
        }

        return false;
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