package monthlyChallenge202109.p2;

import java.util.ArrayList;
import java.util.List;

class Node {
    char dir;
    List<Edge> outEdgeList;
    List<Edge> inEdgeList;
    String id;

    public Node(char dir, String id) {
        this.dir = dir;
        outEdgeList = new ArrayList<>();
        inEdgeList = new ArrayList<>();
        this.id = id;
    }
}

class Edge {
    boolean visited;
    Node end;

    public Edge() {

    }
}

class Solution {
    public int[] solution(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();

        Node[][] nodeArr = new Node[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nodeArr[i][j] = new Node(grid[i].charAt(j), i + "-" + j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //
                Edge rightEdge = new Edge();
                rightEdge.end = nodeArr[i][(j + 1) % m];
                nodeArr[i][j].outEdgeList.add(rightEdge);

                Edge downEdge = new Edge();

                downEdge.end = nodeArr[(i + 1) % n][j];
                nodeArr[i][j].outEdgeList.add(downEdge);

                Edge leftEdge = new Edge();
                leftEdge.end = nodeArr[i][(j + m - 1) % m];
                nodeArr[i][j].outEdgeList.add(leftEdge);

                Edge upEdge = new Edge();
                upEdge.end = nodeArr[(i + n - 1) % n][j];
                nodeArr[i][j].outEdgeList.add(upEdge);
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    Edge edge = nodeArr[i][j].outEdgeList.get(k);
                    int numVisted = 0;
                    int myDir = k;
                    while (!edge.visited) {
                        numVisted++;
                        edge.visited = true;
                        Node nextNode = edge.end;
                        if (nextNode.dir == 'S') {
                            edge = nextNode.outEdgeList.get(myDir);
                        } else if (nextNode.dir == 'L') {
                            myDir = (myDir + 3) % 4;
                            edge = nextNode.outEdgeList.get(myDir);
                        } else if (nextNode.dir == 'R') {
                            myDir = (myDir + 1) % 4;
                            edge = nextNode.outEdgeList.get(myDir);
                        }
                    }
                    if (numVisted != 0) {
                        answer.add(numVisted);
                    }
                }
            }
        }
        answer.sort((a, b) -> {
            return a - b;
        });

        return answer.stream().mapToInt(i -> i).toArray();
    }
}

public class App {
    public static void main(String[] args) {
        String[] grid = { "SL", "LR" };
        // [16]
        // String[] grid = { "S" };
        // [1,1,1,1]
        // ["R","R"]
        // [4,4]
        Solution solution = new Solution();
        int[] answer = solution.solution(grid);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
