import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FarNode {
    class Node {
        ArrayList<Integer> connectedNode;
        int idx;
        int distance;

        public Node(int idx) {
            connectedNode = new ArrayList<>();
            this.idx = idx;
            this.distance = 0;
        }

        public void add(int i) {
            connectedNode.add(i);
        }
    }

    class Solution {
        public int solution(int n, int[][] edge) {
            Node[] nodeArr = new Node[n + 10];
            boolean[] visited = new boolean[n + 10];
            for (int i = 0; i <= n; i++) {
                nodeArr[i] = new Node(i);
                visited[i] = false;
            }
            for (int i = 0; i < edge.length; i++) {
                nodeArr[edge[i][0]].add(edge[i][1]);
                nodeArr[edge[i][1]].add(edge[i][0]);
            }

            Queue<Node> q = new LinkedList<>();
            q.offer(nodeArr[1]);
            visited[1] = true;
            int maxDistance = 0;
            while (!q.isEmpty()) {
                Node curNode = q.poll();
                for (int i = 0; i < nodeArr[curNode.idx].connectedNode.size(); i++) {
                    int childIdx = nodeArr[curNode.idx].connectedNode.get(i);
                    if (!visited[childIdx]) {
                        visited[childIdx] = true;
                        nodeArr[childIdx].distance = curNode.distance + 1;
                        maxDistance = Math.max(maxDistance, nodeArr[childIdx].distance);
                        q.offer(nodeArr[childIdx]);
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i <= n; i++) {
                if (nodeArr[i].distance == maxDistance) {
                    answer++;
                }
            }

            return answer;
        }

    }

    public static void main(String[] args) {
        FarNode farNode = new FarNode();
        Solution solution = farNode.new Solution();
        int n = 6;
        int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
        System.out.println(solution.solution(n, edge));
    }
}
