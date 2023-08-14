package p0116;

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

class Solution {
    public Node connect(Node root) {
        Node head = root;
        while (head != null) {
            if (head.left == null) {
                return root;
            }
            Node prev = null;
            Node cur = head;
            while (cur != null) {
                if (prev != null) {
                    prev.right.next = cur.left;
                }
                cur.left.next = cur.right;
                prev = cur;
                cur = cur.next;
            }
            head = head.left;
        }

        return root;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }
}