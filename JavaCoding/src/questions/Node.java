package questions;


public class Node {

    public Node next;
    public Node prev;

    public Node(int key) {
        this.val = key;
        this.key = key;
        next = null;
        prev = null;
    }

    public int val;
    public int key;
    public Node left;
    public Node right;

    Node() {
    }


    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
