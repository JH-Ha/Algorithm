package rank;

import java.util.ArrayList;
import java.util.List;

class Node {
    int id;
    List<Integer> loseChildren;
    List<Integer> winChildren;

    public Node(int id) {
        this.id = id;
        loseChildren = new ArrayList<>();
        winChildren = new ArrayList<>();
    }
}

class Solution {
    public void dfs(Node[] nodeArr, boolean[] visited, int id, String type) {
        if (!visited[id]) {
            visited[id] = true;
            Node node = nodeArr[id];
            List<Integer> children = new ArrayList<>();
            if ("win".equals(type)) {
                children = node.winChildren;
            } else if ("lose".equals(type)) {
                children = node.loseChildren;
            }
            for (int i = 0; i < children.size(); i++) {
                if (!visited[children.get(i)]) {
                    dfs(nodeArr, visited, children.get(i), type);
                }
            }
        }
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        Node[] nodeArr = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeArr[i] = new Node(i);
        }
        for (int i = 0; i < results.length; i++) {
            nodeArr[results[i][0]].winChildren.add(results[i][1]);
            nodeArr[results[i][1]].loseChildren.add(results[i][0]);
        }
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                visited[j] = false;
            }
            dfs(nodeArr, visited, i, "win");
            visited[i] = false;
            dfs(nodeArr, visited, i, "lose");

            boolean visitAll = true;

            for (int j = 1; j <= n; j++) {
                if(!visited[j]){
                    visitAll = false;
                    break;
                }
            }
            if(visitAll) answer ++;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
        Solution solution = new Solution();
        System.out.println(solution.solution(n, results));
    }
}
