package questions.searching;

public class SearchInBinarySearchTree700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val == val) return temp;
            else if (temp.val > val) temp = temp.left;
            else temp = temp.right;
        }
        return null;
    }
}
