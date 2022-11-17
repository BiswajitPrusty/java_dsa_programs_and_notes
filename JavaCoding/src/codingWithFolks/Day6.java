package codingWithFolks;

import java.util.ArrayList;


public class Day6 {


    ArrayList<Integer> values = new ArrayList<>();

    public boolean isSameTree(TreeNode p, TreeNode q) {

        printPreorder(p);
        printPreorder(q);
        int mid = values.size() / 2;
        for (int i = 0; i < mid; i++) {

            for (int j = mid + i; j < values.size(); j++) {

                if (values.get(i) == values.get(j)) {
                    break;
                }
                if (values.get(i) != values.get(j)) {
                    return false;
                }
            }

        }

        return true;
    }

    void printPreorder(TreeNode node) {
        if (node == null)
            return;

        /* first print data of node */
        values.add(node.val);

        /* then recur on left subtree */
        printPreorder(node.left);

        if (node.left == null)
            values.add(null);
        /* now recur on right subtree */
        printPreorder(node.right);
        if (node.right == null)
            values.add(null);
    }

    public static void main(String[] args) {
        String s ="{(]}";
        System.out.println(isValid(s));
    }

    static public boolean isValid(String s) {

        boolean ans = false;
        if (s.contains("(")) {
            if (s.contains(")"))
                ans = true;
            else
                return false;
        }

        if (s.contains("[")) {
            if (s.contains("]"))
                ans = true;
            else
                return false;
        }

        if (s.contains("{")) {
            if (s.contains("}"))
                ans = true;
            else
                return false;
        }

        return ans;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
