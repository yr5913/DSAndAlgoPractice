package v2.myPractice;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafSum {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(new ArrayList<>(), root);
    }

    public int sumNumbers(List<Integer> number, TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        number.add(treeNode.val);
        if (treeNode.left == null && treeNode.right == null) {
            int result = 0;
            int k = 1;
            for (int i = number.size() - 1; i >= 0; i--) {
                result += k * number.get(i);
            }
            number.remove(number.size() - 1);
            return result;
        }
        int val = sumNumbers(number, treeNode.left) + sumNumbers(number, treeNode.right);
        number.remove(number.size() - 1);
        return val;
    }
}
