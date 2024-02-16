package dsa.linkedlist;

import questions.Node;

import java.util.List;

public class DeleteKthNOde {

    public Node deleteKth(Node head, int k) {
        if (head == null) {
            return head;
        }
        if (k == 1) {
            return DeleteHeadCLL.delHead(head);
        }
        Node curr = head;
        for (int i = 0; i < k - 2; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}

