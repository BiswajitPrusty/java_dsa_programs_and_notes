package questions.strings;

import questions.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root, "");
        return list;
    }
    public void binaryTreePaths(TreeNode root, String str) {
        if (root == null) return;
        str += root.val + "->";
        binaryTreePaths(root.left, str);
        binaryTreePaths(root.right, str);
        if (root.left == null && root.right == null) list.add(str.substring(0, str.length() - 2));
        return;
    }
}
