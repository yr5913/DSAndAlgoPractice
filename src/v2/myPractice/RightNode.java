package v2.myPractice;

import java.util.ArrayDeque;
import java.util.Queue;

public class RightNode {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node previous = queue.remove();
            if (previous.left != null) {
                queue.add(previous.left);
            }
            if (previous.right != null) {
                queue.add(previous.right);
            }
            for (int i = 1; i < size; i++) {
                Node current = queue.remove();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                previous.next = current;
                previous = current;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        new RightNode().connect(new Node(1,
                new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null), null));

    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


