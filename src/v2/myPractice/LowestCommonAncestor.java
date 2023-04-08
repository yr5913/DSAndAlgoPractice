package v2.myPractice;


/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * 236. Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * */


public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LowestCommonAncestorAnswer answer = new LowestCommonAncestorAnswer();
        lowestCommonAncestorRec(root, p, q, answer);
        return answer.ans;
    }


    public boolean lowestCommonAncestorRec(TreeNode treeNode, TreeNode p, TreeNode q, LowestCommonAncestorAnswer answer) {
        if (treeNode == null) {
            return false;
        }
        if (treeNode == p || treeNode == q) {
            boolean found = lowestCommonAncestorRec(treeNode.left, p, q, answer) || lowestCommonAncestorRec(treeNode.right, p, q, answer);
            if (found)
                answer.ans = treeNode;
            return true;
        }
        boolean left = lowestCommonAncestorRec(treeNode.left, p, q, answer);
        if (answer.ans != null)
            return true;
        boolean right = lowestCommonAncestorRec(treeNode.right, p, q, answer);
        if (answer.ans != null) {
            return true;
        }
        if (left && right)
            answer.ans = treeNode;
        return left || right;

    }
}
class LowestCommonAncestorAnswer {
    TreeNode ans;
}