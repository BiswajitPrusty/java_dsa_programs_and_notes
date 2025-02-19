package dsa.linkedlist;

import questions.searching.ListNode;

public class ReverseLinkedListII92 {


    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0,head);
        ListNode leftPrev = dummy, curr = head, prev = null, next = null;

        for (int i = 0; i <  left - 1; i++) {
            leftPrev = curr;
            curr = curr.next;
        }
        for (int i = 0; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        leftPrev.next.next = curr;
        leftPrev.next = prev;
        return dummy.next;
    }

    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ListNode  lnode = null, prev = null, next = null, curr = head;
        int l = 1;
        while(l <= right){

            if(l > left && l <= right){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                l++;
                continue;
            }
            if(l == left){
                lnode = curr;
            }
            l++;
            prev = curr;
            curr = curr.next;
        }


        ListNode temp = lnode.next;
        lnode.next = prev;
        temp.next = next;

        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        reverseBetween(head, 1, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
