package v2.myPractice;

public class CountCompleteTreeNodes {


    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int height = getHeight(root);
        Answer answer = new Answer(height);
        getLess(root, answer, 0);
        return (int) Math.pow(2, height) - 1 - answer.count;
    }


    public int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + getHeight(treeNode.left);
    }


    public void getLess(TreeNode treeNode, Answer answer, int height) {
        if (treeNode == null) {
            if (answer.height == height) {
                answer.found = true;
            } else
                answer.count++;
            return;
        }
        getLess(treeNode.right, answer, height +1);
        if (!answer.found)
            getLess(treeNode.left, answer, height);
    }

    public static void main(String[] args) {

    }
}

class Answer {
    boolean found;
    int count;
    int height;

    public Answer(int height) {

        this.height = height;
    }
}
