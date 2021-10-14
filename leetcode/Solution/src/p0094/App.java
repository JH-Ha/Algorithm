package p0094;

import java.util.ArrayList;
import java.util.List;

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

class Solution {
    public void solve(TreeNode treeNode, List<Integer> answer) {
        if (treeNode == null) {
            return;
        }
        solve(treeNode.left, answer);
        answer.add(treeNode.val);
        solve(treeNode.right, answer);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        solve(root, answer);
        return answer;
    }
}

public class App {

}
