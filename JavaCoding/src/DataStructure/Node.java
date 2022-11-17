package DataStructure;

public class Node {
    public int value;
    public Node next;
    public Node previous;
    public Node right;
    public Node left;

    public Node(int value) {
        this.value = value;
        this.next = previous = right = left = null;
    }
}
