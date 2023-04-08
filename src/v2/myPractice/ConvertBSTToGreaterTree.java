package v2.myPractice;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * 538. Convert BST to Greater Tree
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * *
 */
public class ConvertBSTToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        convertBSTRec(root, 0);
        return root;
    }

    public int convertBSTRec(TreeNode root, int currentSum) {
        if (root == null) {
            return currentSum;
        }
        root.val += convertBSTRec(root.right, currentSum);
        return convertBSTRec(root.left, root.val);
    }

    public static void main(String[] args) {
        new ConvertBSTToGreaterTree().convertBST(new TreeNode(4,
                new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
                new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8)))));
    }
}
