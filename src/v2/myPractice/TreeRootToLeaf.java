package v2.myPractice;

import java.util.ArrayList;
import java.util.List;

public class TreeRootToLeaf {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSumRec(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    public void pathSumRec(TreeNode root, int targetSum, List<Integer> lis, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                ans.add(new ArrayList<>(lis));
                ans.get(ans.size() - 1).add(root.val);
            }
            return;
        }
        targetSum -= root.val;
        lis.add(root.val);
        pathSumRec(root.left, targetSum, lis, ans);
        pathSumRec(root.right, targetSum, lis, ans);
        lis.remove(lis.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        new TreeRootToLeaf().pathSum(treeNode, 22);
    }
}
