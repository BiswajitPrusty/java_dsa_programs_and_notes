package dsa.tree;

import questions.Node;

public class PrintNodeAtKDistance {

    public static void main(String[] args) {

        Node root = new Node(10,
                new Node(20),
                new Node(30,new Node(40),new Node(50)));
        printKDist(root, 2);

    }

    public static void printKDist(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.key + ", ");
        } else {
            printKDist(root.left, k - 1);
            printKDist(root.right, k - 1);
        }


    }
}
