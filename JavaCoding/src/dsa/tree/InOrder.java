package dsa.tree;

import questions.Node;

public class InOrder {

    public static void main(String[] args) {

        Node root = new Node(10,
                new Node(20),
                new Node(30,new Node(40),new Node(50)));
        inorder(root);

    }
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key+", ");
            inorder(root.right);
        }
    }
}
