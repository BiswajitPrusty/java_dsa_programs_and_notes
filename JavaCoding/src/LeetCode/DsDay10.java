package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class DsDay10 {

    List<Integer> allElements = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        printInorder(root);
        return allElements;
    }

    void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        allElements.add(node.val);

        /* now recur on right child */
        printInorder(node.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        printPreorder(root);
        return allElements;
    }

    void printPreorder(TreeNode node) {
        if (node == null) {
            return;
        }
        /* add the data of node */
        allElements.add(node.val);

        /* first recur on left child */
        printPreorder(node.left);

        /* now recur on right child */
        printPreorder(node.right);
    }


    public List<Integer> postorderTraversal(TreeNode root) {

        printPostorder(root);

        return allElements;
    }

    void printPostorder(TreeNode node) {
        if (node == null) {
            return;
        }
        /* first recur on left child */
        printPostorder(node.left);

        /* now recur on right child */
        printPostorder(node.right);

        /* add the data of node */
        allElements.add(node.val);

    }


}
