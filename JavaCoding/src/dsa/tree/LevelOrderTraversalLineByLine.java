package dsa.tree;

import questions.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {

    public static void main(String[] args) {

        Node root = new Node(10,
                new Node(20),
                new Node(30,new Node(40),new Node(50)));
        printLevelOrderLine(root);

    }
    public static void printLevelOrderLine(Node root) {

        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q.size() > 1) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(curr.key+", ");
            if (curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }
    }
}
