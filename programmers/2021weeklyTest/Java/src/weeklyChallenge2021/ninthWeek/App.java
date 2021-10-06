package weeklyChallenge2021.ninthWeek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Node {
    int id;
    List<Node> children;

    public Node(int id) {
        this.id = id;
        children = new ArrayList<>();
    }
}

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        Node[] nodeArr = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodeArr[i] = new Node(i);
        }
        for (int i = 0; i < n - 1; i++) {
            nodeArr[wires[i][0]].children.add(nodeArr[wires[i][1]]);
            nodeArr[wires[i][1]].children.add(nodeArr[wires[i][0]]);
        }

        for (int i = 0; i < n - 1; i++) {
            nodeArr[wires[i][0]].children.remove(nodeArr[wires[i][1]]);
            nodeArr[wires[i][1]].children.remove(nodeArr[wires[i][0]]);

            List<Integer> groupSize = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();

            for (int j = 1; j <= n; j++) {
                if (!visited.contains(j)) {
                    Queue<Node> q = new LinkedList<>();
                    q.add(nodeArr[j]);
                    visited.add(j);
                    int size = 1;
                    while (!q.isEmpty()) {
                        Node front = q.poll();
                        for (int k = 0; k < front.children.size(); k++) {
                            int id = front.children.get(k).id;
                            if (!visited.contains(id)) {
                                visited.add(id);
                                q.add(nodeArr[id]);
                                size++;
                            }
                        }
                    }
                    groupSize.add(size);
                }
            }
            groupSize.stream().forEach(size -> {
                System.out.println(size);
            });
            System.out.println();
            answer = Math.min(Math.abs(groupSize.get(0) - groupSize.get(1)), answer);
            nodeArr[wires[i][0]].children.add(nodeArr[wires[i][1]]);
            nodeArr[wires[i][1]].children.add(nodeArr[wires[i][0]]);
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] wires = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        solution.solution(n, wires);
    }
}