package questions.recursion;

import questions.Node;

public class HeightOfBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(10, new Node(5), new Node(10));
        System.out.println(height(root));
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);
    }
}
