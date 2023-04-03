package v2.myPractice;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTRec(TreeNode treeNode, int min, int max) {
        if (treeNode == null) {
            return true;
        }
        if (treeNode.val <= min || treeNode.val >= max) {
            return false;
        }
        return isValidBSTRec(treeNode.left, min, treeNode.val) && isValidBSTRec(treeNode.right, treeNode.val, max);
    }
}
