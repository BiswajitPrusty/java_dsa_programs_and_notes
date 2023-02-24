package questionOfDay;

import java.util.ArrayList;
import java.util.List;

public class SameTree100 {
    List<Integer> firstTree = new ArrayList<>();
    List<Integer> secondTree = new ArrayList<>();


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        preOrder(p, firstTree);
        preOrder(p, secondTree);
        return firstTree.toString().equalsIgnoreCase(secondTree.toString());
    }

    public void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);

    }
}
