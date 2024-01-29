package dsa.tree;

import questions.Node;

public class HeightOfBinaryTree {

    public static void main(String[] args) {

        Node root = new Node(10,
                new Node(20),
                new Node(30,new Node(40),new Node(50)));
        System.out.println(height(root));

    }
    public static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

}
