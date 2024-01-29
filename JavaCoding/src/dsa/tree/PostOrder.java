package dsa.tree;

import questions.Node;

public class PostOrder {

    public static void main(String[] args) {

        Node root = new Node(10,
                new Node(20),
                new Node(30,new Node(40),new Node(50)));
        postOrder(root);

    }
    public static void postOrder(Node root) {
        if (root !=null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key+", ");
        }

    }
}
