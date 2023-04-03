package v2.myPractice;


public class KthSmallestInTree {

    public int kthSmallest(TreeNode root, int k) {
        int[] array = new int[2];
        kthSmallestRec(root, k, array, 0);
        return array[1];

    }

    public int kthSmallestRec(TreeNode root, int k, int[] array, int index) {
        if (root == null) {
            return index;
        }
        index = kthSmallestRec(root.left, k, array, index);
        if (index != k) {
            index++;
            if (index == k) {
                array[1] = root.val;
                return k;
            }
            return kthSmallestRec(root.right, k, array, index);
        } else {
            return index;
        }
    }
}


 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

