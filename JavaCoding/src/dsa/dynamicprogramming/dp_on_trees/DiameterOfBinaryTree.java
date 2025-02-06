package dsa.dynamicprogramming.dp_on_trees;

import questions.Node;

public class DiameterOfBinaryTree {

    public static int solve(Node root, int[] res) {
        if(root == null) return 0;

        int l = solve(root.left, res);
        int r = solve(root.right, res);

        int temp = Math.max(l, r) + 1;
        int ans = Math.max(temp, 1 + l + r);
        res[0] = Math.max(res[0], ans);

        return temp;
    }

    public static void main(String[] args) {
        Node root = new Node(10,
                new Node(20,new Node(40),new Node(50)),
                new Node(30,new Node(40),new Node(50)));
        System.out.println(solve(root, new int[]{Integer.MIN_VALUE}));

    }
}
