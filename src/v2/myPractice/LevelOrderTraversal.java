package v2.myPractice;

import java.util.*;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> innerList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.remove();
                    innerList.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                    }
                }
                list.add(innerList);
            }
        }
        Collections.reverse(list);
        return list;

    }
}
