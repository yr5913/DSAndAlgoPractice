//package v2.myPractice;
//
//import java.util.*;
//
//public class GraphClone {
//
//
//    public Node cloneGraph(Node node) {
//        Set<Integer> set = new HashSet<>();
//        List<Node> nodes = new ArrayList<>();
//        Queue<Node> queue = new ArrayDeque<>();
//        queue.add(node);
//        Map<Integer, Node> map = new HashMap<>();
//        Node ref = null;
//        while (!queue.isEmpty()) {
//            Node current = queue.remove();
//            if (!set.contains(current.val)) {
//                set.add(current.val);
//                nodes.add(current);
//                map.put(current.val, new Node(current.val));
//                if (ref == null) {
//                    ref = map.get(current.val);
//                }
//                for (Node node1 : current.neighbors) {
//                    queue.add(node1);
//                }
//            }
//
//        }
//        for (Node current : nodes) {
//            List<Node> list = new ArrayList<>();
//            for (Node neighour : current.neighbors) {
//                list.add(map.get(neighour.val));
//            }
//            map.get(current.val).neighbors = list;
//        }
//        return ref;
//    }
//
//}
//
//
//// Definition for a Node.
// class Node {
//    public int val;
//    public List<Node> neighbors;
//
//    public Node() {
//        val = 0;
//        neighbors = new ArrayList<Node>();
//    }
//
//    public Node(int _val) {
//        val = _val;
//        neighbors = new ArrayList<Node>();
//    }
//
//    public Node(int _val, ArrayList<Node> _neighbors) {
//        val = _val;
//        neighbors = _neighbors;
//    }
//}
//
