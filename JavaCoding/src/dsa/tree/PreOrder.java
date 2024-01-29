package dsa.tree;

import questions.Node;

public class PreOrder {
    public static void main(String[] args) {

        Node root = new Node(10,
                new Node(20),
                new Node(30,new Node(40),new Node(50)));
        preOrder(root);

    }
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key+", ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
