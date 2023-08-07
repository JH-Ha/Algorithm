package p0133;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node found = map.get(node.val);
        if (found == null) {
            Node newNode = new Node(node.val);
            map.put(node.val, newNode);
            for (Node iterNode : node.neighbors) {
                newNode.neighbors.add(cloneGraph(iterNode));
            }
            return newNode;
        } else {
            return found;
        }
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(solution.longestConsecutive(nums));
    }
}
